package com.avito.android.krop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u001b\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00020\n*\u00020\u00182\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH$¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/krop/OverlayView;", "Landroid/view/View;", "Lcom/avito/android/krop/ViewportUpdateListener;", "", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "onLayout", "(ZIIII)V", "Landroid/graphics/RectF;", "newViewport", "onUpdateViewport", "(Landroid/graphics/RectF;)V", "color", "setOverlayColor", "(I)V", "Lcom/avito/android/krop/OverlayView$MeasureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setMeasureListener", "(Lcom/avito/android/krop/OverlayView$MeasureListener;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "viewport", "Landroid/graphics/Paint;", "clearPaint", "drawViewportView", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/Paint;)V", AuthSource.SEND_ABUSE, "I", "overlayColor", "d", "Lcom/avito/android/krop/OverlayView$MeasureListener;", "measureListener", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "c", "Landroid/graphics/RectF;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MeasureListener", "krop_release"}, k = 1, mv = {1, 4, 0})
public abstract class OverlayView extends View implements ViewportUpdateListener {
    public int a;
    public final Paint b;
    public RectF c;
    public MeasureListener d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/krop/OverlayView$MeasureListener;", "", "", "onOverlayMeasured", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
    public interface MeasureListener {
        void onOverlayMeasured();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OverlayView(Context context, AttributeSet attributeSet, int i, j jVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final /* synthetic */ MeasureListener access$getMeasureListener$p(OverlayView overlayView) {
        MeasureListener measureListener = overlayView.d;
        if (measureListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureListener");
        }
        return measureListener;
    }

    public abstract void drawViewportView(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull Paint paint);

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawColor(this.a);
        RectF rectF = this.c;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        drawViewportView(canvas, rectF, this.b);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        MeasureListener measureListener = this.d;
        if (measureListener != null) {
            if (measureListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("measureListener");
            }
            measureListener.onOverlayMeasured();
            return;
        }
        throw new IllegalStateException("Overlay not inited correctly: check, if it is referenced by any MeasureListener implementation".toString());
    }

    @Override // com.avito.android.krop.ViewportUpdateListener
    public void onUpdateViewport(@NotNull RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "newViewport");
        this.c = rectF;
    }

    public final void setMeasureListener(@NotNull MeasureListener measureListener) {
        Intrinsics.checkParameterIsNotNull(measureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = measureListener;
    }

    public final void setOverlayColor(int i) {
        this.a = i;
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b = paint;
        setLayerType(1, null);
    }
}
