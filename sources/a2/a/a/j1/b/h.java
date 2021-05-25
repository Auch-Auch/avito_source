package a2.a.a.j1.b;

import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function1;
public final class h implements Function {
    public final /* synthetic */ Function1 a;

    public h(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.a.invoke(obj);
    }
}
