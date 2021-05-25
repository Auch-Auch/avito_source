package com.facebook.fresco.ui.common;

import a2.b.a.a.a;
public class DimensionsInfo {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;

    public DimensionsInfo(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = str;
    }

    public int getDecodedImageHeight() {
        return this.f;
    }

    public int getDecodedImageWidth() {
        return this.e;
    }

    public int getEncodedImageHeight() {
        return this.d;
    }

    public int getEncodedImageWidth() {
        return this.c;
    }

    public String getScaleType() {
        return this.g;
    }

    public int getViewportHeight() {
        return this.b;
    }

    public int getViewportWidth() {
        return this.a;
    }

    public String toString() {
        StringBuilder L = a.L("DimensionsInfo{mViewportWidth=");
        L.append(this.a);
        L.append(", mViewportHeight=");
        L.append(this.b);
        L.append(", mEncodedImageWidth=");
        L.append(this.c);
        L.append(", mEncodedImageHeight=");
        L.append(this.d);
        L.append(", mDecodedImageWidth=");
        L.append(this.e);
        L.append(", mDecodedImageHeight=");
        L.append(this.f);
        L.append(", mScaleType='");
        L.append(this.g);
        L.append('\'');
        L.append('}');
        return L.toString();
    }
}
