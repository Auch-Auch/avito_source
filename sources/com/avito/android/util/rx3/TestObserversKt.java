package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.TestObserver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Observable;", "awaitAndGetFirstValue", "(Lio/reactivex/rxjava3/core/Observable;)Ljava/lang/Object;", "", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "awaitDoneAndGetValues", "(Lio/reactivex/rxjava3/core/Observable;JLjava/util/concurrent/TimeUnit;)Ljava/util/List;", "Lio/reactivex/rxjava3/core/Single;", "awaitDoneAndGetValue", "(Lio/reactivex/rxjava3/core/Single;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "rx"}, k = 2, mv = {1, 4, 2})
public final class TestObserversKt {
    public static final <T> T awaitAndGetFirstValue(@NotNull Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$awaitAndGetFirstValue");
        return ((TestObserver) observable.take(1).test().awaitCount(1)).values().get(0);
    }

    public static final <T> T awaitDoneAndGetValue(@NotNull Single<T> single, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(single, "$this$awaitDoneAndGetValue");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        return ((TestObserver) single.test().awaitDone(j, timeUnit)).values().get(0);
    }

    public static /* synthetic */ Object awaitDoneAndGetValue$default(Single single, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        Intrinsics.checkNotNullParameter(single, "$this$awaitDoneAndGetValue");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        return ((TestObserver) single.test().awaitDone(j, timeUnit)).values().get(0);
    }

    @NotNull
    public static final <T> List<T> awaitDoneAndGetValues(@NotNull Observable<T> observable, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(observable, "$this$awaitDoneAndGetValues");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        List<T> values = ((TestObserver) observable.test().awaitDone(j, timeUnit)).values();
        Intrinsics.checkNotNullExpressionValue(values, "test()\n        .awaitDon…meUnit)\n        .values()");
        return values;
    }

    public static /* synthetic */ List awaitDoneAndGetValues$default(Observable observable, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        Intrinsics.checkNotNullParameter(observable, "$this$awaitDoneAndGetValues");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        List values = ((TestObserver) observable.test().awaitDone(j, timeUnit)).values();
        Intrinsics.checkNotNullExpressionValue(values, "test()\n        .awaitDon…meUnit)\n        .values()");
        return values;
    }
}
