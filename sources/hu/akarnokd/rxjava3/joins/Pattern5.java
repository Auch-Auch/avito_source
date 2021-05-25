package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function5;
import java.util.Objects;
import r6.a.b.g.s;
public final class Pattern5<T1, T2, T3, T4, T5> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;
    public final Observable<T5> e;

    public Pattern5(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
        this.e = observable5;
    }

    public <T6> Pattern6<T1, T2, T3, T4, T5, T6> and(Observable<T6> observable) {
        Objects.requireNonNull(observable);
        return new Pattern6<>(this.a, this.b, this.c, this.d, this.e, observable);
    }

    public <R> Plan<R> then(Function5<T1, T2, T3, T4, T5, R> function5) {
        Objects.requireNonNull(function5);
        return new s(this, function5);
    }
}
