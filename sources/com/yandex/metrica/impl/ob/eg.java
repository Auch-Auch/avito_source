package com.yandex.metrica.impl.ob;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class eg {
    private final a a;
    private final abx<Thread, StackTraceElement[], lc> b;

    public interface a {
        Thread a();

        Map<Thread, StackTraceElement[]> b();
    }

    public eg() {
        this(new a() { // from class: com.yandex.metrica.impl.ob.eg.1
            @Override // com.yandex.metrica.impl.ob.eg.a
            public Thread a() {
                return Looper.getMainLooper().getThread();
            }

            @Override // com.yandex.metrica.impl.ob.eg.a
            public Map<Thread, StackTraceElement[]> b() {
                return Thread.getAllStackTraces();
            }
        }, new ef());
    }

    private lc b(@NonNull Thread thread) {
        StackTraceElement[] stackTraceElementArr;
        try {
            stackTraceElementArr = thread.getStackTrace();
        } catch (SecurityException unused) {
            stackTraceElementArr = null;
        }
        return this.b.a(thread, stackTraceElementArr);
    }

    public ky a() {
        Thread a3 = this.a.a();
        return new ky(b(a3), a(a3, null));
    }

    @VisibleForTesting
    public eg(@NonNull a aVar, @NonNull abx<Thread, StackTraceElement[], lc> abx) {
        this.a = aVar;
        this.b = abx;
    }

    public List<lc> a(@Nullable Thread thread) {
        Thread a3 = this.a.a();
        List<lc> a4 = a(a3, thread);
        if (thread != a3) {
            a4.add(0, b(a3));
        }
        return a4;
    }

    private List<lc> a(@NonNull Thread thread, @Nullable Thread thread2) {
        Map<Thread, StackTraceElement[]> map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() { // from class: com.yandex.metrica.impl.ob.eg.2
            /* renamed from: a */
            public int compare(Thread thread3, Thread thread4) {
                if (thread3 == thread4) {
                    return 0;
                }
                return dh.d(thread3.getName(), thread4.getName());
            }
        });
        try {
            map = this.a.b();
        } catch (SecurityException unused) {
            map = null;
        }
        if (map != null) {
            treeMap.putAll(map);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (!(thread3 == thread || thread3 == thread2)) {
                arrayList.add(this.b.a(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }
}
