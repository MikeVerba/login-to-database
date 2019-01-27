package com.example.logintodatabase.models.services;

import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.mappers.UserToUserEntityMapper;
import com.example.logintodatabase.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    /**
     *
     * @param userForm
     * @return
     */
    public boolean addUser(UserForm userForm){


        if(!checkIfUsernameIsFree(userForm)){
            return false;
        }

        userRepository.save(new UserToUserEntityMapper().map(userForm));
        return true;

    }

    private boolean checkIfUsernameIsFree(UserForm userForm){
        return !userRepository.existsByName(userForm.getName());

    }


}
