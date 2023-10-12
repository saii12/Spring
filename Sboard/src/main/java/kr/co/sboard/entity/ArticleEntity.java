package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.ArticleDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


// entity는 테이블 객체, DTO는 form에서 입력한 객체
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Article")
public class ArticleEntity {

    @Id // Id 어노테이션은 Entity에서만, DTO는 XXX
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 이건 뭐였더라 아 AUTO_Increment라 해주는것
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime rdate; // private String 아님!!!

    public ArticleDTO toDTO(){
        return ArticleDTO.builder()
                .no(no)
                .parent(parent)
                .comment(comment)
                .cate(cate)
                .title(title)
                .content(content)
                .hit(hit)
                .writer(writer)
                .regip(regip)
                .rdate(rdate)
                .build();
    }
}
