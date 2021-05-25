package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.io.File;
import java.io.FilenameFilter;
public class bv {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;
    @NonNull
    private final bw c;
    @NonNull
    private final mo d;
    @NonNull
    private final an e;

    public bv(@NonNull Context context, @NonNull bw bwVar, @NonNull mo moVar) {
        this(context, new an(), bwVar, moVar);
    }

    @VisibleForTesting
    public bv(@NonNull Context context, @NonNull an anVar, @NonNull bw bwVar, @NonNull mo moVar) {
        this.a = context;
        this.e = anVar;
        this.b = anVar.c(context).getAbsolutePath();
        this.c = bwVar;
        this.d = moVar;
    }

    public synchronized void a() {
        if (ax.a() && !this.d.m()) {
            a(this.a.getFilesDir().getAbsolutePath() + "/YandexMetricaNativeCrashes", new aby<Boolean>() { // from class: com.yandex.metrica.impl.ob.bv.1
                public void a(Boolean bool) {
                    bv.this.d.n();
                }
            });
        }
        a(this.b, new aby<Boolean>() { // from class: com.yandex.metrica.impl.ob.bv.2
            public void a(Boolean bool) {
            }
        });
    }

    private void a(@NonNull String str, @NonNull aby<Boolean> aby) {
        for (String str2 : a(str)) {
            a(a.e3(str, "/", str2), aby, false);
        }
    }

    private String[] a(String str) {
        File a3 = this.e.a(str);
        if (!a3.mkdir() && !a3.exists()) {
            return new String[0];
        }
        String[] list = a3.list(new FilenameFilter() { // from class: com.yandex.metrica.impl.ob.bv.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.endsWith(".dmp");
            }
        });
        return list != null ? list : new String[0];
    }

    public void a(@NonNull String str, @NonNull aby<Boolean> aby, boolean z) {
        try {
            String b2 = ax.b(ax.a(str));
            if (b2 != null) {
                if (z) {
                    this.c.a(b2);
                } else {
                    this.c.b(b2);
                }
            }
            aby.a(Boolean.TRUE);
        } catch (Throwable th) {
            this.e.a(str).delete();
            throw th;
        }
        this.e.a(str).delete();
    }
}
