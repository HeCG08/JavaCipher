package cn.rumoss.cipher.crypto;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import java.security.*;

/**
 *  DH算法密钥对生成
 */
public class DHAlgorithDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        KeyPair kp1 = kpg.genKeyPair();
        KeyPair kp2 = kpg.genKeyPair();

        // 实例化KeyAgreement
        KeyAgreement keyAgree = KeyAgreement.getInstance(kpg.getAlgorithm());
        // 初始化
        keyAgree.init(kp2.getPrivate());
        // 执行计划
        keyAgree.doPhase(kp1.getPublic(),true);
        // 生成SecretKey
        SecretKey secretKey = keyAgree.generateSecret("DES");
        System.out.println(secretKey.getAlgorithm());

    }
}
