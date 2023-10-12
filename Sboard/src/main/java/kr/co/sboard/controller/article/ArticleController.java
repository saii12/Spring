package kr.co.sboard.controller.article;

import groovy.util.logging.Log4j2;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
public class ArticleController {

    @Autowired // 이걸 빠트리네 정신 차리자
    private ArticleService articleService;

    @GetMapping("/article/list") //메서드에 주소를 매핑하는 것
    public String list(Model model, String cate, @RequestParam(defaultValue = "1") int pg){
        Page<ArticleEntity> pageArticle = articleService.findByParent(pg); // 타입이 Page<ArticleEntity>, Page도 리스트 형식임!
        model.addAttribute("pageArticle", pageArticle);
        return "/article/list";
    }

    @GetMapping("/article/register")
    public String register(){
        return "/article/register";
    }
    @PostMapping("/article/register")
    public String register(HttpServletRequest request, ArticleDTO dto){ // 폼 작성하면 데이터가 여기로 들어온다

        dto.setRegip(request.getRemoteAddr());




        articleService.save(dto);
        return "redirect:/article/list";
    }
}
