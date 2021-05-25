package com.avito.android.util;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "victim", "", "removeGlobalLayoutListener", "(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "Lkotlin/Function1;", "block", "ifAlive", "(Landroid/view/ViewTreeObserver;Lkotlin/jvm/functions/Function1;)V", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "ViewTreeObservers")
public final class ViewTreeObservers {

    public static final class a extends Lambda implements Function1<ViewTreeObserver, Unit> {
        public final /* synthetic */ ViewTreeObserver a;
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            super(1);
            this.a = viewTreeObserver;
            this.b = onGlobalLayoutListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ViewTreeObserver viewTreeObserver) {
            Intrinsics.checkNotNullParameter(viewTreeObserver, "it");
            this.a.removeOnGlobalLayoutListener(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final void ifAlive(@NotNull ViewTreeObserver viewTreeObserver, @NotNull Function1<? super ViewTreeObserver, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewTreeObserver, "$this$ifAlive");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (viewTreeObserver.isAlive()) {
            function1.invoke(viewTreeObserver);
        }
    }

    public static final void removeGlobalLayoutListener(@NotNull ViewTreeObserver viewTreeObserver, @NotNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Intrinsics.checkNotNullParameter(viewTreeObserver, "$this$removeGlobalLayoutListener");
        Intrinsics.checkNotNullParameter(onGlobalLayoutListener, "victim");
        ifAlive(viewTreeObserver, new a(viewTreeObserver, onGlobalLayoutListener));
    }
}
