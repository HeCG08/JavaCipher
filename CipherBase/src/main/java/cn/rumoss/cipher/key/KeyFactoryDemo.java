package cn.rumoss.cipher.key;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyFactoryDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator kpg =  KeyPairGenerator.getInstance("RSA");
        // 初始化
        kpg.initialize(1024);
        // 生成KeyPair对象
        KeyPair keyPair = kpg.genKeyPair();
        // 获取私钥密钥字节数组
        Key privateK = keyPair.getPrivate();// 获得Key

        byte[] keyBytes = privateK.getEncoded();
        // 由私钥字节数组获得密钥规范
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // 实例化密钥工厂,并指定RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        // 生成私钥
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);// 还原Key

    }
}
