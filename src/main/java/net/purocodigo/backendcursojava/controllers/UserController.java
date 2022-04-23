package net.purocodigo.backendcursojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.purocodigo.backendcursojava.dto.UserDto;
import net.purocodigo.backendcursojava.models.requests.UserDetailRequestModel;
import net.purocodigo.backendcursojava.models.responses.UserRest;
import net.purocodigo.backendcursojava.services.UserServiceInterface;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

    @Autowired
    UserServiceInterface userService;
    
    @GetMapping (produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();

        UserDto userDto = userService.getUser(email);

        UserRest userToReturn = new UserRest();

        BeanUtils.copyProperties(userDto, userToReturn);

        return userToReturn;
        
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {
        /*estos pasos se hacen por seguridad y para tener el codigo organizado y saber para que se
        utiliza cada clase*/
        
        UserRest userToReturn = new UserRest(); //se  crea objeto que se va a retornar

        UserDto userDto = new UserDto(); //objeto que se enviara a la logica de nuestra app

        BeanUtils.copyProperties(userDetails, userDto); //copiamos propiedades del objeto que recibimos al DTO

        UserDto createUser = userService.createUser(userDto); //service conecta controlador con logica del sistema

        BeanUtils.copyProperties(createUser, userToReturn);

        return userToReturn;
    }


}
