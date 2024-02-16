package com.expense.validator;

import com.expense.domain.UserVO;
import com.expense.entity.User;
import com.expense.expection.ExceptionType;
import com.expense.expection.ExpenseException;
import com.expense.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserValidator implements ExpenseValidator<UserVO> {

    UserRepository userRepository;
    public void validateNewUser(UserVO userVO){
        Optional<User> optionalUser = userRepository.findByUserEmail(userVO.getUserEmail());
        if(optionalUser.isPresent()){
            throw new ExpenseException(ExceptionType.VALIDATION_EXCEPTION, String.format("User with email %s", userVO.getUserEmail()));
        }
    }
}
