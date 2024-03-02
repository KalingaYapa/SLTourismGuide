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
@Table(name = "room_type")
public class RoomType {
    @Id
    @Column(name = "room_type_id")
    private long roomId;
    @Column(name = "room_type_desc")
    private  String Name;

}
