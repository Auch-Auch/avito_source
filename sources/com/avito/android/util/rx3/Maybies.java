package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "T", "Lio/reactivex/rxjava3/core/Maybe;", "toMaybe", "(Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Maybe;", "Lio/reactivex/rxjava3/disposables/Disposable;", "executeImmediately", "(Lio/reactivex/rxjava3/core/Maybe;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lkotlin/Function0;", "", "onTerminate", "doOnTerminate", "(Lio/reactivex/rxjava3/core/Maybe;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Maybe;", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Maybies")
public final class Maybies {

    public static final class a<T> implements Consumer<T> {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(T t) {
            this.a.invoke();
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.invoke();
        }
    }

    @NotNull
    public static final <T> Maybe<T> doOnTerminate(@NotNull Maybe<T> maybe, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(maybe, "$this$doOnTerminate");
        Intrinsics.checkNotNullParameter(function0, "onTerminate");
        Maybe<T> doOnError = maybe.doOnSuccess(new a(function0)).doOnComplete(new b(function0)).doOnError(new c(function0));
        Intrinsics.checkNotNullExpressionValue(doOnError, "this\n    .doOnSuccess { …OnError { onTerminate() }");
        return doOnError;
    }

    @NotNull
    public static final <T> Disposable executeImmediately(@NotNull Maybe<T> maybe) {
        Intrinsics.checkNotNullParameter(maybe, "$this$executeImmediately");
        Disposable subscribe = maybe.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribeOn(Schedulers.t…e())\n        .subscribe()");
        return subscribe;
    }

    @NotNull
    public static final <T> Maybe<T> toMaybe(@Nullable T t) {
        Maybe<T> just;
        if (t != null && (just = Maybe.just(t)) != null) {
            return just;
        }
        Maybe<T> empty = Maybe.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
        return empty;
    }
}
