package hu.akarnokd.rxjava3.expr;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Objects;
import r6.a.b.f.f;
import r6.a.b.f.g;
public final class StatementMaybe {
    public StatementMaybe() {
        throw new IllegalStateException("No instances!");
    }

    public static <R> Maybe<R> ifThen(BooleanSupplier booleanSupplier, MaybeSource<? extends R> maybeSource) {
        return ifThen(booleanSupplier, maybeSource, Maybe.empty());
    }

    public static <K, R> Maybe<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends MaybeSource<? extends R>> map) {
        return switchCase(supplier, map, Maybe.empty());
    }

    public static <R> Maybe<R> ifThen(BooleanSupplier booleanSupplier, MaybeSource<? extends R> maybeSource, Scheduler scheduler) {
        return ifThen(booleanSupplier, maybeSource, Maybe.empty().subscribeOn(scheduler));
    }

    public static <K, R> Maybe<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends MaybeSource<? extends R>> map, Scheduler scheduler) {
        return switchCase(supplier, map, Maybe.empty().subscribeOn(scheduler));
    }

    public static <R> Maybe<R> ifThen(BooleanSupplier booleanSupplier, MaybeSource<? extends R> maybeSource, Maybe<? extends R> maybe) {
        Objects.requireNonNull(booleanSupplier, "condition is null");
        Objects.requireNonNull(maybeSource, "then is null");
        Objects.requireNonNull(maybe, "orElse is null");
        return RxJavaPlugins.onAssembly(new f(booleanSupplier, maybeSource, maybe));
    }

    public static <K, R> Maybe<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends MaybeSource<? extends R>> map, MaybeSource<? extends R> maybeSource) {
        Objects.requireNonNull(supplier, "caseSelector is null");
        Objects.requireNonNull(map, "mapOfCases is null");
        Objects.requireNonNull(maybeSource, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new g(supplier, map, maybeSource));
    }
}
