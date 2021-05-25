package com.avito.android.lib.design.bottom_sheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.picker.Picker;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetBehavior;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", VKApiUserFull.RelativeType.CHILD, "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "p", "(Landroid/view/View;)Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetBehavior<V extends View> extends com.google.android.material.bottomsheet.BottomSheetBehavior<V> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetBehavior(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout coordinatorLayout, @NotNull V v, @NotNull MotionEvent motionEvent) {
        View p;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(v, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        if (!onInterceptTouchEvent || (p = p(v)) == null) {
            return onInterceptTouchEvent;
        }
        int[] iArr = new int[2];
        p.getLocationOnScreen(iArr);
        int left = p.getLeft();
        int right = p.getRight();
        int roundToInt = c.roundToInt(motionEvent.getX());
        boolean z = left <= roundToInt && right >= roundToInt;
        int top = p.getTop() + iArr[1];
        int bottom = p.getBottom() + iArr[1];
        int roundToInt2 = c.roundToInt(motionEvent.getY());
        boolean z2 = top <= roundToInt2 && bottom >= roundToInt2;
        if (!z || !z2) {
            return true;
        }
        return false;
    }

    public final View p(View view) {
        if (view instanceof Picker) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        while (true) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            View p = p(childAt);
            if (p != null) {
                return p;
            }
            if (i == childCount) {
                return null;
            }
            i++;
        }
    }
}
