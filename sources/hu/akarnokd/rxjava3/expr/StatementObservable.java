package hu.akarnokd.rxjava3.expr;

import hu.akarnokd.rxjava3.util.AlwaysTrueBooleanSupplier;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Objects;
import r6.a.b.f.h;
import r6.a.b.f.i;
import r6.a.b.f.j;
public final class StatementObservable {
    public StatementObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable<T> doWhile(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(observableSource, "source is null");
        Objects.requireNonNull(booleanSupplier, "postCondition is null");
        return RxJavaPlugins.onAssembly(new j(observableSource, AlwaysTrueBooleanSupplier.INSTANCE, booleanSupplier));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource) {
        return ifThen(booleanSupplier, observableSource, Observable.empty());
    }

    public static <K, R> Observable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends ObservableSource<? extends R>> map) {
        return switchCase(supplier, map, Observable.empty());
    }

    public static <T> Observable<T> whileDo(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(observableSource, "source is null");
        Objects.requireNonNull(booleanSupplier, "preCondition is null");
        return RxJavaPlugins.onAssembly(new j(observableSource, booleanSupplier, booleanSupplier));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource, Scheduler scheduler) {
        return ifThen(booleanSupplier, observableSource, Observable.empty().subscribeOn(scheduler));
    }

    public static <K, R> Observable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends ObservableSource<? extends R>> map, Scheduler scheduler) {
        return switchCase(supplier, map, Observable.empty().subscribeOn(scheduler));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource, Observable<? extends R> observable) {
        Objects.requireNonNull(booleanSupplier, "condition is null");
        Objects.requireNonNull(observableSource, "then is null");
        Objects.requireNonNull(observable, "orElse is null");
        return RxJavaPlugins.onAssembly(new h(booleanSupplier, observableSource, observable));
    }

    public static <K, R> Observable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends ObservableSource<? extends R>> map, ObservableSource<? extends R> observableSource) {
        Objects.requireNonNull(supplier, "caseSelector is null");
        Objects.requireNonNull(map, "mapOfCases is null");
        Objects.requireNonNull(observableSource, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new i(supplier, map, observableSource));
    }
}
