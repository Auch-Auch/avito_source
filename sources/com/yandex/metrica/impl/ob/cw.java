package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.sothree.slidinguppanel.library.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public final class cw {
    @VisibleForTesting
    public static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        a.D0(1, hashMap, "1.00", 2, "1.10", 3, "1.11", 4, "1.20");
        a.D0(5, hashMap, "1.21", 6, "1.22", 7, "1.23", 8, "1.24");
        a.D0(9, hashMap, "1.26", 10, "1.27", 11, "1.40", 12, "1.41");
        a.D0(13, hashMap, "1.42", 14, "1.50", 15, "1.51", 16, "1.60");
        a.D0(17, hashMap, "1.61", 18, "1.62", 19, "1.63", 20, "1.64");
        a.D0(21, hashMap, "1.65", 22, "1.66", 23, "1.67", 24, "1.68");
        a.D0(25, hashMap, "1.69", 26, "1.70", 27, "1.71", 28, "1.72");
        a.D0(29, hashMap, "1.80", 30, "1.81", 31, "1.82", 32, "2.00");
        a.D0(33, hashMap, "2.10", 34, "2.11", 35, "2.20", 36, "2.21");
        a.D0(37, hashMap, "2.22", 38, "2.23", 39, "2.30", 40, "2.31");
        a.D0(41, hashMap, "2.32", 42, "2.33", 43, "2.40", 44, "2.41");
        a.D0(45, hashMap, "2.42", 46, "2.43", 47, "2.50", 48, "2.51");
        a.D0(49, hashMap, "2.52", 50, "2.60", 51, "2.61", 52, "2.62");
        a.D0(53, hashMap, "2.63", 54, "2.64", 55, "2.70", 56, "2.71");
        a.D0(57, hashMap, "2.72", 58, "2.73", 59, "2.74", 60, "2.75");
        a.D0(61, hashMap, "2.76", 62, "2.77", 63, "2.78", 64, "2.80");
        a.D0(65, hashMap, "2.81-RC1", 66, "3.0.0", 67, "3.1.0", 68, "3.2.0");
        a.D0(69, hashMap, "3.2.1", 70, "3.2.2", 71, "3.3.0", 72, BuildConfig.VERSION_NAME);
        a.D0(73, hashMap, "3.5.0", 74, "3.5.1", 75, "3.5.2", 76, "3.5.3");
        a.D0(77, hashMap, "3.6.0", 78, "3.6.1", 79, "3.6.2", 80, "3.6.3");
        a.D0(81, hashMap, "3.6.4", 82, "3.7.0", 83, "3.7.1", 84, "3.7.2");
        hashMap.put("3.8.0", 85);
        hashMap.put("3.8.1", 85);
        hashMap.put("3.9.0", 86);
        hashMap.put("3.9.1", 86);
        hashMap.put("3.9.2", 86);
        hashMap.put("3.10.0", 87);
        hashMap.put("3.11.0-RC1", 87);
        hashMap.put("3.11.0", 87);
        hashMap.put("3.12.0-RC1", 87);
        hashMap.put("3.12.0", 87);
        hashMap.put("3.13.0", 87);
        hashMap.put("3.13.1", 87);
    }

    @NonNull
    public static String a(int i) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : a.entrySet()) {
            if (entry.getValue().intValue() == i) {
                arrayList.add(entry.getKey());
            }
        }
        if (arrayList.size() == 1) {
            return (String) arrayList.get(0);
        }
        return arrayList.size() != 0 ? String.format("One of %s", arrayList) : "unknown";
    }
}
