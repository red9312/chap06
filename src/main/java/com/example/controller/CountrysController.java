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

import com.example.domain.Country;
import com.example.persistence.CountryRepository;
import com.example.vo.PageMaker;
import com.example.vo.PageVO;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller //controller로 동작한다.
@RequestMapping("/countrys/")  // mapping
@Log
public class CountrysController {

	
	@Autowired  // 타입을 이용하여 의존하는 객체를 삽입해주는 역할
	private CountryRepository repo;
	
	@GetMapping("/register")
	public String registerGET(@ModelAttribute("vo")Country vo ){   
		// 요청으로 들어온 bind된 object를 Model에 Attribute로 추가시켜준다

		log.info("register get");
		
		return "thymeleaf/countrys/register";
				
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")Country vo, RedirectAttributes rttr){
		
		log.info("register post");
		log.info("" + vo);
		
		repo.save(vo);
		rttr.addFlashAttribute("msg", "success"); // (등록 알림 처리)
		
		return "redirect:/countrys/list"; // 작성이 완료되면 리스트로 돌려준다.
	}
	
	@GetMapping("/view")
	public String view(String code, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("Code: "+ code);
		
		repo.findById(code).ifPresent(country -> model.addAttribute("vo", country));
		
		return "thymeleaf/countrys/view";
	}
	
	@GetMapping("/modify")
	public String modify(String code, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("MODIFY Code: "+ toString());
		
		repo.findById(code).ifPresent(country -> model.addAttribute("vo", country));
		
		return "thymeleaf/countrys/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(Country country, PageVO vo, RedirectAttributes rttr ){
		
		log.info("Modify Country: " + country);
		
		repo.findById(country.getCode()).ifPresent( origin ->{
			
			origin.setCode(country.getCode());
			origin.setGnpold(country.getGnpold());
			origin.setLocalname(country.getLocalname());
			origin.setGovernmentform(country.getGovernmentform());
			origin.setHeadofstate(country.getHeadofstate());
			origin.setCapital(country.getCapital());
			origin.setCode2(country.getCode2());
			origin.setName(country.getName());
			origin.setContinent(country.getContinent());
			origin.setRegion(country.getRegion());
			origin.setSurfacearea(country.getSurfacearea());
			origin.setIndepyear(country.getIndepyear());
			origin.setPopulation(country.getPopulation());
			origin.setLifeexpectancy(country.getLifeexpectancy());
			origin.setGnp(country.getGnp());
			
			repo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("code", origin.getCode());
		});
		
		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/countrys/view";
	}
	
	
	@PostMapping("/delete")
	public String delete(String code, PageVO vo, RedirectAttributes rttr ){
		
		log.info("DELETE Code: " + code);
		
		repo.deleteById(code);
		
		rttr.addFlashAttribute("msg", "success");

		// 페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/countrys/list";
	}
	
	// 검색 처리
	@GetMapping("/list")
	public String list(@ModelAttribute("pageVO") PageVO vo, Model model){
		// 요청으로 들어온 bind된 object를 Model에 Attribute로 추가시켜준다
		
		Pageable pageable = vo.makePageable(0, "code");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());
		
//		Page<WebBoard> result = repo.findAll(
//				repo.makePredicate(vo.getType(), 
//						           vo.getKeyword()), page);
		
		Page<Country> result = repo.findAll(predicate, pageable);
		
		log.info(""+ pageable);
		log.info(""+result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		
		
		model.addAttribute("pageMaker", new PageMaker<Country>(result));
		
		return "thymeleaf/countrys/list";
		
	}

}



//ver 1
//@GetMapping("/list")
//public void list(
//		@PageableDefault(
//				direction=Sort.Direction.DESC, 
//				sort="bno" , 
//				size=10 , 
//				page = 0) Pageable page , Model model ) {
//
//	log.info("list() called..." + page);
//	
//	Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), page);
//
//	PageMaker<WebBoard> pgMaker = new PageMaker<>(result.getContent(), 
//			result.getTotalPages(), 
//			result.getPageable());
//	
//	
//	log.info(""+pgMaker);
//	
//	model.addAttribute("result", pgMaker);
//
//}

//ver 2
//@GetMapping("/list")
//public void list(PageVO vo, Model model){
//	
//	Pageable page = vo.makePageable(0, "bno");
//	
//	Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), page);
//	
//	log.info(""+ page);
//	log.info(""+result);
//	
//	log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
//	
//	
//	model.addAttribute("result", new PageMaker(result));
//			
//}


