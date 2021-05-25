package com.warkiz.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
public class Builder {
    public Drawable A = null;
    public boolean B;
    public int C = Color.parseColor("#FF4081");
    public int D = 0;
    public String[] E = null;
    public Typeface F = Typeface.DEFAULT;
    public ColorStateList G = null;
    public int H = 0;
    public int I = 0;
    public int J = Color.parseColor("#FF4081");
    public int K = 0;
    public Drawable L = null;
    public boolean M = false;
    public boolean N = false;
    public ColorStateList O = null;
    public final Context a;
    public float b = 100.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public boolean i = false;
    public boolean j = false;
    public int k = 2;
    public int l = Color.parseColor("#FF4081");
    public int m = Color.parseColor("#FFFFFF");
    public int n = 0;
    public View o = null;
    public View p = null;
    public int q = 0;
    public int r = Color.parseColor("#D7D7D7");
    public int s = 0;
    public int t = Color.parseColor("#FF4081");
    public boolean u = false;
    public int v = Color.parseColor("#FF4081");
    public boolean w = false;
    public int x = 0;
    public int y = Color.parseColor("#FF4081");
    public ColorStateList z = null;

    public Builder(Context context) {
        this.a = context;
        this.n = SizeUtils.sp2px(context, 14.0f);
        this.q = SizeUtils.dp2px(context, 2.0f);
        this.s = SizeUtils.dp2px(context, 2.0f);
        this.K = SizeUtils.dp2px(context, 10.0f);
        this.D = SizeUtils.sp2px(context, 13.0f);
        this.x = SizeUtils.dp2px(context, 14.0f);
    }

    public IndicatorSeekBar build() {
        return new IndicatorSeekBar(this);
    }

    public Builder clearPadding(boolean z2) {
        this.j = z2;
        return this;
    }

    public Builder indicatorColor(@ColorInt int i2) {
        this.l = i2;
        return this;
    }

    public Builder indicatorContentView(@NonNull View view) {
        this.o = view;
        return this;
    }

    public Builder indicatorContentViewLayoutId(@LayoutRes int i2) {
        this.o = View.inflate(this.a, i2, null);
        return this;
    }

    public Builder indicatorTextColor(@ColorInt int i2) {
        this.m = i2;
        return this;
    }

    public Builder indicatorTextSize(int i2) {
        this.n = SizeUtils.sp2px(this.a, (float) i2);
        return this;
    }

    public Builder indicatorTopContentView(View view) {
        this.p = view;
        return this;
    }

    public Builder indicatorTopContentViewLayoutId(@LayoutRes int i2) {
        this.p = View.inflate(this.a, i2, null);
        return this;
    }

    public Builder max(float f2) {
        this.b = f2;
        return this;
    }

    public Builder min(float f2) {
        this.c = f2;
        return this;
    }

    public Builder onlyThumbDraggable(boolean z2) {
        this.i = z2;
        return this;
    }

    public Builder progress(float f2) {
        this.d = f2;
        return this;
    }

    public Builder progressValueFloat(boolean z2) {
        this.e = z2;
        return this;
    }

    public Builder r2l(boolean z2) {
        this.g = z2;
        return this;
    }

    public Builder seekSmoothly(boolean z2) {
        this.f = z2;
        return this;
    }

    public Builder showIndicatorType(int i2) {
        this.k = i2;
        return this;
    }

    public Builder showThumbText(boolean z2) {
        this.w = z2;
        return this;
    }

    public Builder showTickMarksType(int i2) {
        this.I = i2;
        return this;
    }

    public Builder showTickTexts(boolean z2) {
        this.B = z2;
        return this;
    }

    public Builder thumbColor(@ColorInt int i2) {
        this.y = i2;
        return this;
    }

    public Builder thumbColorStateList(@NonNull ColorStateList colorStateList) {
        this.z = colorStateList;
        return this;
    }

    public Builder thumbDrawable(@NonNull Drawable drawable) {
        this.A = drawable;
        return this;
    }

    public Builder thumbSize(int i2) {
        this.x = SizeUtils.dp2px(this.a, (float) i2);
        return this;
    }

    public Builder thumbTextColor(@ColorInt int i2) {
        this.v = i2;
        return this;
    }

    public Builder tickCount(int i2) {
        this.H = i2;
        return this;
    }

    public Builder tickMarksColor(@ColorInt int i2) {
        this.J = i2;
        return this;
    }

    public Builder tickMarksDrawable(@NonNull Drawable drawable) {
        this.L = drawable;
        return this;
    }

    public Builder tickMarksEndsHide(boolean z2) {
        this.M = z2;
        return this;
    }

    public Builder tickMarksSize(int i2) {
        this.K = SizeUtils.dp2px(this.a, (float) i2);
        return this;
    }

    public Builder tickMarksSweptHide(boolean z2) {
        this.N = z2;
        return this;
    }

    public Builder tickTextsArray(String[] strArr) {
        this.E = strArr;
        return this;
    }

    public Builder tickTextsColor(@ColorInt int i2) {
        this.C = i2;
        return this;
    }

    public Builder tickTextsColorStateList(@NonNull ColorStateList colorStateList) {
        this.G = colorStateList;
        return this;
    }

    public Builder tickTextsSize(int i2) {
        this.D = SizeUtils.sp2px(this.a, (float) i2);
        return this;
    }

    public Builder tickTextsTypeFace(Typeface typeface) {
        this.F = typeface;
        return this;
    }

    public Builder trackBackgroundColor(@ColorInt int i2) {
        this.r = i2;
        return this;
    }

    public Builder trackBackgroundSize(int i2) {
        this.q = SizeUtils.dp2px(this.a, (float) i2);
        return this;
    }

    public Builder trackProgressColor(@ColorInt int i2) {
        this.t = i2;
        return this;
    }

    public Builder trackProgressSize(int i2) {
        this.s = SizeUtils.dp2px(this.a, (float) i2);
        return this;
    }

    public Builder trackRoundedCorners(boolean z2) {
        this.u = z2;
        return this;
    }

    public Builder userSeekable(boolean z2) {
        this.h = z2;
        return this;
    }

    public Builder thumbDrawable(@NonNull StateListDrawable stateListDrawable) {
        this.A = stateListDrawable;
        return this;
    }

    public Builder tickMarksColor(@NonNull ColorStateList colorStateList) {
        this.O = colorStateList;
        return this;
    }

    public Builder tickMarksDrawable(@NonNull StateListDrawable stateListDrawable) {
        this.L = stateListDrawable;
        return this;
    }

    public Builder tickTextsArray(@ArrayRes int i2) {
        this.E = this.a.getResources().getStringArray(i2);
        return this;
    }
}
