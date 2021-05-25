package hu.akarnokd.rxjava2.expr;

import hu.akarnokd.rxjava2.util.AlwaysTrueBooleanSupplier;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.concurrent.Callable;
import r6.a.a.e.d;
import r6.a.a.e.e;
import r6.a.a.e.f;
public final class StatementObservable {
    public StatementObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable<T> doWhile(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        ObjectHelper.requireNonNull(booleanSupplier, "postCondition is null");
        return RxJavaPlugins.onAssembly(new f(observableSource, AlwaysTrueBooleanSupplier.INSTANCE, booleanSupplier));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource) {
        return ifThen(booleanSupplier, observableSource, Observable.empty());
    }

    public static <K, R> Observable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends ObservableSource<? extends R>> map) {
        return switchCase(callable, map, Observable.empty());
    }

    public static <T> Observable<T> whileDo(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        ObjectHelper.requireNonNull(booleanSupplier, "preCondition is null");
        return RxJavaPlugins.onAssembly(new f(observableSource, booleanSupplier, booleanSupplier));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource, Scheduler scheduler) {
        return ifThen(booleanSupplier, observableSource, Observable.empty().subscribeOn(scheduler));
    }

    public static <K, R> Observable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends ObservableSource<? extends R>> map, Scheduler scheduler) {
        return switchCase(callable, map, Observable.empty().subscribeOn(scheduler));
    }

    public static <R> Observable<R> ifThen(BooleanSupplier booleanSupplier, ObservableSource<? extends R> observableSource, Observable<? extends R> observable) {
        ObjectHelper.requireNonNull(booleanSupplier, "condition is null");
        ObjectHelper.requireNonNull(observableSource, "then is null");
        ObjectHelper.requireNonNull(observable, "orElse is null");
        return RxJavaPlugins.onAssembly(new d(booleanSupplier, observableSource, observable));
    }

    public static <K, R> Observable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends ObservableSource<? extends R>> map, ObservableSource<? extends R> observableSource) {
        ObjectHelper.requireNonNull(callable, "caseSelector is null");
        ObjectHelper.requireNonNull(map, "mapOfCases is null");
        ObjectHelper.requireNonNull(observableSource, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new e(callable, map, observableSource));
    }
}
