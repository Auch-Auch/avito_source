package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function7;
import java.util.Objects;
import r6.a.b.g.u;
public final class Pattern7<T1, T2, T3, T4, T5, T6, T7> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;
    public final Observable<T5> e;
    public final Observable<T6> f;
    public final Observable<T7> g;

    public Pattern7(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
        this.e = observable5;
        this.f = observable6;
        this.g = observable7;
    }

    public <T8> Pattern8<T1, T2, T3, T4, T5, T6, T7, T8> and(Observable<T8> observable) {
        Objects.requireNonNull(observable);
        return new Pattern8<>(this.a, this.b, this.c, this.d, this.e, this.f, this.g, observable);
    }

    public <R> Plan<R> then(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        Objects.requireNonNull(function7);
        return new u(this, function7);
    }
}
