package cn.rumoss.cipher.key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyPairGenDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator kpg =  KeyPairGenerator.getInstance("DSA");
        // 初始化
        kpg.initialize(1024);
        // 生成KeyPair对象
        KeyPair keys = kpg.genKeyPair();

    }
}
