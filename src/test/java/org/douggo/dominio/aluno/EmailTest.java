package org.douggo.dominio.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateEmailWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid_email"));
    }

    @Test
    void shouldCreateEmailWithValidAddress() {
        assertDoesNotThrow(() -> new Email("doug@gmail.com"));
    }

}