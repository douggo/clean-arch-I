package org.douggo.dominio.aluno;

import java.util.Objects;

/* Value Object (doesn't have an attribute to differentiate */
public class Email {

    private final String address;

    public Email(String address) {
        if (Objects.isNull(address) || !address.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Address doesn't match as an electronic address");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }
}
