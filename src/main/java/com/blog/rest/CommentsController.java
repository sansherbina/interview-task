package com.blog.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.blog.model.dto.CommentDto;
import com.blog.model.dto.NewCommentDto;
import com.blog.service.CommentService;

@Controller
@RestController
@RequestMapping("/posts")
public class CommentsController {

  private final CommentService commentService;

  public CommentsController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping(value = "/comment")
  @ResponseStatus(HttpStatus.OK)
  public List<CommentDto> getComments(@RequestParam(value = "postId") Long postId) {
    return commentService.getCommentsForPost(postId);
  }

  @PostMapping(value = "/comment")
  @ResponseStatus(HttpStatus.CREATED)
  public Long createComment(@RequestParam(value = "postId") Long postId,
      @RequestBody NewCommentDto newCommentDto) {
    newCommentDto.setPostId(postId);
    return commentService.addComment(newCommentDto);
  }
}
