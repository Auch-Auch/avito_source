package com.avito.android.util;

import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u001f\b\u0002\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aJ\u0010\r\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u001f\b\u0002\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\b¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"Landroidx/transition/Transition;", "T", "Landroid/view/ViewGroup;", "transition", "Lkotlin/Function1;", "Lcom/avito/android/util/TransitionDsl;", "", "Lkotlin/ExtensionFunctionType;", "setup", "beginDelayedTransition", "(Landroid/view/ViewGroup;Landroidx/transition/Transition;Lkotlin/jvm/functions/Function1;)V", "Landroidx/transition/TransitionSet;", "Lcom/avito/android/util/TransitionSetDsl;", "beginDelayedTransitionSet", "(Landroid/view/ViewGroup;Landroidx/transition/TransitionSet;Lkotlin/jvm/functions/Function1;)V", "endTransition", "(Landroid/view/ViewGroup;)V", "android_release"}, k = 2, mv = {1, 4, 2})
public final class TransitionsKt {
    public static final <T extends Transition> void beginDelayedTransition(@NotNull ViewGroup viewGroup, @NotNull T t, @NotNull Function1<? super TransitionDsl<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$beginDelayedTransition");
        Intrinsics.checkNotNullParameter(t, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        TransitionDsl transitionDsl = new TransitionDsl(t);
        function1.invoke(transitionDsl);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
    }

    public static /* synthetic */ void beginDelayedTransition$default(ViewGroup viewGroup, Transition transition, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = TransitionsKt$beginDelayedTransition$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "$this$beginDelayedTransition");
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        TransitionDsl transitionDsl = new TransitionDsl(transition);
        function1.invoke(transitionDsl);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
    }

    public static final <T extends TransitionSet> void beginDelayedTransitionSet(@NotNull ViewGroup viewGroup, @NotNull T t, @NotNull Function1<? super TransitionSetDsl<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$beginDelayedTransitionSet");
        Intrinsics.checkNotNullParameter(t, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        TransitionSetDsl transitionSetDsl = new TransitionSetDsl(t);
        function1.invoke(transitionSetDsl);
        TransitionManager.beginDelayedTransition(viewGroup, transitionSetDsl.buildTransition());
    }

    public static /* synthetic */ void beginDelayedTransitionSet$default(ViewGroup viewGroup, TransitionSet transitionSet, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = TransitionsKt$beginDelayedTransitionSet$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "$this$beginDelayedTransitionSet");
        Intrinsics.checkNotNullParameter(transitionSet, "transition");
        Intrinsics.checkNotNullParameter(function1, "setup");
        TransitionSetDsl transitionSetDsl = new TransitionSetDsl(transitionSet);
        function1.invoke(transitionSetDsl);
        TransitionManager.beginDelayedTransition(viewGroup, transitionSetDsl.buildTransition());
    }

    public static final void endTransition(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$endTransition");
        TransitionManager.endTransitions(viewGroup);
    }
}
