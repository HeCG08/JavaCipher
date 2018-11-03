package cn.rumoss.cipher.key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        SecureRandom secureRandom = new SecureRandom();
        // 实例化 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        // 初始化 KeyGenerator 对象
        kg.init(secureRandom);

        // 生成 SecretKey 对象
        SecretKey secretKey = kg.generateKey();

    }
}
