package a2.a.a.e;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
public final class e<T, R> implements Function<Boolean, ObservableSource<? extends T>> {
    public final /* synthetic */ Throwable a;

    public e(Throwable th) {
        this.a = th;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Object apply(Boolean bool) {
        return Observable.error(this.a);
    }
}
