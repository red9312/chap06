package com.example.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.ToString;

/*
 * 1. @OneToOne
 * 2. @OneToMany
 * 3. @ManyToOne
 * 4. @ManyToMany
 */
@Entity
@Table(name="dept")
@Data
@ToString(exclude={"emps"})
public class Dept {

	@Id
	@TableGenerator(name="idGen", table="id_gen", pkColumnName="seq_name", valueColumnName="nextval",
						allocationSize=1, initialValue=0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="idGen")
	Integer deptno;
	String dname;
	String loc;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn
	List<Emp> emps;	
	
}
