package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;

@Entity // 클래스가 엔티티 클래스임을 명시
@Table(name = "tbl_city") // 데이터베이스에 동일한 이름으로 생성
@Data
@ToString(exclude = { "country" }) // ToString 메소드 생성, exclude = { "country" } ==> country는 제외
public class City {

	@Id
	private Integer id;
	private String name;
	private String district;
	private Integer population;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "countrycode")
	private Country country;

	
}
