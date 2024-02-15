package com.expense.service;

import com.expense.domain.UserVO;
import com.expense.expection.ExceptionType;
import com.expense.expection.ExpenseException;
import com.expense.functions.UserFunctions;
import com.expense.repository.UserRepository;
import com.expense.validator.UserValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserValidator userValidator;

    public UserVO addNewUser(UserVO userVO){
        try{
            userValidator.validateNewUser(userVO);
            userVO.setUserId(UserFunctions.generateUserId());
            return UserFunctions.userToUserVOFn.apply(userRepository.save(UserFunctions.userVOToUserFn.apply(userVO)));
        }catch (ExpenseException expenseException){
            throw expenseException;
        }catch (Exception e){
            throw new ExpenseException(ExceptionType.INTERNAL_EXCEPTION, ExceptionUtils.getMessage(e));
        }

    }
}
