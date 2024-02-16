package com.expense.functions;

import com.expense.domain.UserVO;
import com.expense.entity.User;

import java.util.UUID;
import java.util.function.Function;

public class UserFunctions {
    public static UUID generateUserId(){
        return UUID.randomUUID();
    }

    public static Function<UserVO, User> userVOToUserFn = userVO ->
             User.builder()
                     .userId(userVO.getUserId())
                     .userFirstName(userVO.getUserFirstName())
                     .userLastName(userVO.getUserLastName())
                     .userEmail(userVO.getUserEmail())
                     .userCountry(userVO.getUserCountry())
                     .userDateOfBirth(userVO.getUserDateOfBirth())
                     .userRole(userVO.getUserRole())
                     .userStatus(userVO.getUserStatus())
                     .build();

    public static Function<User, UserVO> userToUserVOFn = user ->
            UserVO.builder()
                    .userId(user.getUserId())
                    .userFirstName(user.getUserFirstName())
                    .userLastName(user.getUserLastName())
                    .userEmail(user.getUserEmail())
                    .userCountry(user.getUserCountry())
                    .userDateOfBirth(user.getUserDateOfBirth())
                    .userRole(user.getUserRole())
                    .userStatus(user.getUserStatus())
                    .build();

}
