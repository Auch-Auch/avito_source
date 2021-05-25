package com.avito.android.search.filter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewTreeObservers;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/filter/KeyboardVisibilityDetector;", "", "", "dispose", "()V", "Lcom/avito/android/search/filter/KeyboardVisibilityDetector$b;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/filter/KeyboardVisibilityDetector$b;", "layoutListener", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class KeyboardVisibilityDetector {
    public final b a;
    public final View b;

    public static final class a extends Lambda implements Function1<ViewTreeObserver, Unit> {
        public final /* synthetic */ KeyboardVisibilityDetector a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KeyboardVisibilityDetector keyboardVisibilityDetector) {
            super(1);
            this.a = keyboardVisibilityDetector;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ViewTreeObserver viewTreeObserver) {
            ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
            Intrinsics.checkNotNullParameter(viewTreeObserver2, "it");
            viewTreeObserver2.addOnGlobalLayoutListener(this.a.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final Rect a = new Rect();
        public Integer b;
        public final View c;
        public final Function1<Boolean, Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull View view, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.c = view;
            this.d = function1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.c.getWindowVisibleDisplayFrame(this.a);
            int height = this.a.height();
            Integer num = this.b;
            if (num == null) {
                this.b = Integer.valueOf(height);
                return;
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > height) {
                this.d.invoke(Boolean.TRUE);
            } else {
                this.d.invoke(Boolean.FALSE);
            }
        }
    }

    public static final class c extends Lambda implements Function1<ViewTreeObserver, Unit> {
        public final /* synthetic */ KeyboardVisibilityDetector a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KeyboardVisibilityDetector keyboardVisibilityDetector) {
            super(1);
            this.a = keyboardVisibilityDetector;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ViewTreeObserver viewTreeObserver) {
            ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
            Intrinsics.checkNotNullParameter(viewTreeObserver2, "it");
            viewTreeObserver2.removeOnGlobalLayoutListener(this.a.a);
            return Unit.INSTANCE;
        }
    }

    public KeyboardVisibilityDetector(@NotNull View view, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = view;
        this.a = new b(view, function1);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
        ViewTreeObservers.ifAlive(viewTreeObserver, new a(this));
    }

    public final void dispose() {
        ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
        ViewTreeObservers.ifAlive(viewTreeObserver, new c(this));
    }
}
