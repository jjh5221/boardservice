package net.matholic.study.controller;

import net.matholic.study.domain.Board;
import net.matholic.study.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/delete")
public class DeleteController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public String deleteDocument(@PathVariable("id") int id, @ModelAttribute Board board){
		logger.info("Delete Document");
		boardService.delete(id);
		return "redirect:/";
	}
	
}
