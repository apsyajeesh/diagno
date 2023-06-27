package com.perscholas.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name="Appoinments")
public class Appoinments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private long uid;


    @Column(name = "Test_ID")
    private int tid;

    @Column(name = "AppoinmentDate")
    private int appdate;

    @Column(name = "AppoinmentStatus")
    private String appstatus;


    public Appoinments(int uid, int tid, int appdate, String appstatus) {
        this.uid = uid;
        this.tid = tid;
        this.appdate = appdate;
        this.appstatus = appstatus;
    }
}
