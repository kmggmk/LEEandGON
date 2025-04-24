package com.example.BitCoin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BitCoin.Entity.User;
import com.example.BitCoin.Entity.Authority; // Authority 엔티티 추가
import com.example.BitCoin.UserRepository.UserRepository;
import com.example.BitCoin.UserRepository.AuthorityRepository; // AuthorityRepository 추가
import com.example.BitCoin.dto.UserDto;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository; // AuthorityRepository 주입
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        // User 객체 생성 후 DB에 저장
        User user = new User(userDto.getUsername(), encodedPassword, userDto.getEmail(), userDto.getName());
        userRepository.save(user);

        // 권한 정보 저장
        Authority authority = new Authority(userDto.getUsername(), userDto.getAuthority()); // 권한 객체 생성
        authorityRepository.save(authority); // Authority 저장
    }
}
