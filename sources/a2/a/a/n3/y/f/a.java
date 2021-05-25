package a2.a.a.n3.y.f;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Consumer {
    public final /* synthetic */ Function1 a;

    public a(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(obj), "invoke(...)");
    }
}
