package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //: final이 붙거나 @NotNull이 붙은 필드의 생성자 추가하기, lombok에서 지원
@Service //: 빈으로 등록하기
public class BlogService {
    private  final BlogRepository blogRepository;

    // 블로그 새 글 추가 메소드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
