package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
public class zzcf {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final AtomicBoolean zze = new AtomicBoolean();
    private static HashMap<String, String> zzf;
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static Object zzk;
    private static boolean zzl;
    private static String[] zzm = new String[0];

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3;
        Object obj;
        synchronized (zzcf.class) {
            str3 = null;
            if (zzf == null) {
                zze.set(false);
                zzf = new HashMap<>();
                zzk = new Object();
                zzl = false;
                contentResolver.registerContentObserver(zza, true, new zzch(null));
            } else if (zze.getAndSet(false)) {
                zzf.clear();
                zzg.clear();
                zzh.clear();
                zzi.clear();
                zzj.clear();
                zzk = new Object();
                zzl = false;
            }
            obj = zzk;
            if (zzf.containsKey(str)) {
                String str4 = zzf.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : zzm) {
                if (str.startsWith(str5)) {
                    if (!zzl || zzf.isEmpty()) {
                        zzf.putAll(zza(contentResolver, zzm));
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str6 = zzf.get(str);
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
        Cursor query = contentResolver.query(zza, null, null, new String[]{str}, null);
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
        synchronized (zzcf.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzd, null, null, strArr, null);
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
