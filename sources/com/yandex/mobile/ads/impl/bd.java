package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.mediation.base.a;
import com.yandex.mobile.ads.mediation.base.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class bd<T extends a, L> {
    @NonNull
    private final fo a;
    @NonNull
    private final bf<T, L> b;
    @NonNull
    private final bj c;
    @NonNull
    private final be<T> d;
    @NonNull
    private final b e = new b();
    @NonNull
    private final bi f;
    @Nullable
    private bc<T> g;

    public bd(@NonNull fo foVar, @NonNull bf<T, L> bfVar, @NonNull bj bjVar, @NonNull be<T> beVar, @NonNull bi biVar) {
        this.a = foVar;
        this.b = bfVar;
        this.f = biVar;
        this.d = beVar;
        this.c = bjVar;
    }

    public final void a(@NonNull Context context) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            try {
                this.b.a(bcVar.a());
            } catch (Throwable th) {
                a(context, th, this.g.b());
            }
        }
    }

    public final void b(@NonNull Context context) {
        a(context, (Map<String, Object>) new HashMap());
    }

    public final void c(@NonNull Context context) {
        c(context, new HashMap());
    }

    public final void d(@NonNull Context context) {
        if (this.g != null) {
            HashMap k0 = a2.b.a.a.a.k0("status", "success");
            this.c.c(context, this.g.b(), k0);
        }
    }

    public final void e(@NonNull Context context) {
        d(context, new HashMap());
    }

    private void e(@NonNull Context context, @NonNull Map<String, Object> map) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            map.putAll(b.a(bcVar.a()));
            this.c.d(context, this.g.b(), map);
        }
    }

    public final void b(@NonNull Context context, @NonNull Map<String, Object> map) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            this.c.e(context, bcVar.b(), map);
        }
    }

    public final void c(@NonNull Context context, @NonNull Map<String, Object> map) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            bn b2 = bcVar.b();
            List<String> c2 = b2.c();
            if (c2 != null) {
                for (String str : c2) {
                    new dg(context, this.a).a(str);
                }
            }
            this.c.b(context, b2, map);
        }
    }

    public final void a(@NonNull Context context, @NonNull L l) {
        while (true) {
            bc<T> a3 = this.d.a(context);
            this.g = a3;
            if (a3 != null) {
                bn b2 = a3.b();
                this.c.a(context, b2);
                try {
                    this.b.a(context, this.g.a(), l, this.g.a(context), this.g.c());
                    return;
                } catch (Throwable th) {
                    a(context, th, b2);
                }
            } else {
                this.f.a();
                return;
            }
        }
    }

    private void b(@NonNull Context context, @NonNull L l) {
        a(context);
        a(context, (Context) l);
    }

    public final void d(@NonNull Context context, @NonNull Map<String, Object> map) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            List<String> e2 = bcVar.b().e();
            dg dgVar = new dg(context, this.a);
            if (e2 != null) {
                for (String str : e2) {
                    dgVar.a(str);
                }
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("status", "success");
        e(context, hashMap);
    }

    public final void b(@NonNull Context context, @NonNull AdRequestError adRequestError, @NonNull L l) {
        if (this.g != null) {
            HashMap k0 = a2.b.a.a.a.k0("status", "error");
            k0.put("error_code", Integer.valueOf(adRequestError.getCode()));
            this.c.c(context, this.g.b(), k0);
        }
        b(context, (Context) l);
    }

    public final void a(@NonNull Context context, @NonNull Map<String, Object> map) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            bn b2 = bcVar.b();
            List<String> d2 = b2.d();
            if (d2 != null) {
                for (String str : d2) {
                    new dg(context, this.a).a(str);
                }
            }
            HashMap hashMap = new HashMap(map);
            hashMap.put("click_type", "default");
            this.c.a(context, b2, hashMap);
        }
    }

    private void a(@NonNull Context context, @NonNull Throwable th, @NonNull bn bnVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("exception_in_adapter", th.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("reason", hashMap);
        this.c.f(context, bnVar, hashMap2);
    }

    public final void a(@NonNull Context context, @Nullable x<String> xVar) {
        bc<T> bcVar = this.g;
        if (bcVar != null) {
            this.c.a(context, bcVar.b(), xVar);
        }
    }

    public final void a(@NonNull Context context, @NonNull AdRequestError adRequestError, @NonNull L l) {
        HashMap k0 = a2.b.a.a.a.k0("status", "error");
        k0.put("error_code", Integer.valueOf(adRequestError.getCode()));
        k0.put(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, adRequestError.getDescription());
        e(context, k0);
        b(context, (Context) l);
    }
}
