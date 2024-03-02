package com.project.sltourguide.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_account")
public class User {
    @Id
    @Column(name="user_id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private  String lastName;
    @Column(name="user_name")
    private  String userName;
    @Column(name="email")
    private  String email;
    @Column(name="password")
    private  String password;
    @Column(name="user_type")
    private  int userType;
    @Column(name="user_status")
    private  int userStatus;
    @Column(name="last_updated_time")
    private Date lastUpdatedTime;
    @Column(name="created_time")
    private Date createdTime;
}
