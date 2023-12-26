package com.github.CommentTODO.springbootboardsample.service;

import com.github.CommentTODO.springbootboardsample.entity.Article;
import com.github.CommentTODO.springbootboardsample.repository.BoardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Article> getArticleList() {
    return boardRepository.findAllByOrderByIdDesc();
  }

  public Optional<Article> getArticleById(Long id) {
    return boardRepository.findArticleById(id);
  }
}
