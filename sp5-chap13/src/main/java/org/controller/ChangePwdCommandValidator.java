package org.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePwdCommandValidator implements Validator {
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "newPassword", "field.required");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ChangePwdCommand.class.isAssignableFrom(aClass);
    }
}
