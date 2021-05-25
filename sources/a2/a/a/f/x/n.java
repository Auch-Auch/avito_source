package a2.a.a.f.x;

import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class n<T, R> implements Function<Unit, Boolean> {
    public final /* synthetic */ boolean a;

    public n(boolean z) {
        this.a = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Boolean apply(Unit unit) {
        return Boolean.valueOf(this.a);
    }
}
