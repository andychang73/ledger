package com.abstractionizer.ledger.gateway.annotation;

import com.abstractionizer.ledger.gateway.annotation.validator.DateRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {

    String message() default "{error.DateRange}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int maxRange() default 0;
}
