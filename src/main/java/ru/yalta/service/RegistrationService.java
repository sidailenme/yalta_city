package ru.yalta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yalta.entity.User;
import ru.yalta.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    public User auth(String userId) {


        return null;
    }


}
