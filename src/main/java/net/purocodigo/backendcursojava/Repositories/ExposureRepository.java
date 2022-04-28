package net.purocodigo.backendcursojava.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.purocodigo.backendcursojava.entities.ExposureEntity;

@Repository
public interface ExposureRepository extends CrudRepository<ExposureEntity, Long>{
    
    ExposureEntity findById(long id);
    
}
