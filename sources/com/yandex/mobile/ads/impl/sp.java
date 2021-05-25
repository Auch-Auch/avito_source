package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import com.yandex.mobile.ads.impl.rr;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
public final class sp {
    public static rr.a a(rx rxVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = rxVar.c;
        String str = map.get(HttpHeaders.DATE);
        long a = str != null ? a(str) : 0;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long a3 = str3 != null ? a(str3) : 0;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long a4 = str4 != null ? a(str4) : 0;
        String str5 = map.get(HttpHeaders.ETAG);
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a <= 0 || a3 < a) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a3 - a);
                j3 = j4;
            }
        }
        rr.a aVar = new rr.a();
        aVar.a = rxVar.b;
        aVar.b = str5;
        aVar.f = j4;
        aVar.e = j3;
        aVar.c = a;
        aVar.d = a4;
        aVar.g = map;
        return aVar;
    }

    private static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }

    public static String a(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}
