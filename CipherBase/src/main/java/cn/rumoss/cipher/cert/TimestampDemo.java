package cn.rumoss.cipher.cert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;

/**
 *  数字时间戳
 */
public class TimestampDemo {
    public static void main(String[] args) throws CertificateException, FileNotFoundException {

        // 构建CertificateFactory
        CertificateFactory cerFactory = CertificateFactory.getInstance("X509");
        // 生成CertPath
        CertPath cerPath = cerFactory.generateCertPath(new FileInputStream("F:/x509.cer"));
        // 实例化时间戳
        Timestamp tStamp = new Timestamp(new Date(),cerPath);

    }
}
