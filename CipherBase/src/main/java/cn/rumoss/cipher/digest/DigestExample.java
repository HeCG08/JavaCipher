package cn.rumoss.cipher.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DigestExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        byte[] input = "HelloCipher".getBytes();
        // 使用SHA初始化MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("SHA");

        // 分两步：先update,再digest
        // (1)update
        //digest.update(input);
        // (2)digest
        //byte[] output = digest.digest();

        byte[] output = digest.digest(input);// 一次性操作

        // [10, 81, 9, 87, -6, 123, -125, 116, 31, 11, -58, 21, -79, -65, 53, 49, -95, 88, 83, 74]
        System.out.println(Arrays.toString(output));

    }
}
