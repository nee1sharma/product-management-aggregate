package com.sharma.nks.products.validators.validators;

public interface Validator {

    boolean supports(Class<?> clazz);
    ValidationResult validate(Object object);
}
