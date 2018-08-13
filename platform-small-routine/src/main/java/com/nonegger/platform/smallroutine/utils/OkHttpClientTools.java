package com.nonegger.platform.smallroutine.utils;


import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.*;


/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/6/25 15:14
 * Desc   : OkHttpClient 请求工具类
 */
public class OkHttpClientTools {

    private static final String CHARSET_UTF8 = "UTF-8";

    /**
     * json请求
     */
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * XML请求
     */
    public static final MediaType MEDIA_TYPE_XML = MediaType.parse("text/xml; charset=UTF-8");

    public static final MediaType MEDIA_TYPE_XML_GB2312 = MediaType.parse("text/xml; charset=GB2312");

    /**
     * 通过超时时间作为获取OkHttpClient实例的key
     */
    private static final String INSTANCE_KEY_PREFIX = "OKHTTPCLIENT_CONNECTION_%s_SOCKET_%s";

//    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(100);

    private static Integer MAX_THREAD_NUM = 4000;
    //private static ThreadFactory namedThreadFactory =null;// new ThreadFactoryBuilder().setNameFormat("routine-caller-%d").build();
    //private static ExecutorService selfExecutor = new ThreadPoolExecutor(0, MAX_THREAD_NUM,
    //        60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), namedThreadFactory);


    /**
     * 存储OkHttpClient实例
     */
    private static Map<String, OkHttpClient> OK_HTTPCLIENT_TIMEOUT_MAP = new ConcurrentHashMap<>();

    public static String sendPostXml(String url, String xml) throws Exception {
        return sendPostXml(url, xml, OkhttpClientSingleton.DEFAULT_CONNECTION_TIMEOUT_IN_MS, OkhttpClientSingleton.DEFAULT_SOCKET_TIMEOUT_IN_MS);
    }

    /**
     * 通过Map维护超时时间对应OkHttpClient实例
     *
     * @param connectionTimeoutInMs
     * @param socketTimeoutInMs
     * @return
     */
    public static OkHttpClient getInstanceByTime(int connectionTimeoutInMs, int socketTimeoutInMs) {
        String key = String.format(INSTANCE_KEY_PREFIX, connectionTimeoutInMs, socketTimeoutInMs);//INSTANCE_KEY_PREFIX + socketTimeoutInMs;

        OkHttpClient okHttpClient = OK_HTTPCLIENT_TIMEOUT_MAP.get(key);
        if (okHttpClient == null) {
            okHttpClient = OkhttpClientSingleton.getOkHttpClient().newBuilder()
                    .connectTimeout(connectionTimeoutInMs, TimeUnit.MILLISECONDS)
                    .readTimeout(socketTimeoutInMs, TimeUnit.MILLISECONDS)
                    .retryOnConnectionFailure(Boolean.FALSE)
                    .build();
            OK_HTTPCLIENT_TIMEOUT_MAP.put(key, okHttpClient);
        }
        return okHttpClient;
    }

    /**
     * http统一请求工具
     *
     * @param-callParam ConnectTimeoutMs 连接超时时间
     *                  ReadTimeoutMs socket读取超时时间
     *                  StrUrl 请求URL
     *                  ReqData 请求参数Map形式
     * @return
     * @throws Exception
     */
    //public static String callWithOKHttpClient(CallParam callParam) throws Exception {
    //    //获取当前时间戳，用于计算接口耗时
    //    long beforeRequestTimestamp = System.currentTimeMillis();
    //
    //    String sPostXml = WXPayUtil.mapToXml(callParam.getReqData());
    //    String response = "";
    //    if (callParam.isHardTimeOut()) {
    //        response = sendPostFutureXml(callParam.getStrUrl(), sPostXml, callParam.getConnectTimeoutMs(), callParam.getReadTimeoutMs());
    //    } else {
    //        response = sendPostXml(callParam.getStrUrl(), sPostXml, callParam.getConnectTimeoutMs(), callParam.getReadTimeoutMs());
    //    }
    //    long cost = System.currentTimeMillis() - beforeRequestTimestamp;
    //    if (cost > 1000) {
    //        BiliLog.error("[耗时过长留意观察][接口耗时统计]http request cost[{}], url[{}]", cost, callParam.getStrUrl());
    //    } else {
    //        BiliLog.info("[接口耗时统计]http request cost[{}], url[{}]", cost, callParam.getStrUrl());
    //    }
    //    return response;
    //}


