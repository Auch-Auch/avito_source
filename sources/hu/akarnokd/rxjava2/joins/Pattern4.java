package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.Function4;
import java.util.Objects;
import r6.a.a.f.r;
public final class Pattern4<T1, T2, T3, T4> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;

    public Pattern4(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
    }

    public <T5> Pattern5<T1, T2, T3, T4, T5> and(Observable<T5> observable) {
        Objects.requireNonNull(observable);
        return new Pattern5<>(this.a, this.b, this.c, this.d, observable);
    }

    public <R> Plan<R> then(Function4<T1, T2, T3, T4, R> function4) {
        Objects.requireNonNull(function4);
        return new r(this, function4);
    }
}
