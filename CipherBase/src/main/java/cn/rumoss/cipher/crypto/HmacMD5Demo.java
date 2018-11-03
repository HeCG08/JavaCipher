package cn.rumoss.cipher.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *  HmacMD5 算法摘要处理
 */
public class HmacMD5Demo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        byte[] input = "HelloCipher".getBytes();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        // 构建SecretKey
        SecretKey secretKey = keyGenerator.generateKey();

        System.out.println(secretKey.getAlgorithm());

        // 构建Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 获取安全摘要后的信息
        byte[] output = mac.doFinal(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(output));

    }
}
