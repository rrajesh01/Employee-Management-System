package com.keva.emp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employees")
@Data
public class Employees extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "designation")
    private String designation;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "utss_status")
    private Integer status;

}