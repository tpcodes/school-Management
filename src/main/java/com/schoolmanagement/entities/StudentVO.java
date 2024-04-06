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
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name="STUDENTS")
public class StudentVO {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STU_ID",nullable=false)
	private Long stuId;
	

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private User user;
	
	private Long roleId;
	
//	private Long user_id;
	
	@Column(name="STU_SCH_ID")
	private Long stu_schId;
	
	
	@Column(name="STU_FNAME",nullable=false)
	private String stuFname;
	@Column(name="STU_LNAME")
	private String stuLname;
	@Column(name="STU_EMAIL",nullable=false)
	private String email;
//	@Column(name="STU_PASS",nullable=false)
//	private String password;
	@Column(name="STU_ADD")
	private String stuAddress;
//	@Column(name="STU_ADD")
//	private String stuAadharNo;
	@Column(name="STU_AGE")
	private int stuAge;
	@Column(name="STU_GENDER")
	private String stuGender;
	private Date crtDate;
	private Date lstUpdtDate;
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return this.password;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.email;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
	
	
	
	
}
