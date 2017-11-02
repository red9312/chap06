package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Dept;
import com.example.domain.WebBoard;
import com.example.persistence.DeptRepository;
import com.example.vo.PageMaker;
import com.example.vo.PageVO;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/depts")
@Log
public class DeptsController {

	@Autowired
	private DeptRepository repo;
	
	@GetMapping("/register")
	public String registerGET(@ModelAttribute("vo")Dept vo ){
		log.info("register get");
		vo.setDeptno(00);
		vo.setDname("부서 이름");
		vo.setLoc("지역 이름");
		
		return "thymeleaf/depts/register";
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")Dept vo, RedirectAttributes rttr){
		
		log.info("register post");
		log.info("" + vo);

		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/depts/list";
	}
	
	@GetMapping("/view")
	public String view(Integer deptno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("deptno: "+ deptno);
		
		repo.findById(deptno).ifPresent(dept -> model.addAttribute("vo", dept));
		return "thymeleaf/depts/view";
		
	}
	
	@GetMapping("/modify")
	public String modify(Integer deptno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("MODIFY deptno: "+ deptno);
		
		repo.findById(deptno).ifPresent(dept -> model.addAttribute("vo", dept));
		
		return "thymeleaf/depts/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(Dept dept, PageVO vo, RedirectAttributes rttr ){
		
		log.info("Modify dept: " + dept);
		
		
		repo.findById(dept.getDeptno()).ifPresent( origin ->{
		 
			origin.setDname(dept.getDname());
			origin.setLoc(dept.getLoc());
			
			repo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("deptno", origin.getDeptno());
		});
		
		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/depts/view";
	}
	
	@GetMapping("/list")
	public String list(PageVO vo, Model model) {
		log.info("/depts/list...");
		
		Pageable pageable = vo.makePageable(0, "deptno");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());
		Page<Dept> result = repo.findAll(predicate, pageable);
		
		model.addAttribute("pageMaker", new PageMaker(result));
		
		return "thymeleaf/depts/list";
	}
	
	@PostMapping("/delete")
	public String delete(Integer deptno, PageVO vo, RedirectAttributes rttr ){
		
		log.info("DELETE deptno: " + deptno);
		
		repo.deleteById(deptno);
		
		rttr.addFlashAttribute("msg", "success");

		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/depts/list";
	}
	
}
