package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.p;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
public final class gk implements IIdentifierCallback, gm {
    private static final long a = ((long) hr.b);
    private static final Object b = new Object();
    private static volatile gm c;
    @NonNull
    private final Context d;
    @NonNull
    private final gh e = new gh();
    @NonNull
    private final WeakHashMap<gl, Object> f = new WeakHashMap<>();
    @NonNull
    private final Handler g = new Handler(Looper.getMainLooper());
    @NonNull
    private final go h = new go();
    @NonNull
    private final gi i = new gi();
    @Nullable
    private Map<String, String> j;
    private boolean k;

    private gk(@NonNull Context context) {
        this.d = context.getApplicationContext();
        ht.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.gm
    public final void b(@NonNull gl glVar) {
        synchronized (b) {
            this.f.remove(glVar);
        }
    }

    @Override // com.yandex.metrica.IIdentifierCallback
    public final void onReceive(@Nullable Map<String, String> map) {
        synchronized (b) {
            if (map != null) {
                if (go.a(map)) {
                    HashMap hashMap = new HashMap(map);
                    this.j = hashMap;
                    a(hashMap);
                }
            }
            a(gi.c());
        }
    }

    @Override // com.yandex.metrica.IIdentifierCallback
    public final void onRequestError(@NonNull IIdentifierCallback.Reason reason) {
        synchronized (b) {
            a(gi.a(reason));
        }
    }

    @NonNull
    public static gm a(@NonNull Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new gk(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    @Override // com.yandex.mobile.ads.impl.gm
    public final void a(@NonNull gl glVar) {
        synchronized (b) {
            Map<String, String> map = this.j;
            if (map == null || !go.a(map)) {
                this.f.put(glVar, null);
                try {
                    if (!this.k) {
                        this.k = true;
                        this.g.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.gk.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                gi unused = gk.this.i;
                                gk.this.a(gi.a());
                            }
                        }, a);
                        Context context = this.d;
                        if (Cif.b(p.class, AuthSource.SEND_ABUSE, context, this)) {
                            try {
                                p.a(context, this);
                            } catch (Throwable unused) {
                                p.a(this);
                            }
                        } else {
                            p.a(this);
                        }
                    }
                } catch (Throwable unused2) {
                    a(gi.b());
                }
            } else {
                glVar.a(this.j);
            }
        }
    }

    private void a(@NonNull Map<String, String> map) {
        synchronized (b) {
            a();
            for (gl glVar : this.f.keySet()) {
                glVar.a(map);
            }
            this.f.clear();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@NonNull String str) {
        synchronized (b) {
            a();
            for (gl glVar : this.f.keySet()) {
                glVar.a(str);
            }
            this.f.clear();
        }
    }

    private void a() {
        this.g.removeCallbacksAndMessages(null);
        this.k = false;
    }
}
