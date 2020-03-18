package com.exa.demo.example.alipayDemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//    APPID
    public static String app_id = "2016101500692295";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMTR3PGFiFhkyMnah/VdTUdWPSPxNK70k0EJVFCR9ivSGX0KT0sqKcDAHk1K7UniUwxnuJAcyBgaZroNQDyS8miiNx+euEbOAoikBnx3bbqy1hbKC6cUTLNxWiZqmaOZgxr4q/C4E/y8Mu2eowPp/KiNWkR2lRaGRuH8YVdZkhRsnA+aPzTFRHoVCuuPHGnCy6EX+2yKIWSUq4rGO1coU9lp74FO55tvBZEbxXM8wDcT/MX0o0Vn5WwOFGcYg/fhXCfdYDz31l4idWaHxj9tTsliK0CuqIcU9ihBkNXh7LFYNlC+rrHPZw5UKEjPCxFy3qufk14gurR5mMXlNCKQUDAgMBAAECggEAFX7nN0ian3KRHeY137SN1DNcJOVHFm8M/y4fQKGCLoWdtP3hmCAaa+AnFiFD3A2S0yNF4Brnc1wi3FCayy2yzKvTfG33GKX5vhxYe84CtutGG6wiAA7EpIH/DY+/IoL6f3pOvrCLj/OvJul6SQP/RW+rk+zhBPkCkiDKH5WR7ZgJHU74AXPtVHMEHBhobhhg4XB3VOGb6Ctdftf8KyDbAHsKYWkkJuyU/tE85bHgFItkT8NINsnTLjX4oTrY710xITRB+YQjtx42hcD+ZklSRMVb2dGhE7m4P1pQU+TjcZllRX/FkiqJmuWn+POXxd6QcvxCO0RI1uDjQ/viQ3I/CQKBgQDdsbrZ7H2H8iP+Z/TP/HbeYq2KgMwKkkknA8iwrv0pvlp1kws7ryMsUSt02yfSSoDtxJJ6cPCbgOIJ8jvk56Cdpi3x7yfAVAjmYfRCVFR2G5VJf9CzPK5pOW++RuRdf1j4ax/CEgwoOopob5cg89ApS6m3WYApOwchPiQkDiQJHQKBgQCiAw5qj5E06CFybGJedL2kXiNOo9+o70dOTeAhMDGjXDQBtlRiwmZix+zqU2mtU8lD2d4ZHKgZPenifacqSQyL9iKu04/4i0kPfpnNnyfGJa7qaK9RwE5pNJBL1GP/skID09THR0EZilSOzcMvO82GJlmTow4uIWA1SACpCaIMnwKBgQC8+D1UeuA53C3QMl6cVxAf2a8hi03hiPYv+mq8KD0Fsws6gz+k/VGW+g13y0MzXmxtwAw3sEN32bFTVxa0tLfVCYzKV9fjef4oGsDxNR7Vmgdzoi6MSaJFcT8NyzHnfKCjB/UHIQkZ1WSbRttkrE74lFUzQ2gaPQWD0YtO7HrNBQKBgEVi0bXJrwLduBVtXePeU6oltzFi9dNAR2W97JPKNDgmsQ9aq2FwqLD9tvXUq5nUHIq2sGxI3aWR4q1h60os5va6f7goW6yy2qOMMQrjcwFl+jfihdOZbPuZy4Luf7Vu/t7sxmBin/r0R6qxbTq5fhhKLGsSlmwjVzT6lW3P9ls5AoGBAKsmeKaYvpVqamkw4yZdZP381ZzGjPs2RgZVZ0ztRUofWwltHpboZ84oTwLxcR2A25Xk0tE7ePgGc/5hGhF1HjaqgR5pVfapnoiRWIvXCFRD9p6QSXT+IiiHf00NaMehc1DSHgPT7Si84ViP2jKMh04v8TSmO62MpWJEkBpQ2dB5";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl74WwsmOyybBDypSQYOnTxaj3j9w/6mLC+NPFXdgS3ohJQ18MxHdvZTODgd/xzu6wz7EfzJveNhif5a4RPZirA7E6mMg52OfAFGiBB3l3vS5jyB+nhFgYIPS9dBQhcyMwfk7lo1VFXhQEt438LAwi662JOYiZe0ZHl4k/BVKAYHwJwyETazsna55WlHYEUaQmY1fNrBxEQkNhfVWc+wFsUa6jwvc5rMlJfg6rxyqMDlpFNeKn1Fc1c7hE7gZBunc4boJ5XyW4h1Veg8PFs6ZR7O2To5an7kSA9xOp4U8EVgM20usxbzccxgrU7UQouvKiesbYYprwBUp20NcaOvmUQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    public static String notify_url = "http://localhost:8081/yese/admin/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://localhost:8081/yese/admin/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
//    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


    public static void main(String[] args) {
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,app_id,merchant_private_key, "json", charset,
                alipay_public_key, sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "201912189494400";
        //付款金额，必填
        String total_amount = "0.02";
        //订单名称，必填
        String subject ="测试";
        //商品描述，可空
        String body = "lalala";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
        System.out.println(result);
    }

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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
