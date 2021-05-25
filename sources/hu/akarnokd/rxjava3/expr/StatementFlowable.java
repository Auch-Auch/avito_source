package hu.akarnokd.rxjava3.expr;

import hu.akarnokd.rxjava3.util.AlwaysTrueBooleanSupplier;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Objects;
import org.reactivestreams.Publisher;
import r6.a.b.f.c;
import r6.a.b.f.d;
import r6.a.b.f.e;
public final class StatementFlowable {
    public StatementFlowable() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Flowable<T> doWhile(Publisher<? extends T> publisher, BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(publisher, "source is null");
        Objects.requireNonNull(booleanSupplier, "postCondition is null");
        return RxJavaPlugins.onAssembly(new e(publisher, AlwaysTrueBooleanSupplier.INSTANCE, booleanSupplier));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher) {
        return ifThen(booleanSupplier, publisher, Flowable.empty());
    }

    public static <K, R> Flowable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends Publisher<? extends R>> map) {
        return switchCase(supplier, map, Flowable.empty());
    }

    public static <T> Flowable<T> whileDo(Publisher<? extends T> publisher, BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(publisher, "source is null");
        Objects.requireNonNull(booleanSupplier, "preCondition is null");
        return RxJavaPlugins.onAssembly(new e(publisher, booleanSupplier, booleanSupplier));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher, Scheduler scheduler) {
        return ifThen(booleanSupplier, publisher, Flowable.empty().subscribeOn(scheduler));
    }

    public static <K, R> Flowable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends Publisher<? extends R>> map, Scheduler scheduler) {
        return switchCase(supplier, map, Flowable.empty().subscribeOn(scheduler));
    }

    public static <R> Flowable<R> ifThen(BooleanSupplier booleanSupplier, Publisher<? extends R> publisher, Flowable<? extends R> flowable) {
        Objects.requireNonNull(booleanSupplier, "condition is null");
        Objects.requireNonNull(publisher, "then is null");
        Objects.requireNonNull(flowable, "orElse is null");
        return RxJavaPlugins.onAssembly(new c(booleanSupplier, publisher, flowable));
    }

    public static <K, R> Flowable<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends Publisher<? extends R>> map, Publisher<? extends R> publisher) {
        Objects.requireNonNull(supplier, "caseSelector is null");
        Objects.requireNonNull(map, "mapOfCases is null");
        Objects.requireNonNull(publisher, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new d(supplier, map, publisher));
    }
}
