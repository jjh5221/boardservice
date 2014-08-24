package net.matholic.study.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "boards")
@Getter
@Setter
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String writer;
	private String content;
	private Date dateCreated;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "board_id")
	private List<Comment> comments = new ArrayList<Comment>();

	public Board() {

	}

	public Board(Long id, String title, String writer, String content) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		if (dateCreated == null) {
			dateCreated = new Date();
		}
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
}