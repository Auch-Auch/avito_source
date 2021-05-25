package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.b;
public final class fo {
    @Nullable
    private am a;
    @NonNull
    private final b b;
    @Nullable
    private AdRequest c;
    @Nullable
    private ag d;
    @Nullable
    private af e;
    @Nullable
    private String f;
    @Nullable
    private String g;
    @Nullable
    private String h;
    @Nullable
    private String i;
    @Nullable
    private String j;
    @Nullable
    private gq k;
    @Nullable
    private gq l;
    @Nullable
    private String[] m;
    @Nullable
    private int n;
    @Nullable
    private String[] o;
    @Nullable
    private String p;
    @Nullable
    private String q;
    private boolean r;
    private boolean s;
    private int t = 1;
    private int u = hr.b;

    public fo(@NonNull b bVar) {
        this.b = bVar;
    }

    @NonNull
    public final b a() {
        return this.b;
    }

    @Nullable
    public final am b() {
        return this.a;
    }

    @Nullable
    public final AdRequest c() {
        return this.c;
    }

    @Nullable
    public final synchronized String d() {
        return this.f;
    }

    @Nullable
    public final String e() {
        return this.g;
    }

    @Nullable
    public final synchronized String f() {
        return this.h;
    }

    @Nullable
    public final synchronized String g() {
        return this.i;
    }

    @Nullable
    public final String h() {
        return this.j;
    }

    @Nullable
    public final gq i() {
        return this.k;
    }

    @Nullable
    public final gq j() {
        return this.l;
    }

    public final boolean k() {
        return this.r;
    }

    public final int l() {
        return this.t;
    }

    public final int m() {
        return this.u;
    }

    public final boolean n() {
        return !TextUtils.isEmpty(this.g);
    }

    @Nullable
    public final String[] o() {
        return this.m;
    }

    @Nullable
    public final af p() {
        return this.e;
    }

    @Nullable
    public final ag q() {
        return this.d;
    }

    @Nullable
    public final int r() {
        return this.n;
    }

    @Nullable
    public final String[] s() {
        return this.o;
    }

    @Nullable
    public final String t() {
        return this.p;
    }

    public final boolean u() {
        return this.s;
    }

    @Nullable
    public final String v() {
        return this.q;
    }

    public final void a(@Nullable am amVar) {
        if (amVar == null) {
            throw new IllegalArgumentException("Ad size can't be null or empty.");
        } else if (this.a == null) {
            this.a = amVar;
        } else {
            throw new IllegalArgumentException("Ad size can't be set twice.");
        }
    }

    public final synchronized void b(@Nullable gq gqVar) {
        this.l = gqVar;
    }

    public final synchronized void c(@Nullable String str) {
        this.h = str;
    }

    public final synchronized void d(@Nullable String str) {
        this.i = str;
    }

    public final void e(@Nullable String str) {
        this.p = str;
    }

    public final void f(@Nullable String str) {
        this.q = str;
    }

    public final void b(@NonNull String[] strArr) {
        this.o = strArr;
    }

    public final void b(boolean z) {
        this.s = z;
    }

    public final void a(@Nullable AdRequest adRequest) {
        this.c = adRequest;
    }

    public final void b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Block ID can't be null or empty.");
        } else if (TextUtils.isEmpty(this.g)) {
            this.g = str;
        } else {
            throw new IllegalArgumentException("Block ID can't be set twice.");
        }
    }

    public final synchronized void a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
        }
    }

    public final synchronized void a(@Nullable gq gqVar) {
        this.k = gqVar;
    }

    public final void a(boolean z) {
        this.r = z;
    }

    public final void a(@NonNull String[] strArr) {
        this.m = strArr;
    }

    public final void a(@NonNull af afVar) {
        this.e = afVar;
    }

    public final void a(@NonNull ag agVar) {
        this.d = agVar;
    }

    public final void a(@NonNull int i2) {
        this.n = i2;
    }
}
