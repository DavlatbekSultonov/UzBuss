package com.example.user;


import com.example.user.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("sign-in")
    public String signIn(){
        return "user/sign-in";
    }

    @GetMapping("userType")
    public String UserType(){
        return "user/userType";
    }



    @GetMapping("sign-up")
    public String signUp(){
        return "user/sign-up";
    }

    @PostMapping("sign-up")
    public String createUP(@ModelAttribute UserCreateDto userCreateDto){
        userService.create(userCreateDto);
            return "redirect:user/sign-in";
    }
}
