package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import java.util.HashMap;
import java.util.Map;
public class ck {
    private final boolean a;
    private final cs b;
    private final mn c;
    private String d;
    private Map<String, String> e;
    private DeferredDeeplinkParametersListener f;

    public ck(cs csVar, mn mnVar, @NonNull act act) {
        this(csVar, mnVar, new vw(csVar.b()), act);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(@Nullable String str) {
        if (!(this.a || TextUtils.isEmpty(str)) && TextUtils.isEmpty(this.d)) {
            synchronized (this) {
                this.d = str;
                this.c.n(str);
                e(b(str));
                a();
            }
        }
    }

    private void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e = c(str);
        }
    }

    private static Map<String, String> f(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            String g = g(str);
            if (h(g)) {
                String[] split = g.split("&");
                for (String str2 : split) {
                    int indexOf = str2.indexOf("=");
                    if (indexOf >= 0) {
                        hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                    } else {
                        hashMap.put(str2, "");
                    }
                }
            }
        }
        return hashMap;
    }

    private static String g(String str) {
        int lastIndexOf = str.lastIndexOf(63);
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : str;
    }

    private static boolean h(String str) {
        return str.contains("=");
    }

    @VisibleForTesting
    public final Map<String, String> c(String str) {
        Map<String, String> f2 = f(Uri.decode(str));
        HashMap hashMap = new HashMap(f2.size());
        for (Map.Entry<String, String> entry : f2.entrySet()) {
            hashMap.put(Uri.decode(entry.getKey()), Uri.decode(entry.getValue()));
        }
        return hashMap;
    }

    @VisibleForTesting
    public final String b(String str) {
        return f(str).get("appmetrica_deep_link");
    }

    public void a(String str) {
        this.b.a(str);
        d(str);
    }

    @VisibleForTesting
    public ck(cs csVar, mn mnVar, @NonNull final vw vwVar, @NonNull act act) {
        this.b = csVar;
        this.c = mnVar;
        this.d = mnVar.c();
        boolean d2 = mnVar.d();
        this.a = d2;
        if (d2) {
            mnVar.n(null);
            this.d = null;
        } else {
            e(b(this.d));
        }
        if (!mnVar.e()) {
            act.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ck.1
                @Override // java.lang.Runnable
                public void run() {
                    vwVar.a(new vv() { // from class: com.yandex.metrica.impl.ob.ck.1.1
                        @Override // com.yandex.metrica.impl.ob.vv
                        public void a(@NonNull vu vuVar) {
                            ck.this.b.a(vuVar);
                            ck.this.d(vuVar.a);
                            a();
                        }

                        @Override // com.yandex.metrica.impl.ob.vv
                        public void a(@NonNull Throwable th) {
                            ck.this.b.a((vu) null);
                            a();
                        }

                        private void a() {
                            ck.this.c.g();
                        }
                    });
                }
            });
        }
    }

    private void a() {
        if (!dl.a((Map) this.e)) {
            DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.f;
            if (deferredDeeplinkParametersListener != null) {
                deferredDeeplinkParametersListener.onParametersLoaded(this.e);
                this.f = null;
            }
        } else if (this.d != null) {
            a(DeferredDeeplinkParametersListener.Error.PARSE_ERROR);
        }
    }

    private void a(DeferredDeeplinkParametersListener.Error error) {
        DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.f;
        if (deferredDeeplinkParametersListener != null) {
            deferredDeeplinkParametersListener.onError(error, this.d);
            this.f = null;
        }
    }

    public synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        try {
            this.f = deferredDeeplinkParametersListener;
            if (this.a) {
                a(DeferredDeeplinkParametersListener.Error.NOT_A_FIRST_LAUNCH);
            } else {
                a();
            }
        } finally {
            this.c.f();
        }
    }
}
