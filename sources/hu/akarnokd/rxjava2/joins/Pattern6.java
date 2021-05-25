package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.Function6;
import java.util.Objects;
import r6.a.a.f.t;
public final class Pattern6<T1, T2, T3, T4, T5, T6> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;
    public final Observable<T5> e;
    public final Observable<T6> f;

    public Pattern6(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
        this.e = observable5;
        this.f = observable6;
    }

    public <T7> Pattern7<T1, T2, T3, T4, T5, T6, T7> and(Observable<T7> observable) {
        Objects.requireNonNull(observable);
        return new Pattern7<>(this.a, this.b, this.c, this.d, this.e, this.f, observable);
    }

    public <R> Plan<R> then(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        Objects.requireNonNull(function6);
        return new t(this, function6);
    }
}
