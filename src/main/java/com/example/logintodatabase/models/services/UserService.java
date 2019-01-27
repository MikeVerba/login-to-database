package com.example.logintodatabase.models.services;

import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.entities.UserEntity;
import com.example.logintodatabase.models.mappers.UserToUserEntityMapper;
import com.example.logintodatabase.models.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    HashService hashService;

    @Autowired
    UserSession userSession;


    /**
     * @param userForm
     * @return
     */
    public boolean addUser(UserForm userForm) {


        if (!checkIfUsernameIsFree(userForm)) {
            return false;
        }

        userForm.setPassword(hashService.hashPasssword(userForm.getPassword()));
        userRepository.save(new UserToUserEntityMapper().map(userForm));
        return true;

    }

    private boolean checkIfUsernameIsFree(UserForm userForm) {
        return !userRepository.existsByName(userForm.getName());

    }

    public boolean login(UserForm userForm) {

        Optional<UserEntity> userWhoTriesToLogin =
                userRepository.getUserByUsername(userForm.getName());

        if (userWhoTriesToLogin.isPresent() &&
                hashService.isPasswordCorrect(userWhoTriesToLogin.get().getPassword(), userForm.getPassword())) {
            userSession.setLogin(true);
            userSession.setUserEntity(userWhoTriesToLogin.get());
            return true;
        }
        return false;

    }
}
