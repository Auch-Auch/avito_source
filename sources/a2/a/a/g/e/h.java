package a2.a.a.g.e;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class h implements Consumer {
    public final /* synthetic */ Function1 a;

    public h(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(obj), "invoke(...)");
    }
}
