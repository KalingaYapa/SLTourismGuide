package com.project.sltourguide.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SLTourUser {
    @Id
    private int id;

    private String firstName;

    private  String lastName;
}
