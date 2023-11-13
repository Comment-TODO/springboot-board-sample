package com.github.CommentTODO.springbootboardsample.service;

import com.github.CommentTODO.springbootboardsample.dto.Article;
import com.github.CommentTODO.springbootboardsample.repository.BoardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Article> getArticleList() {
    return boardRepository.findAll();
  }
}
