package ru.avito.component.floating_button;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lru/avito/component/floating_button/FloatingButtonBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", VKApiUserFull.RelativeType.CHILD, "dependency", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z", "onDependentViewChanged", "", "onDependentViewRemoved", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingButtonBehavior extends CoordinatorLayout.Behavior<View> {
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        return view2 instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        if (view.getTranslationY() > ((float) 0)) {
            return true;
        }
        view.setTranslationY(Math.min(0.0f, view2.getTranslationY() - ((float) view2.getHeight())));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view2, "dependency");
        int integer = view.getResources().getInteger(17694720);
        ViewPropertyAnimator translationY = view.animate().translationY(0.0f);
        Intrinsics.checkNotNullExpressionValue(translationY, "child.animate().translationY(0f)");
        translationY.setDuration((long) integer);
    }
}
