package com.yandex.mobile.ads.nativeads;
public final class NativeAdMedia {
    private final float a;

    public NativeAdMedia(float f) {
        this.a = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && NativeAdMedia.class == obj.getClass() && Float.compare(((NativeAdMedia) obj).a, this.a) == 0;
    }

    public final float getAspectRatio() {
        return this.a;
    }

    public final int hashCode() {
        float f = this.a;
        if (f != 0.0f) {
            return Float.floatToIntBits(f);
        }
        return 0;
    }
}
