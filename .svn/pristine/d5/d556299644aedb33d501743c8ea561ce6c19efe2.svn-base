package net.matholic.study.controller;

import java.util.Locale;

import javax.validation.Valid;

import net.matholic.study.domain.BoardDto;
import net.matholic.study.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/write")
public class WriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getWrite(Locale locale, Model model) {
		logger.info("Welcom Write");
		return "write";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(@Valid BoardDto boardDto) {
		boardService.save(boardDto);
		return "redirect:/";
	}

	
}
