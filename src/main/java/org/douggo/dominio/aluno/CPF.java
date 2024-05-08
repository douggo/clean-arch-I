package org.douggo.dominio.aluno;

import java.util.Objects;

/* Value Object */
public class CPF {

    private final String value;

    public CPF(String value) {
        if (Objects.isNull(value) || !value.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF isn't formatted!");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CPF{" +
                "value='" + value + '\'' +
                '}';
    }
}
