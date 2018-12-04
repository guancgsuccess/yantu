package com.crazylemon.yantu.utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-31
 * Time: 19:48
 * Desc: 描述
 */
public class AlipayConfig {
    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000552122";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCN8+q34BE0+kbxGDalK1LoBNMRsvSgSPLGXXQRUd9TjIJE4BrJ9ypCGDQWIc+oJjeyqVD0KyAgidbPPRY4e3Rq4MKtDR+4XasJNX+C9tOQz0gYgsBR5SV1+YbEFh9UH4USQnUsQm9TwsUY4UHnyhpJi3dN1twDl3I63L6bM/9415yCNTz+w2oWItJQIhMLCy+RKnNEA2gV1OOgoRlm65Vm2YgP6uX/zXo43n80tJcOPnjb/ZZWIAnuFSsqh3bIlEl5RlR5iue9wx+TXyT4DcN1BUzwKZ+A0dQKTFL9Hv3YGHrpleN5BJIbOQIjyevBnZMVoPG04UPCmjSpfOw5at09AgMBAAECggEAFj6pA5OLXr/xqgpfVdbKMS3AXb+rcgq8cLVoYOZxlsgoCd8Mk6W165GbZ/R4dCM5CzhZRUoUyMSQ8vzhpIxEHBOIrlGmLOAQ02qcxssjMEgrRhwHQ04jZq9pnQTSd/5QfiIH9p2akIevF00FZOtY3zmJwpru82kiL3M0M2IcoLT8dkpkG6ZR/p2gxGQw7p7j80YHxTp8kqbr3e9wSyfPVwzsNrPdtnZDRqeqr0O1j7JGkkwmPBZMxB/MsRiZRSw4OzN/wbeq0iQKvzCFLmCaSz/N4MMavEho+oN2MNiJMipk+G3lur1UN0+yIOguzb7T5WPVAlveSGO0H3nA67D4iQKBgQDgnf8kKRaQLKN9+RzOEB1XiQKj6cm9p3oUIeScIw7UGz0o1PgwHE2AOvRwTig5g5n5NcDGE4jpVyzsIgoUis5d/mGpcq4HqFbyMfpHA5wbA4bD4c2pb7S+oQbpDHgiWnQcvulQFribdaqZ6VlO90UDWr03F8q8dE03V4VRr59zvwKBgQChyTgUy6TVZuOzaTGBu16mLH/gOLeNSbmFJDgFjQua/G+r3XhPCCSmkDZNJRrtVc0sOrwHCzB07olN0UTwoT6UzGlBdKfRO2PHmQydxTzYjlt1v52IGrT1CHGd4VQZSs0eu2Dkus+ambF36tC88q/dWOIsbOg/gn+HVhuwI4v+AwKBgQDWFqG11JfV6UYXbtX+ritZYJSsqMuJwdRA1iEwlNWwYxoDDiJUsNVJsGeFl2kNkJq0hoBsCviG93kwxCz5cWfK/QgW2uB3GgNtKyeSgiVLNixADbvZkEglHhQZErJ6g96B+5EjrdRdEGT/+AMQmewki1sn5LxurSdf5UKEHjGLvwKBgDRbYyvPr5tkPcI9A8mBMqNCeWu9zyEJP+Gnk/2v5JaWpSkQdjPVZc8Fkp0qqekuwERVCa6Z32eoHoUxeUcKV69d655EO18KAkOA80VHpGZMw6p6hWebhP5bajF2z3mT7IfKihPbpP3aSUWOl1jejS1r614HLK4I9G5+3l0FU/OzAoGBAJSTeSHhnDX1k0bkZ0f+viXKqZRkhrJZ1nO+RBkA+Q81TVoz/OkfPksHuJLCG8tv9ow4nu4KUWZYRgs2aZt+SOMIKcindfRf+QJN5gFVcwg+yC1Uz+GcGA0zKFhIJtHZH4pgBSh9zEDRflx4g1KyyCHMsInaLfdKn0K03qrT2X5a";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA47dCzDqqqFrtXhDdU1sDwWwaEEMBAwf411pywP5XU6p0/EZRSjwC0N5fkD5gBwzJirdnU/u6/0BdrZCTsjGZ0X5OuN0BbzZSpo2ISoQEN7yy+ms/nAc3BQxLdD7geDTR9EYN9iGw0XT/LjXb+Uim3mEQ9k3w2bSccd9MhkHM1/MyNJAUDZ48QQZMXRm8jS3EuA1xA6jBT21rb7LYvc3DZazfZb3qHhLgOwRhrXhg6dA53p2S9LrHOPLQur2iWzxZxQwBt7g7YgqsuP8CzEpDQ/9PFh2JWqMA0DOejC9+XgNdbWN+kscNrPSFED1uS5ywgZhIqNggRS+B/iyJrolHkwIDAQAB\n";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 返回的时候此页面不会返回到用户页面，只会执行你写到控制器里的地址
     */
    public static String notify_url = "http://www.kleislove.top/alipay/notifyUrl";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 此页面是同步返回用户页面，也就是用户支付后看到的页面，上面的notify_url是异步返回商家操作，谢谢
     * 要是看不懂就找度娘，或者多读几遍，或者去看支付宝第三方接口API，不看API直接拿去就用，遇坑不怪别人
     */
    public static String return_url = "http://www.kleislove.top/alipay/returnUrl";
    // 签名方式
    public static String format = "json";
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 日志地址
    public static String log_path = "E:/develop/logs";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
