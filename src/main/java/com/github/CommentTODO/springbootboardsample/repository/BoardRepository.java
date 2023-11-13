package com.github.CommentTODO.springbootboardsample.repository;

import com.github.CommentTODO.springbootboardsample.dto.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Article, Long> {

  List<Article> findAll();
}
