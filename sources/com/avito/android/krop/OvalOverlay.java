package com.avito.android.krop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/avito/android/krop/OvalOverlay;", "Lcom/avito/android/krop/OverlayView;", "Landroid/graphics/Canvas;", "Landroid/graphics/RectF;", "viewport", "Landroid/graphics/Paint;", "clearPaint", "", "drawViewportView", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/Paint;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class OvalOverlay extends OverlayView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OvalOverlay(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    @Override // com.avito.android.krop.OverlayView
    public void drawViewportView(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull Paint paint) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$drawViewportView");
        Intrinsics.checkParameterIsNotNull(rectF, "viewport");
        Intrinsics.checkParameterIsNotNull(paint, "clearPaint");
        canvas.drawOval(rectF, paint);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OvalOverlay(Context context, AttributeSet attributeSet, int i, j jVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
