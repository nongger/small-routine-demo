package com.nonegger.platform.smallroutine.utils;


import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;

public class DarLog {
    static ThreadLocal<LinkedList<Pair<String, String>>> noticeMap = new ThreadLocal();
    static ThreadLocal<String> threadTag = new ThreadLocal();
    private static Logger logger = LoggerFactory.getLogger("");
    private static String NOTICE_TAG = "[NOTICE]";

    public DarLog() {
    }

    public static void error(String fmt, Object... value) {
        logger.error(getLogPrefix("", fmt), value);
    }

    public static void warn(String fmt, Object... value) {
        logger.warn(getLogPrefix("", fmt), value);
    }

    public static void trace(String fmt, Object... value) {
        logger.trace(getLogPrefix("", fmt), value);
    }

    public static void debug(String fmt, Object... value) {
        logger.debug(getLogPrefix("", fmt), value);
    }

    public static void info(String fmt, Object... value) {
        logger.info(getLogPrefix("", fmt), value);
    }

    //public static void addNotice(String key, Object value) {
    //    if (noticeMap.get() == null) {
    //        noticeMap.set(new LinkedList());
    //    }
    //
    //    Pair<String, String> infoPair = new ImmutablePair(key, JsonUtils.toJson(value));
    //    ((LinkedList)noticeMap.get()).addLast(infoPair);
    //}

    //public static void addNoticeFront(String key, Object value) {
    //    if (noticeMap.get() == null) {
    //        noticeMap.set(new LinkedList());
    //    }
    //
    //    Pair<String, String> infoPair = new ImmutablePair(key, JsonUtils.toJson(value));
    //    ((LinkedList)noticeMap.get()).addFirst(infoPair);
    //}

    public static void notice() {
        StringBuilder sb = new StringBuilder();
        Iterator var1 = ((LinkedList)noticeMap.get()).iterator();

        while(var1.hasNext()) {
            Pair<String, String> entry = (Pair)var1.next();
            sb.append(" ");
            sb.append((String)entry.getKey());
            sb.append("[");
            sb.append((String)entry.getValue());
            sb.append("]");
        }

        logger.info(getLogPrefix(NOTICE_TAG, sb.toString(), false));
        ((LinkedList)noticeMap.get()).clear();
        noticeMap.remove();
    }

    private static String getLogPrefix(String front, String back) {
        return getLogPrefix(front, back, true);
    }

    private static String getLogPrefix(String front, String back, boolean needClassInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(front);
        sb.append(" ");
        String tags = (String)threadTag.get();
        if (tags == null) {
            tags = buildTag();
            threadTag.set(tags);
        }

        sb.append(" [");
        sb.append(tags);
        sb.append("]");
        if (needClassInfo) {
            StackTraceElement[] stes = (new Throwable()).getStackTrace();
            if (stes.length > 3) {
                StackTraceElement ste = stes[3];
                sb.append("class[");
                sb.append(ste.getClassName());
                sb.append("] method[");
                sb.append(ste.getMethodName());
                sb.append("] ");
            }
        }

        sb.append(back);
        return sb.toString();
    }

    private static String buildTag() {
        return SignUtils.md5sum(String.valueOf(System.currentTimeMillis()));
    }

    public static void initTag() {
        String tags = buildTag();
        threadTag.set(tags);
    }

    //public static String getTag() {
    //    return !StringUtils.isEmpty((CharSequence)threadTag.get()) ? (String)threadTag.get() : buildTag();
    //}

    public static void setTag(String tag) {
        threadTag.set(tag);
    }

    public static void clearTag() {
        if (threadTag.get() != null) {
            threadTag.remove();
        }

    }
}
