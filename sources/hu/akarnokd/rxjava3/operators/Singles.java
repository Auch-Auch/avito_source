package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.SingleConverter;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import org.reactivestreams.Publisher;
import r6.a.b.i.b1;
import r6.a.b.i.c1;
import r6.a.b.i.d1;
import r6.a.b.i.e1;
public final class Singles {
    public Singles() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> SingleConverter<T, Completable> flatMapCompletable(Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        return new b1(null, function, function2);
    }

    public static <T, R> SingleConverter<T, Flowable<R>> flatMapFlowable(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        return new c1(null, function, function2);
    }

    public static <T, R> SingleConverter<T, Maybe<R>> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        return new d1(null, function, function2);
    }

    public static <T, R> SingleConverter<T, Observable<R>> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessHandler is null");
        Objects.requireNonNull(function2, "onErrorHandler is null");
        return new e1(null, function, function2);
    }
}
