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
@Table(name="SCHOOLS")
public class SchoolVO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCH_ID",nullable=false)
	private long schId;
	@Column(name="SCH_NAME",nullable=false)
	private String schName;
	@Column(name="SCH_REG_NO",nullable=false)
	private String schRegNo;
	@Column(name="SCH_EMAIL",nullable=false)
	private String email;
	@Column(name="SCH_PASS")
	private String password;

	@Column(name="SCH_ADD")
	private String schAddress;

	private String principalName;
	private String stndrdStart;
	private String stndrdEnd;
	private String moto;
	private String aboutUs;
	private String logo;
	
	private Date crtDate;
	private Date lstUpdtDate;
	
}
