package cn.rumoss.cipher.parameter;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

public class AlgorithmParameterGeneratorDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        // 实例化AlgorithmParameterGenerator
        AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DES");
        // 初始化
        apg.init(56);
        AlgorithmParameters ap = apg.generateParameters();
        byte[]  b = ap.getEncoded();
        System.out.println(new BigInteger(b).toString());
        /**
         * 注：jdk运行报错-NoSuchAlgorithmException: DES AlgorithmParameterGenerator not available
         * 需要引入bcprov
         */

    }
}
