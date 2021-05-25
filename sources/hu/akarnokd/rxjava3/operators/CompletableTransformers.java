package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.CompletableTransformer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import r6.a.b.i.a;
public final class CompletableTransformers {
    public CompletableTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static CompletableTransformer flatMap(Supplier<? extends CompletableSource> supplier, Function<? super Throwable, ? extends CompletableSource> function) {
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        Objects.requireNonNull(function, "onErrorHandler is null");
        return new a(null, supplier, function);
    }
}
