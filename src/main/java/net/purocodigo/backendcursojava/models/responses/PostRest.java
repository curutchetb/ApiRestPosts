package net.purocodigo.backendcursojava.models.responses;

import java.util.Date;

public class PostRest {

    private String postId;

    private String title;

    private String content;
    
    private Date createdAt;
    private Date expiresAt;

    private boolean expired = false;

    private UserRest user;

    private ExposureRest exposure;



    public ExposureRest getExposure() {
        return this.exposure;
    }

    public void setExposure(ExposureRest exposure) {
        this.exposure = exposure;
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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public boolean getExpired() {
        return this.expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public UserRest getUser() {
        return this.user;
    }

    public void setUser(UserRest user) {
        this.user = user;
    }

    
    
}
