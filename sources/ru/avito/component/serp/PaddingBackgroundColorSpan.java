package ru.avito.component.serp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJg\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lru/avito/component/serp/PaddingBackgroundColorSpan;", "Landroid/text/style/LineBackgroundSpan;", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "top", "baseline", "bottom", "", "text", Tracker.Events.CREATIVE_START, "end", "lnum", "", "drawBackground", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;III)V", AuthSource.BOOKING_ORDER, "I", "backgroundColor", "Landroid/graphics/Rect;", AuthSource.SEND_ABUSE, "Landroid/graphics/Rect;", "bgRect", "c", "padding", "<init>", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingBackgroundColorSpan implements LineBackgroundSpan {
    public final Rect a = new Rect();
    public final int b;
    public final int c;

    public PaddingBackgroundColorSpan(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        int roundToInt = c.roundToInt(paint.measureText(charSequence, i6, i7));
        int color = paint.getColor();
        Rect rect = this.a;
        int i9 = this.c;
        rect.set(i - i9, i3 - (i8 == 0 ? i9 / 2 : -(i9 / 2)), i + roundToInt + i9, (i9 / 2) + i5);
        paint.setColor(this.b);
        canvas.drawRect(this.a, paint);
        paint.setColor(color);
    }
}
