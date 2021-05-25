package com.avito.android.util;

import a2.a.a.n3.r;
import a2.a.a.n3.t;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class ViewPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    public boolean a;
    public final View.OnAttachStateChangeListener b = new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.util.ViewPreDrawListener$attachStateListener$1
        public final /* synthetic */ ViewPreDrawListener a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.a.e) {
                ViewPreDrawListener viewPreDrawListener = Views.a(view);
                if (viewPreDrawListener == null) {
                    ViewPreDrawListener viewPreDrawListener2 = this.a;
                    Objects.requireNonNull(viewPreDrawListener2);
                    viewPreDrawListener2.b(view, new r(viewPreDrawListener2));
                    Views.access$associatePreDrawListener(view, this.a);
                } else if (!Intrinsics.areEqual(viewPreDrawListener, this.a)) {
                    view.removeOnAttachStateChangeListener(this);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "detachedView");
            ViewPreDrawListener viewPreDrawListener = this.a;
            View.OnAttachStateChangeListener onAttachStateChangeListener = viewPreDrawListener.e ? this : null;
            if (onAttachStateChangeListener != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            viewPreDrawListener.b(view, new t(viewPreDrawListener));
            Views.access$associatePreDrawListener(view, null);
        }
    };
    public final View c;
    public Function0<Boolean> d;
    public final boolean e;

    public ViewPreDrawListener(@NotNull View view, @NotNull Function0<Boolean> function0, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "preDrawListener");
        this.c = view;
        this.d = function0;
        this.e = z;
        a();
    }

    public final void a() {
        if (!this.a) {
            this.c.addOnAttachStateChangeListener(this.b);
            b(this.c, new r(this));
            this.a = true;
        }
    }

    public final void b(View view, Function1<? super ViewTreeObserver, Unit> function1) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver2, "viewTreeObserver");
            function1.invoke(viewTreeObserver2);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.a) {
            View view = this.c;
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.b;
            if (onAttachStateChangeListener != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            b(view, new t(this));
            Views.access$associatePreDrawListener(view, null);
            this.a = false;
        }
        return this.d.invoke().booleanValue();
    }
}
