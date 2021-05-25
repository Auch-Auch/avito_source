package com.avito.android.messenger.channels.mvi.common.v3;

import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ForkJoinPool;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\b\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/ForkJoinCommonPoolScheduler;", "", "Lio/reactivex/Scheduler;", "invoke", "()Lio/reactivex/Scheduler;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getValue", "value", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class ForkJoinCommonPoolScheduler {
    @NotNull
    public static final ForkJoinCommonPoolScheduler INSTANCE = new ForkJoinCommonPoolScheduler();
    @NotNull
    public static final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<Scheduler> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            Scheduler scheduler;
            if (Build.VERSION.SDK_INT >= 24) {
                scheduler = Schedulers.from(ForkJoinPool.commonPool());
            } else {
                scheduler = Schedulers.from(new ForkJoinPool());
            }
            Intrinsics.checkNotNullExpressionValue(scheduler, "when {\n            Build…)\n            }\n        }");
            return scheduler;
        }
    }

    @NotNull
    public final Scheduler getValue() {
        return (Scheduler) a.getValue();
    }

    @NotNull
    public final Scheduler invoke() {
        return getValue();
    }
}
