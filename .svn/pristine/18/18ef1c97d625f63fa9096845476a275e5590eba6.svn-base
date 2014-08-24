package net.matholic.study.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import net.matholic.study.config.PersistenceJPAConfig;
import net.matholic.study.config.SecurityConfig;
import net.matholic.study.config.WebConfig;
import net.matholic.study.domain.Board;
import net.matholic.study.domain.BoardDto;
import net.matholic.study.service.BoardService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={PersistenceJPAConfig.class, WebConfig.class, SecurityConfig.class})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class ControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private BoardService boardService;

	protected MockMvc mockMvc;
	
	private Board board;
	
   @Before
   public void setUp() {
	   this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	   BoardDto boardDto = new BoardDto();
	   boardDto.setTitle("test");
	   boardDto.setWriter("test");
	   boardDto.setContent("test");
	   board = boardService.save(boardDto);
   }
   
	@Test
	public void homeTest() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
	public void readTest() throws Exception {
		Long id = board.getId();
		mockMvc.perform(get("/board/read/"+id)).andExpect(status().isOk());
	}
	
	@Test
	public void cencelTest() throws Exception {
		mockMvc.perform(get("/cencel")).andExpect(status().isMovedTemporarily());
	}
	
	@Test
	public void writeTest() throws Exception {
		mockMvc.perform(get("/board/write")).andExpect(status().isOk());
		mockMvc.perform(post("/board/write")).andExpect(status().isMovedTemporarily());
	}
	
	@Test
	public void deleteTest() throws Exception {
		Long id = board.getId();
		mockMvc.perform(get("/board/delete/"+id)).andExpect(status().isMovedTemporarily());
	}
	
	@Test
	public void updateTest() throws Exception {
		Long id = board.getId();
		mockMvc.perform(get("/board/update/"+id)).andExpect(status().isOk());
		mockMvc.perform(post("/board/update", board)).andExpect(status().isOk());
	}
}
