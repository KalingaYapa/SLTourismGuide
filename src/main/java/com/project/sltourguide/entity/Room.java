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
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private long roomId;
    @Column(name = "room_name")
    private  String Name;
    @Column(name = "room_type")
    private  int roomType;
    @Column(name="last_updated_time")
    private Date lastUpdatedTime;
    @Column(name="created_time")
    private Date createdTime;

}
