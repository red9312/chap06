package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/board")
@Log
public class WebBoardController {
	
	@GetMapping("/list")
	public String list(@ModelAttribute("xxx")PageVO vo, Model model) {
		log.info("/board/list()");
		log.info("PageVo=" + vo);
		
		return "jsp/board/list";
	}
	
}
