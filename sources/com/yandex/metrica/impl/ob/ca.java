package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.wj;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public abstract class ca<T extends wj> {
    public String a;
    public int b = 1;
    public final Map<String, List<String>> c = new HashMap();
    public byte[] d;
    public int e;
    public byte[] f;
    public Map<String, List<String>> g;
    public int h = -1;
    @NonNull
    public final T i;
    private List<String> j;
    @Nullable
    private Boolean k;
    private boolean l;
    @Nullable
    private Long m;
    @Nullable
    private Integer n;

    public enum a {
        REPORT,
        LOCATION,
        STARTUP,
        DIAGNOSTIC
    }

    public ca(@NonNull T t) {
        this.i = t;
    }

    @Nullable
    public Integer A() {
        return this.n;
    }

    public Map<String, List<String>> B() {
        return this.c;
    }

    public void C() {
    }

    public void D() {
    }

    @NonNull
    public abstract a E();

    @Nullable
    public xq F() {
        return null;
    }

    public abstract void a(@NonNull Uri.Builder builder);

    public void a(String str) {
        this.a = str;
    }

    public void a(Throwable th) {
    }

    public abstract boolean a();

    public void b(byte[] bArr) {
        this.f = bArr;
    }

    public abstract boolean b();

    public boolean b(int i2) {
        return (i2 == 400 || i2 == 500) ? false : true;
    }

    @NonNull
    public sg c() {
        return new si().a(h());
    }

    public void d() {
        u();
        e();
    }

    public void e() {
        Uri.Builder buildUpon = Uri.parse(r()).buildUpon();
        a(buildUpon);
        a(buildUpon.build().toString());
    }

    public void f() {
    }

    public void g() {
        this.k = Boolean.FALSE;
    }

    public String h() {
        return this.a;
    }

    public int i() {
        return this.b;
    }

    public byte[] j() {
        return this.d;
    }

    public int k() {
        return this.e;
    }

    public byte[] l() {
        return this.f;
    }

    public Map<String, List<String>> m() {
        return this.g;
    }

    @NonNull
    public String n() {
        return getClass().getName();
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return k() == 400;
    }

    public int q() {
        return this.h;
    }

    public String r() {
        return this.j.get(q());
    }

    public List<String> s() {
        return this.j;
    }

    public boolean t() {
        return !v() && q() + 1 < this.j.size();
    }

    @VisibleForTesting
    public void u() {
        this.h++;
    }

    public boolean v() {
        return this.l;
    }

    public void w() {
        this.l = true;
    }

    public boolean x() {
        Boolean bool = this.k;
        return bool != null && bool.booleanValue();
    }

    public boolean y() {
        return this.k != null;
    }

    @Nullable
    public Long z() {
        return this.m;
    }

    public void a(byte[] bArr) {
        this.b = 2;
        this.d = bArr;
    }

    public void a(int i2) {
        this.e = i2;
    }

    public void a(Map<String, List<String>> map) {
        this.g = map;
    }

    public void a(List<String> list) {
        this.j = list;
    }

    public void a(boolean z) {
        this.k = Boolean.valueOf(z);
    }

    public void a(@Nullable Long l2) {
        this.m = l2;
    }

    public void a(@Nullable Integer num) {
        this.n = num;
    }

    public void a(@NonNull String str, @NonNull String... strArr) {
        this.c.put(str, Arrays.asList(strArr));
    }

    public void a(long j2) {
        a(Long.valueOf(j2));
        a(Integer.valueOf(abu.a(TimeUnit.MILLISECONDS.toSeconds(j2))));
    }
}
