package net.matholic.study.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import net.matholic.study.config.PersistenceJPAConfig;
import net.matholic.study.config.SecurityConfig;
import net.matholic.study.config.WebConfig;
import net.matholic.study.domain.Board;
import net.matholic.study.domain.BoardDto;
import net.matholic.study.domain.Comment;
import net.matholic.study.domain.CommentDto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={PersistenceJPAConfig.class, WebConfig.class, SecurityConfig.class})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class BoardServiceTest {
	@Autowired
	private BoardService boardService;
	
	private BoardDto boardDto;
	
	private Board board;
	
	private CommentDto commentDto;
	
	@Before
	public void setUp() {
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle("test");
		boardDto.setWriter("test");
		boardDto.setContent("test");
		board = boardService.save(boardDto);
		commentDto = new CommentDto();
		commentDto.setContent("test");
		commentDto.setWriter("test");
		boardService.saveComment(board.getId(), commentDto);
	}
	
	@Test
	public void findByIdTest() {
		BoardDto findedBoard = boardService.findById(board.getId());
		assertNotNull(findedBoard);
	}
	
	@Test
	public void getAllTest() {
		List<BoardDto> boardsDto = boardService.getAll();
		assertNotNull(boardsDto);
	}
	
	@Test
	public void saveTest() {
		int prevSize = boardService.getAll().size();
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle("test");
		boardDto.setWriter("test");
		boardDto.setContent("test");
		Board newBoard = boardService.save(boardDto);
		int afterSize = boardService.getAll().size();
		assertNotNull(newBoard.getId());
		assertEquals(prevSize+1, afterSize);
	}
	
	@Test
	public void deleteTest() {
		int prevSize = boardService.getAll().size();
		long id = board.getId();
		boardService.delete(id);
		boardDto = boardService.findById(id);
		int afterSize = boardService.getAll().size();
		assertEquals(null, boardDto);
		assertEquals(prevSize-1, afterSize);
	}
	
	@Test
	public void saveCommentTest() {
		long id = board.getId();
		CommentDto commentDto = new CommentDto();
		commentDto.setWriter("test");
		commentDto.setContent("test");
		Comment comment = boardService.saveComment(id, commentDto);
		assertNotNull(comment);
		List<CommentDto> commentsDto = boardService.findComments(id);
		assertEquals(2, commentsDto.size());
	}
	
	@Test
	public void findCommentsTest() {
		List<CommentDto> commentsDto = boardService.findComments(board.getId());
		assertNotNull(commentsDto);
	}
	
}
