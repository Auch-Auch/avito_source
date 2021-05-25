package a2.a.a.f;

import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function1;
public final class d implements Function {
    public final /* synthetic */ Function1 a;

    public d(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.a.invoke(obj);
    }
}
