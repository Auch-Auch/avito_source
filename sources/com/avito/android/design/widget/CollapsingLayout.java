package com.avito.android.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001eB!\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010 B)\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\"J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006#"}, d2 = {"Lcom/avito/android/design/widget/CollapsingLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/util/AttributeSet;)V", "c", "I", "overflowMargin", "measuredChildrenWidth", AuthSource.BOOKING_ORDER, "normalMargin", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CollapsingLayout extends ViewGroup {
    public int a;
    public int b;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CollapsingLayout);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingLayout_normal_margin, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingLayout_overflow_margin, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = this.a > getWidth();
        int width = getWidth();
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i5 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int height = (getHeight() / 2) - (measuredHeight / 2);
                    int i6 = z2 ? this.c : this.b;
                    if (i5 <= 0) {
                        i6 = 0;
                    }
                    width -= i6 + measuredWidth;
                    childAt.layout(width, height, measuredWidth + width, measuredHeight + height);
                }
                if (i5 != childCount) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i5 = 0;
            i4 = 0;
            i3 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int i6 = this.b;
                    if (i5 <= 0) {
                        i6 = 0;
                    }
                    i4 += measuredWidth + i6;
                    i3 = Math.max(i3, childAt.getMeasuredHeight());
                    ViewGroup.combineMeasuredStates(0, childAt.getMeasuredState());
                }
                if (i5 == childCount) {
                    break;
                }
                i5++;
            }
        } else {
            i4 = 0;
            i3 = 0;
        }
        int max = Math.max(i3, getSuggestedMinimumHeight());
        int max2 = Math.max(i4, getSuggestedMinimumWidth());
        this.a = max2;
        setMeasuredDimension(View.resolveSizeAndState(max2, i, 0), View.resolveSizeAndState(max, i2, 0));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(attributeSet);
    }
}
