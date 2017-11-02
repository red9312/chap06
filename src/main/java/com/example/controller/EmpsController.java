package com.example.controller;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
import com.example.domain.Emp;
import com.example.domain.WebBoard;
import com.example.persistence.DeptRepository;
import com.example.persistence.EmpRepository;
import com.example.vo.PageMaker;
import com.example.vo.PageVO;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/emps")
@Log
public class EmpsController {

	@Autowired
	private EmpRepository repo;
	
	@GetMapping("/register")
	public String registerGET(@ModelAttribute("vo")Emp vo ){
		log.info("register get");
		vo.setEmpno(0);
		vo.setEname("사원 이름 입력");
		vo.setGender(null);
		vo.setJob("직급 입력");
		vo.setHiredate(null);
		vo.setSal(null);
		vo.setComm(null);
		vo.setDept(null);
		
		return "thymeleaf/emps/register";
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")Emp vo, RedirectAttributes rttr){
		
		log.info("register post");
		log.info("" + vo);

		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/emps/list";
	}
	
	@GetMapping("/view")
	public String view(Integer empno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("empno: "+ empno);
		
		repo.findById(empno).ifPresent(emp -> {
			System.out.println("############");
			System.out.println("############");
			System.out.println("############");
			model.addAttribute("vo", emp);
		});
		
		return "thymeleaf/emps/view";
		
	}
	
	@GetMapping("/modify")
	public String modify(Integer empno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("MODIFY empno: "+ empno);
		
		repo.findById(empno).ifPresent(emp -> model.addAttribute("vo", emp));
		
		return "thymeleaf/emps/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(Emp emp, PageVO vo, RedirectAttributes rttr ){
		
		log.info("Modify emp: " + emp);
		
		
		repo.findById(emp.getEmpno()).ifPresent( origin ->{
		 
			origin.setEname(emp.getEname());
			origin.setGender(emp.getGender());
			origin.setJob(emp.getJob());
			origin.setHiredate(emp.getHiredate());
			origin.setMgr(emp.getMgr());
			origin.setSal(emp.getSal());
			origin.setComm(emp.getComm());
			origin.setDept(emp.getDept());
			
			repo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("Empno", origin.getEmpno());
		});

		log.info("emp = " + emp);
		log.info("empa = " + emp.getDept());
		
//		페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("empno", emp.getEmpno());
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/emps/view";
	}
	
	@PostMapping("/delete")
	public String delete(Integer empno, PageVO vo, RedirectAttributes rttr ){
		
		log.info("DELETE empno: " + empno);
		
		repo.deleteById(empno);
		
		rttr.addFlashAttribute("msg", "success");

		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/emps/list";
	}
	
	@GetMapping("/list")
	public String list(PageVO vo, Model model) {
		log.info("/emps/list...");
		
		Pageable pageable = vo.makePageable(0, "empno");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());
		Page<Emp> result = repo.findAll(predicate, pageable);
		
		model.addAttribute("pageMaker", new PageMaker(result));
		
		return "thymeleaf/emps/list";
	}
	
	
	
}
