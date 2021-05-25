package com.google.android.play.core.splitcompat;

import a2.j.b.e.a.h.a;
import a2.j.b.e.a.h.j;
import a2.j.b.e.a.h.k;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import com.google.android.play.core.internal.an;
import com.google.android.play.core.internal.ao;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bj;
import com.google.android.play.core.splitinstall.w;
import com.google.android.play.core.splitinstall.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
public class SplitCompat {
    public static final AtomicReference<SplitCompat> d = new AtomicReference<>(null);
    public final e a;
    public final Set<String> b = new HashSet();
    public final a c;

    public SplitCompat(Context context) {
        try {
            e eVar = new e(context);
            this.a = eVar;
            this.c = new a(eVar);
        } catch (PackageManager.NameNotFoundException e) {
            throw new bj("Failed to initialize FileStorage", e);
        }
    }

    public static boolean a() {
        return d.get() != null;
    }

    public static boolean a(Context context) {
        return b(context, true);
    }

    public static boolean b(Context context, boolean z) {
        AtomicReference<SplitCompat> atomicReference = d;
        boolean compareAndSet = atomicReference.compareAndSet(null, new SplitCompat(context));
        SplitCompat splitCompat = atomicReference.get();
        if (compareAndSet) {
            w.a.a(new an(context, d.a(), new ao(context, splitCompat.a, new d(), null), splitCompat.a, new aq(), null));
            y.a(new j(splitCompat));
            d.a().execute(new k(context));
        }
        try {
            splitCompat.c(context, z);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean install(Context context) {
        return b(context, false);
    }

    public static boolean installActivity(Context context) {
        HashSet hashSet;
        StrictMode.ThreadPolicy threadPolicy;
        boolean z;
        SplitCompat splitCompat = d.get();
        if (splitCompat != null) {
            a aVar = splitCompat.c;
            synchronized (splitCompat.b) {
                hashSet = new HashSet(splitCompat.b);
            }
            synchronized (aVar) {
                try {
                    threadPolicy = StrictMode.getThreadPolicy();
                    try {
                        StrictMode.allowThreadDiskReads();
                        StrictMode.allowThreadDiskWrites();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    threadPolicy = null;
                }
                try {
                    HashSet hashSet2 = new HashSet();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        hashSet2.add(aVar.a.b((String) it.next()));
                    }
                    a.a(context, hashSet2);
                    if (threadPolicy != null) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    z = true;
                } catch (Exception unused3) {
                    if (threadPolicy != null) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    z = false;
                } catch (Throwable th) {
                    if (threadPolicy != null) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    throw th;
                }
            }
            return z;
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a2 A[SYNTHETIC, Splitter:B:78:0x01a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c(android.content.Context r12, boolean r13) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 526
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.c(android.content.Context, boolean):void");
    }
}
