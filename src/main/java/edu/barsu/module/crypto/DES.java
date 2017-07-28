package edu.barsu.module.crypto;

import javax.crypto.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DES {
    private final static String ALGORITHM = "DES";

    private Key key;

    private Cipher cipher;

    public DES() throws NoSuchPaddingException, NoSuchAlgorithmException {
        cipher = Cipher.getInstance(ALGORITHM);
    }

    public final Key genKey() throws Exception {
        return key = KeyGenerator.getInstance(ALGORITHM).generateKey();
    }

    public final void setKey(Key key) {
        this.key = key;
    }

    public final byte[] encrypt(String input) throws InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(input.getBytes());
    }

    public final String decrypt(byte[] sendBytes, int count) throws InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] encryptionBytes = new byte[count];

        for (int i = 0; i < count; ++i)
            encryptionBytes[i] = sendBytes[i];

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes =
                cipher.doFinal(encryptionBytes);

        return new String(recoveredBytes);
    }

    public static Key getKeyFromFile(String keyPath) {
        try (ObjectInputStream keyIS = new ObjectInputStream(new FileInputStream(keyPath))) {
            return (Key) keyIS.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}