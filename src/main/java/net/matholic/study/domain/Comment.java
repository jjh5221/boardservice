package net.matholic.study.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "comments")
@Getter
@Setter
public class Comment {

	@OneToOne
	private Board board;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String writer;
	private String content;
	private Date dateCreated;

	public Comment() {

	}

	public Comment(String writer, String content) {
		this.writer = writer;
		this.content = content;
		if (dateCreated == null) {
			dateCreated = new Date();
		}
	}

}
