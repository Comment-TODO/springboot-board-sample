package com.github.CommentTODO.springbootboardsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootBoardSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootBoardSampleApplication.class, args);
  }

}
