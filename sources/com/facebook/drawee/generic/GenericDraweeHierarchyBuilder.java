package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
    public static final int DEFAULT_FADE_DURATION = 300;
    public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
    public Resources a;
    public int b;
    public float c;
    @Nullable
    public Drawable d;
    @Nullable
    public ScalingUtils.ScaleType e;
    @Nullable
    public Drawable f;
    @Nullable
    public ScalingUtils.ScaleType g;
    @Nullable
    public Drawable h;
    @Nullable
    public ScalingUtils.ScaleType i;
    @Nullable
    public Drawable j;
    @Nullable
    public ScalingUtils.ScaleType k;
    @Nullable
    public ScalingUtils.ScaleType l;
    @Nullable
    public PointF m;
    @Nullable
    public ColorFilter n;
    @Nullable
    public Drawable o;
    @Nullable
    public List<Drawable> p;
    @Nullable
    public Drawable q;
    @Nullable
    public RoundingParams r;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.a = resources;
        a();
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources);
    }

    public final void a() {
        this.b = 300;
        this.c = 0.0f;
        this.d = null;
        ScalingUtils.ScaleType scaleType = DEFAULT_SCALE_TYPE;
        this.e = scaleType;
        this.f = null;
        this.g = scaleType;
        this.h = null;
        this.i = scaleType;
        this.j = null;
        this.k = scaleType;
        this.l = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    public GenericDraweeHierarchy build() {
        List<Drawable> list = this.p;
        if (list != null) {
            for (Drawable drawable : list) {
                Preconditions.checkNotNull(drawable);
            }
        }
        return new GenericDraweeHierarchy(this);
    }

    @Nullable
    public ColorFilter getActualImageColorFilter() {
        return this.n;
    }

    @Nullable
    public PointF getActualImageFocusPoint() {
        return this.m;
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        return this.l;
    }

    @Nullable
    public Drawable getBackground() {
        return this.o;
    }

    public float getDesiredAspectRatio() {
        return this.c;
    }

    public int getFadeDuration() {
        return this.b;
    }

    @Nullable
    public Drawable getFailureImage() {
        return this.h;
    }

    @Nullable
    public ScalingUtils.ScaleType getFailureImageScaleType() {
        return this.i;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.p;
    }

    @Nullable
    public Drawable getPlaceholderImage() {
        return this.d;
    }

    @Nullable
    public ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        return this.e;
    }

    @Nullable
    public Drawable getPressedStateOverlay() {
        return this.q;
    }

    @Nullable
    public Drawable getProgressBarImage() {
        return this.j;
    }

    @Nullable
    public ScalingUtils.ScaleType getProgressBarImageScaleType() {
        return this.k;
    }

    public Resources getResources() {
        return this.a;
    }

    @Nullable
    public Drawable getRetryImage() {
        return this.f;
    }

    @Nullable
    public ScalingUtils.ScaleType getRetryImageScaleType() {
        return this.g;
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        return this.r;
    }

    public GenericDraweeHierarchyBuilder reset() {
        a();
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageColorFilter(@Nullable ColorFilter colorFilter) {
        this.n = colorFilter;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageFocusPoint(@Nullable PointF pointF) {
        this.m = pointF;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        this.l = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setBackground(@Nullable Drawable drawable) {
        this.o = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float f2) {
        this.c = f2;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFadeDuration(int i2) {
        this.b = i2;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(@Nullable Drawable drawable) {
        this.h = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        this.i = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlay(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.p = null;
        } else {
            this.p = Arrays.asList(drawable);
        }
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlays(@Nullable List<Drawable> list) {
        this.p = list;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(@Nullable Drawable drawable) {
        this.d = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        this.e = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPressedStateOverlay(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.q = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.q = stateListDrawable;
        }
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(@Nullable Drawable drawable) {
        this.j = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        this.k = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(@Nullable Drawable drawable) {
        this.f = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        this.g = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(@Nullable RoundingParams roundingParams) {
        this.r = roundingParams;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i2) {
        this.h = this.a.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i2) {
        this.d = this.a.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i2) {
        this.j = this.a.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i2) {
        this.f = this.a.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.h = drawable;
        this.i = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.d = drawable;
        this.e = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.j = drawable;
        this.k = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.f = drawable;
        this.g = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        this.h = this.a.getDrawable(i2);
        this.i = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        this.d = this.a.getDrawable(i2);
        this.e = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        this.j = this.a.getDrawable(i2);
        this.k = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        this.f = this.a.getDrawable(i2);
        this.g = scaleType;
        return this;
    }
}
