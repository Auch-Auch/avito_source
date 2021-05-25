package com.avito.android.id_overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b \u0010!J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\f¨\u0006\""}, d2 = {"Lcom/avito/android/id_overlay/ViewOverlay;", "", "Landroid/graphics/Canvas;", "canvas", "", "dx", "dy", "", "paintOn", "(Landroid/graphics/Canvas;II)V", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "viewRect", "Landroid/text/TextPaint;", AuthSource.BOOKING_ORDER, "Landroid/text/TextPaint;", "textPaint", "Landroid/graphics/Paint;", AuthSource.SEND_ABUSE, "Landroid/graphics/Paint;", "rectPaint", "Landroid/view/View;", "f", "Landroid/view/View;", "hostView", "", "e", "Ljava/lang/String;", "text", "d", "textRect", "<init>", "(Ljava/lang/String;Landroid/view/View;)V", "id-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class ViewOverlay {
    public final Paint a;
    public final TextPaint b;
    public Rect c = new Rect();
    public final Rect d;
    public final String e;
    public final View f;

    public ViewOverlay(@NotNull String str, @NotNull View view) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(view, "hostView");
        this.e = str;
        this.f = view;
        Paint paint = new Paint();
        paint.setColor(Views.getColor(view, R.color.expected_strange_purple));
        Unit unit = Unit.INSTANCE;
        this.a = paint;
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Views.getColor(view, R.color.avito_white));
        textPaint.setTextSize(36.0f);
        this.b = textPaint;
        Rect rect = new Rect();
        this.d = rect;
        textPaint.getTextBounds(str, 0, str.length(), rect);
        rect.right += 10;
        rect.bottom += 10;
    }

    public static /* synthetic */ void paintOn$default(ViewOverlay viewOverlay, Canvas canvas, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        viewOverlay.paintOn(canvas, i, i2);
    }

    public final void paintOn(@NotNull Canvas canvas, int i, int i2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        canvas.translate((float) i, (float) i2);
        this.a.setStyle(Paint.Style.STROKE);
        Rect displayingRect = ViewExtensionsKt.displayingRect(this.f);
        this.c = displayingRect;
        canvas.drawRect(displayingRect, this.a);
        Rect rect = this.d;
        Rect rect2 = this.c;
        ViewExtensionsKt.moveTo(rect, rect2.left, rect2.top);
        this.a.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.d, this.a);
        String str = this.e;
        Rect rect3 = this.d;
        float f2 = (float) 5;
        canvas.drawText(str, ((float) rect3.left) + f2, ((float) rect3.bottom) - f2, this.b);
        canvas.restore();
    }
}
