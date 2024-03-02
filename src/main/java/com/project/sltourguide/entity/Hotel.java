package com.project.sltourguide.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "hotel_id")
    private long roomId;
    @Column(name = "hotel_name")
    private  String Name;
    @Column(name = "hotel_desc",columnDefinition = "text")
    private  String roomType;
    @Column(name="last_updated_time")
    private Date lastUpdatedTime;
    @Column(name="created_time")
    private Date createdTime;
    @Column(name="address",columnDefinition = "text")
    private  String address;
    @Column(name="location_url",columnDefinition = "text")
    private  String locationURL;
}
