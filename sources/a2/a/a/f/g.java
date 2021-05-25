package a2.a.a.f;

import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class g<T, R> implements Function<Unit, Boolean> {
    public final /* synthetic */ Boolean a;

    public g(Boolean bool) {
        this.a = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Boolean apply(Unit unit) {
        return Boolean.valueOf(!this.a.booleanValue());
    }
}
