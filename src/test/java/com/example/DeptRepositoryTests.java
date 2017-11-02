package com.example;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.domain.WebBoard;
import com.example.persistence.DeptRepository;
import com.example.persistence.WebBoardRepository;
import com.example.vo.PageMaker;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class DeptRepositoryTests {

	@Autowired
	DeptRepository repo;

	@Test
	public void insertDeptDummies() {

		IntStream.range(0, 30).forEach(i -> {

			Dept dept = new Dept();

			dept.setDeptno(i + 1);
			dept.setDname("Content Sample ..." + i + " of dname");
			dept.setLoc("locloc" + i);

			repo.save(dept);
		});

	}

//	@Test
//	public void testList1() {
//
//		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
//
//		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), pageable);
//
//		log.info("PAGE: " + result.getPageable());
//
//		log.info("----------------------");
//
//		log.info("PageNumber: " + result.getPageable().getPageNumber());
//
//		log.info("TotalPages " + result.getTotalPages());
//
//		log.info("" + result.getPageable());
//
//		result.getContent().forEach(board -> log.info("" + board));
//		
//
//	}
//
//	@Test
//	public void testList2() {
//
//		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
//
//		Page<WebBoard> result = repo.findAll(repo.makePredicate("t", "10"), pageable);
//
//		log.info("PAGE: " + result.getPageable());
//
//		log.info("----------------------");
//		result.getContent().forEach(board -> log.info("" + board));
//
//	}
//	
//	@Test
//	public void testPaging() {
//
//		//3 page , size = 20
//		Pageable pageable = PageRequest.of(29, 10, Direction.DESC, "bno");
//
//		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), pageable);
//
//		PageMaker<WebBoard> pgMaker = new PageMaker<>(result);
//		
//		log.info("prev page: " +  pgMaker.getPrevPage());
//
//		pgMaker.getPageList().forEach(p -> log.info(""+(p.getPageNumber() +1) ));
//		
//		log.info("next page: " +  pgMaker.getNextPage());
//
//	}

}
