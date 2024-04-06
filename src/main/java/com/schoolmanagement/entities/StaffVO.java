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
@Table(name="STAFF")
public class StaffVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STAFF_ID",nullable=false)
	private Long staffId;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private User user;
	private Long roleId;

	@Column(name="STAFF_SCH_ID")
	private Long staff_schId;
	
	
	@Column(name="STAFF_FNAME",nullable=false)
	private String staffFname;
	@Column(name="STAFF_LNAME")
	private String staffLname;
	@Column(name="STAFF_EMAIL",nullable=false)
	private String email;
//	@Column(name="STU_PASS",nullable=false)
//	private String password;
	@Column(name="STAFF_ADD")
	private String staffAddress;
//	@Column(name="STU_ADD")
//	private String stuAadharNo;
	@Column(name="STAFF_AGE")
	private int staffAge;
	@Column(name="STAFF_GENDER")
	private String staffGender;
	private Date crtDate;
	private Date lstUpdtDate;

}
