package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
public class jg {
    private boolean a;
    @NonNull
    private Set<Integer> b;
    private int c;
    private int d;

    public jg() {
        this(false, 0, 0, (Set<Integer>) new HashSet());
    }

    public void a() {
        this.b = new HashSet();
        this.d = 0;
    }

    public boolean b() {
        return this.a;
    }

    @NonNull
    public Set<Integer> c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public jg(boolean z, int i, int i2, @NonNull int[] iArr) {
        this(z, i, i2, dl.a(iArr));
    }

    public void b(int i) {
        this.b.add(Integer.valueOf(i));
        this.d++;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public jg(boolean z, int i, int i2, @NonNull Set<Integer> set) {
        this.a = z;
        this.b = set;
        this.c = i;
        this.d = i2;
    }

    public void a(int i) {
        this.c = i;
        this.d = 0;
    }
}
