//package com.nonegger.platform.smallroutine;
//
//
//import com.blipay.infosec.util.SecurityEnvelopMsgUtils;
//import org.junit.Test;
//
//import java.io.File;
//
///**
// * Project: platform-small-routine
// * Author : Eric
// * Time   : 2018/6/25 14:25
// * Desc   : 交行加解密工具测试
// */
//public class TocomTest {
//
//    String deSignerDN = "C=CN,O=boccom.com,OU=BANKCOMM,OU=CCMerchants,CN=040@[8fcf03056d5e4dcdbd8f8da5f5b400fa]@000";
//    String deReciptDN ="C=CN,O=boccom.com,CN=creditcard.bankcomm.com2048";
//
//    @Test
//    public void testFileList() {
//        File file = new File("src/main/resources/cert/bocom/crl");
//        File[] ftmp = file.listFiles();
//        File[] ftmp2 = new File[0];
//        for (File fl:ftmp) {
//            System.out.println(fl.getName().toLowerCase());
//        }
//
//    }
//
//    /**
//     * 测试加密过程
//     */
//    @Test
//    public void testEncrypt() {
//        String xmlReq = "<transData>\n" +
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
//                "</transData>";
//
//        try {
//            System.out.println(SecurityEnvelopMsgUtils.encryptMsg(xmlReq.getBytes(), deSignerDN, deReciptDN));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 测试解密
//     */
//    @Test
//    public void testDecrypt() {
//        String resp = "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";
//        try {
//            System.out.println(SecurityEnvelopMsgUtils.decryptMsg(resp, deSignerDN));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
