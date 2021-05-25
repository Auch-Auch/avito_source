package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.al;
public class kv {
    private static SparseArray<kv> c;
    public final String a;
    public final String b;

    static {
        SparseArray<kv> sparseArray = new SparseArray<>();
        c = sparseArray;
        sparseArray.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED.a(), new kv("jvm", "binder"));
        c.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF.a(), new kv("jvm", "binder"));
        c.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT.a(), new kv("jvm", "intent"));
        c.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE.a(), new kv("jvm", "file"));
        c.put(al.a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH.a(), new kv("jni_native", "file"));
        c.put(al.a.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH.a(), new kv("jni_native", "file"));
    }

    private kv(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    public static kv a(int i) {
        return c.get(i);
    }
}
