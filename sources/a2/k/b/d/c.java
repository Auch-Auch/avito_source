package a2.k.b.d;

import android.view.View;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Boolean> {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;

    public c(View view, int i) {
        this.a = view;
        this.b = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        View view = this.a;
        Intrinsics.checkExpressionValueIsNotNull(bool2, "value");
        view.setVisibility(bool2.booleanValue() ? 0 : this.b);
    }
}
