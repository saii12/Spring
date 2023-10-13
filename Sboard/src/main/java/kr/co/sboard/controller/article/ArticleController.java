package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class ArticleController {

    @Autowired // 이걸 빠트리네 정신 차리자
    private ArticleService articleService;

    @GetMapping("/article/list") //메서드에 주소를 매핑하는 것
    public String list(Model model, PageRequestDTO pageRequestDTO){
        PageResponseDTO pageResponseDTO = articleService.findByParentAndCate(pageRequestDTO); // 타입이 Page<ArticleEntity>, Page도 리스트 형식임!

        log.info("pageResponseDTO pg : " + pageResponseDTO.getPg());
        log.info("pageResponseDTO size : " + pageResponseDTO.getSize());
        log.info("pageResponseDTO total : " + pageResponseDTO.getTotal());
        log.info("pageResponseDTO start : " + pageResponseDTO.getStart());
        log.info("pageResponseDTO end : " + pageResponseDTO.getEnd());
        log.info("pageResponseDTO prev : " + pageResponseDTO.isPrev());
        log.info("pageResponseDTO next : " + pageResponseDTO.isNext());

        model.addAttribute(pageResponseDTO);
        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(@ModelAttribute PageRequestDTO pageRequestDTO){ //PageRequestDTO 앞에 ModelAttribute 어노테이션생략가능

        //model.addAttribute(pageRequestDTO); 어노테이션 생략되있어서 이 코드 없어도 됨
        return "/article/write";
    }
    @PostMapping("/article/write")
    public String write(HttpServletRequest request, ArticleDTO dto){ // 폼 작성하면 데이터가 여기로 들어온다

        dto.setRegip(request.getRemoteAddr());




        articleService.save(dto);
        return "redirect:/article/list";
    }

    @GetMapping("/article/delete") // deleteMapping은 RESTAPI에서 type: 'DELETE'로 AJAX 쏠 때 받는 것! / 파라미터 이렇게 수신 가능
    public String delete (@RequestParam("no") int ano){ // 파라미터 받는 no는 int 값임, @RequestParam("no") 기억하자! /  @PathVariable 어노테이션은 RESTAPI에서 쓰는것!

        String no = Integer.toString(ano); // articleService.delete의 매개변수는 String 타입만 가능하므로 int타입을 String으로 변환해줘야함

        articleService.delete(no);
        return "redirect:/article/list"; // 해당 게시판으로 어떻게 리다이렉트 시키지?
    }
}
