package org.douggo.dominio.aluno;

public interface PasswordEncryption {

    String encryptPassword(String password);

    boolean validateEncryptedPassword(String password, String encryptedPassword);

}
