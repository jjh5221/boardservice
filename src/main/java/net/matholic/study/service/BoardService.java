package net.matholic.study.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.matholic.study.domain.Board;
import net.matholic.study.domain.BoardDto;
import net.matholic.study.domain.Comment;
import net.matholic.study.domain.CommentDto;
import net.matholic.study.repository.BoardRepository;
import net.matholic.study.repository.CommentRepository;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private Mapper mapper;

	final Pageable page = new PageRequest(0, 20, Direction.DESC, "id");

	public List<BoardDto> getAll() {
		List<BoardDto> items = findAll();
		return items;
	}

	private List<BoardDto> findAll() {
		List<BoardDto> boardsDto = convertBoards(boardRepository.findAll(page));
		return boardsDto;
	}

	private List<BoardDto> convertBoards(Page<Board> boards) {
		List<BoardDto> boardsDto = new ArrayList<BoardDto>();
		for (Board board : boards) {
			boardsDto.add(convertBoard(board));
		}
		return boardsDto;
	}

	private BoardDto convertBoard(Board board) {
		if (board == null) {
			return null;
		} else {
			BoardDto boardDto = this.mapper.map(board, BoardDto.class);
			return boardDto;
		}
	}

	public void delete(long id) {
		boardRepository.delete(id);
	}

	public BoardDto findById(long id) {
		BoardDto boardDto = convertBoard(boardRepository.findOne(id));
		return boardDto;
	}

	@Transactional
	public List<CommentDto> findComments(Long id) {
		Board board = boardRepository.findOne(id);
		List<CommentDto> commentsDto = convertComments(board.getComments());
		Collections.reverse(commentsDto);
		return commentsDto;
	}

	private List<CommentDto> convertComments(List<Comment> comments) {
		List<CommentDto> commentsDto = new ArrayList<CommentDto>();
		for (Comment comment : comments) {
			commentsDto.add(convertComment(comment));
		}
		return commentsDto;
	}

	private CommentDto convertComment(Comment comment) {
		if (comment == null) {
			return null;
		} else {
			CommentDto commentDto = this.mapper.map(comment, CommentDto.class);
			return commentDto;
		}
	}

	public Board save(BoardDto boardDto) {
		Board board = createBoard(boardDto);
		this.boardRepository.save(board);
		return board;
	}

	private Board createBoard(BoardDto boardDto) {
		return new Board(boardDto.getId(), boardDto.getTitle(),
				boardDto.getWriter(), boardDto.getContent());
	}

	public Comment saveComment(Long id, CommentDto commentDto) {
		Comment comment = createComment(commentDto);
		this.commentRepository.save(comment);
		boardRepository.findOne(id).addComment(comment);
		return comment;
	}

	private Comment createComment(CommentDto commentDto) {
		return new Comment(commentDto.getWriter(), commentDto.getContent());
	}
}
