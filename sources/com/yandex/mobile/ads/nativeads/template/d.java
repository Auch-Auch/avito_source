package com.yandex.mobile.ads.nativeads.template;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import com.yandex.mobile.ads.nativeads.NativeAdType;
public final class d {
    private final NativeAdImage a;
    private final NativeAdImage b;
    private final NativeAdImage c;
    private final NativeAdMedia d;
    private final NativeAdType e;

    public d(@NonNull NativeAdAssets nativeAdAssets, @NonNull NativeAdType nativeAdType) {
        this.a = nativeAdAssets.getFavicon();
        this.b = nativeAdAssets.getIcon();
        this.c = nativeAdAssets.getImage();
        this.d = nativeAdAssets.getMedia();
        this.e = nativeAdType;
    }

    public static boolean a(@NonNull NativeAdImage nativeAdImage) {
        return "large".equals(nativeAdImage.a()) || "wide".equals(nativeAdImage.a());
    }

    public static boolean b(@NonNull NativeAdImage nativeAdImage) {
        return "fill".equals(nativeAdImage.a());
    }

    private boolean g() {
        return NativeAdType.APP_INSTALL == this.e;
    }

    public final boolean c() {
        NativeAdImage nativeAdImage;
        return !f() && (nativeAdImage = this.c) != null && !a(nativeAdImage) && !g();
    }

    public final boolean d() {
        NativeAdImage nativeAdImage;
        return !f() && (nativeAdImage = this.c) != null && a(nativeAdImage);
    }

    public final boolean e() {
        NativeAdImage nativeAdImage;
        return !f() && (nativeAdImage = this.c) != null && b(nativeAdImage);
    }

    public final boolean f() {
        return this.d != null;
    }

    public final boolean b() {
        if (this.b != null) {
            return g() || !c();
        }
        return false;
    }

    public final boolean a() {
        NativeAdImage nativeAdImage;
        return !b() && this.a != null && (f() || (nativeAdImage = this.c) == null || a(nativeAdImage));
    }
}
