package com.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.dto.CommentDto;
import com.blog.model.dto.NewCommentDto;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;

@Service
public class CommentService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<CommentDto> getCommentsForPost(Long postId) {
    List<Comment> comments = commentRepository.findByPostIdOrderByCreationDateDesc(postId);
    return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
  }

  public Long addComment(NewCommentDto newCommentDto) {
    Optional<Post> post = postRepository.findById(newCommentDto.getPostId());
    if (!post.isPresent()) {
      throw new IllegalArgumentException(String.format("There is no post with id %d", newCommentDto.getPostId()));
    }

    Comment comment = modelMapper.map(newCommentDto, Comment.class);
    comment.setPost(post.get());

    comment = commentRepository.save(comment);
    return comment.getId();
  }
}
