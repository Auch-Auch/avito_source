package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import r6.a.b.g.o;
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
