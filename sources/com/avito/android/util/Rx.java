package com.avito.android.util;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/util/Rx;", "", "T", "value", "Lio/reactivex/Observable;", "fallback", "notNull", "(Ljava/lang/Object;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "<init>", "()V", "rx"}, k = 1, mv = {1, 4, 2})
public final class Rx {
    @NotNull
    public static final Rx INSTANCE = new Rx();

    public static final class a<V> implements Callable<ObservableSource<? extends T>> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ Observable b;

        public a(Object obj, Observable observable) {
            this.a = obj;
            this.b = observable;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            Object obj = this.a;
            if (obj == null) {
                return this.b;
            }
            Observable just = Observable.just(obj);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(value)");
            return just;
        }
    }

    @NotNull
    public final <T> Observable<T> notNull(@Nullable T t, @NotNull Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "fallback");
        Observable<T> defer = Observable.defer(new a(t, observable));
        Intrinsics.checkNotNullExpressionValue(defer, "Observable.defer {\n     …)\n            }\n        }");
        return defer;
    }
}
