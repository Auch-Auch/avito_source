package com.yandex.mobile.ads.nativeads.template;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdType;
public final class e {
    private final NativeAdType a;
    private final String b;
    private final NativeAdImage c;
    private final Float d;
    private final String e;
    private final String f;

    public e(@NonNull NativeAdAssets nativeAdAssets, @NonNull NativeAdType nativeAdType) {
        this.b = nativeAdAssets.getCallToAction();
        this.c = nativeAdAssets.getImage();
        this.d = nativeAdAssets.getRating();
        this.e = nativeAdAssets.getReviewCount();
        this.f = nativeAdAssets.getWarning();
        this.a = nativeAdType;
    }

    private boolean g() {
        if (j()) {
            return NativeAdType.CONTENT == this.a || i();
        }
        return false;
    }

    private boolean h() {
        return (this.d == null && this.e == null) ? false : true;
    }

    private boolean i() {
        return !h();
    }

    private boolean j() {
        return this.b != null;
    }

    public final boolean a() {
        NativeAdImage nativeAdImage = this.c;
        if (nativeAdImage != null) {
            return "large".equals(nativeAdImage.a()) || "wide".equals(this.c.a());
        }
        return false;
    }

    public final boolean b() {
        if (j()) {
            return g() || a();
        }
        return false;
    }

    public final boolean c() {
        return j() || h();
    }

    public final boolean d() {
        return g();
    }

    public final boolean e() {
        if (!g()) {
            return a() && i();
        }
        return true;
    }

    public final boolean f() {
        return this.f != null;
    }
}
