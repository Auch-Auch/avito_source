package hu.akarnokd.rxjava3.expr;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Objects;
import r6.a.b.f.k;
import r6.a.b.f.l;
public final class StatementSingle {
    public StatementSingle() {
        throw new IllegalStateException("No instances!");
    }

    public static <R> Single<R> ifThen(BooleanSupplier booleanSupplier, SingleSource<? extends R> singleSource, Single<? extends R> single) {
        Objects.requireNonNull(booleanSupplier, "condition is null");
        Objects.requireNonNull(singleSource, "then is null");
        Objects.requireNonNull(single, "orElse is null");
        return RxJavaPlugins.onAssembly(new k(booleanSupplier, singleSource, single));
    }

    public static <K, R> Single<R> switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends SingleSource<? extends R>> map, SingleSource<? extends R> singleSource) {
        Objects.requireNonNull(supplier, "caseSelector is null");
        Objects.requireNonNull(map, "mapOfCases is null");
        Objects.requireNonNull(singleSource, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new l(supplier, map, singleSource));
    }
}
