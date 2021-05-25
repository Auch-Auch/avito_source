package com.yandex.mobile.ads.impl;
public final class rt implements sc {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public rt() {
        this(2500, 1, 1.0f);
    }

    @Override // com.yandex.mobile.ads.impl.sc
    public final int a() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.impl.sc
    public final int b() {
        return this.b;
    }

    public rt(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.yandex.mobile.ads.impl.sc
    public final void a(sl slVar) throws sl {
        boolean z = true;
        int i = this.b + 1;
        this.b = i;
        int i2 = this.a;
        this.a = (int) ((((float) i2) * this.d) + ((float) i2));
        if (i > this.c) {
            z = false;
        }
        if (!z) {
            throw slVar;
        }
    }
}
