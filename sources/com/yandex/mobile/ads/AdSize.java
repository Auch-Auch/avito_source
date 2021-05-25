package com.yandex.mobile.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.am;
public final class AdSize extends c {
    public static final AdSize BANNER_240x400 = new AdSize(240, 400);
    public static final AdSize BANNER_300x250 = new AdSize(300, 250);
    public static final AdSize BANNER_300x300 = new AdSize(300, 300);
    public static final AdSize BANNER_320x100 = new AdSize(320, 100);
    public static final AdSize BANNER_320x50 = new AdSize(320, 50);
    public static final AdSize BANNER_400x240 = new AdSize(400, 240);
    public static final AdSize BANNER_728x90 = new AdSize(728, 90);
    public static final int FULL_HEIGHT = -2;
    public static final AdSize FULL_SCREEN = new AdSize(-1, -2);
    public static final int FULL_WIDTH = -1;
    private static final long serialVersionUID = 2680092174282737642L;

    public AdSize(int i, int i2) {
        this(i, i2, am.a.FIXED);
    }

    public static AdSize flexibleSize() {
        return new AdSize(-1, 0, am.a.SCREEN);
    }

    public static AdSize stickySize(int i) {
        return new AdSize(i, 0, am.a.STICKY);
    }

    @Override // com.yandex.mobile.ads.c
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // com.yandex.mobile.ads.c
    public final int getHeightInPixels(@NonNull Context context) {
        return super.getHeightInPixels(context);
    }

    @Override // com.yandex.mobile.ads.c
    public final int getWidth() {
        return super.getWidth();
    }

    @Override // com.yandex.mobile.ads.c
    public final int getWidthInPixels(@NonNull Context context) {
        return super.getWidthInPixels(context);
    }

    private AdSize(int i, int i2, @NonNull am.a aVar) {
        super(i, i2, aVar);
    }

    public static AdSize flexibleSize(int i) {
        return new AdSize(i, 0, am.a.FLEXIBLE);
    }

    @Override // com.yandex.mobile.ads.c
    public final int getHeight(@NonNull Context context) {
        return super.getHeight(context);
    }

    @Override // com.yandex.mobile.ads.c
    public final int getWidth(@NonNull Context context) {
        return super.getWidth(context);
    }

    public static AdSize flexibleSize(int i, int i2) {
        return new AdSize(i, i2, am.a.FLEXIBLE);
    }
}
