package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import org.reactivestreams.Publisher;
import r6.a.b.i.b;
import r6.a.b.i.c;
import r6.a.b.i.d;
import r6.a.b.i.e;
public final class Completables {
    public Completables() {
        throw new IllegalStateException("No instances!");
    }

    public static <R> CompletableConverter<Flowable<R>> flatMapFlowable(Supplier<? extends Publisher<? extends R>> supplier, Function<? super Throwable, ? extends Publisher<? extends R>> function) {
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        Objects.requireNonNull(function, "onErrorHandler is null");
        return new b(null, supplier, function);
    }

    public static <R> CompletableConverter<Maybe<R>> flatMapMaybe(Supplier<? extends MaybeSource<? extends R>> supplier, Function<? super Throwable, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        Objects.requireNonNull(function, "onErrorHandler is null");
        return new c(null, supplier, function);
    }

    public static <R> CompletableConverter<Observable<R>> flatMapObservable(Supplier<? extends ObservableSource<? extends R>> supplier, Function<? super Throwable, ? extends ObservableSource<? extends R>> function) {
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        Objects.requireNonNull(function, "onErrorHandler is null");
        return new d(null, supplier, function);
    }

    public static <R> CompletableConverter<Single<R>> flatMapSingle(Supplier<? extends SingleSource<? extends R>> supplier, Function<? super Throwable, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(supplier, "onCompleteHandler is null");
        Objects.requireNonNull(function, "onErrorHandler is null");
        return new e(null, supplier, function);
    }
}
