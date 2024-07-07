package com.github.CommentTODO.springbootboardsample.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultErrorController implements ErrorController {

  @RequestMapping("/error")
  public String handleError() {
    return "Something's wrong.";
  }
}
