package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\b¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"", "T", "Lcom/avito/android/remote/model/TypedResult;", "Lio/reactivex/Observable;", "toTypedObservable", "(Lcom/avito/android/remote/model/TypedResult;)Lio/reactivex/Observable;", "toTyped", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lio/reactivex/rxjava3/core/Observable;", "toTypedObservable3", "(Lcom/avito/android/remote/model/TypedResult;)Lio/reactivex/rxjava3/core/Observable;", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "api_release"}, k = 2, mv = {1, 4, 2})
public final class TypedObservablesKt {

    public static final class a<T, R> implements Function<TypedResult<T>, ObservableSource<? extends T>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            TypedResult typedResult = (TypedResult) obj;
            Intrinsics.checkNotNullParameter(typedResult, "it");
            return TypedObservablesKt.toTypedObservable(typedResult);
        }
    }

    public static final class b<T, R> implements io.reactivex.rxjava3.functions.Function<TypedResult<T>, io.reactivex.rxjava3.core.ObservableSource<? extends T>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            TypedResult typedResult = (TypedResult) obj;
            Intrinsics.checkNotNullExpressionValue(typedResult, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    @NotNull
    public static final <T> Observable<T> toTyped(@NotNull Observable<TypedResult<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toTyped");
        Observable observable2 = (Observable<R>) observable.flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "flatMap { it.toTypedObservable() }");
        return observable2;
    }

    @NotNull
    public static final <T> Observable<T> toTypedObservable(@NotNull TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toTypedObservable");
        if (typedResult instanceof TypedResult.OfResult) {
            Observable<T> just = Observable.just(((TypedResult.OfResult) typedResult).getResult());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(result)");
            return just;
        } else if (typedResult instanceof TypedResult.OfError) {
            Observable<T> error = Observable.error(new TypedResultException(((TypedResult.OfError) typedResult).getError()));
            Intrinsics.checkNotNullExpressionValue(error, "Observable.error(TypedResultException(error))");
            return error;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final <T> io.reactivex.rxjava3.core.Observable<T> toTypedObservable3(@NotNull TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toTypedObservable3");
        if (typedResult instanceof TypedResult.OfResult) {
            io.reactivex.rxjava3.core.Observable<T> just = io.reactivex.rxjava3.core.Observable.just(((TypedResult.OfResult) typedResult).getResult());
            Intrinsics.checkNotNullExpressionValue(just, "Observable3.just(result)");
            return just;
        } else if (typedResult instanceof TypedResult.OfError) {
            io.reactivex.rxjava3.core.Observable<T> error = io.reactivex.rxjava3.core.Observable.error(new TypedResultException(((TypedResult.OfError) typedResult).getError()));
            Intrinsics.checkNotNullExpressionValue(error, "Observable3.error(TypedResultException(error))");
            return error;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @NotNull
    public static final <T> io.reactivex.rxjava3.core.Observable<T> toTyped(@NotNull io.reactivex.rxjava3.core.Observable<TypedResult<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toTyped");
        io.reactivex.rxjava3.core.Observable observable2 = (io.reactivex.rxjava3.core.Observable<R>) observable.flatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "flatMap { it.toTypedObservable3() }");
        return observable2;
    }
}
