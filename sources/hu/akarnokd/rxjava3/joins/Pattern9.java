package hu.akarnokd.rxjava3.joins;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function9;
import java.util.ArrayList;
import java.util.Objects;
import r6.a.b.g.w;
public final class Pattern9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    public final Observable<T1> a;
    public final Observable<T2> b;
    public final Observable<T3> c;
    public final Observable<T4> d;
    public final Observable<T5> e;
    public final Observable<T6> f;
    public final Observable<T7> g;
    public final Observable<T8> h;
    public final Observable<T9> i;

    public Pattern9(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        this.a = observable;
        this.b = observable2;
        this.c = observable3;
        this.d = observable4;
        this.e = observable5;
        this.f = observable6;
        this.g = observable7;
        this.h = observable8;
        this.i = observable9;
    }

    public PatternN and(Observable<? extends Object> observable) {
        Objects.requireNonNull(observable);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        arrayList.add(this.b);
        arrayList.add(this.c);
        arrayList.add(this.d);
        arrayList.add(this.e);
        arrayList.add(this.f);
        arrayList.add(this.g);
        arrayList.add(this.h);
        arrayList.add(this.i);
        arrayList.add(observable);
        return new PatternN(arrayList);
    }

    public <R> Plan<R> then(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        Objects.requireNonNull(function9, "selector is null");
        return new w(this, function9);
    }
}
