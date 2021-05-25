package com.avito.android.util;

import a2.a.a.n3.u;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "Lkotlin/Function0;", "", "onEnd", "withEnd", "(Landroid/view/ViewPropertyAnimator;Lkotlin/jvm/functions/Function0;)Landroid/view/ViewPropertyAnimator;", "onStart", "withStart", "(Landroid/view/ViewPropertyAnimator;Lkotlin/jvm/functions/Function0;)V", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ViewPropertyAnimatorUtilKt {
    @NotNull
    public static final ViewPropertyAnimator withEnd(@NotNull ViewPropertyAnimator viewPropertyAnimator, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(viewPropertyAnimator, "$this$withEnd");
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        viewPropertyAnimator.withEndAction(new u(function0));
        return viewPropertyAnimator;
    }

    public static final void withStart(@NotNull ViewPropertyAnimator viewPropertyAnimator, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(viewPropertyAnimator, "$this$withStart");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        viewPropertyAnimator.withStartAction(new u(function0));
    }
}
