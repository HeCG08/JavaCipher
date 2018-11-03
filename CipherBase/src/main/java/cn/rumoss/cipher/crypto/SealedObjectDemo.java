package cn.rumoss.cipher.crypto;

import javax.crypto.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *  对象加密处理
 */
public class SealedObjectDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException,IllegalBlockSizeException, FileNotFoundException,BadPaddingException,ClassNotFoundException {

        String input = "HelloCipher";
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey secretKey = kg.generateKey();

        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);

        // 构建SealedObject
        SealedObject sealedObject = new SealedObject(input,cipher);
        // 解密的Cipher
        Cipher cipher2 = Cipher.getInstance(secretKey.getAlgorithm());
        cipher2.init(Cipher.DECRYPT_MODE,secretKey);
        String output = (String)sealedObject.getObject(cipher2);
        System.out.println("解密后结果： " + output);

    }
}
