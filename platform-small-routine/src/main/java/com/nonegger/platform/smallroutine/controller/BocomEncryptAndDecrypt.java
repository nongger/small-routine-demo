//package com.nonegger.platform.smallroutine.controller;
//
//import com.bilibili.openplatform.utils.BiliLog;
//import com.blipay.infosec.util.SecurityEnvelopMsgUtils;
//import com.github.wxpay.sdk.WXPayUtil;
//import com.nonegger.platform.smallroutine.model.BocomRespVO;
//import com.nonegger.platform.smallroutine.utils.OkHttpClientTools;
//import com.nonegger.platform.smallroutine.utils.XmlUtils;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
///**
// * Project: platform-small-routine
// * Author : Eric
// * Time   : 2018/6/25 15:14
// * Desc   :  *
// */
//@RestController
//@RequestMapping(value = "/payplatform/routine")
//public class BocomEncryptAndDecrypt {
//    String deSignerDN = "C=CN,O=boccom.com,OU=BANKCOMM,OU=CCMerchants,CN=040@[8fcf03056d5e4dcdbd8f8da5f5b400fa]@000";
//    String deReciptDN = "C=CN,O=boccom.com,CN=creditcard.bankcomm.com2048";
//    String requestStr = "version=1.0&transDataXml=%s";
//
//    @RequestMapping(value = "/encrypt", method = {RequestMethod.GET})
//    public String encrypt() {
//        String xmlReq = "<TransData>\n" +
//                "  <version>1.0</version>\n" +
//                "  <msgId>0200</msgId>\n" +
//                "  <transCode>999100</transCode>\n" +
//                "  <cardNo>6222529117029113</cardNo>\n" +
//                "  <expiryDate>2712</expiryDate>\n" +
//                "  <merNo>301001000001401</merNo>\n" +
//                "  <termNo>00000000</termNo>\n" +
//                "  <traceNo>670000</traceNo>\n" +
//                "  <invioceNo>180621670000</invioceNo>\n" +
//                "  <addDataField>110401</addDataField>\n" +
//                "  <addData>00WN07商务部1M12线上快捷商户T13500001111</addData>\n" +
//                "</TransData>";
//
//        String encryptMsg = "";
//        String decryptMsg = "";
//        String url = "https://paymenttest.bankcomm.com/pisxml";
//
//        //this.getClass().getResourceAsStream("/config/bctcms/" + templateFileName);
//        try {
//            encryptMsg = SecurityEnvelopMsgUtils.encryptMsg(xmlReq.getBytes(), deSignerDN, deReciptDN);
//            System.out.println(encryptMsg);
//
//            String respXml = OkHttpClientTools.sendPostXml(url, String.format(requestStr, encryptMsg), 3000, 3000);
//            System.out.println(respXml);
//
//            Document document = DocumentHelper.parseText(respXml);
//            String elementText = document.getRootElement().getText();
//
//            decryptMsg = SecurityEnvelopMsgUtils.decryptMsg(elementText, deSignerDN);
//            System.out.println(decryptMsg);
//
//            Map<String, String> respData = WXPayUtil.xmlToMap(decryptMsg);
//            System.out.println(respData);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptMsg;
//    }
//
//    @RequestMapping(value = "/decrypt", method = {RequestMethod.GET})
//    public String decrypt() {
//        String resp = "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";
//        String decryptMsg = "";
//
//        try {
//            decryptMsg = SecurityEnvelopMsgUtils.decryptMsg(resp, deSignerDN);
//            System.out.println(decryptMsg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return decryptMsg;
//    }
//
//    @Test
//    public void testXml() {
//        String needDexml = "<?xml version='1.0' encoding='utf-8'?><string xmlns='http://tempuri.org/'>MIIHEAYJKoZIhvcNAQcDoIIHATCCBv0CAQAxggFbMIIBVwIBADA/MDcxCzAJBgNVBAYTAkNOMRMwEQYDVQQKEwpib2Njb20uY29tMRMwEQYDVQQDEwpCQU5LQ09NTUNBAgQ7yb45MA0GCSqGSIb3DQEBAQUABIIBABwuO3KPAy9JC5Pbl4v7dylv7v9RvQMlgoHtnoGMShcNFw0ordPNhzIfj0eITEsxGZWx7JLZhMgJAPnLAt9r974Sdxos18TdOptxA3IJbmOKK+lE78WOjRYHBymeh+jNabenEykR7lcQFu7WBGzVfoeNWgypPNnQMkb1yXrgSerBUqK3WFJ5B5ihas8OwGg5jRWXZ9z7oBDipgRIw+pRekrVXT94AnKGI6IvaOqfh1xqlvptcV0wgujkt7qPWC5+Xwm7tR2txwD+yTfJQKVcF44SOYv5Y3lUxdfGlenHkAWZqEQCUlEydFnWalGrn8+33ubeH2pyT/LNr59NNaHYuUQwggWXBgkqhkiG9w0BBwEwDAYIKoZIhvcNAwQFAKCCBXoEggV23QPG2eajWHXzoQvS+jLb+bhcacY2FQS1X6COWG496WAFU/2kwglU9KmSwzJq2HJJOnJDlEPHFpqGlYOjtreC+ePE5LgjYKcd+DCG9f3BpCWipKLnrGZh1Kehodj7ACEPelr/VvAKCNKiuB7mnwqBEgCLVdbPCvrDgFi2A57mf0WoR2oAhMl8X+FL7zf5t+QP1C/msYMZmf6Tpf1cTuCoicYkpZCnXlvAJh7fyjnAPVQ2EUux1i8zR9fcESlvlNWsXaodxtzqOGmDeQL/KHBg10yxBlueNP7bqPjkW4ckJrnZl6ZXv0tiwgiI5fJPqwZIGiry/erNBrdrJFnpzJPYd/xX+yeSqq5FrTk2uXIwwQ0NKEuaz3rar3vdZMUjolz62PwZa2y9wsXz77thRlZBMuS1OKrPa4BGFzmQSwbbxzaEUT9/XiwN7lDYfxqTdhR0ZhaSOC5JJgIynd7VRIozmXFDBD5kOb6J93ussEKHAwchaw4bD3nPuEV4MVjkB9ntm2v9ioZ33j4GyYLUkoqklqz2FYUqYuUa4ljBSDQElEqPBHdc+vXsw6IRYNd6f7oYdY28GljOdJNptxl1/hp27/7kBEu6LI+xyXTSRaScQSRz788i/6Ln4c1d0NdEBL6sSppmLms8e03eNJHPMIMyi46RRYWfev23KJgvpTjodVeaqVCnNdVs6ZKrA63rF1j0CG2ue5hzO3slvpQj81N5xIfCzfYeKr5IBuDFrnLaJ5yeSx+UQevkY5IW+WujQIBUnxFkG+vm6A502Rd6PmzEcCWoIejXmPR75ddQFAxNgqS0dE/3nSk9slmP85fFp+PHSLO90xDEnvK4FvdOIrV8Iy459huv3pI3W2WfCC/+r/PWwrJbum0WmDu4FiP59+0YFq7NnGQh2sAl6Ql7XOGgivHjNKCc2mMNtT/idIJyi8JFuL3D0VUuzWUZLjMiYRFksSpcS1sixpaLENU6VCY4knDm2sk6P9UNesWqzfIpyL1Q1YW6k1O8w24JIS/IasbbI0VtgD9Sd5FXKDZi9VC5O4wyQNe/NLWbk7xGKrrSSgjDoxRum+C274/7/97CtK38o5uvUAUiRKBe9qPwWsihMmloxQ2Rs4YZ/weZQJAiFPlMGNckFBU60JMTWb871QTC/XZh/D63g+N+kvQgtOnRdQAOb3hsi5OE++tBfrkn4bZXwqZ1Pt+UlBZERUVdH17KTSTjCxHcXzeRvMsBGWTdbmgFAyr8PqooB1DgXE0dYM6JBg0uioNxfYatQ6J++MQ3BId+2Go4IqhV93JBAHKmiuV8DgPessnYKb2AZADNcpRUMDWwZ2EcMBsSksOJ0LCZZCt/49aM8MJwFefnzTfxNm1ugISe7kOYHdtJ1173/ztFl4e8ICN3cWfFUl6+QJkWjgY9hLfROy9NlpP8F3J2FcyLWwaGWRP0bQLmURIdV1uj0NS40hbA464+d9B12gcrXWSm1gSLMPZO+n3fEN7nLBSeV6LMU4/7U2cohZoJK/bK4U+AftJqUJB6gm9/uRddcb9tLM+xIXqqzihpxY4uny2I1OX6FntU6Df3BAgu+BooFK64ucE4AFTh+mnH7d/JsD7gOAPtBr85Jw/gH2ka69EndZQ8VTjEprUIYUOMDMt+ndllTRHFok/QxtjoCEOsDPXv4Z2j0ZwtWf3GdaxkWzsiUx7X+RbxdjXm9Vfa1NPJgvGJsQwso5I52pfjclZJPovn39HJ05DUqXSxtrA/Af1ulz6Ox1L6R2BdTdW0HzmD8F/0uPga72mTr1STHK7aIQ7zfz+1gmmHLY3IgvEEWMXAORnCmXSDNl3/jfvH6LZKTOEED4HtRyIkRe5ljOSW4qNXPnPh</string>";
//        try {
//            BocomRespVO bocomRespVO = handleResp(needDexml);
//            System.out.println(bocomRespVO);
//            //Document document = DocumentHelper.parseText(needDexml);
//            //Element element = document.getRootElement();
//            //String elementText = element.getText();
//            //System.out.println(elementText);
//            //
//            //String decryptMsg = SecurityEnvelopMsgUtils.decryptMsg(elementText, deSignerDN);
//            //System.out.println(decryptMsg);
//            //
//            //Object transData2 = XmlUtils.xml2Bean(decryptMsg, "transData", BocomRespVO.class);
//            //System.out.println(transData2);
//
//            //TransData transData = new TransData();
//            //transData.setAmount("441");
//            //String xml2 = XmlUtils.bean2Xml(transData, "transData", TransData.class);
//            //System.out.println(xml2);
//
//
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    public BocomRespVO handleResp(String respXml) {
//        BocomRespVO transData = null;
//        try {
//            // 获取第三方加密串
//            String elementText = DocumentHelper.parseText(respXml).getRootElement().getText();
//            // 解密信封获取xml报文
//            String decryptMsg = SecurityEnvelopMsgUtils.decryptMsg(elementText, deSignerDN);
//            // 解析xml成对象
//            transData = (BocomRespVO) XmlUtils.xml2Bean(decryptMsg, "transData", BocomRespVO.class);
//        } catch (Exception e) {
//            BiliLog.error("解析交行返回报文出错，msg:[{}]", e);
//        }
//        return transData;
//    }
//
//
//}
