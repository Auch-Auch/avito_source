package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function8;
import java.util.Objects;
import r6.a.b.g.v;
public final class Pattern8<T1, T2, T3, T4, T5, T6, T7, T8> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;
    public final Observable<T5> e;
    public final Observable<T6> f;
    public final Observable<T7> g;
    public final Observable<T8> h;

    public Pattern8(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
        this.e = observable5;
        this.f = observable6;
        this.g = observable7;
        this.h = observable8;
    }

    public <T9> Pattern9<T1, T2, T3, T4, T5, T6, T7, T8, T9> and(Observable<T9> observable) {
        Objects.requireNonNull(observable);
        return new Pattern9<>(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, observable);
    }

    public <R> Plan<R> then(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        Objects.requireNonNull(function8);
        return new v(this, function8);
    }
}
