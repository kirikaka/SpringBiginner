package org.controller;

import org.spring.RegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRequestValidator implements Validator {
    private static final String emailRegExp =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    public RegisterRequestValidator() {
        pattern = Pattern.compile(emailRegExp);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest regReq=(RegisterRequest)target;
        if(regReq.getEmail() == null || regReq.getEmail().isEmpty()) {
            errors.rejectValue("email", "error.required");
        } else{
            Matcher matcher = pattern.matcher(regReq.getEmail());
            if(!matcher.matches()) {
                errors.rejectValue("email", "error.invalid");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.required");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "error.required");
        if(!regReq.getPassword().isEmpty()) {
            if(!regReq.isPasswordEqualToConfirmPassword()){
                errors.rejectValue("confirmPassword", "nomatch");
            }
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);

    }
}
