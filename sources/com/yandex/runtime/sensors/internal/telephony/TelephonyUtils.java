package com.yandex.runtime.sensors.internal.telephony;

import java.util.HashMap;
import java.util.Map;
public class TelephonyUtils {
    private static final int UNKNOWN_VALUE = -1;
    private static Map<Integer, String> networkTypesMap;

    static {
        HashMap hashMap = new HashMap();
        networkTypesMap = hashMap;
        hashMap.put(2, "EDGE");
        networkTypesMap.put(1, "GPRS");
        networkTypesMap.put(8, "HSDPA");
        networkTypesMap.put(10, "HSPA");
        networkTypesMap.put(15, "HSPAP");
        networkTypesMap.put(9, "HSUPA");
        networkTypesMap.put(13, "LTE");
        networkTypesMap.put(3, "UMTS");
        networkTypesMap.put(0, "UNKNOWN");
    }

    public static String getNetworkTypeString(int i) {
        return networkTypesMap.get(Integer.valueOf(i));
    }

    public static boolean isCidCorrect(int i) {
        return isKnown(i) && i > 0;
    }

    public static boolean isKnown(int i) {
        return i != -1;
    }

    public static boolean isLacCorrect(int i) {
        return isCidCorrect(i);
    }
}
