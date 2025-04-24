package com.example.BitCoin.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BitCoin.Service.UserService;
import com.example.BitCoin.dto.UserDto;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // 회원가입 폼을 보여주는 view 이름
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDto userDto) {
        userService.registerUser(userDto);
        return "redirect:/login";  // 회원가입 후 로그인 페이지로 리디렉션
    }
}
