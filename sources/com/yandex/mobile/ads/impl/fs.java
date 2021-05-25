package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.p;
import com.yandex.mobile.ads.impl.fr;
import java.util.WeakHashMap;
public final class fs implements fw {
    private static final long a = ((long) hr.b);
    private static final Object b = new Object();
    private static volatile fs c;
    @NonNull
    private final fr d = new fr();
    @NonNull
    private final gi e = new gi();
    @NonNull
    private final Handler f = new Handler(Looper.getMainLooper());
    @NonNull
    private final WeakHashMap<fx, Object> g = new WeakHashMap<>();
    private boolean h;

    public class a implements fr.a {
        private a() {
        }

        @Override // com.yandex.mobile.ads.impl.fr.a
        public final void a(@Nullable String str) {
            synchronized (fs.b) {
                fs.this.a(str);
            }
        }

        public /* synthetic */ a(fs fsVar, byte b) {
            this();
        }

        @Override // com.yandex.mobile.ads.impl.fr.a
        public final void a() {
            synchronized (fs.b) {
                fs.this.c();
            }
        }
    }

    private fs() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        synchronized (b) {
            a((String) null);
        }
    }

    private void d() {
        this.f.removeCallbacksAndMessages(null);
        this.h = false;
    }

    @NonNull
    public static fs a() {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new fs();
                }
            }
        }
        return c;
    }

    @Override // com.yandex.mobile.ads.impl.fw
    public final void b(@NonNull fx fxVar) {
        synchronized (b) {
            this.g.put(fxVar, null);
            try {
                if (!this.h) {
                    this.h = true;
                    this.f.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.fs.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            gi unused = fs.this.e;
                            gi.a();
                            fs.this.c();
                        }
                    }, a);
                    a aVar = new a(this, (byte) 0);
                    try {
                        p.guc(new fr.b(aVar), true);
                    } catch (Throwable unused) {
                        aVar.a();
                    }
                }
            } catch (Throwable unused2) {
                gi.b();
                c();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.fw
    public final void a(@NonNull fx fxVar) {
        synchronized (b) {
            this.g.remove(fxVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@Nullable String str) {
        synchronized (b) {
            d();
            for (fx fxVar : this.g.keySet()) {
                fxVar.a(str);
            }
            this.g.clear();
        }
    }
}
