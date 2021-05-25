package com.avito.android.util;

import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u000e\u001a\u00020\u0006\"\b\b\u0001\u0010\u0002*\u00020\t2\u0006\u0010\n\u001a\u00028\u00012\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\u0010\u001a\u00020\u0006\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\n\u001a\u00028\u00012\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/util/TransitionSetDsl;", "Landroidx/transition/TransitionSet;", "T", "Lcom/avito/android/util/TransitionDsl;", "", "ordering", "", "setOrdering", "(I)V", "Landroidx/transition/Transition;", "transition", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setup", "addTransition", "(Landroidx/transition/Transition;Lkotlin/jvm/functions/Function1;)V", "addTransitionSet", "(Landroidx/transition/TransitionSet;Lkotlin/jvm/functions/Function1;)V", "e", "Landroidx/transition/TransitionSet;", "getTransition", "()Landroidx/transition/TransitionSet;", "<init>", "(Landroidx/transition/TransitionSet;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class TransitionSetDsl<T extends TransitionSet> extends TransitionDsl<T> {
    @NotNull
    public final T e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransitionSetDsl(@NotNull T t) {
        super(t);
        Intrinsics.checkNotNullParameter(t, "transition");
        this.e = t;
    }

    public final <T extends Transition> void addTransition(@NotNull T t, @NotNull Function1<? super TransitionDsl<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        T transition = getTransition();
        TransitionDsl transitionDsl = new TransitionDsl(t);
        function1.invoke(transitionDsl);
        transition.addTransition(transitionDsl.buildTransition());
    }

    public final <T extends TransitionSet> void addTransitionSet(@NotNull T t, @NotNull Function1<? super TransitionSetDsl<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        T transition = getTransition();
        TransitionSetDsl transitionSetDsl = new TransitionSetDsl(t);
        function1.invoke(transitionSetDsl);
        transition.addTransition(transitionSetDsl.buildTransition());
    }

    public final void setOrdering(int i) {
        getTransition().setOrdering(i);
    }

    @Override // com.avito.android.util.TransitionDsl
    @NotNull
    public T getTransition() {
        return this.e;
    }
}
