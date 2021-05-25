package com.avito.android.item_map.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.design.widget.BoundedFrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000e\u0010\u0014J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/item_map/view/MoveAboveBottomSheetBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", VKApiUserFull.RelativeType.CHILD, "dependency", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z", "onDependentViewChanged", "", "onDependentViewRemoved", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class MoveAboveBottomSheetBehavior extends CoordinatorLayout.Behavior<View> {
    public MoveAboveBottomSheetBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        return view2 instanceof BoundedFrameLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        int peekHeight;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (bottomSheetBehavior == null || (peekHeight = bottomSheetBehavior.getPeekHeight()) < 0 || view2.getTop() < peekHeight) {
            return false;
        }
        view.setTranslationY((float) (view2.getTop() - coordinatorLayout.getHeight()));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        view.setTranslationY(0.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoveAboveBottomSheetBehavior(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
