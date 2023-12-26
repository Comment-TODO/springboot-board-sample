package com.github.CommentTODO.springbootboardsample.repository;

import com.github.CommentTODO.springbootboardsample.entity.Article;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends CrudRepository<Article, Long> {

  List<Article> findAllByOrderByIdDesc();

  @Query("select a from Article a where a.id=:id")
  Optional<Article> findArticleById(@Param(value = "id") Long id);

  @Transactional
  @Modifying
  @Query("UPDATE Article a SET title = :title WHERE a.id = :id")
  int updateById(@Param(value = "id") Long id, @Param(value = "title") String title);
}
