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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/")
  public List<Article> getArticleList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
    return boardService.getArticleList(page, 10);
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
