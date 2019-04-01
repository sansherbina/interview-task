package com.blog.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {

  public Long id;

  public String content;

  public String author;

  public LocalDateTime creationDate;

}
