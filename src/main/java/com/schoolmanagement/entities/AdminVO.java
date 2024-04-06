package com.schoolmanagement.entities;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="admins")
public class AdminVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADMIN_ID",nullable=false)
	private Long adminId;
	

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private User user;
	
	private Long roleId;
	
	
	@Column(name="Admin_SCH_ID")
	private Long admin_schId;
	
	
	@Column(name="ADMIN_FNAME",nullable=false)
	private String adminFname;
	@Column(name="ADMIN_LNAME")
	private String adminLname;
	@Column(name="ADMIN_EMAIL",nullable=false)
	private String email;
//	@Column(name="STU_PASS",nullable=false)
//	private String password;
	@Column(name="ADMIN_ADD")
	private String adminAddress;
//	@Column(name="STU_ADD")
//	private String stuAadharNo;
	@Column(name="ADMIN_AGE")
	private int adminAge;
	@Column(name="ADMIN_GENDER")
	private String adminGender;
	private Date crtDate;
	private Date lstUpdtDate;
	

}
