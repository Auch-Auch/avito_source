package com.avito.android.design.widget.add_advert;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/design/widget/add_advert/NewAdvertBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/avito/android/design/widget/add_advert/NewAdvertView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", VKApiUserFull.RelativeType.CHILD, "Landroid/view/View;", "dependency", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/avito/android/design/widget/add_advert/NewAdvertView;Landroid/view/View;)Z", "onDependentViewChanged", "", "onDependentViewRemoved", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/avito/android/design/widget/add_advert/NewAdvertView;Landroid/view/View;)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class NewAdvertBehavior extends CoordinatorLayout.Behavior<NewAdvertView> {
    public boolean layoutDependsOn(@NotNull CoordinatorLayout coordinatorLayout, @NotNull NewAdvertView newAdvertView, @NotNull View view) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(newAdvertView, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view, "dependency");
        return view instanceof Snackbar.SnackbarLayout;
    }

    public boolean onDependentViewChanged(@NotNull CoordinatorLayout coordinatorLayout, @NotNull NewAdvertView newAdvertView, @NotNull View view) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(newAdvertView, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view, "dependency");
        if (newAdvertView.getTranslationY() > ((float) 0)) {
            return true;
        }
        newAdvertView.setTranslationY(Math.min(0.0f, view.getTranslationY() - ((float) view.getHeight())));
        return true;
    }

    public void onDependentViewRemoved(@NotNull CoordinatorLayout coordinatorLayout, @NotNull NewAdvertView newAdvertView, @NotNull View view) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(newAdvertView, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view, "dependency");
        int integer = newAdvertView.getResources().getInteger(17694720);
        ViewPropertyAnimator translationY = newAdvertView.animate().translationY(0.0f);
        Intrinsics.checkNotNullExpressionValue(translationY, "child.animate().translationY(0f)");
        translationY.setDuration((long) integer);
    }
}
