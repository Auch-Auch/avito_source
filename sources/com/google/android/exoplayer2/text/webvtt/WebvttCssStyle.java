package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public final class WebvttCssStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    public String a = "";
    public String b = "";
    public Set<String> c = Collections.emptySet();
    public String d = "";
    @Nullable
    public String e = null;
    @ColorInt
    public int f;
    public boolean g = false;
    public int h;
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public float o;
    public int p = -1;
    public boolean q = false;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public static int a(int i2, String str, @Nullable String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public int getBackgroundColor() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean getCombineUpright() {
        return this.q;
    }

    public int getFontColor() {
        if (this.g) {
            return this.f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String getFontFamily() {
        return this.e;
    }

    public float getFontSize() {
        return this.o;
    }

    public int getFontSizeUnit() {
        return this.n;
    }

    public int getRubyPosition() {
        return this.p;
    }

    public int getSpecificityScore(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int a3 = a(a(a(0, this.a, str, 1073741824), this.b, str2, 2), this.d, str3, 4);
        if (a3 == -1 || !set.containsAll(this.c)) {
            return 0;
        }
        return (this.c.size() * 4) + a3;
    }

    public int getStyle() {
        int i2 = this.l;
        if (i2 == -1 && this.m == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.m == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public boolean hasBackgroundColor() {
        return this.i;
    }

    public boolean hasFontColor() {
        return this.g;
    }

    public boolean isLinethrough() {
        return this.j == 1;
    }

    public boolean isUnderline() {
        return this.k == 1;
    }

    public WebvttCssStyle setBackgroundColor(int i2) {
        this.h = i2;
        this.i = true;
        return this;
    }

    public WebvttCssStyle setBold(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setCombineUpright(boolean z) {
        this.q = z;
        return this;
    }

    public WebvttCssStyle setFontColor(int i2) {
        this.f = i2;
        this.g = true;
        return this;
    }

    public WebvttCssStyle setFontFamily(@Nullable String str) {
        this.e = Util.toLowerInvariant(str);
        return this;
    }

    public WebvttCssStyle setFontSize(float f2) {
        this.o = f2;
        return this;
    }

    public WebvttCssStyle setFontSizeUnit(short s) {
        this.n = s;
        return this;
    }

    public WebvttCssStyle setItalic(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setLinethrough(boolean z) {
        this.j = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setRubyPosition(int i2) {
        this.p = i2;
        return this;
    }

    public void setTargetClasses(String[] strArr) {
        this.c = new HashSet(Arrays.asList(strArr));
    }

    public void setTargetId(String str) {
        this.a = str;
    }

    public void setTargetTagName(String str) {
        this.b = str;
    }

    public void setTargetVoice(String str) {
        this.d = str;
    }

    public WebvttCssStyle setUnderline(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }
}
