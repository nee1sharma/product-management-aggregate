package com.sharma.nks.products.validators.validators;

public class Result implements ValidationResult {

    public static final Result VALID_RESULT = new Result(true);
    public static final Result INVALID_RESULT = new Result(false);

    private boolean isValid;

    private Result() {}

    public Result(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }
}
