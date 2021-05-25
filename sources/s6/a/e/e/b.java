package s6.a.e.e;

import io.reactivex.rxjava3.functions.BiFunction;
import kotlin.jvm.functions.Function2;
public final class b implements BiFunction {
    public final /* synthetic */ Function2 a;

    public b(Function2 function2) {
        this.a = function2;
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.invoke(obj, obj2);
    }
}
