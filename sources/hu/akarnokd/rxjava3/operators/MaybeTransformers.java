package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.MaybeTransformer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import r6.a.b.i.p0;
public final class MaybeTransformers {
    public MaybeTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> MaybeTransformer<T, R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        return new p0(null, function, function2, supplier);
    }
}
