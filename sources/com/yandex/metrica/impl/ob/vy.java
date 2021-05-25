package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.yandex.metrica.impl.ob.pc;
import java.util.Locale;
import java.util.Map;
public class vy {
    private String a;
    private x b;
    private final String c = "3.13.1";
    private final String d = "72430";
    @NonNull
    private final String e = a();
    private final String f = "android";
    private final String g = ExifInterface.GPS_MEASUREMENT_2D;
    @NonNull
    private String h = cx.b();
    @Nullable
    private final String i = "92eae106af06d42d4d1aed7145c2da6c30b52a3d";
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    @NonNull
    private Map<pc.a, pc> q;
    private String r = com.yandex.metrica.b.PHONE.name().toLowerCase(Locale.US);
    private String s;
    private yb t;

    public static abstract class a<I, O> implements vx<I, O> {
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.c = str;
            this.d = str2;
            this.e = str3;
        }
    }

    public static abstract class b<T extends vy, A extends a> implements d<T, c<A>> {
        @NonNull
        public final Context a;
        @NonNull
        public final String b;

        public b(@NonNull Context context, @NonNull String str) {
            this.a = context;
            this.b = str;
        }

        private void b(@NonNull T t, @NonNull String str, @Nullable String str2, @NonNull Context context) {
            if (TextUtils.isEmpty(str2)) {
                str2 = dl.a(context, str);
            }
            t.c(str2);
        }

        @NonNull
        public abstract T b();

        @NonNull
        /* renamed from: c */
        public T a(@NonNull c<A> cVar) {
            T b2 = b();
            x a3 = x.a(this.a);
            b2.a(a3);
            b2.a(cVar.a);
            b2.k(a(this.a, cVar.b.c));
            b2.i((String) abw.b(a3.a(cVar.a), ""));
            c(b2, cVar);
            a(b2, this.b, cVar.b.d, this.a);
            b(b2, this.b, cVar.b.e, this.a);
            b2.b(this.b);
            b2.a(pe.a().c(this.a));
            b2.j(bi.a(this.a).a());
            return b2;
        }

        private void a(@NonNull T t, @NonNull String str, @Nullable String str2, @NonNull Context context) {
            if (TextUtils.isEmpty(str2)) {
                str2 = dl.b(context, str);
            }
            t.d(str2);
        }

        public void b(T t, @NonNull c<A> cVar) {
            t.g(cVar.a.c);
        }

        public void a(T t, @NonNull c<A> cVar) {
            t.f(cVar.a.b);
            t.h(cVar.a.d);
        }

        private String a(@NonNull c<A> cVar) {
            return cVar.a.a;
        }

        @VisibleForTesting
        public String a(@NonNull Context context, @Nullable String str) {
            return str == null ? x.a(context).g : str;
        }

        private synchronized void c(@NonNull T t, @NonNull c<A> cVar) {
            t.e(a((c) cVar));
            a((b<T, A>) t, cVar);
            b(t, cVar);
        }
    }

    public static class c<A> {
        @NonNull
        public final yb a;
        @NonNull
        public final A b;

        public c(@NonNull yb ybVar, A a3) {
            this.a = ybVar;
            this.b = a3;
        }
    }

    public interface d<T extends vy, D> {
        @NonNull
        T a(D d);
    }

    public float A() {
        return this.b.f.d;
    }

    @NonNull
    public String B() {
        return (String) abw.b(this.s, "");
    }

    @NonNull
    public String C() {
        return this.p;
    }

    @NonNull
    public String D() {
        return (String) abw.b(this.r, com.yandex.metrica.b.PHONE.name().toLowerCase(Locale.US));
    }

    @NonNull
    public Map<pc.a, pc> E() {
        return this.q;
    }

    @Nullable
    public String F() {
        return "92eae106af06d42d4d1aed7145c2da6c30b52a3d";
    }

    public void a(x xVar) {
        this.b = xVar;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.k = str;
        }
    }

    public String d() {
        return this.a;
    }

    public yb e() {
        return this.t;
    }

    @NonNull
    public xq f() {
        return this.t.E;
    }

    public synchronized boolean g() {
        return !dh.a(u(), s(), this.o);
    }

    @NonNull
    public String h() {
        return (String) abw.b(this.b.b, "");
    }

    public String i() {
        return ExifInterface.GPS_MEASUREMENT_2D;
    }

    public void i(String str) {
        this.p = str;
    }

    public String j() {
        return "3.13.1";
    }

    public final void j(String str) {
        this.s = str;
    }

    public String k() {
        return "72430";
    }

    public void k(String str) {
        this.r = str;
    }

    @NonNull
    public String l() {
        return this.e;
    }

    public String m() {
        return "android";
    }

    @NonNull
    public String n() {
        return this.b.c;
    }

    @NonNull
    public String o() {
        return this.b.d;
    }

    public int p() {
        return this.b.e;
    }

    public String q() {
        return (String) abw.b(this.k, "");
    }

    public String r() {
        return (String) abw.b(this.j, "");
    }

    @NonNull
    public synchronized String s() {
        return (String) abw.b(this.m, "");
    }

    @NonNull
    public synchronized String t() {
        return (String) abw.b(this.n, "");
    }

    @NonNull
    public synchronized String u() {
        return (String) abw.b(this.l, "");
    }

    @NonNull
    public String v() {
        return this.b.h;
    }

    @NonNull
    public String w() {
        return this.h;
    }

    public int x() {
        return this.b.f.a;
    }

    public int y() {
        return this.b.f.b;
    }

    public int z() {
        return this.b.f.c;
    }

    public void a(yb ybVar) {
        this.t = ybVar;
    }

    public void d(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.j = str;
        }
    }

    public synchronized void e(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.l = str;
        }
    }

    public synchronized void f(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m = str;
        }
    }

    public synchronized void g(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n = str;
        }
    }

    public synchronized void h(String str) {
        this.o = str;
    }

    public void a(@NonNull Map<pc.a, pc> map) {
        this.q = map;
    }

    @NonNull
    private static String a() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty("public")) {
            sb.append("public");
        }
        if (!TextUtils.isEmpty("binary")) {
            sb.append("_binary");
        }
        if (!TextUtils.isEmpty("")) {
            sb.append("_");
        }
        return sb.toString();
    }
}
