package com.laridosos.annotation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {CPFValidator.class})
public @interface CPF {
    public String message() default "CPF inválido, por favor, verifique se o CPF está correto.";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
