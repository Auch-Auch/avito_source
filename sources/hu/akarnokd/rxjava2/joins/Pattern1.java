package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import r6.a.a.f.o;
public final class Pattern1<T1> {
    public final Observable<T1> a;

    public Pattern1(Observable<T1> observable) {
        this.a = observable;
    }

    public <R> Plan<R> then(Function<? super T1, ? extends R> function) {
        Objects.requireNonNull(function);
        return new o(this, function);
    }
}
