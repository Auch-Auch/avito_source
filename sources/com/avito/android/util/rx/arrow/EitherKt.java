package com.avito.android.util.rx.arrow;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.Either;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a?\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/core/Either;", "O", "Lio/reactivex/Observable;", "filterRight", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "filterLeft", "rx"}, k = 2, mv = {1, 4, 2})
public final class EitherKt {

    public static final class a<T, R> implements Function<O, ObservableSource<? extends A>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Either either = (Either) obj;
            Intrinsics.checkNotNullParameter(either, "option");
            if (either instanceof Either.Right) {
                ((Either.Right) either).getB();
                return Observable.empty();
            } else if (either instanceof Either.Left) {
                return Observable.just(((Either.Left) either).getA());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<O, ObservableSource<? extends B>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Either either = (Either) obj;
            Intrinsics.checkNotNullParameter(either, "option");
            if (either instanceof Either.Right) {
                return Observable.just(((Either.Right) either).getB());
            }
            if (either instanceof Either.Left) {
                ((Either.Left) either).getA();
                return Observable.empty();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<A> */
    @NotNull
    public static final <A, B, O extends Either<? extends A, ? extends B>> Observable<A> filterLeft(@NotNull Observable<O> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterLeft");
        Observable observable2 = (Observable<R>) observable.concatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "concatMap { option ->\n  …ty<A>() }\n        )\n    }");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<B> */
    @NotNull
    public static final <A, B, O extends Either<? extends A, ? extends B>> Observable<B> filterRight(@NotNull Observable<O> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterRight");
        Observable observable2 = (Observable<R>) observable.concatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "concatMap { option ->\n  …ust(it) }\n        )\n    }");
        return observable2;
    }
}
