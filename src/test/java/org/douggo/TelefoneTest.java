package org.douggo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void shouldNotCreateTelefoneWithAnInvalidDdd() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "3535-3535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "3535-3535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "3535-3535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("A", "3535-3535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("!", "3535-3535"));
    }

    @Test
    void shouldNotCreateTelefoneWithAnInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "35353535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "3535-353"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "33535-535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "535-35535"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "535-335"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "A"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "A-ASw"));
    }

    @Test
    void shouldCreateTelefoneWithValidData8Digits() {
        assertDoesNotThrow(() -> new Telefone("47", "3535-3535"));
    }

    @Test
    void shouldCreateTelefoneWithValidData9Digits() {
        assertDoesNotThrow(() -> new Telefone("47", "98888-9999"));
    }

}