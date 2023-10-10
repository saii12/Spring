package kr.co.sboard.controller.user;

import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){
        TermsEntity terms = userService.findByTerms();
        model.addAttribute(terms); // 속성이름 안정하면 타입이 terms의 타입이 속성이름으로 됨

        return "/user/terms";
    }
}