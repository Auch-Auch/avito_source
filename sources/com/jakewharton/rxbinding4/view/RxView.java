package com.jakewharton.rxbinding4.view;

import a2.k.b.d.c;
import a2.k.b.d.d;
import a2.k.b.d.e;
import a2.k.b.d.f;
import a2.k.b.d.g;
import a2.k.b.d.h;
import a2.k.b.d.j;
import a2.k.b.d.k;
import a2.k.b.d.l;
import a2.k.b.d.m;
import a2.k.b.d.n;
import a2.k.b.d.o;
import a2.k.b.d.p;
import a2.k.b.d.q;
import a2.k.b.d.r;
import a2.k.b.d.s;
import a2.k.b.d.t;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.AlwaysTrue;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxView {
    @CheckResult
    @NotNull
    public static final Observable<ViewAttachEvent> attachEvents(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$attachEvents");
        return new d(view);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> attaches(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$attaches");
        return new e(view, true);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> clicks(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$clicks");
        return new f(view);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> detaches(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$detaches");
        return new e(view, false);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<DragEvent> drags(@NotNull View view) {
        return drags$default(view, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<DragEvent> drags(@NotNull View view, @NotNull Function1<? super DragEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$drags");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new g(view, function1);
    }

    public static /* synthetic */ Observable drags$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return drags(view, function1);
    }

    @NotNull
    @CheckResult
    @RequiresApi(16)
    public static final Observable<Unit> draws(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$draws");
        return new r(view);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Boolean> focusChanges(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$focusChanges");
        return new h(view);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> globalLayouts(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$globalLayouts");
        return new s(view);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MotionEvent> hovers(@NotNull View view) {
        return hovers$default(view, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MotionEvent> hovers(@NotNull View view, @NotNull Function1<? super MotionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$hovers");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new j(view, function1);
    }

    public static /* synthetic */ Observable hovers$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return hovers(view, function1);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<KeyEvent> keys(@NotNull View view) {
        return keys$default(view, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<KeyEvent> keys(@NotNull View view, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$keys");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new k(view, function1);
    }

    public static /* synthetic */ Observable keys$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return keys(view, function1);
    }

    @CheckResult
    @NotNull
    public static final Observable<ViewLayoutChangeEvent> layoutChangeEvents(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$layoutChangeEvents");
        return new l(view);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> layoutChanges(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$layoutChanges");
        return new m(view);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Unit> longClicks(@NotNull View view) {
        return longClicks$default(view, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Unit> longClicks(@NotNull View view, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$longClicks");
        Intrinsics.checkParameterIsNotNull(function0, "handled");
        return new n(view, function0);
    }

    public static /* synthetic */ Observable longClicks$default(View view, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = AlwaysTrue.INSTANCE;
        }
        return longClicks(view, function0);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> preDraws(@NotNull View view, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$preDraws");
        Intrinsics.checkParameterIsNotNull(function0, "proceedDrawingPass");
        return new t(view, function0);
    }

    @NotNull
    @CheckResult
    @RequiresApi(23)
    public static final Observable<ViewScrollChangeEvent> scrollChangeEvents(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$scrollChangeEvents");
        return new o(view);
    }

    @CheckResult
    @NotNull
    public static final Observable<Integer> systemUiVisibilityChanges(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$systemUiVisibilityChanges");
        return new p(view);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MotionEvent> touches(@NotNull View view) {
        return touches$default(view, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MotionEvent> touches(@NotNull View view, @NotNull Function1<? super MotionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$touches");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new q(view, function1);
    }

    public static /* synthetic */ Observable touches$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return touches(view, function1);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Consumer<? super Boolean> visibility(@NotNull View view) {
        return visibility$default(view, 0, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Consumer<? super Boolean> visibility(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$this$visibility");
        boolean z = false;
        if (i != 0) {
            if (i == 4 || i == 8) {
                z = true;
            }
            if (z) {
                return new c(view, i);
            }
            throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.".toString());
        }
        throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.".toString());
    }

    public static /* synthetic */ Consumer visibility$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        return visibility(view, i);
    }
}
