package com.avito.android.lib.design.component_container;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.component_container.ComponentContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"8\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004*\u00020\u00002\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00048F@BX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroid/view/View;", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "getState", "(Landroid/view/View;)Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "value", "getBehavior", "(Landroid/view/View;)Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "setBehavior", "(Landroid/view/View;Lcom/avito/android/lib/design/component_container/ComponentBehavior;)V", "behavior", "components_release"}, k = 2, mv = {1, 4, 2})
public final class ComponentContainerKt {
    public static final void access$setBehavior$p(View view, ComponentBehavior componentBehavior) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ComponentContainer.LayoutParams)) {
            layoutParams = null;
        }
        ComponentContainer.LayoutParams layoutParams2 = (ComponentContainer.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.setBehavior(componentBehavior);
        }
    }

    @Nullable
    public static final ComponentBehavior<View> getBehavior(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$behavior");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ComponentContainer.LayoutParams)) {
            layoutParams = null;
        }
        ComponentContainer.LayoutParams layoutParams2 = (ComponentContainer.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            return layoutParams2.getBehavior();
        }
        return null;
    }

    @NotNull
    public static final ComponentContainer.State getState(@NotNull View view) {
        ComponentContainer.State state;
        Intrinsics.checkNotNullParameter(view, "$this$getState");
        ComponentBehavior<View> behavior = getBehavior(view);
        return (behavior == null || (state = behavior.getState()) == null) ? ComponentContainer.State.NORMAL : state;
    }
}
