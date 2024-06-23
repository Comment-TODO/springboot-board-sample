package com.github.CommentTODO.springbootboardsample.controller;

import com.github.CommentTODO.springbootboardsample.entity.Article;
import com.github.CommentTODO.springbootboardsample.service.BoardService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/")
  public List<Article> getArticleList() {
    return boardService.getArticleList();
  }

  @GetMapping("/{id}")
  public Optional<Article> getArticleById(@PathVariable(value = "id") Long id) {
    return boardService.getArticleById(id);
  }

  @PutMapping("/{id}")
  public void updateArticleById(@PathVariable(value = "id") Long id, @RequestBody Article article) {
    boardService.updateArticle(id, article);
  }
}
