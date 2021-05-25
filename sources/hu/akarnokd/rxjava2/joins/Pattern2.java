package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.Objects;
import r6.a.a.f.p;
public final class Pattern2<T1, T2> {
    public final Observable<T1> a;
    public final Observable<T2> b;

    public Pattern2(Observable<T1> observable, Observable<T2> observable2) {
        this.a = observable;
        this.b = observable2;
    }

    public <T3> Pattern3<T1, T2, T3> and(Observable<T3> observable) {
        Objects.requireNonNull(observable);
        return new Pattern3<>(this.a, this.b, observable);
    }

    public <R> Plan<R> then(BiFunction<T1, T2, R> biFunction) {
        Objects.requireNonNull(biFunction);
        return new p(this, biFunction);
    }
}
