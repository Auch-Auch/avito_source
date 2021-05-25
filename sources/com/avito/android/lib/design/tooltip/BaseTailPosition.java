package com.avito.android.lib.design.tooltip;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.TailPosition;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/lib/design/tooltip/BaseTailPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "Landroid/view/View;", "anchorView", "tooltipView", "Lkotlin/Pair;", "", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "innerTailHeight", "getTailHeight", "()I", "tailHeight", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseTailPosition implements TailPosition {
    public Integer a;

    @Override // com.avito.android.lib.design.tooltip.TailPosition
    @SuppressLint({"RtlHardcoded"})
    @NotNull
    public Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(view, "anchorView");
        Intrinsics.checkNotNullParameter(view2, "tooltipView");
        TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
        Rect measureAbsoluteRect = tooltipUtils.measureAbsoluteRect(view);
        Rect measureAbsoluteRect2 = tooltipUtils.measureAbsoluteRect(view2);
        int calculateTooltipGravity = tooltipUtils.calculateTooltipGravity(measureAbsoluteRect2, measureAbsoluteRect);
        Rect rect = new Rect(view2.getPaddingLeft() + measureAbsoluteRect2.left, view2.getPaddingTop() + measureAbsoluteRect2.top, measureAbsoluteRect2.right - view2.getPaddingRight(), measureAbsoluteRect2.bottom - view2.getPaddingBottom());
        if (calculateTooltipGravity == 48 || calculateTooltipGravity == 80) {
            i2 = measureAbsoluteRect.left;
            i = measureAbsoluteRect.right;
        } else {
            i2 = measureAbsoluteRect.top;
            i = measureAbsoluteRect.bottom;
        }
        if (calculateTooltipGravity == 48 || calculateTooltipGravity == 80) {
            i3 = measureAbsoluteRect2.left;
            i4 = rect.left;
            i5 = rect.right;
        } else {
            i3 = measureAbsoluteRect2.top;
            i4 = rect.top;
            i5 = rect.bottom;
        }
        int max = Math.max(i4, i2);
        int min = Math.min(i5, i);
        int calculateDefaultTailPosition = calculateDefaultTailPosition(i4, i5);
        if (max > calculateDefaultTailPosition || min < calculateDefaultTailPosition) {
            calculateDefaultTailPosition = a.R1(min, max, 2, max);
        }
        int i6 = calculateDefaultTailPosition - i3;
        if (calculateTooltipGravity == 3) {
            return TuplesKt.to(Integer.valueOf(measureAbsoluteRect2.width() - getTailHeight()), Integer.valueOf(i6));
        }
        if (calculateTooltipGravity == 5) {
            return TuplesKt.to(Integer.valueOf(getTailHeight()), Integer.valueOf(i6));
        }
        if (calculateTooltipGravity != 48) {
            return TuplesKt.to(Integer.valueOf(i6), Integer.valueOf(getTailHeight()));
        }
        return TuplesKt.to(Integer.valueOf(i6), Integer.valueOf(measureAbsoluteRect2.height() - getTailHeight()));
    }

    @Override // com.avito.android.lib.design.tooltip.TailPosition
    public int getTailHeight() {
        Integer num = this.a;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.avito.android.lib.design.tooltip.TailPosition
    public int getTailSize() {
        return TailPosition.DefaultImpls.getTailSize(this);
    }

    @Override // com.avito.android.lib.design.tooltip.AnchorPosition
    public void init(@NotNull Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
        if (this.a == null) {
            this.a = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_tailHeight, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
