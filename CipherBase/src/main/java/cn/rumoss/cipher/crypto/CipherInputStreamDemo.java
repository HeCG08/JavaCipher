package cn.rumoss.cipher.crypto;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *  使用密钥输入流解密文件中的数据
 */
public class CipherInputStreamDemo {

    public static void decryData(SecretKey secretKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException {

        // 实例化Cipher
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,secretKey);

        // 实例化CipherInputStream
        CipherInputStream cis = new CipherInputStream(new FileInputStream("F:/secret"),cipher);
        DataInputStream dis = new DataInputStream(cis);

        // 读出解密后的数据
        String output = dis.readUTF();
        System.out.println("解密出的数据： " + output);
        dis.close();

    }

}
