package com.avito.android.calls.voximplant.rx.core;

import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.ErrorAndDuration;
import com.avito.android.util.rx3.RetryWhenKt;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aC\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/reactivex/rxjava3/core/Scheduler;", "scheduler", "Lkotlin/Function1;", "Lcom/avito/android/util/rx3/ErrorAndDuration;", "", "actionOnRetry", "Lio/reactivex/rxjava3/functions/Function;", "Lio/reactivex/rxjava3/core/Flowable;", "", "", "exponentialRetryCallRequest", "(Lio/reactivex/rxjava3/core/Scheduler;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/functions/Function;", "calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallClientUtilsKt {

    public static final class a extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            Intrinsics.checkNotNullParameter(errorAndDuration, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            ErrorAndDuration errorAndDuration2 = errorAndDuration;
            Intrinsics.checkNotNullParameter(errorAndDuration2, "it");
            Logs.debug$default(LogTagsKt.TAG_IAC, "Request error [" + errorAndDuration2.getThrowable().getLocalizedMessage() + "], retry", null, 4, null);
            this.a.invoke(errorAndDuration2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Throwable, Boolean> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return Boolean.valueOf((th2 instanceof CallClientException) && ((CallClientException) th2).getNeedRetry());
        }
    }

    @NotNull
    public static final Function<Flowable<Throwable>, Flowable<Object>> exponentialRetryCallRequest(@NotNull Scheduler scheduler, @NotNull Function1<? super ErrorAndDuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "actionOnRetry");
        return RetryWhenKt.exponentialRetry$default(500, 3, scheduler, c.a, new b(function1), null, 0.0d, 96, null);
    }

    public static /* synthetic */ Function exponentialRetryCallRequest$default(Scheduler scheduler, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = a.a;
        }
        return exponentialRetryCallRequest(scheduler, function1);
    }
}
