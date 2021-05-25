package com.google.android.gms.common.util;

import a2.b.a.a.a;
import androidx.annotation.RecentlyNonNull;
import com.avito.android.BuildConfig;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String str : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            String str2 = hashMap.get(str);
            a.m1(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
            } else {
                a.m1(sb, "\"", str2, "\"");
            }
        }
        sb.append("}");
    }
}
