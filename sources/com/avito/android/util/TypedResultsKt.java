package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\b¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\tH\b¢\u0006\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"", "T", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/util/LoadingState;", "toLoadingState", "(Lcom/avito/android/remote/model/TypedResult;)Lcom/avito/android/util/LoadingState;", "Lio/reactivex/Observable;", "toTyped", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lio/reactivex/rxjava3/core/Observable;", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "loading-state_release"}, k = 2, mv = {1, 4, 2})
public final class TypedResultsKt {
    public static final /* synthetic */ <T> LoadingState<T> toLoadingState(TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toLoadingState");
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    public static final /* synthetic */ <T> Observable<T> toTyped(Observable<LoadingState<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toTyped");
        Observable observable2 = (Observable<R>) observable.flatMap(TypedResultsKt$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable2, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    public static final /* synthetic */ <T> io.reactivex.rxjava3.core.Observable<T> toTyped(io.reactivex.rxjava3.core.Observable<LoadingState<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toTyped");
        io.reactivex.rxjava3.core.Observable observable2 = (io.reactivex.rxjava3.core.Observable<R>) observable.flatMap(TypedResultsKt$toTyped$2.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable2, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable2;
    }
}
