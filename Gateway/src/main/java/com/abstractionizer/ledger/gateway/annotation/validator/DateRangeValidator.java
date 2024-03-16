package com.abstractionizer.ledger.gateway.annotation.validator;

import com.abstractionizer.ledger.gateway.annotation.DateRange;
import com.abstractionizer.ledger.gateway.model.dto.DateRangeQry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class DateRangeValidator implements ConstraintValidator<DateRange, DateRangeQry> {

    private int numberOfMonth;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        numberOfMonth = constraintAnnotation.maxRange();
    }

    @Override
    public boolean isValid(DateRangeQry dateRangeQry, ConstraintValidatorContext constraintValidatorContext) {

        if (dateRangeQry.getFrom() == null) {
            genConstraintViolation(constraintValidatorContext, "From date must not be null", "from");
            return false;
        }

        if (dateRangeQry.getTo() == null) {
            genConstraintViolation(constraintValidatorContext, "To date must not be null", "to");
            return false;
        }

        if (dateRangeQry.getFrom().isAfter(dateRangeQry.getTo())) {
            genConstraintViolation(constraintValidatorContext, "To date must not be later than From date", "from");
            return false;
        }

        LocalDateTime maxDateRange = dateRangeQry.getFrom().plusMonths(numberOfMonth);
        if(dateRangeQry.getTo().equals(maxDateRange) || dateRangeQry.getTo().isAfter(maxDateRange)){
            genConstraintViolation(constraintValidatorContext, "Query range date must not exceed " + numberOfMonth + " month", "from");
            return false;
        }
        return true;
    }

    private void genConstraintViolation(ConstraintValidatorContext constraintValidatorContext, String message, String property) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(property).addConstraintViolation();
    }
}
