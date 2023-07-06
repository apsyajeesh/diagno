package com.perscholas.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "location")
    private String location;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "status")
    private String status;
}
