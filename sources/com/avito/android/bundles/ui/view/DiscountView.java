package com.avito.android.bundles.ui.view;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR.\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\rR\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0011R\u0016\u0010*\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001a¨\u00063"}, d2 = {"Lcom/avito/android/bundles/ui/view/DiscountView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "color", "setDiscountBackgroundColor", "(I)V", "", "f", "F", "textRectSize", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "backgroundPaint", g.a, "I", "additionalTextBottomPadding", "d", "backgroundRectSize", "Landroid/graphics/RectF;", "h", "Landroid/graphics/RectF;", "backgroundRect", "", "value", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDiscountTitle", "()Ljava/lang/String;", "setDiscountTitle", "(Ljava/lang/String;)V", "discountTitle", "e", "backgroundRectShift", "c", "textPaint", "i", "textRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountView extends View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public String a;
    public final Paint b;
    public final Paint c;
    public final float d;
    public final float e;
    public final float f;
    public final int g;
    public final RectF h;
    public final RectF i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/bundles/ui/view/DiscountView$Companion;", "", "", "BACKGROUND_SQUARE_ROTATE_DEGREE", "F", "TEXT_SQUARE_ROTATE_DEGREE", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @JvmOverloads
    public DiscountView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public DiscountView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiscountView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Nullable
    public final String getDiscountTitle() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        RectF rectF = this.h;
        float f2 = this.e;
        float width = rectF.width();
        float height = rectF.height();
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = width + f2;
        rectF.bottom = f2 + height;
        canvas.rotate(45.0f, this.h.centerX(), this.h.centerY());
        canvas.drawRect(this.h, this.b);
        canvas.restore();
        String str = this.a;
        if (str != null) {
            canvas.save();
            canvas.rotate(-45.0f, this.i.centerX(), this.i.centerY());
            canvas.drawText(str, this.i.centerX(), this.i.centerY() + ((float) this.g), this.c);
            canvas.restore();
        }
    }

    public final void setDiscountBackgroundColor(int i2) {
        this.b.setColor(i2);
        invalidate();
    }

    public final void setDiscountTitle(@Nullable String str) {
        this.a = str;
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscountView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.b = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(Contexts.getColorByAttr(context, R.attr.white));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(getResources().getDimension(com.avito.android.bundles.R.dimen.discount_view_text_size));
        this.c = paint2;
        float dimension = getResources().getDimension(com.avito.android.bundles.R.dimen.discount_view_background_square_size);
        this.d = dimension;
        this.e = -getResources().getDimension(com.avito.android.bundles.R.dimen.discount_view_background_square_shift);
        float dimension2 = getResources().getDimension(com.avito.android.bundles.R.dimen.discount_view_text_square_size);
        this.f = dimension2;
        this.g = getResources().getDimensionPixelSize(com.avito.android.bundles.R.dimen.discount_view_text_bottom_padding);
        this.h = new RectF(0.0f, 0.0f, dimension, dimension);
        this.i = new RectF(0.0f, 0.0f, dimension2, dimension2);
    }
}
