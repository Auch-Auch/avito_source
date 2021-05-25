package com.yandex.mobile.ads.nativeads;
public final class ao {
    private static final Object a = new Object();
    private static volatile ao b;
    private boolean c = true;

    private ao() {
    }

    public static ao a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new ao();
                }
            }
        }
        return b;
    }

    public final boolean b() {
        return this.c;
    }
}
