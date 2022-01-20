package com.coderhouse.service;

import com.coderhouse.handle.exceptions.ApiRestException;
import com.coderhouse.handle.exceptions.ApiRestTokenException;
import com.coderhouse.model.User;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JwtProvider jwtProvider;

    @Override
    public User getUser(String username, String pwd) throws Exception {
        var user = repository.findUserByUsername(username);

        if (!(user.getUsername().equals(username) && user.getPassword().equals(pwd))) {
            throw new ApiRestTokenException("El usuario o el password es inválido");
        }
        var token = jwtProvider.getJWTToken(username);
        return User.builder().username(username).token(token).build();
    }
}
