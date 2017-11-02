package com.example.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.domain.Country;
import com.example.domain.QCountry;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface CountryRepository extends JpaRepository<Country, String>, QuerydslPredicateExecutor<Country>{
// JpaRepository<WebBoard, Long> ==> JPA 처리방법 < 엔티티 타입 클래스 , 식별자(PK)의 타입 >
// QuerydslPredicateExecutor<WebBoard> ==> QueryDsl Predicate 인스턴스의 실행을 허용하는 인터페이스 
	public default Predicate makePredicate(String type, String keyword){
		
		BooleanBuilder builder = new BooleanBuilder();
		// Predicate , 이 조건이 맞다고 판단하는 근거
		// Boolean으로 리턴되는 결과 데이터를 생성
		
		QCountry country = QCountry.country;
		// Board의 속성을 이용해서 다양한 SQL에 필요한 구문을 처리할수있는 기능이 추가된형태로 SQL을 구성하는데 도움을 준다.
		
		builder.and(country.code.gt(""));
		
		if(type == null){
			
			return builder;
		}
		
		
		// 검색 조건
		switch(type){
		case "code": 
			builder.and(country.code.like(keyword+ "%"));
			break;
		case "name":
			builder.and(country.name.like(keyword +"%"));
			break;
		case "localname":
			builder.and(country.localname.like(keyword +"%"));
			break;
			
		}
		return builder;
	}
	

}





