package com.yandex.mobile.ads.impl;
public final class pk {
    private final int a;

    public pk(int i) {
        this.a = i;
    }

    public final int a(int i) {
        return i > 0 ? Math.min(i, this.a) : this.a;
    }
}
