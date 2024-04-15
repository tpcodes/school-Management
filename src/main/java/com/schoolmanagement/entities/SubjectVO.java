package com.schoolmanagement.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="subjects")
public class SubjectVO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sub_id",nullable=false)
	private long subId;
	private String subCode;
	@Column(name="SUB_NAME",nullable=false)
	private String subName;
	@Column(name="sub_desc",nullable=false)
	private String subDesc;
	
	
	private Date crtDate;
	private Date lstUpdtDate;
	
}
