package cn.rumoss.cipher.parameter;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

public class AlgorithmParametersDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        AlgorithmParameters ap = AlgorithmParameters.getInstance("DES");
        // 使用 BigInteger 生成参数字节数组
        ap.init(new BigInteger("19050619766489163472469").toByteArray());
        // 获得参数字节数组
        byte[]  b = ap.getEncoded();
        System.out.println(new BigInteger(b).toString());

    }
}
