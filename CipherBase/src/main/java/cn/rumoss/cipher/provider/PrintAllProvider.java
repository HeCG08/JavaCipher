package cn.rumoss.cipher.provider;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class PrintAllProvider {
    public static void main(String[] args) {

        int idx = 1;
        // 遍历所有的安全提供者
        for (Provider p : Security.getProviders()) {
            System.out.println(p);
            for (Map.Entry<Object,Object> entry: p.entrySet()){
                //System.out.println("\t" + entry.getKey() + "\t" + entry.getValue());
                System.out.println("\t" + entry.getKey());
            }
            idx++;
        }
        System.out.println("总个数：" + idx);

    }
}
