package com.yandex.mobile.ads.impl;
public final class aa {
    private final float a;

    public aa(float f) {
        this.a = f == 0.0f ? 1.7777778f : f;
    }

    public final int a(int i) {
        return Math.round(((float) i) * this.a);
    }

    public final int b(int i) {
        return Math.round(((float) i) / this.a);
    }
}
