package net.matholic.study.controller;

import javax.validation.Valid;

import net.matholic.study.domain.Board;
import net.matholic.study.domain.BoardDto;
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
@RequestMapping("/board/update")
public class UpdateController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getUpdate(@PathVariable("id") int id, Model model, @ModelAttribute Board board) {
		logger.info("Update Log");
		model.addAttribute("boardItems", boardService.findById(id));
		return "update";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String update(@Valid BoardDto boardDto, Model model) {
		boardService.save(boardDto);
		model.addAttribute("boardItems", boardDto);
		return "read";
	}
	
}
