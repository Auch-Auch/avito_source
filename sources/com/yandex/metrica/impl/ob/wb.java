package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.vy;
public class wb extends vy {
    @NonNull
    private String a;
    @NonNull
    private String b;

    public static abstract class a<T extends wb, A extends vy.a> extends vy.b<T, A> {
        private final ado c;

        public a(@NonNull Context context, @NonNull String str) {
            this(context, str, new ado());
        }

        @NonNull
        /* renamed from: b */
        public T c(@NonNull vy.c<A> cVar) {
            T t = (T) ((wb) super.a(cVar));
            String packageName = this.a.getPackageName();
            ApplicationInfo b = this.c.b(this.a, this.b, 0);
            if (b != null) {
                t.l(a(b));
                t.m(b(b));
            } else if (TextUtils.equals(packageName, this.b)) {
                t.l(a(this.a.getApplicationInfo()));
                t.m(b(this.a.getApplicationInfo()));
            } else {
                t.l("0");
                t.m("0");
            }
            return t;
        }

        public a(@NonNull Context context, @NonNull String str, @NonNull ado ado) {
            super(context, str);
            this.c = ado;
        }

        @NonNull
        private String a(@NonNull ApplicationInfo applicationInfo) {
            return (applicationInfo.flags & 2) != 0 ? "1" : "0";
        }

        @NonNull
        private String b(@NonNull ApplicationInfo applicationInfo) {
            return (applicationInfo.flags & 1) != 0 ? "1" : "0";
        }
    }

    @NonNull
    public String G() {
        return this.a;
    }

    public String H() {
        return this.b;
    }

    public void l(@NonNull String str) {
        this.a = str;
    }

    public void m(@NonNull String str) {
        this.b = str;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CoreRequestConfig{mAppDebuggable='");
        a2.b.a.a.a.k1(L, this.a, '\'', ", mAppSystem='");
        a2.b.a.a.a.k1(L, this.b, '\'', "} ");
        L.append(super.toString());
        return L.toString();
    }
}
