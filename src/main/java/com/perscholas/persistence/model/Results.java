package com.perscholas.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name="Results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long uid;


    @Column(name = "TestID")
    private int tid;

    @Column(name = "AppoinmentID")
    private int appid;

    @Column(name = "ResultStatus")
    private String rstatus;

    @Column(name = "Results")
    private int results;


    public Results(long uid, int tid, int appid, String rstatus, int results) {
        this.uid = uid;
        this.tid = tid;
        this.appid = appid;
        this.rstatus = rstatus;
        this.results = results;
    }

}