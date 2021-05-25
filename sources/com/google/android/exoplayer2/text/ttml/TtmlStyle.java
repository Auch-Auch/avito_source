package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class TtmlStyle {
    @Nullable
    public String a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public float k;
    @Nullable
    public String l;
    public int m = -1;
    public int n = -1;
    @Nullable
    public Layout.Alignment o;
    public int p = -1;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public TtmlStyle a(@Nullable TtmlStyle ttmlStyle) {
        int i2;
        Layout.Alignment alignment;
        String str;
        if (ttmlStyle != null) {
            if (!this.c && ttmlStyle.c) {
                this.b = ttmlStyle.b;
                this.c = true;
            }
            if (this.h == -1) {
                this.h = ttmlStyle.h;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.a == null && (str = ttmlStyle.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
            }
            if (this.n == -1) {
                this.n = ttmlStyle.n;
            }
            if (this.o == null && (alignment = ttmlStyle.o) != null) {
                this.o = alignment;
            }
            if (this.p == -1) {
                this.p = ttmlStyle.p;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
                this.k = ttmlStyle.k;
            }
            if (!this.e && ttmlStyle.e) {
                this.d = ttmlStyle.d;
                this.e = true;
            }
            if (this.m == -1 && (i2 = ttmlStyle.m) != -1) {
                this.m = i2;
            }
        }
        return this;
    }

    public int b() {
        int i2 = this.h;
        if (i2 == -1 && this.i == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.i == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }
}
