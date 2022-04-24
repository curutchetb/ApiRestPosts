package net.purocodigo.backendcursojava.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.purocodigo.backendcursojava.models.requests.PostCreateRequestModel;

@RestController
@RequestMapping("/posts")
public class PostController {

    @PostMapping
    public String createPosts (@RequestBody PostCreateRequestModel postCreateRequestModel){
        return postCreateRequestModel.getTitle();
    }
    
}
