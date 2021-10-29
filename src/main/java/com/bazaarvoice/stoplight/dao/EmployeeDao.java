package com.bazaarvoice.stoplight.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Employee") 
public class EmployeeDao{

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="gender")
    private String gender;
    @Column(name="office_location")
    private String officeLocation;
    @Column(name="profile_pic")
    private String profilePic;
    @Column(name="title")
    private String title;



}