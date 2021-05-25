package com.jakewharton.rxbinding3.widget;

import a2.k.a.f.u;
import a2.k.a.f.v;
import a2.k.a.f.w;
import a2.k.a.f.x;
import a2.k.a.f.y;
import a2.k.a.f.z;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxTextView {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$afterTextChangeEvents");
        return new u(textView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$beforeTextChangeEvents");
        return new v(textView);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<TextViewEditorActionEvent> editorActionEvents(@NotNull TextView textView) {
        return editorActionEvents$default(textView, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<TextViewEditorActionEvent> editorActionEvents(@NotNull TextView textView, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$editorActionEvents");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new w(textView, function1);
    }

    public static /* synthetic */ Observable editorActionEvents$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return editorActionEvents(textView, function1);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Integer> editorActions(@NotNull TextView textView) {
        return editorActions$default(textView, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Integer> editorActions(@NotNull TextView textView, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$editorActions");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new x(textView, function1);
    }

    public static /* synthetic */ Observable editorActions$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return editorActions(textView, function1);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$textChangeEvents");
        return new y(textView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<CharSequence> textChanges(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$textChanges");
        return new z(textView);
    }
}
