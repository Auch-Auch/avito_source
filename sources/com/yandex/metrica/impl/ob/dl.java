package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public final class dl {
    private static final ado a = new ado();

    public static String a(Context context, String str) {
        return String.valueOf(c(context, str));
    }

    public static boolean a(Object obj) {
        return obj != null;
    }

    public static String b(Context context, String str) {
        PackageInfo a3 = a.a(context, str);
        if (a3 == null) {
            return IdManager.DEFAULT_VERSION_NAME;
        }
        return a3.versionName;
    }

    public static int c(Context context, String str) {
        PackageInfo a3 = a.a(context, str);
        if (a3 == null) {
            return 0;
        }
        return a3.versionCode;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String obj = stringWriter.toString();
        printWriter.close();
        return obj;
    }

    @NonNull
    public static StackTraceElement[] b(@Nullable Throwable th) {
        if (th != null) {
            try {
                return th.getStackTrace();
            } catch (Throwable unused) {
            }
        }
        return new StackTraceElement[0];
    }

    @Nullable
    public static <K, V> List<Map.Entry<K, V>> c(@Nullable Map<K, V> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(new AbstractMap.SimpleEntry(entry));
        }
        return arrayList;
    }

    public static boolean b(int i) {
        return Build.VERSION.SDK_INT > i;
    }

    public static void b(@Nullable SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(@Nullable Cursor cursor) {
        return cursor == null || cursor.getCount() == 0;
    }

    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    @NonNull
    public static String b(@Nullable String str) {
        if (TextUtils.isEmpty(str) || str.length() != 36) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.replace(8, str.length() - 4, "-xxxx-xxxx-xxxx-xxxxxxxx");
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    @Nullable
    public static <K, V> Map<K, V> b(@Nullable Map<K, V> map) {
        if (a((Map) map)) {
            return null;
        }
        return new HashMap(map);
    }

    public static List<ResolveInfo> a(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Intent intent = new Intent(str, (Uri) null);
            intent.addCategory(str2);
            return a.a(context, intent, 0);
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public static List<PackageInfo> a(Context context) {
        return a.a(context, 0);
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean a(@Nullable byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME.equals(str);
    }

    @NonNull
    public static <K, V> V a(@NonNull Map<K, V> map, @Nullable K k, @NonNull V v) {
        V v2 = map.get(k);
        return v2 == null ? v : v2;
    }

    @NonNull
    public static Set<Integer> a(@NonNull int[] iArr) {
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        return hashSet;
    }

    public static <T> List<T> a(@NonNull List<T> list, int i) {
        if (list.size() <= i) {
            return list;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(list.get(i2));
        }
        return arrayList;
    }

    public static String a(@NonNull String str, int i) {
        return str.length() > i ? str.substring(0, 100) : str;
    }

    @NonNull
    public static List<String> a(@NonNull String... strArr) {
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, strArr);
        return Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public static <T> void a(@NonNull abz<T> abz, @Nullable T t, @NonNull String str, @NonNull String str2) {
        if (t != null) {
            try {
                abz.a(t);
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public static <T, S> S a(@NonNull aca<T, S> aca, @Nullable T t, @NonNull String str, @NonNull String str2) {
        if (t == null) {
            return null;
        }
        try {
            return aca.a(t);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static <T, S> S a(@NonNull aca<T, S> aca, @Nullable T t, @NonNull String str, @NonNull String str2, @NonNull S s) {
        S s2 = (S) a(aca, t, str, str2);
        return s2 == null ? s : s2;
    }

    @NonNull
    public static <K, V> Map<K, V> a(@Nullable List<Map.Entry<K, V>> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null) {
            for (Map.Entry<K, V> entry : list) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
