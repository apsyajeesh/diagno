package com.perscholas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private String testName;
    private String patientName;
    private String location;
    private String appointmentDate;
    private String appointmentTime;
}
