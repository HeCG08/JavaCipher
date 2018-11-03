package cn.rumoss.cipher.key;

import java.security.*;
import java.util.Arrays;

/**
 *  数字签名处理，改造后可以用于数字证书的签名和认证
 */
public class SignatureDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException,SignatureException {

        // 将被签名的信息
        byte[] data = "HelloCipher".getBytes();
        // 实例化 KeyPairGenerator ,指定DSA算法
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DSA");
        // 初始化 KeyPairGenerator
        kpGen.initialize(1024);
        // 生成KeyPair
        KeyPair keyPair = kpGen.generateKeyPair();

        // 实例化Signature
        Signature signature = Signature.getInstance(kpGen.getAlgorithm());
        // 初始化Signature
        signature.initSign(keyPair.getPrivate());
        // 更新
        signature.update(data);
        // 获得签名
        byte[] sign = signature.sign();

        // 验证
        signature.initVerify(keyPair.getPublic());
        // 更新
        signature.update(data);// update都是对初始数据进行操作
        // 验证结果
        boolean status = signature.verify(sign);
        System.out.println("验证结果： " + status);

    }
}
