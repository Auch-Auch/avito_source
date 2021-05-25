package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.core.SingleTransformer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import r6.a.b.i.f1;
public final class SingleTransformers {
    public SingleTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> SingleTransformer<T, R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        return new f1(null, function, function2);
    }
}
