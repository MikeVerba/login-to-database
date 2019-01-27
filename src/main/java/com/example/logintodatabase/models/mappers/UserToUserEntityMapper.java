package com.example.logintodatabase.models.mappers;

import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserToUserEntityMapper extends Mapper<UserForm, UserEntity> {
    @Override
    public UserEntity map(UserForm key) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(key.getName());
        userEntity.setPassword(key.getPassword());
        userEntity.setTime(key.getTime());
        return userEntity;
    }
}
