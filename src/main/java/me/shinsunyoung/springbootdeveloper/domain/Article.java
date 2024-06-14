package me.shinsunyoung.springbootdeveloper.domain;
// 엔티티 구성하기

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //: 엔티티로 지정하기
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id //: id필드를 기본키로지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //: 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

//  빌더패턴으로 객체생성
    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
//    **Getter와 NoArgsConstructor의 사용으로 필요없어짐
//    protected  Article(){
//    }
//    public Long getId(){
//        return id;
//    }
//    public String getTitle(){
//        return title;
//    }
//    public String getContent(){
//        return content;
//    }
}
