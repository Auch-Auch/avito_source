package com.avito.android.in_app_calls.service;

import a2.a.a.f1.f.c;
import a2.a.a.f1.f.d;
import a2.a.a.f1.f.e;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.remote.CallInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010 ¨\u0006("}, d2 = {"Lcom/avito/android/in_app_calls/service/CallInfoLoaderImpl;", "Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "", "callUuid", "", "requestCallInfo", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callStateStream", "Lio/reactivex/rxjava3/disposables/Disposable;", "processRequests", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/avito/android/calls/remote/CallsApi;", "c", "Lcom/avito/android/calls/remote/CallsApi;", "api", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "f", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/CallInfo;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/Relay;", "getResultStream", "()Lcom/jakewharton/rxrelay3/Relay;", "resultStream", AuthSource.SEND_ABUSE, "requestStream", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallInfoLoaderImpl implements CallInfoLoader {
    public final Relay<String> a;
    @NotNull
    public final Relay<CallInfo> b;
    public final CallsApi c;
    public final Analytics d;
    public final SchedulersFactory3 e;
    public final ErrorTracker f;

    public static final class a<T, R> implements Function<String, SingleSource<? extends Option<? extends CallInfo>>> {
        public final /* synthetic */ CallInfoLoaderImpl a;
        public final /* synthetic */ Observable b;

        public a(CallInfoLoaderImpl callInfoLoaderImpl, Observable observable) {
            this.a = callInfoLoaderImpl;
            this.b = observable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Option<? extends CallInfo>> apply(String str) {
            String str2 = str;
            CallsApi callsApi = this.a.c;
            Intrinsics.checkNotNullExpressionValue(str2, "callUuid");
            return callsApi.getCallInfo(str2).subscribeOn(this.a.e.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry(this.a.e, new a2.a.a.f1.f.a(this))).flatMap(a2.a.a.f1.f.b.a).onErrorReturn(new c(this)).takeUntil(this.b.skip(1).filter(new d(str2)).firstOrError()).doOnSubscribe(new e(this));
        }
    }

    public static final class b<T> implements Consumer<Option<? extends CallInfo>> {
        public final /* synthetic */ CallInfoLoaderImpl a;

        public b(CallInfoLoaderImpl callInfoLoaderImpl) {
            this.a = callInfoLoaderImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Option<? extends CallInfo> option) {
            Option<? extends CallInfo> option2 = option;
            if (option2 instanceof None) {
                this.a.d.track(new StatsdEvent.CountEvent("calls.in.info.error", 0, 2, null));
            } else if (option2 instanceof Some) {
                this.a.d.track(new StatsdEvent.CountEvent("calls.in.info.success", 0, 2, null));
                this.a.getResultStream().accept((CallInfo) ((Some) option2).getT());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Inject
    public CallInfoLoaderImpl(@NotNull CallsApi callsApi, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "api");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.c = callsApi;
        this.d = analytics;
        this.e = schedulersFactory3;
        this.f = errorTracker;
        Relay<String> serialized = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "PublishRelay.create<T>().toSerialized()");
        this.a = serialized;
        Relay<CallInfo> serialized2 = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized2, "PublishRelay.create<T>().toSerialized()");
        this.b = serialized2;
    }

    @Override // com.avito.android.in_app_calls.service.CallInfoLoader
    @NotNull
    public Disposable processRequests(@NotNull Observable<CallState> observable) {
        Intrinsics.checkNotNullParameter(observable, "callStateStream");
        Disposable subscribe = this.a.observeOn(this.e.computation()).switchMapSingle(new a(this, observable)).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "requestStream\n          …          )\n            }");
        return subscribe;
    }

    @Override // com.avito.android.in_app_calls.service.CallInfoLoader
    public void requestCallInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        this.a.accept(str);
    }

    @Override // com.avito.android.in_app_calls.service.CallInfoLoader
    @NotNull
    public Relay<CallInfo> getResultStream() {
        return this.b;
    }
}
