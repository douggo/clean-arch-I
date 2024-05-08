package org.douggo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldNotCreateAnInvalidCpf() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF("12345678900"));
    }

    @Test
    void shouldCreateAValidCpf() {
        assertDoesNotThrow(() -> new CPF("123.456.789-00"));
    }

}