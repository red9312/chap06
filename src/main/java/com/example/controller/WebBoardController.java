package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/board")
@Log
public class WebBoardController {
	
	@GetMapping("/list")
	public String list() {
		log.info("/board/list()");
		
		return "jsp/board/list";
	}
	
}
