package com.menga.openapi;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangpeng on 2017/12/27.
 */
public class SignDemo3 {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String KEY_MAC = "HmacMD5";
    private static final String HEXSTR =  "0123456789ABCDEF";

    /**
     * 生成签名
     * @return
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String serviceName = decode("com.isuwang.soa.finance.funder.dianrong.service.FinanceFunderDianrongService");
        String versionName = decode("1.0.0");
        String methodName = decode("pushLoanResultByDianrong");
        String timestamp = decode(String.valueOf(System.currentTimeMillis() / 1000));
        String format = decode("json");
        String appKey = decode("dianrong");
        // 应用级参数
        // 生产
        String parameter = decode("%7B%22request%22%3A%7B%22extendTradeId%22%3A%2216998%22%2C%22code%22%3A%22000000%22%2C%22message%22%3A%22%E7%AD%BE%E7%BA%A6%E8%B4%B7%E6%AC%BEID%3D26713221%E6%88%90%E5%8A%9F%22%2C%22funderId%22%3A%222%22%2C%22assetPoolId%22%3A%220%22%7D%7D");
        // sandbox3

        //系统级参数
        Map<String, String> sysParams = new HashMap<String, String>();
        sysParams.put("serviceName", serviceName);
        sysParams.put("methodName", methodName);
        sysParams.put("versionName", versionName);
        sysParams.put("timestamp", timestamp);
        sysParams.put("format", format);
        sysParams.put("appKey", appKey);

        //对系统级参数进行排序，并拼接上应用级参数
        String data = convertToSortStr(sysParams) + parameter;

        String sign = byte2hex(encryptHMAC(data,"isu20180112"));
        System.out.println("timestamp=" + timestamp);
        System.out.println("sign=" + sign);
}

    public static String decode(String str) throws Exception {
        return URLDecoder.decode(str, "UTF-8");
    }

    private static String convertToSortStr(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }

        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        StringBuilder query = new StringBuilder();

        for (String key : keys) {
            String value = params.get(key);
            if (isNotEmpty(key, value)) {
                query.append(key).append(value);
            }
        }

        return query.toString();
    }

    private static boolean isNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !StringUtils.isEmpty(value);
            }
        }
        return result;
    }

    /**
     * hmac-md5签名
     * @param data
     * @param secret
     * @return
     * @throws IOException
     */
    public static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), KEY_MAC);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(CHARSET_UTF8));
        } catch (GeneralSecurityException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将byte转化为十六进制字符串
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sign.append(HEXSTR.charAt((bytes[i]&0xF0)>>4)); //字节高4位
            sign.append(HEXSTR.charAt(bytes[i]&0x0F));  //字节低4位
        }
        return sign.toString();
    }
}
