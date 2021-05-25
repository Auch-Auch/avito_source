package com.avito.android.search.map.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SnackBarsKt$disableSwipeToDismiss$1$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Snackbar a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackBarsKt$disableSwipeToDismiss$1$1(Snackbar snackbar) {
        super(0);
        this.a = snackbar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        View view = this.a.getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            layoutParams = null;
        }
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.setBehavior(null);
        }
    }
}
