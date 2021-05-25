package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.HashMap;
import java.util.Map;
public abstract class fb {
    @NonNull
    public final Map<String, String> a = new HashMap();

    public static boolean a(@NonNull String str, @NonNull Context context) {
        int i;
        try {
            i = context.checkCallingOrSelfPermission(str);
        } catch (Throwable th) {
            a.q1(th, a.R("unable to check ", str, " permission! Unexpected throwable in Context.checkCallingOrSelfPermission() method: "));
            i = -1;
        }
        return i == 0;
    }

    public synchronized boolean addParam(@NonNull String str, @Nullable String str2) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else if (str2 == null) {
            return removeParam(str);
        } else {
            this.a.put(str, str2);
            z = true;
        }
        return z;
    }

    public synchronized void addParams(@NonNull Map<String, String> map) {
        this.a.putAll(map);
    }

    @WorkerThread
    public abstract void collectData(@NonNull Context context);

    @NonNull
    public synchronized Map<String, String> getData() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.putAll(this.a);
        return hashMap;
    }

    @NonNull
    public synchronized Map<String, String> getMap() {
        return this.a;
    }

    @Nullable
    public synchronized String getParam(@NonNull String str) {
        return this.a.get(str);
    }

    public synchronized void putDataTo(@NonNull Map<String, String> map) {
        map.putAll(this.a);
    }

    public synchronized void removeAll() {
        this.a.clear();
    }

    public synchronized boolean removeParam(@NonNull String str) {
        boolean z;
        if (this.a.containsKey(str)) {
            this.a.remove(str);
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
