package org.douggo;

import java.util.Objects;

/* Value Object */
public class Telefone {

    private String ddd;
    private String number;

    public Telefone(String ddd, String number) {
        this.validateDdd(ddd);
        this.validateNumber(number);
        this.ddd = ddd;
        this.number = number;
    }

    private void validateDdd(String ddd) throws IllegalArgumentException {
        if (!Objects.isNull(ddd) && ddd.matches("\\d{2}")) {
            return;
        }
        throw new IllegalArgumentException("DDD doesn't meet the condition of 2 numbers");
    }

    private void validateNumber(String number) throws IllegalArgumentException {
        if (!Objects.isNull(number) && number.matches("\\d{4,5}-\\d{4}")) {
            return;
        }
        throw new IllegalArgumentException("Telefone number doesn`t meet the requirements!");
    }

}
