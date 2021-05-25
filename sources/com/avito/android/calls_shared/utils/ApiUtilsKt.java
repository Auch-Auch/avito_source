package com.avito.android.calls_shared.utils;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.ErrorAndDuration;
import com.avito.android.util.rx3.RetryWhenKt;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aC\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lkotlin/Function1;", "Lcom/avito/android/util/rx3/ErrorAndDuration;", "", "actionOnRetry", "Lio/reactivex/rxjava3/functions/Function;", "Lio/reactivex/rxjava3/core/Flowable;", "", "", "inAppCallsExponentialRetry", "(Lcom/avito/android/util/SchedulersFactory3;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/functions/Function;", "calls-shared_release"}, k = 2, mv = {1, 4, 2})
public final class ApiUtilsKt {

    public static final class a extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            Intrinsics.checkNotNullParameter(errorAndDuration, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.TRUE;
        }
    }

    @NotNull
    public static final Function<Flowable<Throwable>, Flowable<Object>> inAppCallsExponentialRetry(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull Function1<? super ErrorAndDuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(function1, "actionOnRetry");
        return RetryWhenKt.exponentialRetry$default(250, 3, schedulersFactory3.io(), b.a, function1, null, 0.0d, 96, null);
    }

    public static /* synthetic */ Function inAppCallsExponentialRetry$default(SchedulersFactory3 schedulersFactory3, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = a.a;
        }
        return inAppCallsExponentialRetry(schedulersFactory3, function1);
    }
}
