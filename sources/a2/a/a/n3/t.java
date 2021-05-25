package a2.a.a.n3;

import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class t extends Lambda implements Function1<ViewTreeObserver, Unit> {
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        super(1);
        this.a = onPreDrawListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ViewTreeObserver viewTreeObserver) {
        ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
        Intrinsics.checkNotNullParameter(viewTreeObserver2, "it");
        viewTreeObserver2.removeOnPreDrawListener(this.a);
        return Unit.INSTANCE;
    }
}
