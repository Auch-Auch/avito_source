package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.util.Objects;
import r6.a.a.f.q;
public final class Pattern3<T1, T2, T3> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;

    public Pattern3(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
    }

    public <T4> Pattern4<T1, T2, T3, T4> and(Observable<T4> observable) {
        Objects.requireNonNull(observable);
        return new Pattern4<>(this.a, this.b, this.c, observable);
    }

    public <R> Plan<R> then(Function3<T1, T2, T3, R> function3) {
        Objects.requireNonNull(function3);
        return new q(this, function3);
    }
}
