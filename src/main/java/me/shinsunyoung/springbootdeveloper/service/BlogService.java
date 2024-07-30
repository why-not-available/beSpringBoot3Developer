package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //: final이 붙거나 @NotNull이 붙은 필드의 생성자 추가하기, lombok에서 지원
@Service //: 빈으로 등록하기
public class BlogService {
    private  final BlogRepository blogRepository;

    // 블로그 새 글 추가 메소드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에 저장되어있는 글을 모두 가져오는 findAll 메서드
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // DB에 저장되어있는 글의 ID를 이용해 글 조회하기
    public Article findById(long id){
        return blogRepository.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 6.6 p194
    // 블로그 글의 ID를 받아 deleteById(JPA에서 제공하는 메서드) 메서드로 DB에서 데이터를 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }
}
