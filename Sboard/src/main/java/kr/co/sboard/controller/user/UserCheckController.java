package kr.co.sboard.controller.user;

import kr.co.sboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/check")
public class UserCheckController {

    @Autowired
    private UserService userService;


    @GetMapping("/user/check/uid/{uid}")
    public int checkUid(@PathVariable("uid") String uid){

        return userService.countUid(uid);

    }
    @GetMapping("/nick/{nick}")
    public int checkNick(@PathVariable("nick") String uid){

        return userService.countUid(uid);

    }
    @GetMapping("/hp/{hp}")
    public int checkHp(@PathVariable("hp") String uid){

        return userService.countUid(uid);

    }
}
