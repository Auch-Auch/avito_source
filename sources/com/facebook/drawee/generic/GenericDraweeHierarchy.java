package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public final Drawable a;
    public final Resources b;
    @Nullable
    public RoundingParams c;
    public final RootDrawable d;
    public final FadeDrawable e;
    private final ForwardingDrawable mActualImageWrapper;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.a = colorDrawable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.b = genericDraweeHierarchyBuilder.getResources();
        this.c = genericDraweeHierarchyBuilder.getRoundingParams();
        ForwardingDrawable forwardingDrawable = new ForwardingDrawable(colorDrawable);
        this.mActualImageWrapper = forwardingDrawable;
        int i2 = 1;
        int size = genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 1;
        int i3 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[(i3 + 6)];
        drawableArr[0] = a(genericDraweeHierarchyBuilder.getBackground(), null);
        drawableArr[1] = a(genericDraweeHierarchyBuilder.getPlaceholderImage(), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        ScalingUtils.ScaleType actualImageScaleType = genericDraweeHierarchyBuilder.getActualImageScaleType();
        PointF actualImageFocusPoint = genericDraweeHierarchyBuilder.getActualImageFocusPoint();
        forwardingDrawable.setColorFilter(genericDraweeHierarchyBuilder.getActualImageColorFilter());
        drawableArr[2] = WrappingUtils.e(forwardingDrawable, actualImageScaleType, actualImageFocusPoint);
        drawableArr[3] = a(genericDraweeHierarchyBuilder.getProgressBarImage(), genericDraweeHierarchyBuilder.getProgressBarImageScaleType());
        drawableArr[4] = a(genericDraweeHierarchyBuilder.getRetryImage(), genericDraweeHierarchyBuilder.getRetryImageScaleType());
        drawableArr[5] = a(genericDraweeHierarchyBuilder.getFailureImage(), genericDraweeHierarchyBuilder.getFailureImageScaleType());
        if (i3 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                for (Drawable drawable : genericDraweeHierarchyBuilder.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
                i2 = i;
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i2 + 6] = a(genericDraweeHierarchyBuilder.getPressedStateOverlay(), null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.e = fadeDrawable;
        fadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.d(fadeDrawable, this.c));
        this.d = rootDrawable;
        rootDrawable.mutate();
        g();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Nullable
    public final Drawable a(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return WrappingUtils.e(WrappingUtils.c(drawable, this.c, this.b), scaleType, null);
    }

    public final void b(int i) {
        if (i >= 0) {
            this.e.fadeInLayer(i);
        }
    }

    public final void c() {
        d(1);
        d(2);
        d(3);
        d(4);
        d(5);
    }

    public final void d(int i) {
        if (i >= 0) {
            this.e.fadeOutLayer(i);
        }
    }

    public final DrawableParent e(int i) {
        DrawableParent drawableParentForIndex = this.e.getDrawableParentForIndex(i);
        if (drawableParentForIndex.getDrawable() instanceof MatrixDrawable) {
            drawableParentForIndex = (MatrixDrawable) drawableParentForIndex.getDrawable();
        }
        return drawableParentForIndex.getDrawable() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParentForIndex.getDrawable() : drawableParentForIndex;
    }

    public final ScaleTypeDrawable f(int i) {
        DrawableParent e2 = e(i);
        if (e2 instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) e2;
        }
        Drawable e3 = WrappingUtils.e(e2.setDrawable(WrappingUtils.a), ScalingUtils.ScaleType.FIT_XY, null);
        e2.setDrawable(e3);
        Preconditions.checkNotNull(e3, "Parent has no child drawable!");
        return (ScaleTypeDrawable) e3;
    }

    public final void g() {
        FadeDrawable fadeDrawable = this.e;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            this.e.fadeInAllLayers();
            c();
            b(1);
            this.e.finishTransitionImmediately();
            this.e.endBatchMode();
        }
    }

    public void getActualImageBounds(RectF rectF) {
        this.mActualImageWrapper.getTransformedBounds(rectF);
    }

    @Nullable
    public PointF getActualImageFocusPoint() {
        if (!(e(2) instanceof ScaleTypeDrawable)) {
            return null;
        }
        return f(2).getFocusPoint();
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        if (!(e(2) instanceof ScaleTypeDrawable)) {
            return null;
        }
        return f(2).getScaleType();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        return this.d.getBounds();
    }

    public int getFadeDuration() {
        return this.e.getTransitionDuration();
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        return this.c;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable getTopLevelDrawable() {
        return this.d;
    }

    public final void h(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.e.setDrawable(i, null);
            return;
        }
        e(i).setDrawable(WrappingUtils.c(drawable, this.c, this.b));
    }

    @VisibleForTesting
    public boolean hasImage() {
        return this.mActualImageWrapper.getDrawable() != this.a;
    }

    public boolean hasPlaceholderImage() {
        return this.e.getDrawable(1) != null;
    }

    public final void i(float f) {
        Drawable drawable = this.e.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                d(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                b(3);
            }
            drawable.setLevel(Math.round(f * 10000.0f));
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        this.mActualImageWrapper.setDrawable(this.a);
        g();
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.mActualImageWrapper.setColorFilter(colorFilter);
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        f(2).setFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Preconditions.checkNotNull(scaleType);
        f(2).setScaleType(scaleType);
    }

    public void setBackgroundImage(@Nullable Drawable drawable) {
        h(0, drawable);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@Nullable Drawable drawable) {
        this.d.setControllerOverlay(drawable);
    }

    public void setFadeDuration(int i) {
        this.e.setTransitionDuration(i);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(Throwable th) {
        this.e.beginBatchMode();
        c();
        if (this.e.getDrawable(5) != null) {
            b(5);
        } else {
            b(1);
        }
        this.e.endBatchMode();
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        h(5, drawable);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(Drawable drawable, float f, boolean z) {
        Drawable c2 = WrappingUtils.c(drawable, this.c, this.b);
        c2.mutate();
        this.mActualImageWrapper.setDrawable(c2);
        this.e.beginBatchMode();
        c();
        b(2);
        i(f);
        if (z) {
            this.e.finishTransitionImmediately();
        }
        this.e.endBatchMode();
    }

    public void setOnFadeFinishedListener(FadeDrawable.OnFadeFinishedListener onFadeFinishedListener) {
        this.e.setOnFadeFinishedListener(onFadeFinishedListener);
    }

    public void setOverlayImage(int i, @Nullable Drawable drawable) {
        Preconditions.checkArgument(i >= 0 && i + 6 < this.e.getNumberOfLayers(), "The given index does not correspond to an overlay image.");
        h(i + 6, drawable);
    }

    public void setPlaceholderImage(@Nullable Drawable drawable) {
        h(1, drawable);
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        f(1).setFocusPoint(pointF);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float f, boolean z) {
        if (this.e.getDrawable(3) != null) {
            this.e.beginBatchMode();
            i(f);
            if (z) {
                this.e.finishTransitionImmediately();
            }
            this.e.endBatchMode();
        }
    }

    public void setProgressBarImage(@Nullable Drawable drawable) {
        h(3, drawable);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(Throwable th) {
        this.e.beginBatchMode();
        c();
        if (this.e.getDrawable(4) != null) {
            b(4);
        } else {
            b(1);
        }
        this.e.endBatchMode();
    }

    public void setRetryImage(@Nullable Drawable drawable) {
        h(4, drawable);
    }

    public void setRoundingParams(@Nullable RoundingParams roundingParams) {
        this.c = roundingParams;
        RootDrawable rootDrawable = this.d;
        Drawable drawable = WrappingUtils.a;
        Drawable drawable2 = rootDrawable.getDrawable();
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawable2 instanceof RoundedCornersDrawable) {
                Drawable drawable3 = WrappingUtils.a;
                rootDrawable.setDrawable(((RoundedCornersDrawable) drawable2).setCurrent(drawable3));
                drawable3.setCallback(null);
            }
        } else if (drawable2 instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable2;
            WrappingUtils.b(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
        } else {
            rootDrawable.setDrawable(WrappingUtils.d(rootDrawable.setDrawable(WrappingUtils.a), roundingParams));
        }
        for (int i = 0; i < this.e.getNumberOfLayers(); i++) {
            DrawableParent e2 = e(i);
            RoundingParams roundingParams2 = this.c;
            Resources resources = this.b;
            while (true) {
                Drawable drawable4 = e2.getDrawable();
                if (drawable4 == e2 || !(drawable4 instanceof DrawableParent)) {
                    break;
                }
                e2 = (DrawableParent) drawable4;
            }
            Drawable drawable5 = e2.getDrawable();
            if (roundingParams2 == null || roundingParams2.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
                if (drawable5 instanceof Rounded) {
                    Rounded rounded = (Rounded) drawable5;
                    rounded.setCircle(false);
                    rounded.setRadius(0.0f);
                    rounded.setBorder(0, 0.0f);
                    rounded.setPadding(0.0f);
                    rounded.setScaleDownInsideBorders(false);
                    rounded.setPaintFilterBitmap(false);
                }
            } else if (drawable5 instanceof Rounded) {
                WrappingUtils.b((Rounded) drawable5, roundingParams2);
            } else if (drawable5 != null) {
                e2.setDrawable(WrappingUtils.a);
                e2.setDrawable(WrappingUtils.a(drawable5, roundingParams2, resources));
            }
        }
    }

    public void setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        h(5, drawable);
        f(5).setScaleType(scaleType);
    }

    public void setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        h(1, drawable);
        f(1).setScaleType(scaleType);
    }

    public void setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        h(3, drawable);
        f(3).setScaleType(scaleType);
    }

    public void setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        h(4, drawable);
        f(4).setScaleType(scaleType);
    }

    public void setFailureImage(int i) {
        setFailureImage(this.b.getDrawable(i));
    }

    public void setPlaceholderImage(int i) {
        setPlaceholderImage(this.b.getDrawable(i));
    }

    public void setProgressBarImage(int i) {
        setProgressBarImage(this.b.getDrawable(i));
    }

    public void setRetryImage(int i) {
        setRetryImage(this.b.getDrawable(i));
    }

    public void setFailureImage(int i, ScalingUtils.ScaleType scaleType) {
        setFailureImage(this.b.getDrawable(i), scaleType);
    }

    public void setOverlayImage(@Nullable Drawable drawable) {
        setOverlayImage(0, drawable);
    }

    public void setPlaceholderImage(int i, ScalingUtils.ScaleType scaleType) {
        setPlaceholderImage(this.b.getDrawable(i), scaleType);
    }

    public void setProgressBarImage(int i, ScalingUtils.ScaleType scaleType) {
        setProgressBarImage(this.b.getDrawable(i), scaleType);
    }

    public void setRetryImage(int i, ScalingUtils.ScaleType scaleType) {
        setRetryImage(this.b.getDrawable(i), scaleType);
    }
}
