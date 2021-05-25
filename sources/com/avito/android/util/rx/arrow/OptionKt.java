package com.avito.android.util.rx.arrow;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0007\u0010\u0005\u001a3\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u0004\u0010\t\u001a3\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"T", "Larrow/core/Option;", "O", "Lio/reactivex/Observable;", "filterDefined", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "", "filterEmpty", "Lio/reactivex/Flowable;", "(Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "Lio/reactivex/Single;", "Lio/reactivex/Maybe;", "(Lio/reactivex/Single;)Lio/reactivex/Maybe;", "rx"}, k = 2, mv = {1, 4, 2})
public final class OptionKt {

    public static final class a<T, R> implements Function<O, ObservableSource<? extends T>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "option");
            if (option instanceof None) {
                return Observable.empty();
            }
            if (option instanceof Some) {
                return Observable.just(((Some) option).getT());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<O, Publisher<? extends T>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "option");
            if (option instanceof None) {
                return Flowable.empty();
            }
            if (option instanceof Some) {
                return Flowable.just(((Some) option).getT());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function<O, MaybeSource<? extends T>> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "option");
            if (option instanceof None) {
                return Maybe.empty();
            }
            if (option instanceof Some) {
                return Maybe.just(((Some) option).getT());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<O, ObservableSource<? extends Unit>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "option");
            if (option instanceof None) {
                return Observable.just(Unit.INSTANCE);
            }
            if (option instanceof Some) {
                ((Some) option).getT();
                return Observable.empty();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    @NotNull
    public static final <T, O extends Option<? extends T>> Observable<T> filterDefined(@NotNull Observable<O> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterDefined");
        Observable observable2 = (Observable<R>) observable.concatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "concatMap { option ->\n  …ust(it) }\n        )\n    }");
        return observable2;
    }

    @NotNull
    public static final <O extends Option<?>> Observable<Unit> filterEmpty(@NotNull Observable<O> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterEmpty");
        Observable<R> concatMap = observable.concatMap(d.a);
        Intrinsics.checkNotNullExpressionValue(concatMap, "concatMap { option ->\n  …Unit>() }\n        )\n    }");
        return concatMap;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Flowable<R>, java.lang.Object, io.reactivex.Flowable<T> */
    @NotNull
    public static final <T, O extends Option<? extends T>> Flowable<T> filterDefined(@NotNull Flowable<O> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$filterDefined");
        Flowable flowable2 = (Flowable<R>) flowable.concatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(flowable2, "concatMap { option ->\n  …ust(it) }\n        )\n    }");
        return flowable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Maybe<R>, java.lang.Object, io.reactivex.Maybe<T> */
    @NotNull
    public static final <T, O extends Option<? extends T>> Maybe<T> filterDefined(@NotNull Single<O> single) {
        Intrinsics.checkNotNullParameter(single, "$this$filterDefined");
        Maybe maybe = (Maybe<R>) single.flatMapMaybe(c.a);
        Intrinsics.checkNotNullExpressionValue(maybe, "flatMapMaybe { option ->…<T>(it) }\n        )\n    }");
        return maybe;
    }
}
