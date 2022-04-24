package net.purocodigo.backendcursojava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.purocodigo.backendcursojava.Repositories.PostRepository;
import net.purocodigo.backendcursojava.dto.PostCreationDto;
import net.purocodigo.backendcursojava.dto.PostDto;

@Service
public class PostService implements PostServiceInterface{

    @Autowired
    PostRepository postRepository;

    @Override
    public PostDto createPost(PostCreationDto post) {
        //postRepository.
        return null;
    }


    
}
