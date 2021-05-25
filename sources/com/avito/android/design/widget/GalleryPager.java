package com.avito.android.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ui.SafeViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/design/widget/GalleryPager;", "Lcom/avito/android/ui/SafeViewPager;", "", "wMeasureSpec", "hMeasureSpec", "", "onMeasure", "(II)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class GalleryPager extends SafeViewPager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryPager(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z = true;
        boolean z2 = layoutParams.width == -2;
        if (layoutParams.height != -2) {
            z = false;
        }
        int childCount = getChildCount();
        if ((z2 || z) && childCount > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i, i2);
            if (z) {
                Intrinsics.checkNotNullExpressionValue(childAt, "view");
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
            }
            if (z2) {
                Intrinsics.checkNotNullExpressionValue(childAt, "view");
                i = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth(), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
