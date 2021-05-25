package com.rd.draw.data;

import androidx.annotation.NonNull;
import com.rd.animation.type.AnimationType;
public class Indicator {
    public static final int COUNT_NONE = -1;
    public static final int DEFAULT_COUNT = 3;
    public static final int DEFAULT_PADDING_DP = 8;
    public static final int DEFAULT_RADIUS_DP = 6;
    public static final int IDLE_ANIMATION_DURATION = 250;
    public static final int MIN_COUNT = 1;
    public RtlMode A;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public int t = 3;
    public int u;
    public int v;
    public int w;
    public int x = -1;
    public Orientation y;
    public AnimationType z;

    public long getAnimationDuration() {
        return this.s;
    }

    @NonNull
    public AnimationType getAnimationType() {
        if (this.z == null) {
            this.z = AnimationType.NONE;
        }
        return this.z;
    }

    public int getCount() {
        return this.t;
    }

    public int getHeight() {
        return this.a;
    }

    public long getIdleDuration() {
        return this.r;
    }

    public int getLastSelectedPosition() {
        return this.w;
    }

    @NonNull
    public Orientation getOrientation() {
        if (this.y == null) {
            this.y = Orientation.HORIZONTAL;
        }
        return this.y;
    }

    public int getPadding() {
        return this.d;
    }

    public int getPaddingBottom() {
        return this.h;
    }

    public int getPaddingLeft() {
        return this.e;
    }

    public int getPaddingRight() {
        return this.g;
    }

    public int getPaddingTop() {
        return this.f;
    }

    public int getRadius() {
        return this.c;
    }

    @NonNull
    public RtlMode getRtlMode() {
        if (this.A == null) {
            this.A = RtlMode.Off;
        }
        return this.A;
    }

    public float getScaleFactor() {
        return this.j;
    }

    public int getSelectedColor() {
        return this.l;
    }

    public int getSelectedPosition() {
        return this.u;
    }

    public int getSelectingPosition() {
        return this.v;
    }

    public int getStroke() {
        return this.i;
    }

    public int getUnselectedColor() {
        return this.k;
    }

    public int getViewPagerId() {
        return this.x;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isAutoVisibility() {
        return this.n;
    }

    public boolean isDynamicCount() {
        return this.o;
    }

    public boolean isFadeOnIdle() {
        return this.p;
    }

    public boolean isIdle() {
        return this.q;
    }

    public boolean isInteractiveAnimation() {
        return this.m;
    }

    public void setAnimationDuration(long j2) {
        this.s = j2;
    }

    public void setAnimationType(AnimationType animationType) {
        this.z = animationType;
    }

    public void setAutoVisibility(boolean z2) {
        this.n = z2;
    }

    public void setCount(int i2) {
        this.t = i2;
    }

    public void setDynamicCount(boolean z2) {
        this.o = z2;
    }

    public void setFadeOnIdle(boolean z2) {
        this.p = z2;
    }

    public void setHeight(int i2) {
        this.a = i2;
    }

    public void setIdle(boolean z2) {
        this.q = z2;
    }

    public void setIdleDuration(long j2) {
        this.r = j2;
    }

    public void setInteractiveAnimation(boolean z2) {
        this.m = z2;
    }

    public void setLastSelectedPosition(int i2) {
        this.w = i2;
    }

    public void setOrientation(Orientation orientation) {
        this.y = orientation;
    }

    public void setPadding(int i2) {
        this.d = i2;
    }

    public void setPaddingBottom(int i2) {
        this.h = i2;
    }

    public void setPaddingLeft(int i2) {
        this.e = i2;
    }

    public void setPaddingRight(int i2) {
        this.g = i2;
    }

    public void setPaddingTop(int i2) {
        this.f = i2;
    }

    public void setRadius(int i2) {
        this.c = i2;
    }

    public void setRtlMode(RtlMode rtlMode) {
        this.A = rtlMode;
    }

    public void setScaleFactor(float f2) {
        this.j = f2;
    }

    public void setSelectedColor(int i2) {
        this.l = i2;
    }

    public void setSelectedPosition(int i2) {
        this.u = i2;
    }

    public void setSelectingPosition(int i2) {
        this.v = i2;
    }

    public void setStroke(int i2) {
        this.i = i2;
    }

    public void setUnselectedColor(int i2) {
        this.k = i2;
    }

    public void setViewPagerId(int i2) {
        this.x = i2;
    }

    public void setWidth(int i2) {
        this.b = i2;
    }
}
