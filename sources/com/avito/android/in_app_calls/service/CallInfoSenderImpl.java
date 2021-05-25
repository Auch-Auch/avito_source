package com.avito.android.in_app_calls.service;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.ErrorAndDuration;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallInfoSenderImpl;", "Lcom/avito/android/in_app_calls/service/CallInfoSender;", "", "callId", "itemId", "caller", "recepient", "Lio/reactivex/rxjava3/core/Completable;", "sendCallInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "d", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallInfoSenderImpl implements CallInfoSender {
    public final CallsApi a;
    public final SchedulersFactory3 b;
    public final Analytics c;
    public final ErrorTracker d;

    public static final class a<T, R> implements Function<Unit, SingleSource<? extends TypedResult<Object>>> {
        public final /* synthetic */ CallInfoSenderImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(CallInfoSenderImpl callInfoSenderImpl, String str, String str2, String str3, String str4) {
            this.a = callInfoSenderImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends TypedResult<Object>> apply(Unit unit) {
            return this.a.a.requestStartCall(this.e, this.b, this.c, this.d);
        }
    }

    public static final class b extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public final /* synthetic */ CallInfoSenderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CallInfoSenderImpl callInfoSenderImpl) {
            super(1);
            this.a = callInfoSenderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            Intrinsics.checkNotNullParameter(errorAndDuration, "it");
            this.a.c.track(new StatsdEvent.CountEvent("calls.out.info.retry", 0, 2, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ CallInfoSenderImpl a;

        public c(CallInfoSenderImpl callInfoSenderImpl) {
            this.a = callInfoSenderImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.c.track(new StatsdEvent.CountEvent("calls.out.info.start", 0, 2, null));
        }
    }

    public static final class d<T> implements Consumer<Object> {
        public final /* synthetic */ CallInfoSenderImpl a;

        public d(CallInfoSenderImpl callInfoSenderImpl) {
            this.a = callInfoSenderImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            this.a.c.track(new StatsdEvent.CountEvent("calls.out.info.success", 0, 2, null));
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ CallInfoSenderImpl a;

        public e(CallInfoSenderImpl callInfoSenderImpl) {
            this.a = callInfoSenderImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.c.track(new StatsdEvent.CountEvent("calls.out.info.error", 0, 2, null));
            ErrorTracker.DefaultImpls.track$default(this.a.d, new CallApiRequestException("Can't send call info", th), null, null, 6, null);
        }
    }

    @Inject
    public CallInfoSenderImpl(@NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = callsApi;
        this.b = schedulersFactory3;
        this.c = analytics;
        this.d = errorTracker;
    }

    @Override // com.avito.android.in_app_calls.service.CallInfoSender
    @NotNull
    public Completable sendCallInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "callId", str2, "itemId", str3, "caller", str4, "recepient");
        Single retryWhen = Single.just(Unit.INSTANCE).flatMap(new a(this, str, str2, str3, str4)).subscribeOn(this.b.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry(this.b, new b(this)));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "Single.just(Unit).flatMa….retry\"))\n            }))");
        Single flatMap = retryWhen.flatMap(CallInfoSenderImpl$sendCallInfo$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Completable ignoreElement = flatMap.doOnSubscribe(new c(this)).doOnSuccess(new d(this)).doOnError(new e(this)).onErrorComplete().ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "Single.just(Unit).flatMa…         .ignoreElement()");
        return ignoreElement;
    }
}
