package com.yandex.mobile.ads.nativeads;

import android.graphics.Bitmap;
public final class NativeAdImage {
    private Bitmap a;
    private String b;
    private int c;
    private int d;

    public final void a(Bitmap bitmap) {
        this.a = bitmap;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NativeAdImage.class != obj.getClass()) {
            return false;
        }
        NativeAdImage nativeAdImage = (NativeAdImage) obj;
        if (this.c != nativeAdImage.c || this.d != nativeAdImage.d) {
            return false;
        }
        Bitmap bitmap = this.a;
        if (bitmap == null ? nativeAdImage.a != null : !bitmap.equals(nativeAdImage.a)) {
            return false;
        }
        String str = this.b;
        String str2 = nativeAdImage.b;
        return str == null ? str2 == null : str.equals(str2);
    }

    public final Bitmap getBitmap() {
        return this.a;
    }

    public final int getHeight() {
        return this.c;
    }

    public final int getWidth() {
        return this.d;
    }

    public final int hashCode() {
        Bitmap bitmap = this.a;
        int i = 0;
        int hashCode = (bitmap != null ? bitmap.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((hashCode + i) * 31) + this.c) * 31) + this.d;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
