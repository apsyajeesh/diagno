package com.perscholas.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "test_id")
    private long testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_type")
    private String testType;

    @Column(name = "lower_range")
    private String lowerRange;

    @Column(name = "upper_range")
    private String upperRange;

    @Column(name = "result_unit")
    private String resultUnit;

}

