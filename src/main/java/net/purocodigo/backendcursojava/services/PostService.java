package net.purocodigo.backendcursojava.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.purocodigo.backendcursojava.Repositories.ExposureRepository;
import net.purocodigo.backendcursojava.Repositories.PostRepository;
import net.purocodigo.backendcursojava.Repositories.UserRepository;
import net.purocodigo.backendcursojava.dto.PostCreationDto;
import net.purocodigo.backendcursojava.dto.PostDto;
import net.purocodigo.backendcursojava.entities.ExposureEntity;
import net.purocodigo.backendcursojava.entities.PostEntity;
import net.purocodigo.backendcursojava.entities.UserEntity;

@Service
public class PostService implements PostServiceInterface{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExposureRepository exposureRepository;

    @Autowired
    ModelMapper mapper;


    @Override
    public PostDto createPost(PostCreationDto post) {
        UserEntity userEntity = userRepository.findByEmail(post.getUserEmail());
        ExposureEntity exposureEntity = exposureRepository.findById(post.getExposureId());

        PostEntity postEntity = new PostEntity();
        postEntity.setUser(userEntity);
        postEntity.setExposure(exposureEntity);
        postEntity.setTitle(post.getTitle());
        postEntity.setContent(post.getContent());
        postEntity.setPostId(UUID.randomUUID().toString());
        postEntity.setExpiresAt(new Date(System.currentTimeMillis()+ post.getExpirationTime()*60000)); //convertir min en milisegundos por eso se multiplica-

        PostEntity createdPost = postRepository.save(postEntity);

        PostDto postToReturn = mapper.map(createdPost, PostDto.class);

        return postToReturn;
    }


    @Override
    public List<PostDto> getLastPosts() {
        long publicExposureId = 2;
        List<PostEntity> postEntities = postRepository.getLastPublicPosts(publicExposureId, new Date(System.currentTimeMillis()));
        
        List<PostDto> postDtos = new ArrayList<>();

        for (PostEntity post : postEntities) {
            PostDto postDto = mapper.map(post, PostDto.class);
            postDtos.add(postDto);
        }
        return postDtos;
    }


    @Override
    public PostDto getPost(String postId) {
        
        PostEntity postEntity = postRepository.findByPostId(postId);

        PostDto postDto = mapper.map(postEntity, PostDto.class);

        return postDto;
    }


    @Override
    public void deletePost(String postId, long userId) {
        
        PostEntity postEntity = postRepository.findByPostId(postId);

        if (postEntity.getUser().getId() != userId) throw new RuntimeException("No se puede realizar esta accion");

        postRepository.delete(postEntity);
        
    }


    @Override
    public PostDto updatePost(String postId, long userId, PostCreationDto postUpdateDtos) {
       
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity.getUser().getId() != userId) throw new RuntimeException("No se puede realizar esta accion");
        
        ExposureEntity exposureEntity = exposureRepository.findById(postUpdateDtos.getExposureId());

        postEntity.setExposure(exposureEntity);
        postEntity.setTitle(postUpdateDtos.getTitle());
        postEntity.setContent(postUpdateDtos.getContent());
        postEntity.setExpiresAt(new Date(System.currentTimeMillis()+ postUpdateDtos.getExpirationTime()*60000)); 
        
        PostEntity updatePost = postRepository.save(postEntity);

        PostDto postDto = mapper.map(updatePost, PostDto.class);


        return postDto;
    }



    
}
