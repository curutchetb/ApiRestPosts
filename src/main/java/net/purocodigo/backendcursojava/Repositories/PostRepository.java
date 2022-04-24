package net.purocodigo.backendcursojava.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.purocodigo.backendcursojava.entities.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long>{
    
}
