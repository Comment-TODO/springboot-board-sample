package com.github.CommentTODO.springbootboardsample.service;

import com.github.CommentTODO.springbootboardsample.dto.Article;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  public List<Article> getArticleList() {
    return Arrays.asList(new Article(1L, "Hello", "world!"), new Article(2L, "John", "Doe"));
  }
}
