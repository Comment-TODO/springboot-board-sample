package com.github.CommentTODO.springbootboardsample.service;

import com.github.CommentTODO.springbootboardsample.entity.Article;
import com.github.CommentTODO.springbootboardsample.repository.BoardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Article> getArticleList(int page, int size) {
    return boardRepository.findAllByOrderByIdDesc(PageRequest.of(page, size));
  }

  public Optional<Article> getArticleById(Long id) {
    return boardRepository.findArticleById(id);
  }

  @Transactional
  public void updateArticle(Long id, Article updateDTO) {
    Article prevArticle = this.getArticleById(id).orElseThrow(() -> {
      throw new IllegalArgumentException("해당 게시물은 더 이상 존재하지 않습니다.");
    });

    // 에러 처리 미들웨어 추가

    updateDTO.setId(id);
    boardRepository.save(updateDTO);
  }
}
