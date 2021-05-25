package com.avito.android.user_adverts.root_screen.adverts_host.publish_button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0018\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001dB\u001d\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010\"J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJW\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishButtonBehavior;", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton$Behavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", VKApiUserFull.RelativeType.CHILD, "Landroid/view/View;", "directTargetChild", "target", "", "axes", "type", "", "onStartNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/floatingactionbutton/FloatingActionButton;Landroid/view/View;Landroid/view/View;II)Z", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "consumed", "", "onNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/floatingactionbutton/FloatingActionButton;Landroid/view/View;IIIII[I)V", "com/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishButtonBehavior$visibilityChangeListener$1", "d", "Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishButtonBehavior$visibilityChangeListener$1;", "visibilityChangeListener", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishButtonBehavior extends FloatingActionButton.Behavior {
    public final PublishButtonBehavior$visibilityChangeListener$1 d = new PublishButtonBehavior$visibilityChangeListener$1();

    public PublishButtonBehavior() {
    }

    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull FloatingActionButton floatingActionButton, @NotNull View view, int i, int i2, int i3, int i4, int i5, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(floatingActionButton, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (i2 > 0 && floatingActionButton.getVisibility() == 0) {
            floatingActionButton.hide(this.d);
        } else if (i2 < 0 && floatingActionButton.getVisibility() != 0) {
            floatingActionButton.show();
        }
    }

    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull FloatingActionButton floatingActionButton, @NotNull View view, @NotNull View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(floatingActionButton, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkNotNullParameter(view, "directTargetChild");
        Intrinsics.checkNotNullParameter(view2, "target");
        return i == 2 || super.onStartNestedScroll(coordinatorLayout, floatingActionButton, view, view2, i, i2);
    }

    public PublishButtonBehavior(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
