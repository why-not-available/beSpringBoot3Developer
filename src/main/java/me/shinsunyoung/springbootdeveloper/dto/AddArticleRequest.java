package me.shinsunyoung.springbootdeveloper.dto;
// 데이터 이동을 위한 전달자 역할의 객체, 별도의 비즈니스 로직 X

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;

@NoArgsConstructor //: 기본 생성자 추가
@AllArgsConstructor //: 모든 필드값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private  String title;
    private String content;

    // toEntity: 빌더패턴을 사용해 DTO를 엔티티로 만들어주는 메소드
    public Article toEntity(){
        return Article.builder().title(title)
                                .content(content)
                                .build();
    }
}
