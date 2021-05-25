package com.avito.android.lib.design.tooltip;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0005\u001a\u00060\u0002j\u0002`\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipUtils;", "", "Landroid/graphics/Rect;", "anchorDisplayRect", "Lcom/avito/android/lib/design/tooltip/AnchorWindowRect;", "forAnchorWindow", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "forTooltipWindow", "Landroid/view/View;", "view", "measureAbsoluteRect", "(Landroid/view/View;)Landroid/graphics/Rect;", "tooltipRect", "anchorRect", "", "calculateTooltipGravity", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)I", "tooltipView", "displayBounds", "", "measureTooltip", "(Landroid/view/View;Landroid/graphics/Rect;)Z", "", "fitTooltipIntoDisplay", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)V", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TooltipUtils {
    @NotNull
    public static final TooltipUtils INSTANCE = new TooltipUtils();

    @SuppressLint({"RtlHardcoded"})
    public final int calculateTooltipGravity(@NotNull Rect rect, @NotNull Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "tooltipRect");
        Intrinsics.checkNotNullParameter(rect2, "anchorRect");
        if (rect.bottom <= rect2.bottom) {
            return 48;
        }
        if (rect.top >= rect2.top) {
            return 80;
        }
        return rect.right <= rect2.right ? 3 : 5;
    }

    public final void fitTooltipIntoDisplay(@NotNull Rect rect, @NotNull Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "tooltipRect");
        Intrinsics.checkNotNullParameter(rect2, "displayBounds");
        rect.offset(Math.max(rect.left, rect2.left) - rect.left, 0);
        rect.offset(Math.min(rect.right, rect2.right) - rect.right, 0);
        rect.offset(0, Math.max(rect.top, rect2.top) - rect.top);
        rect.offset(0, Math.min(rect.bottom, rect2.bottom) - rect.bottom);
    }

    @NotNull
    public final Rect forAnchorWindow(@NotNull Rect rect, @NotNull Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "$this$forAnchorWindow");
        Intrinsics.checkNotNullParameter(rect2, "anchorDisplayRect");
        rect.offset(rect2.left, rect2.top);
        return rect;
    }

    @NotNull
    public final Rect forTooltipWindow(@NotNull Rect rect, @NotNull Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "$this$forTooltipWindow");
        Intrinsics.checkNotNullParameter(rect2, "anchorDisplayRect");
        rect.offset(-rect2.left, -rect2.top);
        return rect;
    }

    @NotNull
    public final Rect measureAbsoluteRect(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = view.getMeasuredWidth() + iArr[0];
        rect.bottom = view.getMeasuredHeight() + iArr[1];
        return rect;
    }

    public final boolean measureTooltip(@NotNull View view, @NotNull Rect rect) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(view, "tooltipView");
        Intrinsics.checkNotNullParameter(rect, "displayBounds");
        int i3 = view.getLayoutParams().width;
        if (i3 == -2) {
            i = View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE);
        } else if (i3 != -1) {
            i = View.MeasureSpec.makeMeasureSpec(view.getPaddingRight() + view.getPaddingLeft() + view.getLayoutParams().width, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824);
        }
        int i4 = view.getLayoutParams().height;
        if (i4 == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec(rect.height(), Integer.MIN_VALUE);
        } else if (i4 != -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(view.getPaddingBottom() + view.getPaddingTop() + view.getLayoutParams().height, 1073741824);
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec(rect.height(), 1073741824);
        }
        boolean z = false;
        view.measure(view.getLayoutParams().width == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : i, view.getLayoutParams().height == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : i2);
        boolean z2 = true;
        if (view.getMeasuredWidth() > rect.width()) {
            z2 = false;
        }
        if (view.getMeasuredHeight() <= rect.height()) {
            z = z2;
        }
        view.measure(i, i2);
        return z;
    }
}
