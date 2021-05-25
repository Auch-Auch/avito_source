package ru.avito.component.popup;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.avito.android.ui.widget.WrapWidthTextView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010$J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017¨\u0006%"}, d2 = {"Lru/avito/component/popup/BlackPopupView;", "Lcom/avito/android/ui/widget/WrapWidthTextView;", "", "w", "h", "oldw", "oldh", "", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "e", "Landroid/graphics/RectF;", "tailRect", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "tailPaint", g.a, "I", "tailPadding", "innerPadding", "f", "tailSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BlackPopupView extends WrapWidthTextView {
    public RectF e;
    public final int f;
    public final int g;
    public final int h;
    public final Paint i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlackPopupView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.popup_tail_size);
        this.f = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.g = context3.getResources().getDimensionPixelSize(R.dimen.popup_tail_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.h = context4.getResources().getDimensionPixelSize(R.dimen.popup_inner_vertical_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.i = paint;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = this.e;
        if (rectF != null) {
            canvas.save();
            canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
            canvas.drawRect(rectF, this.i);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = ((float) this.f) / 2.0f;
        float width = ((float) (getWidth() - this.g)) - f2;
        float strokeWidth = (float) (this.h + ((int) this.i.getStrokeWidth()));
        this.e = new RectF(width - f2, strokeWidth - f2, width + f2, strokeWidth + f2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlackPopupView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.popup_tail_size);
        this.f = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.g = context3.getResources().getDimensionPixelSize(R.dimen.popup_tail_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.h = context4.getResources().getDimensionPixelSize(R.dimen.popup_inner_vertical_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.i = paint;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlackPopupView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.popup_tail_size);
        this.f = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.g = context3.getResources().getDimensionPixelSize(R.dimen.popup_tail_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.h = context4.getResources().getDimensionPixelSize(R.dimen.popup_inner_vertical_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.i = paint;
    }
}
