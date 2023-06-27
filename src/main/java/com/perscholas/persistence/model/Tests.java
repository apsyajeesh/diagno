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
@Table(name="Tests")
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TestID")
    private int tid;

    @Column(name = "TestName")
    private String tname;

    @Column(name = "TestType")
    private String ttype;

    @Column(name = "Range")
    private int trange;

    @Column(name = "Unit")
    private int tunit;

}

