package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import org.reactivestreams.Publisher;
import r6.a.b.i.n0;
import r6.a.b.i.o0;
import r6.a.b.i.q0;
import r6.a.b.i.r0;
public final class Maybes {
    public Maybes() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> MaybeConverter<T, Completable> flatMapCompletable(Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2, Supplier<? extends CompletableSource> supplier) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        return new n0(null, function, function2, supplier);
    }

    public static <T, R> MaybeConverter<T, Flowable<R>> flatMapFlowable(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Supplier<? extends Publisher<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        return new o0(null, function, function2, supplier);
    }

    public static <T, R> MaybeConverter<T, Observable<R>> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        return new q0(null, function, function2, supplier);
    }

    public static <T, R> MaybeConverter<T, Single<R>> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2, Supplier<? extends SingleSource<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        return new r0(null, function, function2, supplier);
    }
}
