package hu.akarnokd.rxjava3.expr;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Objects;
import r6.a.b.f.a;
import r6.a.b.f.b;
public final class StatementCompletable {
    public StatementCompletable() {
        throw new IllegalStateException("No instances!");
    }

    public static Completable ifThen(BooleanSupplier booleanSupplier, CompletableSource completableSource, Completable completable) {
        Objects.requireNonNull(booleanSupplier, "condition is null");
        Objects.requireNonNull(completableSource, "then is null");
        Objects.requireNonNull(completable, "orElse is null");
        return RxJavaPlugins.onAssembly(new a(booleanSupplier, completableSource, completable));
    }

    public static <K> Completable switchCase(Supplier<? extends K> supplier, Map<? super K, ? extends CompletableSource> map, CompletableSource completableSource) {
        Objects.requireNonNull(supplier, "caseSelector is null");
        Objects.requireNonNull(map, "mapOfCases is null");
        Objects.requireNonNull(completableSource, "defaultCase is null");
        return RxJavaPlugins.onAssembly(new b(supplier, map, completableSource));
    }
}
