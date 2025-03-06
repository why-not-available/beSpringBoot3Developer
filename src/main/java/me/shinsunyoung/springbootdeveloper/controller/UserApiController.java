package me.shinsunyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    public String signup(AddUserRequest request){
        userService.save(request);
        return "redirect:/login"; //: redirect:는 회원가입 처리 후 로그인 페이지로 이동하기
    }

}
