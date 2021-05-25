package a2.a.a.t2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
public final class r<T, R> implements Function<T, ObservableSource<? extends R>> {
    public final /* synthetic */ Function1 a;

    public r(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Observable just;
        Object invoke = this.a.invoke(obj);
        return (invoke == null || (just = Observable.just(invoke)) == null) ? Observable.empty() : just;
    }
}
