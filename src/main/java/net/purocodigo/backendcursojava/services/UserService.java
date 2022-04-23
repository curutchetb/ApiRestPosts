package net.purocodigo.backendcursojava.services;

import java.util.ArrayList;
import java.util.UUID;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.purocodigo.backendcursojava.Repositories.UserRepository;
import net.purocodigo.backendcursojava.dto.UserDto;
import net.purocodigo.backendcursojava.entities.UserEntity;
import net.purocodigo.backendcursojava.exceptions.EmailExistsException;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) 
        throw new EmailExistsException("El correo electronico ya existe");
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userToReturn);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new RuntimeException("El correo electronico no existe");
        }

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(userEntity, userToReturn);

        return userToReturn;


    }



}