    public static String sendPostFormData(String url, Map<String, String> paraMaps, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
        OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
        Request.Builder requestBuilder = new Request.Builder().url(url);
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        paraMaps.forEach((k, v) -> {
            formBodyBuilder.add(k, v);
        });
        RequestBody body = formBodyBuilder.build();
        Response response = null;
        String responeContent;
        try {
            response = okHttpClient.newCall(requestBuilder.post(body).build()).execute();
            responeContent = responeContent(response);
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responeContent;
    }


    public static String sendPost(String url, String content, int connectionTimeoutInMs, int socketTimeoutInMs, MediaType mediaType) throws Exception {
        OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
        Request.Builder requestBuilder = new Request.Builder().url(url);
        RequestBody body = RequestBody.create(mediaType, content);
        Response response = null;
        String responeContent;
        try {
            response = okHttpClient.newCall(requestBuilder.post(body).build()).execute();
            responeContent = responeContent(response);
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responeContent;
    }


    /**
     * 取消tag
     */
    //使用方式
    //            if (isHardTimeout) {
//                executor.schedule(() -> cancelCallWithTag(okHttpClient, tag),
//                        connectionTimeoutInMs + socketTimeoutInMs, TimeUnit.MILLISECONDS);
//            }
//    public static void cancelCallWithTag(OkHttpClient client, String tag) {
//
//        client.dispatcher().queuedCalls().stream().forEach(call -> {
//            if (call.request().tag().equals(tag)) {
//                call.cancel();
//                BiliLog.warn("cancelCallWithTag queuedCalls :{}", tag);
//            }
//        });
//
//        client.dispatcher().runningCalls().stream().forEach(call -> {
//            if (call.request().tag().equals(tag)) {
//                call.cancel();
//                BiliLog.warn("cancelCallWithTag runningCalls :{}", tag);
//            }
//        });
//    }


    /**
     * OkHttpClient完成网路请求
     * <p>
     * 不强制hardTimeOut
     */
    public static String sendPostXml(String url, String xml, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
        return sendPost(url, xml, connectionTimeoutInMs, socketTimeoutInMs, MEDIA_TYPE_XML);
    }

    public static String sendPostJson(String url, String json, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
        return sendPost(url, json, connectionTimeoutInMs, socketTimeoutInMs, MEDIA_TYPE_JSON);
    }

    //public static String sendPostFutureXml(String url, String xml, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
    //    return sendPostFuture(url, xml, connectionTimeoutInMs, socketTimeoutInMs, MEDIA_TYPE_XML);
    //}
    //
    //public static String sendPostFutureJson(String url, String json, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
    //    return sendPostFuture(url, json, connectionTimeoutInMs, socketTimeoutInMs, MEDIA_TYPE_JSON);
    //}


    //public static String sendPostFuture(String url, String content, int connectionTimeoutInMs, int socketTimeoutInMs, MediaType mediaType) throws Exception {
    //    OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
    //    Request.Builder requestBuilder = new Request.Builder().url(url);
    //    RequestBody body = RequestBody.create(mediaType, content);
    //    Response response = null;
    //    String responeContent;
    //    FutureTask<Response> future = null;
    //    try {
    //        Callable<Response> callable = () -> okHttpClient.newCall(requestBuilder.post(body).build()).execute();
    //        future = new FutureTask<Response>(callable);
    //        selfExecutor.execute(future);
    //        response = future.get(socketTimeoutInMs + connectionTimeoutInMs, TimeUnit.MILLISECONDS);
    //        if (response == null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        responeContent = responeContent(response);
    //    } catch (Exception e) {
    //        if (e instanceof TimeoutException && future != null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        throw e;
    //    } finally {
    //        if (response != null) {
    //            response.close();
    //        }
    //    }
    //    return responeContent;
    //}


    //public static String sendPostFutureFormData(String url, Map<String, String> paraMaps, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
    //    OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
    //    Request.Builder requestBuilder = new Request.Builder().url(url);
    //    FormBody.Builder formBodyBuilder = new FormBody.Builder();
    //    paraMaps.forEach((k, v) -> {
    //        formBodyBuilder.add(k, v);
    //    });
    //    RequestBody body = formBodyBuilder.build();
    //    Response response = null;
    //    String responeContent;
    //    FutureTask<Response> future = null;
    //    try {
    //        Callable<Response> callable = () -> okHttpClient.newCall(requestBuilder.post(body).build()).execute();
    //        future = new FutureTask<Response>(callable);
    //        selfExecutor.execute(future);
    //        response = future.get(socketTimeoutInMs + connectionTimeoutInMs, TimeUnit.MILLISECONDS);
    //        if (response == null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        responeContent = responeContent(response);
    //    } catch (Exception e) {
    //        if (e instanceof TimeoutException && future != null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        throw e;
    //    } finally {
    //        if (response != null) {
    //            response.close();
    //        }
    //    }
    //    return responeContent;
    //}

    /**
     * OkHttpClient完成网路请求
     * <p>
     * 不强制hardTimeOut
     */
    public static String sendGet(String url, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
        OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
        Request.Builder requestBuilder = new Request.Builder().url(url);
        Response response = null;
        String responeContent;
        try {
            response = okHttpClient.newCall(requestBuilder.get().build()).execute();
            responeContent = responeContent(response);
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responeContent;
    }


    /**
     * OkHttpClient完成网路请求
     * <p>
     */
    //public static String sendGetFuture(String url, int connectionTimeoutInMs, int socketTimeoutInMs) throws Exception {
    //    OkHttpClient okHttpClient = getInstanceByTime(connectionTimeoutInMs, socketTimeoutInMs);
    //    Request.Builder requestBuilder = new Request.Builder().url(url);
    //    Response response = null;
    //    String responeContent;
    //    FutureTask<Response> future = null;
    //    long s = System.currentTimeMillis();
    //    try {
    //        Callable<Response> callable = () -> okHttpClient.newCall(requestBuilder.get().build()).execute();
    //        future = new FutureTask<Response>(callable);
    //        selfExecutor.execute(future);
    //        response = future.get(socketTimeoutInMs + connectionTimeoutInMs, TimeUnit.MILLISECONDS);
    //        if (response == null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        responeContent = responeContent(response);
    //    } catch (Exception e) {
    //        if (e instanceof TimeoutException && future != null) {
    //            future.cancel(Boolean.TRUE);
    //        }
    //        throw e;
    //    } finally {
    //        if (response != null) {
    //            response.close();
    //        }
    //    }
    //    return responeContent;
    //}

    /**
     * 构造返回结果
     */
    private static String responeContent(Response response) throws IOException {
        String responeContent = "";
        if (response != null && response.isSuccessful()) {
            responeContent = response.body().string();
        }
        return responeContent;
    }

//    private static String getReqTag() {
//        return new StringBuilder()
//                .append(System.currentTimeMillis())
//                .append(UUID.randomUUID().toString().replace("-", "")).toString();
//    }
}
