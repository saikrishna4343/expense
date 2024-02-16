package com.expense.entity;

import com.expense.enums.UserRoles;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity(name = "users")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UUID userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userCountry;
    private Date userDateOfBirth;
    private char userStatus;
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
}
