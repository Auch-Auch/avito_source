package ru.avito.component.animator;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lru/avito/component/animator/VpaListenerAdapter;", "Landroidx/core/view/ViewPropertyAnimatorListener;", "Landroid/view/View;", "view", "", "onAnimationStart", "(Landroid/view/View;)V", "onAnimationEnd", "onAnimationCancel", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class VpaListenerAdapter implements ViewPropertyAnimatorListener {
    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
