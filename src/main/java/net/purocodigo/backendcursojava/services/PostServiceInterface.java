package net.purocodigo.backendcursojava.services;

import net.purocodigo.backendcursojava.dto.PostCreationDto;
import net.purocodigo.backendcursojava.dto.PostDto;

public interface PostServiceInterface {

    public PostDto createPost(PostCreationDto post);
    
}
