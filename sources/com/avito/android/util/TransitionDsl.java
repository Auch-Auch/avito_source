package com.avito.android.util;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.IdRes;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\u0019\u0010\u0007\u001a\u00020\u00062\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\u0004\b\u0007\u0010\u0011J!\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001c\u0010\u001f\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/util/TransitionDsl;", "Landroidx/transition/Transition;", "T", "", "", "viewId", "", "addTarget", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "", "targetName", "(Ljava/lang/String;)V", "Ljava/lang/Class;", "targetType", "(Ljava/lang/Class;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onTransitionEnd", "(Lkotlin/jvm/functions/Function1;)V", "onTransitionStart", "buildTransition", "()Landroidx/transition/Transition;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", AuthSource.BOOKING_ORDER, "d", "Landroidx/transition/Transition;", "getTransition", "transition", "Landroid/view/animation/Interpolator;", "c", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "interpolator", "<init>", "(Landroidx/transition/Transition;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public class TransitionDsl<T extends Transition> {
    public Function1<? super Transition, Unit> a = a.c;
    public Function1<? super Transition, Unit> b = a.b;
    @Nullable
    public Interpolator c;
    @NotNull
    public final T d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Transition, Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Transition transition) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(transition, "it");
                return Unit.INSTANCE;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(transition, "it");
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public TransitionDsl(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "transition");
        this.d = t;
    }

    public final void addTarget(@IdRes int i) {
        getTransition().addTarget(i);
    }

    @NotNull
    public final Transition buildTransition() {
        Interpolator interpolator = this.c;
        if (interpolator != null) {
            getTransition().setInterpolator(interpolator);
        }
        getTransition().addListener(new TransitionListenerAdapter(this) { // from class: com.avito.android.util.TransitionDsl$buildTransition$2
            public final /* synthetic */ TransitionDsl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                this.a.b.invoke(transition);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                this.a.a.invoke(transition);
            }
        });
        return getTransition();
    }

    @Nullable
    public final Interpolator getInterpolator() {
        return this.c;
    }

    @NotNull
    public T getTransition() {
        return this.d;
    }

    public final void onTransitionEnd(@NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function1;
    }

    public final void onTransitionStart(@NotNull Function1<? super Transition, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = function1;
    }

    public final void setInterpolator(@Nullable Interpolator interpolator) {
        this.c = interpolator;
    }

    public final void addTarget(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getTransition().addTarget(view);
    }

    public final void addTarget(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "targetName");
        getTransition().addTarget(str);
    }

    public final void addTarget(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "targetType");
        getTransition().addTarget(cls);
    }
}
