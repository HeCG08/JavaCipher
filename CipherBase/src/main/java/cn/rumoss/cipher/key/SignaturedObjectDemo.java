package cn.rumoss.cipher.key;

import java.io.IOException;
import java.security.*;

/**
 *  数字签名对象处理
 */
public class SignaturedObjectDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException,SignatureException, IOException {

        // 将被签名的信息
        byte[] data = "HelloCipher".getBytes();
        // 实例化 KeyPairGenerator ,指定DSA算法
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DSA");
        // 初始化 KeyPairGenerator
        kpGen.initialize(1024);
        // 生成KeyPair
        KeyPair keyPair = kpGen.genKeyPair();

        // 实例化Signature
        Signature signature = Signature.getInstance(kpGen.getAlgorithm());

        // 实例化SignedObject
        SignedObject so = new SignedObject(data,keyPair.getPrivate(),signature);
        // 获得签名
        byte[] sign = so.getSignature();

        // 验证结果
        boolean status = so.verify(keyPair.getPublic(),signature);
        System.out.println("验证结果： " + status);

    }
}
