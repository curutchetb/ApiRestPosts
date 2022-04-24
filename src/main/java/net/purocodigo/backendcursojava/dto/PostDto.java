package net.purocodigo.backendcursojava.dto;

import java.io.Serializable;
import java.util.Date;

public class PostDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private long id;

    private String postId;

    
    private String title;

    private String content;
    
    private Date expires_at;

    private Date created_at;

    //relacion con userDto
    private UserDto user;

    //relacion con exposure
    private ExposureDto exposure;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getExpires_at() {
        return this.expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ExposureDto getExposure() {
        return this.exposure;
    }

    public void setExposure(ExposureDto exposure) {
        this.exposure = exposure;
    }

}

