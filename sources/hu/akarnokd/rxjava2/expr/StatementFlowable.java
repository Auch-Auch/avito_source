package hu.akarnokd.rxjava2.expr;

import hu.akarnokd.rxjava2.util.AlwaysTrueBooleanSupplier;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import r6.a.a.e.a;
import r6.a.a.e.b;
import r6.a.a.e.c;
public final class StatementFlowable {
    public StatementFlowable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Flowable<T> doWhile(Publisher<? extends T> publisher, BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(publisher, "source is null");
        ObjectHelper.requireNonNull(booleanSupplier, "postCondition is null");
        return RxJavaPlugins.onAssembly(new c(publisher, AlwaysTrueBooleanSupplier.INSTANCE, booleanSupplier));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher) {
        return ifThen(booleanSupplier, publisher, Flowable.empty());
    }

    public static <K, R> Flowable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends Publisher<? extends R>> map) {
        return switchCase(callable, map, Flowable.empty());
    }

    public static <T> Flowable<T> whileDo(Publisher<? extends T> publisher, BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(publisher, "source is null");
        ObjectHelper.requireNonNull(booleanSupplier, "preCondition is null");
        return RxJavaPlugins.onAssembly(new c(publisher, booleanSupplier, booleanSupplier));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher, Scheduler scheduler) {
        return ifThen(booleanSupplier, publisher, Flowable.empty().subscribeOn(scheduler));
    }

    public static <K, R> Flowable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends Publisher<? extends R>> map, Scheduler scheduler) {
        return switchCase(callable, map, Flowable.empty().subscribeOn(scheduler));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher, Flowable<? extends R> flowable) {
        ObjectHelper.requireNonNull(booleanSupplier, "condition is null");
        ObjectHelper.requireNonNull(publisher, "then is null");
        ObjectHelper.requireNonNull(flowable, "orElse is null");
        return RxJavaPlugins.onAssembly(new a(booleanSupplier, publisher, flowable));
    }

    public static <K, R> Flowable<R> switchCase(Callable<? extends K> callable, Map<? super K, ? extends Publisher<? extends R>> map, Publisher<? extends R> publisher) {
        ObjectHelper.requireNonNull(callable, "caseSelector is null");
        ObjectHelper.requireNonNull(map, "mapOfCases is null");
        ObjectHelper.requireNonNull(publisher, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new b(callable, map, publisher));
    }
}
