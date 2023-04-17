package com.bookyourcab.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tblUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "userFirstName", nullable = false)
    private String userFirstName;
    @Column(name = "userLastName", nullable = false)
    private String userLastName;
    @Column(name = "userEmail",unique = true,nullable = false)
    private String userEmail;
    @Column(name = "userMobile", nullable = false,unique = true)
    private String userMobile;
    @Column(name = "userCreationDate")
    private LocalDate userCreationDate;

}
