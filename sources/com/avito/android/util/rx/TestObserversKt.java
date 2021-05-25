package com.avito.android.util.rx;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.observers.TestObserver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a4\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a:\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\f\u0010\r\u001a4\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a4\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0016\u001a\u00020\u0015*\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"T", "Lio/reactivex/Observable;", "Ljava/lang/Runnable;", "waitStrategy", "", "timeOut", "awaitAndGetFirstValue", "(Lio/reactivex/Observable;Ljava/lang/Runnable;J)Ljava/lang/Object;", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "awaitDoneAndGetValues", "(Lio/reactivex/Observable;JLjava/util/concurrent/TimeUnit;)Ljava/util/List;", "Lio/reactivex/Single;", "awaitDoneAndGetValue", "(Lio/reactivex/Single;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "", "awaitAndGetError", "(Lio/reactivex/Single;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Throwable;", "Lio/reactivex/Completable;", "", "awaitCompletion", "(Lio/reactivex/Completable;JLjava/util/concurrent/TimeUnit;)V", "rx"}, k = 2, mv = {1, 4, 2})
public final class TestObserversKt {
    @NotNull
    public static final <T> Throwable awaitAndGetError(@NotNull Single<T> single, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(single, "$this$awaitAndGetError");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        TestObserver<T> test = single.test();
        test.awaitTerminalEvent(j, timeUnit);
        Throwable th = test.errors().get(0);
        Intrinsics.checkNotNullExpressionValue(th, "observer.errors()[0]");
        return th;
    }

    public static /* synthetic */ Throwable awaitAndGetError$default(Single single, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        Intrinsics.checkNotNullParameter(single, "$this$awaitAndGetError");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        TestObserver test = single.test();
        test.awaitTerminalEvent(j, timeUnit);
        Throwable th = test.errors().get(0);
        Intrinsics.checkNotNullExpressionValue(th, "observer.errors()[0]");
        return th;
    }

    public static final <T> T awaitAndGetFirstValue(@NotNull Observable<T> observable, @NotNull Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(observable, "$this$awaitAndGetFirstValue");
        Intrinsics.checkNotNullParameter(runnable, "waitStrategy");
        return ((TestObserver) observable.take(1).test().awaitCount(1, runnable, j)).values().get(0);
    }

    public static /* synthetic */ Object awaitAndGetFirstValue$default(Observable observable, Runnable runnable, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = BaseTestConsumer.TestWaitStrategy.SLEEP_10MS;
        }
        if ((i & 2) != 0) {
            j = 2000;
        }
        Intrinsics.checkNotNullParameter(observable, "$this$awaitAndGetFirstValue");
        Intrinsics.checkNotNullParameter(runnable, "waitStrategy");
        return ((TestObserver) observable.take(1).test().awaitCount(1, runnable, j)).values().get(0);
    }

    public static final void awaitCompletion(@NotNull Completable completable, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(completable, "$this$awaitCompletion");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        ((TestObserver) completable.test().awaitDone(j, timeUnit)).assertComplete();
    }

    public static /* synthetic */ void awaitCompletion$default(Completable completable, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        Intrinsics.checkNotNullParameter(completable, "$this$awaitCompletion");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        ((TestObserver) completable.test().awaitDone(j, timeUnit)).assertComplete();
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
