package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.ViewGroup;
public class aan {
    @Nullable
    private aap a;
    @NonNull
    private final b b;
    @NonNull
    private final a c;

    public static class a {
        @NonNull
        public zr a(@NonNull zx zxVar) {
            return new zr(zxVar.a());
        }
    }

    public static class b {
        @NonNull
        public zx a(@NonNull aap aap) {
            return new zx(aap);
        }
    }

    public aan(@Nullable aap aap) {
        this(aap, new b(), new a());
    }

    @NonNull
    public aaf a(@NonNull Activity activity, @NonNull zt ztVar) {
        aaf aaf = new aaf();
        if (this.a != null) {
            ViewGroup viewGroup = null;
            try {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            } catch (Throwable unused) {
            }
            if (viewGroup != null) {
                zx a3 = this.b.a(this.a);
                aaf.a(a3, viewGroup, ztVar);
                if (this.a.e) {
                    zr a4 = this.c.a(a3);
                    for (aad aad : a3.b()) {
                        a4.a(aad);
                    }
                }
            }
        }
        return aaf;
    }

    @VisibleForTesting
    public aan(@Nullable aap aap, @NonNull b bVar, @NonNull a aVar) {
        this.a = aap;
        this.b = bVar;
        this.c = aVar;
    }

    public void a(@Nullable aap aap) {
        this.a = aap;
    }
}
