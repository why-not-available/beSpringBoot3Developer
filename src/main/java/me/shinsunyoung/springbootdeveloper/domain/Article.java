package me.shinsunyoung.springbootdeveloper.domain;
// 엔티티 구성하기

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
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

//  업데이트
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

//  보러가기를 누르면 해당 글 보이기(뷰)
    @CreatedDate //: 엔티티가 생성될때 생성시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //: 엔티티가 수정될때 수정시간 저장
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


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
