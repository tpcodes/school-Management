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
@Table(name="TEACHERS")
public class TeacherVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tchr_ID",nullable=false)
	private Long tchrId;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private User user;
	private Long roleId;

	@Column(name="TCHR_SCH_ID")
	private Long tchr_schId;

	@Column(name="TCHR_FNAME",nullable=false)
	private String tchrFname;
	@Column(name="TCHR_LNAME")
	private String tchrLname;
	@Column(name="TCHR_EMAIL",nullable=false)
	private String email;
//	@Column(name="STU_PASS",nullable=false)
//	private String password;
	@Column(name="TCHR_ADD")
	private String tchrAddress;
//	@Column(name="STU_ADD")
//	private String stuAadharNo;
	@Column(name="TCHR_AGE")
	private int tchrAge;
	@Column(name="TCHR_GENDER")
	private String tchrGender;
	private Date crtDate;
	private Date lstUpdtDate;
}
