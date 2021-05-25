package com.avito.android.serp;

import a2.b.a.a.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001d\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B%\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u001bB-\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u001dJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/avito/android/serp/AdColumnsLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", AuthSource.SEND_ABUSE, "I", "columnOffset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdColumnsLayout extends ViewGroup {
    public final int a = getResources().getDimensionPixelOffset(R.dimen.rds_column_offset);

    public AdColumnsLayout(@Nullable Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "image");
        childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        int measuredWidth = childAt.getMeasuredWidth() + this.a;
        View childAt2 = getChildAt(1);
        Intrinsics.checkNotNullExpressionValue(childAt2, "other");
        childAt2.layout(measuredWidth, 0, childAt2.getMeasuredWidth() + measuredWidth, childAt2.getMeasuredHeight());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (getChildCount() == 2) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = this.a;
            int i4 = size - (i3 * 4);
            int i5 = i4 > 0 ? (i3 * 1) + ((i4 / 5) * 2) : size;
            View childAt = getChildAt(0);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int i6 = size - i5;
            int i7 = this.a;
            int i8 = i6 > i7 ? i6 - i7 : 0;
            View childAt2 = getChildAt(1);
            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            Intrinsics.checkNotNullExpressionValue(childAt, "image");
            int measuredHeight = childAt.getMeasuredHeight();
            Intrinsics.checkNotNullExpressionValue(childAt2, "other");
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(measuredHeight, childAt2.getMeasuredHeight()), 1073741824));
            return;
        }
        StringBuilder L = a.L("Should be exactly two children (actual ");
        L.append(getChildCount());
        L.append(')');
        throw new IllegalStateException(L.toString());
    }

    public AdColumnsLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdColumnsLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdColumnsLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
