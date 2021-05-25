package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a9\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\n\u0010\t\u001a9\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000b\u0010\t\u001a9\u0010\f\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\f\u0010\t\u001a9\u0010\r\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\r\u0010\t\u001aÍ\u0001\u0010\u0013\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "action", "Landroid/transition/Transition$TransitionListener;", "doOnEnd", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onResume", "onPause", "addListener", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class TransitionKt {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1, @NotNull Function1<? super Transition, Unit> function12, @NotNull Function1<? super Transition, Unit> function13, @NotNull Function1<? super Transition, Unit> function14, @NotNull Function1<? super Transition, Unit> function15) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function12, "onStart");
        Intrinsics.checkParameterIsNotNull(function13, "onCancel");
        Intrinsics.checkParameterIsNotNull(function14, "onResume");
        Intrinsics.checkParameterIsNotNull(function15, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = TransitionKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = TransitionKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            function15 = TransitionKt$addListener$5.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(transition, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function12, "onStart");
        Intrinsics.checkParameterIsNotNull(function13, "onCancel");
        Intrinsics.checkParameterIsNotNull(function14, "onResume");
        Intrinsics.checkParameterIsNotNull(function15, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TransitionKt$doOnCancel$$inlined$addListener$1 transitionKt$doOnCancel$$inlined$addListener$1 = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
                this.a.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }
        };
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$1);
        return transitionKt$doOnCancel$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TransitionKt$doOnEnd$$inlined$addListener$1 transitionKt$doOnEnd$$inlined$addListener$1 = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
                this.a.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }
        };
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$1);
        return transitionKt$doOnEnd$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TransitionKt$doOnPause$$inlined$addListener$1 transitionKt$doOnPause$$inlined$addListener$1 = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
                this.a.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }
        };
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$1);
        return transitionKt$doOnPause$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TransitionKt$doOnResume$$inlined$addListener$1 transitionKt$doOnResume$$inlined$addListener$1 = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
                this.a.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }
        };
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$1);
        return transitionKt$doOnResume$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(transition, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TransitionKt$doOnStart$$inlined$addListener$1 transitionKt$doOnStart$$inlined$addListener$1 = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Intrinsics.checkParameterIsNotNull(transition2, "transition");
                this.a.invoke(transition2);
            }
        };
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$1);
        return transitionKt$doOnStart$$inlined$addListener$1;
    }
}
