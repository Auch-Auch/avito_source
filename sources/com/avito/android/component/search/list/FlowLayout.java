package com.avito.android.component.search.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001f\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\"J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a¨\u0006#"}, d2 = {"Lcom/avito/android/component/search/list/FlowLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "d", "Ljava/util/List;", "yOffsetsByPosition", "I", "horizontalOffset", "c", "xOffsetsByPosition", "verticalOffset", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FlowLayout extends ViewGroup {
    public int a;
    public int b;
    public final List<Integer> c = new ArrayList();
    public final List<Integer> d = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.FlowLayout)");
        this.a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.FlowLayout_verticalItemOffset, this.a);
        this.b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.FlowLayout_horizontalItemOffset, this.b);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int intValue = this.c.get(i5).intValue() + getPaddingLeft();
            int intValue2 = this.d.get(i5).intValue() + getPaddingTop();
            Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
            childAt.layout(intValue, intValue2, childAt.getMeasuredWidth() + intValue, childAt.getMeasuredHeight() + intValue2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.c.clear();
        this.d.clear();
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth > size - i5) {
                if (i4 > 0) {
                    i3 = i4 + this.a + i3;
                }
                i4 = 0;
                i5 = 0;
            }
            this.c.add(i6, Integer.valueOf(i5));
            this.d.add(i6, Integer.valueOf(i3));
            i5 += measuredWidth + this.b;
            if (measuredHeight > i4) {
                i4 = measuredHeight;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + i3 + i4, 1073741824));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }
}
