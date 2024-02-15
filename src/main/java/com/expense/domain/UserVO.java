package com.expense.domain;

import com.expense.enums.UserRoles;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    private UUID userId;
    @NotNull(message = "Missing First Name")
    private String userFirstName;
    @NotNull(message = "Missing Last Name")
    private String userLastName;
    @NotNull(message = "Missing Email")
    private String userEmail;
    @NotNull(message = "Missing Phone Number")
    private BigInteger userPhoneNumber;
    @NotNull(message = "Missing Phone Number Country Code")
    private BigInteger userCountryPhoneCode;
    @NotNull(message = "Missing Country")
    private String userCountry;
    @NotNull(message = "Missing Date Of Birth")
    private Date userDateOfBirth;
    private char userStatus = 'A';
    private UserRoles userRole = UserRoles.BASIC;
}
