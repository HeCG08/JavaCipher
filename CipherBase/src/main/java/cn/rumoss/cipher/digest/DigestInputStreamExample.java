package cn.rumoss.cipher.digest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DigestInputStreamExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        byte[] input = "HelloCipher".getBytes();
        // 使用SHA初始化MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("SHA");

        // 构建DigestInputStream对象
        DigestInputStream dis = new DigestInputStream(new ByteArrayInputStream(input),digest);
        dis.read(input,0,input.length);
        byte[] output = dis.getMessageDigest().digest();
        dis.close();// 关闭流

        // [10, 81, 9, 87, -6, 123, -125, 116, 31, 11, -58, 21, -79, -65, 53, 49, -95, 88, 83, 74]
        System.out.println(Arrays.toString(output));

    }
}
