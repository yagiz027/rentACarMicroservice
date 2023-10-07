package com.yagiz.commonservice.utils.annotations;

import java.time.Year;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotFutureYearValidator implements ConstraintValidator<NotFutureYear,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        var currentYear=Year.now().getValue();
        return value <= currentYear;
    }
}
