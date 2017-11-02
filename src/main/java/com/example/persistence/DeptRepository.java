package com.example.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Dept;
import com.example.domain.QDept;
import com.example.domain.QWebBoard;
import com.example.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface DeptRepository extends JpaRepository<Dept, Integer>, QuerydslPredicateExecutor<Dept>{

	public default Predicate makePredicate(String type, String keyword){
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QDept dept = QDept.dept;
		
		builder.and(dept.deptno.gt(0));
		
		if(type == null){
			return builder;
		}
		
		switch(type){
		case "no":
			builder.and(dept.deptno.like("%" + keyword +"%"));
			break;
		case "n":
			builder.and(dept.dname.like("%" + keyword +"%"));
			break;
		case "l":
			builder.and(dept.loc.like("%" + keyword +"%"));
			break;
		}
		
		return builder;
	}
	

}





