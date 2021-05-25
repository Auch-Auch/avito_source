package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a \u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Flowable;", "awaitAndGetFirstValue", "(Lio/reactivex/rxjava3/core/Flowable;)Ljava/lang/Object;", "", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "awaitDoneAndGetValues", "(Lio/reactivex/rxjava3/core/Flowable;JLjava/util/concurrent/TimeUnit;)Ljava/util/List;", "rx"}, k = 2, mv = {1, 4, 2})
public final class TestSubscribersKt {
    public static final <T> T awaitAndGetFirstValue(@NotNull Flowable<T> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$awaitAndGetFirstValue");
        return ((TestSubscriber) flowable.take(1).test().awaitCount(1)).values().get(0);
    }

    @NotNull
    public static final <T> List<T> awaitDoneAndGetValues(@NotNull Flowable<T> flowable, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(flowable, "$this$awaitDoneAndGetValues");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        List<T> values = ((TestSubscriber) flowable.test().awaitDone(j, timeUnit)).values();
        Intrinsics.checkNotNullExpressionValue(values, "test()\n        .awaitDon…meUnit)\n        .values()");
        return values;
    }

    public static /* synthetic */ List awaitDoneAndGetValues$default(Flowable flowable, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 100;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        Intrinsics.checkNotNullParameter(flowable, "$this$awaitDoneAndGetValues");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        List values = ((TestSubscriber) flowable.test().awaitDone(j, timeUnit)).values();
        Intrinsics.checkNotNullExpressionValue(values, "test()\n        .awaitDon…meUnit)\n        .values()");
        return values;
    }
}
