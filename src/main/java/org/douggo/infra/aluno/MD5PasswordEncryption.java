package org.douggo.infra.aluno;

import org.douggo.dominio.aluno.PasswordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordEncryption implements PasswordEncryption {

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i< bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar o hash da senha");
        }
    }

    @Override
    public boolean validateEncryptedPassword(String password, String encryptedPassword) {
       return this.encryptPassword(password).equals(encryptedPassword);
    }

}
