package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.ii;
import com.yandex.mobile.ads.impl.rr;
import com.yandex.mobile.ads.impl.sa;
import java.util.Collections;
import java.util.Map;
public abstract class ry<T> implements Comparable<ry<T>> {
    private final ii.a a = null;
    private final int b;
    private final String c;
    private final int d;
    private final sa.a e;
    private Integer f;
    private rz g;
    private boolean h = true;
    private boolean i;
    private boolean j;
    private boolean k;
    private sc l;
    private rr.a m;
    private Object n;

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public ry(int i2, String str, sa.a aVar) {
        Uri parse;
        String host;
        int i3 = 0;
        this.i = false;
        this.j = false;
        this.k = false;
        this.m = null;
        this.b = i2;
        this.c = str;
        this.e = aVar;
        this.l = new rt();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i3 = host.hashCode();
        }
        this.d = i3;
    }

    public static String k() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> a(Object obj) {
        this.n = obj;
        return this;
    }

    public abstract sa<T> a(rx rxVar);

    public sl a(sl slVar) {
        return slVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> b(int i2) {
        this.f = Integer.valueOf(i2);
        return this;
    }

    public abstract void b(T t);

    public byte[] c() throws se {
        return null;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        ry ryVar = (ry) obj;
        a o = o();
        a o2 = ryVar.o();
        if (o == o2) {
            return this.f.intValue() - ryVar.f.intValue();
        }
        return o2.ordinal() - o.ordinal();
    }

    public final int d() {
        return this.b;
    }

    public final Object e() {
        return this.n;
    }

    public final int f() {
        return this.d;
    }

    public final void g() {
        rz rzVar = this.g;
        if (rzVar != null) {
            rzVar.b(this);
        }
    }

    public final rr.a h() {
        return this.m;
    }

    public final void i() {
        this.i = true;
    }

    public final boolean j() {
        return this.i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> l() {
        this.h = false;
        return this;
    }

    public final boolean m() {
        return this.h;
    }

    public final boolean n() {
        return this.k;
    }

    public a o() {
        return a.NORMAL;
    }

    public final int p() {
        return this.l.a();
    }

    public final sc q() {
        return this.l;
    }

    public final void r() {
        this.j = true;
    }

    public final boolean s() {
        return this.j;
    }

    @Override // java.lang.Object
    public String toString() {
        String str = "0x" + Integer.toHexString(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(this.i ? "[X] " : "[ ] ");
        sb.append(b());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(o());
        sb.append(" ");
        sb.append(this.f);
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> a(sc scVar) {
        this.l = scVar;
        return this;
    }

    public String b() {
        return this.c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> a(rz rzVar) {
        this.g = rzVar;
        return this;
    }

    public final void b(sl slVar) {
        sa.a aVar = this.e;
        if (aVar != null) {
            aVar.a(slVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.mobile.ads.impl.ry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final ry<?> a(rr.a aVar) {
        this.m = aVar;
        return this;
    }

    public Map<String, String> a() throws se {
        return Collections.emptyMap();
    }
}
