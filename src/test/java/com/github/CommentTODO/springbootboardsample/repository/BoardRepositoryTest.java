package com.github.CommentTODO.springbootboardsample.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.CommentTODO.springbootboardsample.entity.Article;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

  @Autowired
  BoardRepository boardRepository;

  @BeforeAll
  static void setProperties() {
    System.getProperties().setProperty("spring.profiles.active", "local");
    System.getProperties().setProperty("DB_USER_NAME", "board_user");
    System.getProperties().setProperty("DB_USER_PASSWORD", "sample");
  }

  @Test
  void createArticle() {
    Article article = new Article("Test Title", "Test Content.");
    Article savedArticle = boardRepository.save(article);
    assertThat(boardRepository.findArticleById(savedArticle.getId()).get()).isEqualTo(savedArticle);
  }

  @Test
  void updateArticle() {
    int updatedRows = boardRepository.updateById(2l, "New Title Again");
    Optional<Article> after = boardRepository.findArticleById(2l);

    assertThat(updatedRows).isEqualTo(1);
    assertThat(after.get().getTitle()).isEqualTo("New Title Again");
  }
}