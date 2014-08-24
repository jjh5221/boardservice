package net.matholic.study.controller;

import java.util.List;

import net.matholic.study.domain.Board;
import net.matholic.study.domain.CommentDto;
import net.matholic.study.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/read")
public class ReadController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getContent(@PathVariable("id") Long id, Model model, @ModelAttribute Board board) {
		logger.info("Hellow Read");
		List<CommentDto> commentsDto = boardService.findComments(id);
		model.addAttribute("boardItems", boardService.findById(id));
		model.addAttribute("commentItems", commentsDto);
		return "read";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.POST)
	public String setComment(@PathVariable("id") Long id, CommentDto commentDto) {
		boardService.saveComment(id, commentDto);
		return "redirect:/board/read/" + id;
	}
}
