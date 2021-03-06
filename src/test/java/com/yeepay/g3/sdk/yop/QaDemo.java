package com.yeepay.g3.sdk.yop;

import com.TrustAllHttpsCertificates;
import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopConfig;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * title: <br/>
 * description: 描述<br/>
 * Copyright: Copyright (c)2014<br/>
 * Company: 易宝支付(YeePay)<br/>
 *
 * @author baitao.ji
 * @version 1.0.0
 * @since 15/7/8 10:23
 */
public class QaDemo {

//    private static final String BASE_URL = "http://10.151.30.87:8064/yop-center/";
    private static final String BASE_URL = "http://10.151.30.88:8064/yop-center/";

    @Before
    public void setUp() throws Exception {
        TrustAllHttpsCertificates.setTrue();
    }

    @Test
    public void testIdCard() throws Exception {
        YopRequest request = new YopRequest(null, "0/ZoyfKku0tunPunw7dbfA==", BASE_URL);
//        YopRequest request = new YopRequest(null, "cAFj+DxhpeMo8afn7s0z5w==", "http://10.151.30.88:8064/yop-center/");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg("sha-256");
        request.addParam("appKey", "jinkela2");
        request.addParam("requestFlowId", "test123456");//请求流水标识
        request.addParam("name", "张文康");
        request.addParam("idCardNumber", "370982199101186692");
        request.addParam("testDate", "2012-10-09 12:13:14");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v2.0/auth/idcard", request);
        System.out.println(response.toString());
    }

