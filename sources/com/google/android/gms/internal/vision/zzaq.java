package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
public class zzaq {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzfa = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzfb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzfc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzfd = new AtomicBoolean();
    private static HashMap<String, String> zzfe;
    private static final HashMap<String, Boolean> zzff = new HashMap<>();
    private static final HashMap<String, Integer> zzfg = new HashMap<>();
    private static final HashMap<String, Long> zzfh = new HashMap<>();
    private static final HashMap<String, Float> zzfi = new HashMap<>();
    private static Object zzfj;
    private static boolean zzfk;
    private static String[] zzfl = new String[0];

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3;
        Object obj;
        synchronized (zzaq.class) {
            str3 = null;
            if (zzfe == null) {
                zzfd.set(false);
                zzfe = new HashMap<>();
                zzfj = new Object();
                zzfk = false;
                contentResolver.registerContentObserver(CONTENT_URI, true, new zzat(null));
            } else if (zzfd.getAndSet(false)) {
                zzfe.clear();
                zzff.clear();
                zzfg.clear();
                zzfh.clear();
                zzfi.clear();
                zzfj = new Object();
                zzfk = false;
            }
            obj = zzfj;
            if (zzfe.containsKey(str)) {
                String str4 = zzfe.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : zzfl) {
                if (str.startsWith(str5)) {
                    if (!zzfk || zzfe.isEmpty()) {
                        zzfe.putAll(zza(contentResolver, zzfl));
                        zzfk = true;
                        if (zzfe.containsKey(str)) {
                            String str6 = zzfe.get(str);
                            if (str6 != null) {
                                str3 = str6;
                            }
                            return str3;
                        }
                    }
                    return null;
                }
            }
        }
        Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
        if (query == null) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        try {
            if (!query.moveToFirst()) {
                zza(obj, str, (String) null);
                return null;
            }
            String string = query.getString(1);
            if (string != null && string.equals(null)) {
                string = null;
            }
            zza(obj, str, string);
            if (string != null) {
                str3 = string;
            }
            query.close();
            return str3;
        } finally {
            query.close();
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzaq.class) {
            if (obj == zzfj) {
                zzfe.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzfa, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
