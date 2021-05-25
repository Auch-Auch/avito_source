package com.avito.android.krop;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.WorkerThread;
import com.avito.android.krop.KropView;
import com.avito.android.krop.OverlayView;
import com.avito.android.krop.ZoomableImageView;
import com.avito.android.krop.util.ScaleAfterRotationStyle;
import com.avito.android.krop.util.Transformation;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002]^B\u0017\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u001b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\nJ\u0015\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\"¢\u0006\u0004\b+\u0010%J\u0015\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\"¢\u0006\u0004\b-\u0010%J\u0015\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\nJ\u000f\u00104\u001a\u000203H\u0014¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000203H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010\nR\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010&\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010A\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010;R$\u0010I\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010;R\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006_"}, d2 = {"Lcom/avito/android/krop/KropView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/krop/OverlayView$MeasureListener;", "Lkotlin/Pair;", "Landroid/graphics/RectF;", "", "getCropRect", "()Lkotlin/Pair;", "", "onAttachedToWindow", "()V", "angle", "Lcom/avito/android/krop/util/ScaleAfterRotationStyle;", "scaleAnimation", "rotateBy", "(FLcom/avito/android/krop/util/ScaleAfterRotationStyle;)V", "scale", "setZoom", "(F)V", "setMaxScale", "setMinScale", "Landroid/graphics/Bitmap;", "bitmap", "setBitmap", "(Landroid/graphics/Bitmap;)V", "Lcom/avito/android/krop/util/Transformation;", "transformation", "setTransformation", "(Lcom/avito/android/krop/util/Transformation;)V", "getTransformation", "()Lcom/avito/android/krop/util/Transformation;", "getCroppedBitmap", "()Landroid/graphics/Bitmap;", "onOverlayMeasured", "", "offset", "applyOffset", "(I)V", "aspectX", "aspectY", "applyAspectRatio", "(II)V", "color", "applyOverlayColor", "shape", "applyOverlayShape", "Lcom/avito/android/krop/OverlayView;", "overlay", "applyOverlay", "(Lcom/avito/android/krop/OverlayView;)V", "invalidate", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, "d", "I", "c", AuthSource.BOOKING_ORDER, "f", "overlayShape", "e", "overlayColor", "Lcom/avito/android/krop/KropView$TransformationListener;", "k", "Lcom/avito/android/krop/KropView$TransformationListener;", "getTransformationListener", "()Lcom/avito/android/krop/KropView$TransformationListener;", "setTransformationListener", "(Lcom/avito/android/krop/KropView$TransformationListener;)V", "transformationListener", "h", "Landroid/graphics/Bitmap;", g.a, "overlayResId", "Landroid/graphics/RectF;", "viewport", "Lcom/avito/android/krop/ZoomableImageView;", "i", "Lcom/avito/android/krop/ZoomableImageView;", "imageView", "j", "Lcom/avito/android/krop/OverlayView;", "overlayView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SavedState", "TransformationListener", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class KropView extends FrameLayout implements OverlayView.MeasureListener {
    public final RectF a = new RectF();
    public int b;
    public int c = 1;
    public int d = 1;
    public int e;
    public int f;
    @IdRes
    public int g;
    public Bitmap h;
    public ZoomableImageView i;
    public OverlayView j;
    @Nullable
    public TransformationListener k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/krop/KropView$TransformationListener;", "", "Lcom/avito/android/krop/util/Transformation;", "transformation", "", "onUpdate", "(Lcom/avito/android/krop/util/Transformation;)V", "krop_release"}, k = 1, mv = {1, 4, 0})
    public interface TransformationListener {
        void onUpdate(@NotNull Transformation transformation);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KropView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        TypedArray typedArray = null;
        try {
            typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.KropView);
            Intrinsics.checkExpressionValueIsNotNull(typedArray, "arr");
            this.b = typedArray.getDimensionPixelOffset(R.styleable.KropView_krop_offset, this.b);
            this.c = typedArray.getInteger(R.styleable.KropView_krop_aspectX, this.c);
            this.d = typedArray.getInteger(R.styleable.KropView_krop_aspectY, this.d);
            this.f = typedArray.getInteger(R.styleable.KropView_krop_shape, this.f);
            this.e = typedArray.getColor(R.styleable.KropView_krop_overlayColor, this.e);
            this.g = typedArray.getResourceId(R.styleable.KropView_krop_overlay, this.g);
            typedArray.recycle();
            ZoomableImageView zoomableImageView = new ZoomableImageView(context);
            this.i = zoomableImageView;
            zoomableImageView.setImageMoveListener(new ZoomableImageView.ImageMoveListener() { // from class: com.avito.android.krop.KropView$initViews$1
                @Override // com.avito.android.krop.ZoomableImageView.ImageMoveListener
                public void onMove() {
                    KropView.TransformationListener transformationListener = KropView.this.getTransformationListener();
                    if (transformationListener != null) {
                        transformationListener.onUpdate(KropView.this.getTransformation());
                    }
                }
            });
            ZoomableImageView zoomableImageView2 = this.i;
            if (zoomableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            }
            addView(zoomableImageView2);
            applyOverlayShape(this.f);
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    private final Pair<RectF, Float> getCropRect() {
        RectF rectF = new RectF();
        Bitmap bitmap = this.h;
        if (bitmap == null) {
            return TuplesKt.to(rectF, Float.valueOf(1.0f));
        }
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        RectF imageBounds$krop_release = zoomableImageView.getImageBounds$krop_release();
        float width = ((float) bitmap.getWidth()) / imageBounds$krop_release.width();
        rectF.left = (-imageBounds$krop_release.left) * width;
        rectF.top = (-imageBounds$krop_release.top) * width;
        rectF.right = (this.a.width() + (-imageBounds$krop_release.left)) * width;
        rectF.bottom = (this.a.height() + (-imageBounds$krop_release.top)) * width;
        return TuplesKt.to(rectF, Float.valueOf(width));
    }

    public static /* synthetic */ void rotateBy$default(KropView kropView, float f2, ScaleAfterRotationStyle scaleAfterRotationStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            scaleAfterRotationStyle = ScaleAfterRotationStyle.NONE;
        }
        kropView.rotateBy(f2, scaleAfterRotationStyle);
    }

    public final void a() {
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView.setOverlayColor(this.e);
        if (getChildCount() > 1) {
            removeViewAt(1);
        }
        OverlayView overlayView2 = this.j;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        if (overlayView2.getParent() == null) {
            OverlayView overlayView3 = this.j;
            if (overlayView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overlayView");
            }
            addView(overlayView3, 1);
        }
        OverlayView overlayView4 = this.j;
        if (overlayView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView4.setMeasureListener(this);
    }

    public final void applyAspectRatio(int i2, int i3) {
        this.c = i2;
        this.d = i3;
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView.requestLayout();
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.resetZoom();
        invalidate();
    }

    public final void applyOffset(int i2) {
        this.b = i2;
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView.requestLayout();
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.resetZoom();
        invalidate();
    }

    public final void applyOverlay(@NotNull OverlayView overlayView) {
        Intrinsics.checkParameterIsNotNull(overlayView, "overlay");
        this.f = -1;
        this.j = overlayView;
        a();
    }

    public final void applyOverlayColor(int i2) {
        this.e = i2;
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView.setOverlayColor(this.e);
        invalidate();
    }

    public final void applyOverlayShape(int i2) {
        OverlayView overlayView;
        this.f = i2;
        if (i2 != 0) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            overlayView = new RectOverlay(context, null, 2, null);
        } else {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            overlayView = new OvalOverlay(context2, null, 2, null);
        }
        this.j = overlayView;
        a();
    }

    @WorkerThread
    @Nullable
    public final Bitmap getCroppedBitmap() {
        Pair<RectF, Float> cropRect = getCropRect();
        RectF component1 = cropRect.component1();
        float floatValue = cropRect.component2().floatValue();
        Bitmap bitmap = this.h;
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) component1.width(), (int) component1.height(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        Matrix matrix = new Matrix(zoomableImageView.getImageMatrix());
        matrix.postScale(floatValue, floatValue);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    @NotNull
    public final Transformation getTransformation() {
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        return zoomableImageView.getTransformation();
    }

    @Nullable
    public final TransformationListener getTransformationListener() {
        return this.k;
    }

    @Override // android.view.View
    public void invalidate() {
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.invalidate();
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView.invalidate();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != 0) {
            View findViewById = getRootView().findViewById(this.g);
            if (!(findViewById instanceof OverlayView)) {
                findViewById = null;
            }
            OverlayView overlayView = (OverlayView) findViewById;
            if (overlayView != null) {
                applyOverlay(overlayView);
                return;
            }
            throw new IllegalStateException("Overlay should instantiate OverlayView class".toString());
        }
    }

    @Override // com.avito.android.krop.OverlayView.MeasureListener
    public void onOverlayMeasured() {
        float f2;
        float f3;
        OverlayView overlayView = this.j;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        int measuredWidth = overlayView.getMeasuredWidth();
        OverlayView overlayView2 = this.j;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        int measuredHeight = overlayView2.getMeasuredHeight();
        RectF rectF = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        float f4 = (float) measuredWidth;
        float f5 = f4 * 0.5f;
        float f6 = (float) measuredHeight;
        float f7 = 0.5f * f6;
        float f8 = ((float) i2) * 2.0f;
        float f9 = f4 - f8;
        float f10 = f6 - f8;
        if (f9 < f10) {
            f3 = (((float) i4) * f9) / ((float) i3);
            f2 = f9;
        } else {
            f2 = f9 > f10 ? (((float) i3) * f10) / ((float) i4) : f9;
            f3 = f10;
        }
        float f11 = (f9 * f3) / f2;
        if (f11 > f10) {
            f9 = (f2 * f10) / f3;
        } else {
            f10 = f11;
        }
        float f12 = (float) 2;
        float f13 = f9 / f12;
        rectF.left = f5 - f13;
        float f14 = f10 / f12;
        rectF.top = f7 - f14;
        rectF.right = f5 + f13;
        rectF.bottom = f7 + f14;
        OverlayView overlayView3 = this.j;
        if (overlayView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        overlayView3.onUpdateViewport(this.a);
        RectF rectF2 = new RectF(this.a);
        OverlayView overlayView4 = this.j;
        if (overlayView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        int left = overlayView4.getLeft() - getLeft();
        OverlayView overlayView5 = this.j;
        if (overlayView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        rectF2.offset((float) left, (float) (overlayView5.getTop() - getTop()));
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.onUpdateViewport(rectF2);
        ZoomableImageView zoomableImageView2 = this.i;
        if (zoomableImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView2.requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkParameterIsNotNull(parcelable, "state");
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.b = savedState.getOffset();
            this.c = savedState.getAspectX();
            this.d = savedState.getAspectY();
            this.e = savedState.getOverlayColor();
            this.f = savedState.getOverlayShape();
            ZoomableImageView zoomableImageView = this.i;
            if (zoomableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            }
            zoomableImageView.onRestoreInstanceState(savedState.getImageViewState());
            OverlayView overlayView = this.j;
            if (overlayView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overlayView");
            }
            overlayView.setOverlayColor(this.e);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkExpressionValueIsNotNull(onSaveInstanceState, "superState");
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        int i5 = this.e;
        int i6 = this.f;
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        return new SavedState(onSaveInstanceState, i2, i3, i4, i5, i6, zoomableImageView.onSaveInstanceState());
    }

    public final void rotateBy(float f2, @NotNull ScaleAfterRotationStyle scaleAfterRotationStyle) {
        Intrinsics.checkParameterIsNotNull(scaleAfterRotationStyle, "scaleAnimation");
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.rotateBy(f2, scaleAfterRotationStyle);
    }

    public final void setBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        this.h = bitmap;
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.setImageBitmap(bitmap);
    }

    public final void setMaxScale(float f2) {
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.setMaxZoom(f2);
    }

    public final void setMinScale(float f2) {
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.setMinZoom(f2);
    }

    public final void setTransformation(@NotNull Transformation transformation) {
        Intrinsics.checkParameterIsNotNull(transformation, "transformation");
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        zoomableImageView.setTransformation(transformation);
    }

    public final void setTransformationListener(@Nullable TransformationListener transformationListener) {
        this.k = transformationListener;
    }

    public final void setZoom(float f2) {
        ZoomableImageView zoomableImageView = this.i;
        if (zoomableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        ZoomableImageView.setZoom$default(zoomableImageView, f2, 0.0f, 0.0f, null, 14, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 +2\u00020\u0001:\u0001+BA\b\u0016\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b'\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014¨\u0006,"}, d2 = {"Lcom/avito/android/krop/KropView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Parcelable;", "f", "Landroid/os/Parcelable;", "getImageViewState", "()Landroid/os/Parcelable;", "imageViewState", AuthSource.SEND_ABUSE, "I", "getOffset", "()I", "setOffset", "(I)V", "offset", "d", "getOverlayColor", "setOverlayColor", "overlayColor", "e", "getOverlayShape", "setOverlayShape", "overlayShape", "c", "getAspectY", "setAspectY", "aspectY", AuthSource.BOOKING_ORDER, "getAspectX", "setAspectX", "aspectX", "superState", "<init>", "(Landroid/os/Parcelable;IIIIILandroid/os/Parcelable;)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "krop_release"}, k = 1, mv = {1, 4, 0})
    public static final class SavedState extends View.BaseSavedState {
        public static final CREATOR CREATOR = new CREATOR(null);
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        @NotNull
        public final Parcelable f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/krop/KropView$SavedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/krop/KropView$SavedState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/krop/KropView$SavedState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/krop/KropView$SavedState;", "<init>", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
        public static final class CREATOR implements Parcelable.Creator<SavedState> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SavedState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "parcel");
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable, int i, int i2, int i3, int i4, int i5, @NotNull Parcelable parcelable2) {
            super(parcelable);
            Intrinsics.checkParameterIsNotNull(parcelable, "superState");
            Intrinsics.checkParameterIsNotNull(parcelable2, "imageViewState");
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = parcelable2;
        }

        public final int getAspectX() {
            return this.b;
        }

        public final int getAspectY() {
            return this.c;
        }

        @NotNull
        public final Parcelable getImageViewState() {
            return this.f;
        }

        public final int getOffset() {
            return this.a;
        }

        public final int getOverlayColor() {
            return this.d;
        }

        public final int getOverlayShape() {
            return this.e;
        }

        public final void setAspectX(int i) {
            this.b = i;
        }

        public final void setAspectY(int i) {
            this.c = i;
        }

        public final void setOffset(int i) {
            this.a = i;
        }

        public final void setOverlayColor(int i) {
            this.d = i;
        }

        public final void setOverlayShape(int i) {
            this.e = i;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f, i);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkParameterIsNotNull(parcel, "source");
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            Parcelable readParcelable = parcel.readParcelable(SavedState.class.getClassLoader());
            Intrinsics.checkExpressionValueIsNotNull(readParcelable, "source.readParcelable(Sa…::class.java.classLoader)");
            this.f = readParcelable;
        }
    }
}
