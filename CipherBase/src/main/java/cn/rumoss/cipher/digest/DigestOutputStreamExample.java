package cn.rumoss.cipher.digest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DigestOutputStreamExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        byte[] input = "HelloCipher".getBytes();
        // 使用SHA初始化MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("SHA");

        // 构建DigestOutputStream对象
        DigestOutputStream dos = new DigestOutputStream(new ByteArrayOutputStream(),digest);
        // 流输出
       dos.write(input,0,input.length);

        byte[] output = dos.getMessageDigest().digest();
        dos.close();// 关闭流

        // [10, 81, 9, 87, -6, 123, -125, 116, 31, 11, -58, 21, -79, -65, 53, 49, -95, 88, 83, 74]
        System.out.println(Arrays.toString(output));

    }
}
