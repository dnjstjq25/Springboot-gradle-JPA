package com.use.gradle.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "car")
public class Car {
    @Id
    private String car_number;
    private String car_name;
    private String car_status;
    private String car_remark;
}
