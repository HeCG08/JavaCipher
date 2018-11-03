package cn.rumoss.cipher.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 *  获取秘密密钥的密钥编码字节数组
 */
public class SecretKeyFactoryDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGenerator.generateKey();
        // 获取秘密密钥编码字节数组
        byte[] key = secretKey.getEncoded();
        System.out.println("密钥编码字节数组： " + Arrays.toString(key));

        // 由获得的密钥编码字节数组构建DESKeySpec
        DESKeySpec dks = new DESKeySpec(key);
        // 实例化SecretKeyFactory
        SecretKeyFactory keyFactory =  SecretKeyFactory.getInstance("DES");
        // 生成SecretKey
        SecretKey secretKeyRecover = keyFactory.generateSecret(dks);
        System.out.println("还原后结果： " + secretKey.equals(secretKeyRecover));// 还原后是相等的

    }
}
