package com.cs.miu.hcmc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false)
    @NotBlank
    private String patientNumber;
    @Column(nullable = false)
    @NotBlank
    private String isAnOutPatient;
    @Column(nullable = false)
    @NotBlank
    private String fullNames;
    private String emailAddress;
    private String contactPhoneNumber;
    @Column(nullable = false)
    @NotBlank
    private LocalDate dateOfBirth;

    public boolean isElderly(){
        return (this.dateOfBirth.isBefore(LocalDate.now().minusYears(65l)));
    }
}