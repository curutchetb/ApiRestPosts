package net.purocodigo.backendcursojava.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//representacion en codigo java del usuario en la base de datos a traves de las entities
@Entity(name= "users")
@Table(indexes = { @Index(columnList = "userId", name = "index_userId", unique = true), 
    @Index(columnList = "email", name = "index_email", unique = true ) } )
public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable= false)
    private String userId;

    @Column(nullable= false, length = 50)
    private String firstName;

    @Column(nullable= false, length = 50)
    private String lastName;

    @Column(nullable= false, length = 255)
    private String email;

    @Column(nullable= false)
    private String encryptedPassword;

    //un usuario puede tener MUCHOS posts por eso la lista
    //cascada porque si se borra un usuario hay que borrar todos los posts
    //mappedBy es la propiedad que une las tablas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostEntity> posts = new ArrayList<>();


    public List<PostEntity> getPosts() {
        return this.posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


}
