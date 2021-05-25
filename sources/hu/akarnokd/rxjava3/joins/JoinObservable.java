package hu.akarnokd.rxjava3.joins;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import r6.a.b.g.n;
public final class JoinObservable<T> {
    public final Observable<T> a;

    public JoinObservable(Observable<T> observable) {
        this.a = observable;
    }

    public static <T> JoinObservable<T> from(Observable<T> observable) {
        return new JoinObservable<>(RxJavaPlugins.onAssembly(observable));
    }

    public static <R> JoinObservable<R> when(Iterable<? extends Plan<R>> iterable) {
        Objects.requireNonNull(iterable, "plans");
        return from(new n(iterable));
    }

    public <T2> Pattern2<T, T2> and(Observable<T2> observable) {
        Observable<T> observable2 = this.a;
        Objects.requireNonNull(observable2, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        Objects.requireNonNull(observable, "right");
        return new Pattern2<>(observable2, observable);
    }

    public <R> Plan<R> then(Function<? super T, ? extends R> function) {
        Observable<T> observable = this.a;
        Objects.requireNonNull(observable, "source");
        Objects.requireNonNull(function, "selector");
        return new Pattern1(observable).then(function);
    }

    public Observable<T> toObservable() {
        return this.a;
    }

    @SafeVarargs
    public static <R> JoinObservable<R> when(Plan<R>... planArr) {
        return from(AppCompatDelegateImpl.i.k2(planArr));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan) {
        return from(AppCompatDelegateImpl.i.k2(plan));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4, Plan<R> plan5) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4, plan5));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4, Plan<R> plan5, Plan<R> plan6) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4, plan5, plan6));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4, Plan<R> plan5, Plan<R> plan6, Plan<R> plan7) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4, plan5, plan6, plan7));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4, Plan<R> plan5, Plan<R> plan6, Plan<R> plan7, Plan<R> plan8) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4, plan5, plan6, plan7, plan8));
    }

    public static <R> JoinObservable<R> when(Plan<R> plan, Plan<R> plan2, Plan<R> plan3, Plan<R> plan4, Plan<R> plan5, Plan<R> plan6, Plan<R> plan7, Plan<R> plan8, Plan<R> plan9) {
        return from(AppCompatDelegateImpl.i.k2(plan, plan2, plan3, plan4, plan5, plan6, plan7, plan8, plan9));
    }
}
