package com.junghwan.jwt.service;

import com.junghwan.jwt.dto.JoinDto;
import com.junghwan.jwt.entity.User;
import com.junghwan.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {
        String userName = joinDto.getUserName();
        String password = joinDto.getPassword();

        Boolean isExists = userRepository.existsByUsername(userName);

        if (isExists) {
            return;
        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        user.setRole("ADMIN");

        userRepository.save(user);

    }
}
