package cn.rumoss.cipher.crypto;

import javax.crypto.*;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *  使用密钥输出流加密数据到文件中
 */
public class CipherOutputStreamDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException {

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey secretKey = kg.generateKey();

        // 实例化Cipher
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);

        // 原始数据
        String input = "HelloCipher";
        CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("F:/secret"),cipher);
        // 使用DataOutputStream包装CipherOutputStream
        DataOutputStream dos = new DataOutputStream(cos);

        // 向输出流写待加密的数据
        dos.writeUTF(input);

        // 清空、关闭
        dos.flush();
        dos.close();

        CipherInputStreamDemo.decryData(secretKey);

    }
}
