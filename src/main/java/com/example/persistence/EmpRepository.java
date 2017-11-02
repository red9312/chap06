package com.example.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Emp;
import com.example.domain.QEmp;
import com.example.domain.QWebBoard;
import com.example.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface EmpRepository extends JpaRepository<Emp, Integer>, QuerydslPredicateExecutor<Emp>{

	public default Predicate makePredicate(String type, String keyword){
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QEmp Emp = QEmp.emp;
		
		builder.and(Emp.empno.gt(0));
		
		if(type == null){
			return builder;
		}
		
		switch(type){
		case "eno":
			builder.and(Emp.empno.like("%" + keyword +"%"));
			break;
		case "n":
			builder.and(Emp.ename.like("%" + keyword +"%"));
			break;
		case "dno":
			builder.and(Emp.dept.deptno.like("%" + keyword +"%"));
			break;
		}
		
		return builder;
	}
	

}





