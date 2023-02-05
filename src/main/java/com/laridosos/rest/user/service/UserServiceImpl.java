package com.laridosos.rest.user.service;

import com.laridosos.rest.user.UserApp;
import com.laridosos.rest.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserApp findById(Long id) {
        Optional<UserApp> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return user.get();
    }
}
