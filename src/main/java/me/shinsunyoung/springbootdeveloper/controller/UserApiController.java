package me.shinsunyoung.springbootdeveloper.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    // 회원가입
    public String signup(AddUserRequest request){
        userService.save(request);
        return "redirect:/login"; //: redirect:는 회원가입 처리 후 로그인 페이지로 이동하기
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
