package me.shinsunyoung.springbootdeveloper.repository;
// JpaRepository클래스를 상속받을때 엔티티 Article와 엔티티의 PK타입 Long을 인수로 넣는다

import me.shinsunyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
