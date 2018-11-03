package cn.rumoss.cipher.cert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.CodeSigner;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;

/**
 *  验证代码签名
 */
public class CodeSignerDemo {
    public static void main(String[] args) throws CertificateException, FileNotFoundException {

        // 构建CertificateFactory
        CertificateFactory cerFactory = CertificateFactory.getInstance("X509");
        // 生成CertPath
        CertPath cerPath = cerFactory.generateCertPath(new FileInputStream("F:/x509.cer"));
        // 实例化时间戳
        Timestamp tStamp = new Timestamp(new Date(),cerPath);
        // 实例化CodeSigner
        CodeSigner cs = new CodeSigner(cerPath,tStamp);
        // 获取对比结果
        boolean status =  cs.equals(new CodeSigner(cerPath,tStamp));
        System.out.println("对比结果： " + status);

    }
}
