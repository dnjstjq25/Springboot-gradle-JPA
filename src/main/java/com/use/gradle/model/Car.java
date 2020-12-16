package com.use.gradle.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_car")
public class Car {
    @Id
    private String car_number;
    private String car_name;
    private String car_status;
    private String car_remark;
}
