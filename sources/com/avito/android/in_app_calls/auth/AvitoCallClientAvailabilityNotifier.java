package com.avito.android.in_app_calls.auth;

import com.avito.android.Features;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.calls.push.PushTokenRegistrationCallback;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.models.CallAvailabilityNotifiedState;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\f\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/in_app_calls/auth/AvitoCallClientAvailabilityNotifier;", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "", "forced", "Lio/reactivex/rxjava3/core/Completable;", "notifyAvailable", "(Z)Lio/reactivex/rxjava3/core/Completable;", "notifyUnavailable", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "", "request", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "e", "Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "pushTokenRegistrationCallback", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "d", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/calls_shared/storage/CallStorage;", "f", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lcom/avito/android/calls/push/PushTokenRegistrationCallback;Lcom/avito/android/calls_shared/storage/CallStorage;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoCallClientAvailabilityNotifier implements CallClientAvailabilityNotifier {
    public final Features a;
    public final CallsApi b;
    public final SchedulersFactory3 c;
    public final ErrorTracker d;
    public final PushTokenRegistrationCallback e;
    public final CallStorage f;

    public static final class a implements Action {
        public final /* synthetic */ AvitoCallClientAvailabilityNotifier a;

        public a(AvitoCallClientAvailabilityNotifier avitoCallClientAvailabilityNotifier) {
            this.a = avitoCallClientAvailabilityNotifier;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.f.setCallAvailabilityNotifiedState(CallAvailabilityNotifiedState.AVAILABLE);
            Logs.debug$default(LogTagsKt.TAG_IAC, "Notify available - successfully", null, 4, null);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ AvitoCallClientAvailabilityNotifier a;

        public b(AvitoCallClientAvailabilityNotifier avitoCallClientAvailabilityNotifier) {
            this.a = avitoCallClientAvailabilityNotifier;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.f.setCallAvailabilityNotifiedState(CallAvailabilityNotifiedState.UNAVAILABLE);
            Logs.debug$default(LogTagsKt.TAG_IAC, "Notify unavailable - successfully", null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ AvitoCallClientAvailabilityNotifier a;

        public c(AvitoCallClientAvailabilityNotifier avitoCallClientAvailabilityNotifier) {
            this.a = avitoCallClientAvailabilityNotifier;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ErrorTracker.DefaultImpls.track$default(this.a.d, new CallApiRequestException("Can't mark device availability", th2), null, null, 6, null);
            Logs.error(LogTagsKt.TAG_IAC, "Can't notify", th2);
        }
    }

    @Inject
    public AvitoCallClientAvailabilityNotifier(@NotNull Features features, @NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorTracker errorTracker, @NotNull PushTokenRegistrationCallback pushTokenRegistrationCallback, @NotNull CallStorage callStorage) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(pushTokenRegistrationCallback, "pushTokenRegistrationCallback");
        Intrinsics.checkNotNullParameter(callStorage, "callStorage");
        this.a = features;
        this.b = callsApi;
        this.c = schedulersFactory3;
        this.d = errorTracker;
        this.e = pushTokenRegistrationCallback;
        this.f = callStorage;
    }

    public final Completable a(Single<TypedResult<Object>> single) {
        Single<TypedResult<Object>> retryWhen = single.retryWhen(ApiUtilsKt.inAppCallsExponentialRetry$default(this.c, null, 2, null));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "request\n            .ret…nentialRetry(schedulers))");
        Single<R> flatMap = retryWhen.flatMap(AvitoCallClientAvailabilityNotifier$processRequest$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Completable ignoreElement = flatMap.doOnError(new c(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "request\n            .ret…         .ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.calls.CallClientAvailabilityNotifier
    @NotNull
    public Completable notifyAvailable(boolean z) {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Notify available, forced=[" + z + "], state=[" + this.f.getCallAvailabilityNotifiedState() + ']', null, 4, null);
        if (!z && this.a.getCallsAvailabilityNotifiedState().invoke().booleanValue() && this.f.getCallAvailabilityNotifiedState() == CallAvailabilityNotifiedState.AVAILABLE) {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Notify available - skipped because already notified", null, 4, null);
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        } else if (!this.a.getCallsCheckAvailability().invoke().booleanValue()) {
            return this.e.onPushTokenRegistered();
        } else {
            Completable doOnComplete = a(this.b.meAvailable()).doOnComplete(new a(this));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "processRequest(callsApi.…fully\")\n                }");
            return doOnComplete;
        }
    }

    @Override // com.avito.android.calls.CallClientAvailabilityNotifier
    @NotNull
    public Completable notifyUnavailable(boolean z) {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Notify unavailable, forced=[" + z + "], state=[" + this.f.getCallAvailabilityNotifiedState() + ']', null, 4, null);
        if (!z && this.a.getCallsAvailabilityNotifiedState().invoke().booleanValue() && this.f.getCallAvailabilityNotifiedState() == CallAvailabilityNotifiedState.UNAVAILABLE) {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Notify unavailable - skipped because already notified", null, 4, null);
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        } else if (!this.a.getCallsCheckAvailability().invoke().booleanValue()) {
            return this.e.onPushTokenUnregistered();
        } else {
            Completable doOnComplete = a(this.b.meUnavailable()).doOnComplete(new b(this));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "processRequest(callsApi.…fully\")\n                }");
            return doOnComplete;
        }
    }
}