    @Test
    public void testQueryMemberAccount() throws Exception {
        YopRequest request = new YopRequest(null,
                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
                "http://10.151.30.88:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.addParam("customerNo", "10040011444");
        request.addParam("requestId", "0");
        request.addParam("platformUserNo", "1234567890123456789012345673333");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v1.0/member/queryAccount", request);
        System.out.println(response.toString());
    }

    @Test
    public void v() {
        YopRequest request = new YopRequest(null,
                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
                "http://open.yeepay.com:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.addParam("customerNo", "10040011444");
        request.addParam("merchantNo", "10040028626");
//        request.addParam("platformUserNo", "12345678901234567890123456789012");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v1.0/merchant/queryBalance", request);
        System.out.println(response.toString());
    }

    @Test
    public void testEnterprise() throws Exception {
        YopRequest request = new YopRequest("yop-boss",
                "QFdODaBYBiVuLpP+sbyH+g==", "http://open.yeepay.com:8064/yop-center/");
        request.setEncrypt(false);
        request.setSignRet(true);
        request.addParam("appKey", "yop-boss");//这个写YOP就可以了
//        request.addParam("requestSystem", "YOP");//这个写YOP就可以了
        request.addParam("corpName", "青海韩都忆餐饮管理有限公司");//企业名称
        request.addParam("regNo", "630104063037404");//工商注册号
        request.addParam("requestCustomerId", "jinkela");//子商户编号
        request.addParam("requestFlowId", "test-" + System.currentTimeMillis() + RandomStringUtils.randomNumeric(3));//请求流水标识
        request.addParam("requestIdentification", "wenkang.zhang");//请求者标识
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v1.2/auth/authenterprise", request);
        System.out.println(response.toString());
    }

    @Test
    public void testName1() throws Exception {
        YopRequest request = new YopRequest(null,
                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
                "http://open.yeepay.com:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.addParam("customerNo", "10040011444");
        request.addParam("requestId", "YOP-SDK-" + System.currentTimeMillis());
//		request.addParam("platformUserNo","YOP-USERNO-" + System.currentTimeMillis());
        request.addParam("platformUserNo", "8880222");
//		request.addParam("platformUserNo","YOP-USERNO-1435560994654");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v1.0/merchant/queryAccount", request);
        System.out.println(response.toString());
    }

    @Test
    public void testName2() throws Exception {
        YopRequest request = new YopRequest(null,
                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
                "http://open.yeepay.com:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.addParam("customerNo", "10040011444");
        request.addParam("requestId", "YOP-SDK-" + System.currentTimeMillis());
        request.addParam("platformUserNo", "20150623143151652niuniu");
        request.addParam("orderNo", "YOP-SDK-ORDER-" + System.currentTimeMillis());
        request.addParam("amount", "20");
        request.addParam("payproducttype", "NET");
        request.addParam("bankid", "");
        request.addParam("callbackurl", "http://50.1.1.24:8018/fundtrans-hessian/");
        request.addParam("webcallbackurl", "http://localhost:8080/reciver/page");
        System.out.println(request.toQueryString());

        String requestUri = YopClient.buildURL("/rest/v1.0/member/gatewayDeposit", request);
        System.out.println(requestUri);

        YopResponse yopResponse = YopClient.get("/rest/v1.0/member/gatewayDeposit", request);
        System.out.println(yopResponse);
    }

    @Test
    public void test1() {
        YopRequest request = new YopRequest(null,
                "s5KI8r0920SQ339oVlFE6eWJ0yk019SD7015nw39iaXJp10856z0C1d7JV5l",
                "https://open.yeepay.com:8064/yop-center/");
        request.setEncrypt(true);
        request.setSignRet(true);
        request.addParam("customerNo", "10011830665");
        request.addParam("customernumber", "10012544672");
        request.addParam("requestid", System.currentTimeMillis());
        request.addParam("amount", "0.1");
        request.addParam("callbackurl", "http://www.baidu.com");
        request.addParam("webcallbackurl", "http://www.baidu.com");
        request.addParam("bankid", "ICBC");
        request.addParam("payproducttype", "SALES");
        YopResponse response = YopClient.post("/rest/v1.0/merchant/pay", request);
        System.out.println(response.toString());
    }

    @Test//发送短信接口
    public void testSendSms() {
        YopConfig.setAppKey("TestAppKey002");//yop应用
        YopConfig.setAesSecretKey("TestAppSecret002");//yop应用密钥，需要和短信通知应用的密钥保持一致才行，否则验证签名不通过
        YopConfig.setServerRoot("http://open.yeepay.com:8064/yop-center");
        YopRequest request = new YopRequest();
        // request.setSignAlg("SHA1");
        request.setSignAlg("MD5");//具体看api签名算法而定
        //request.setEncrypt(true);
        String notifyRule = "fundauth_MOBILE_IFVerify";//通知规则
        List recipients = new ArrayList();//接收人
        recipients.add(0, "18253166342");
        String content = "{code:12345,something:something}";//json字符串，code，mctName为消息模板变量
        String extNum = "01";//扩展码
        String feeSubject = "0.01";//计费主体
        request.addParam("notifyRule", notifyRule);
        request.addParam("recipients", recipients);
        request.addParam("content", content);
        request.addParam("extNum", extNum);
        request.addParam("feeSubject", feeSubject);
        YopResponse response = YopClient.post("/rest/v1.0/notifier/send", request);
        System.out.println(response);
    }

    @Test
    public void testSendSmsQa() {
        YopConfig.setAppKey("openSmsApi");//yop应用
        YopConfig.setAesSecretKey("1234554321");//yop应用密钥，需要和短信通知应用的密钥保持一致才行，否则验证签名不通过
        YopConfig.setServerRoot("http://open.yeepay.com:8064/yop-center/");
        YopRequest request = new YopRequest();
        request.setSignAlg("MD5");//具体看api签名算法而定
        //request.setEncrypt(true);
        String notifyRule = "商户结算短信通知";//通知规则
        List recipients = new ArrayList();//接收人
        recipients.add(0, "18253166342");
        String content = "{code:1235}";//json字符串，code，mctName为消息模板变量
        String extNum = "3";//扩展码
        String feeSubject = "0.01";//计费主体
        request.addParam("notifyRule", notifyRule);
        request.addParam("recipients", recipients);
        request.addParam("content", content);
        request.addParam("extNum", extNum);
        request.addParam("feeSubject", feeSubject);
        YopResponse response = YopClient.post("/rest/v1.0/notifier/send", request);
        System.out.println(response);
    }

    @Test
    public void testSendSmsProduct() {
        try {
            TrustAllHttpsCertificates.setTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        YopConfig.setAppKey("ypo2o");//yop应用
        YopConfig.setAesSecretKey("tpcY6k2RSpEod7hsJIp33Q==");//yop应用密钥，需要和短信通知应用的密钥保持一致才行，否则验证签名不通过
        YopConfig.setServerRoot("https://open.yeepay.com:8064/yop-center");//生产环境
        //   YopConfig.setServerRoot("http://50.1.1.14:8064/yop-center");
        YopRequest request = new YopRequest();
        request.setSignAlg("MD5");//具体看api签名算法而定
        // request.setEncrypt(true);
        String notifyRule = "EGOU_VERIFY";//通知规则
        List recipients = new ArrayList();//接收人
        recipients.add(0, "18519193582");
        String content = "{message1:123445}";//json字符串，code，mctName为消息模板变量
        String extNum = "52";//扩展码
        String feeSubject = "0.01";//计费主体
        request.addParam("notifyRule", notifyRule);
        request.addParam("recipients", recipients);
        request.addParam("content", content);
        request.addParam("extNum", extNum);
        request.addParam("feeSubject", feeSubject);
        YopResponse response = YopClient.post("/rest/v1.0/notifier/send", request);
        System.out.println(response);
    }


    @Test
    public void testValidate() {
        YopRequest request = new YopRequest(null,
                "cGB2CeC3YmwSWGoVz0kAvQ==",
                "http://localhost:8064/yop-center/");
        request.setEncrypt(false);
        request.setSignRet(true);
        request.setSignAlg("sha-256");
        request.addParam("appKey", "yop-boss");
        request.addParam("not_null", "10011830665");
        request.addParam("complex", "33647");
        request.addParam("not_blank", "张文康");

        request.addParam("length", "fkdjfld");
        request.addParam("range", "10");
        request.addParam("int", "3");
        request.addParam("email", "wenkang.zhang@yeepay.com");
        request.addParam("mobile", "15901189967");
        request.addParam("idcard", "370982199101186");


        YopResponse response = YopClient.get("/yop-center/rest/v1.0/kong/validator", request);
        System.out.println(response.toString());
    }

    @Test
    public void testWhiteList() throws Exception {
        YopRequest request = new YopRequest(null,
                "cGB2CeC3YmwSWGoVz0kAvQ==",
                "http://localhost:8064/yop-center");
        request.setEncrypt(false);
        request.setSignRet(true);
        request.addParam("appKey", "yop-boss");
        request.setSignAlg("sha-256");
        request.addParam("requestFlowId", "test123456");//请求流水标识
        request.addParam("name", "张文康");
        request.addParam("idCardNumber", "370982199101186691");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v2.0/auth/idcard", request);
        System.out.println(response.toString());
    }

    @Test
    public void testCreateToken() {
        YopRequest request = new YopRequest(null, "cGB2CeC3YmwSWGoVz0kAvQ==", "http://127.0.0.1:7777/yop-center");
//                YopRequest request = new YopRequest(null, "cGB2CeC3YmwSWGoVz0kAvQ==", "http://172.17.102.177:7777/yop-center");
//        YopRequest request = new YopRequest(null,
//                "cGB2CeC3YmwSWGoVz0kAvQ==",
//                "http://localhost:8064/yop-center");
//        YopRequest request = new YopRequest(null, "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a", "http://127.0.0.1:7777");
//        YopRequest request = new YopRequest(null,
//                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
//                "http://localhost:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
//        request.setSignAlg("SHA1");
//        request.addParam("customerNo", "10040011444");
        request.addParam("appKey", "yop-boss");

        request.addParam("grant_type", "password");//请求流水标识
        request.addParam("client_id", "appKey");
        request.addParam("authenticated_user_id", "wenkang.zhang");
        request.addParam("scope", "test");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v1.0/oauth2/token", request);
        System.out.println(response.toString());
    }

    @Test
    public void testAmount() {
        YopRequest request = new YopRequest(null, "cGB2CeC3YmwSWGoVz0kAvQ==", "http://127.0.0.1:8064/yop-center");
//                YopRequest request = new YopRequest(null, "cGB2CeC3YmwSWGoVz0kAvQ==", "http://172.17.102.177:7777/yop-center");
//        YopRequest request = new YopRequest(null,
//                "cGB2CeC3YmwSWGoVz0kAvQ==",
//                "http://localhost:8064/yop-center");
//        YopRequest request = new YopRequest(null, "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a", "http://127.0.0.1:7777");
//        YopRequest request = new YopRequest(null,
//                "8intulgnqibv77f1t8q9j0hhlkiy6ei6c82sknv63vib3zhgyzl8uif9ky7a",
//                "http://localhost:8064/yop-center");
        request.setEncrypt(true);
        request.setSignRet(true);
//        request.setSignAlg("SHA1");
//        request.addParam("customerNo", "10040011444");
        request.addParam("appKey", "yop-boss");

        request.addParam("requestFlowId", "test123456");//请求流水标识
        request.addParam("name", "张文康", true);
        request.addParam("idCardNumber", "370982199101186691");
        request.addParam("bankCardNumber", "4392250043179877");
        System.out.println(request.toQueryString());
        YopResponse response = YopClient.post("/rest/v2.0/auth/debit3", request);
        System.out.println(response.toString());
    }
}
