package net.matholic.study.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentDto {
	private Long boardId;
	private String writer;
	private String content;
	private Date dateCreated;
}
