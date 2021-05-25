package com.avito.android.in_app_calls.service;

import a2.a.a.f1.f.k;
import a2.a.a.f1.f.l;
import a2.a.a.f1.f.m;
import a2.a.a.f1.f.n;
import a2.a.a.f1.f.o;
import a2.a.a.f1.f.q;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001-B)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b+\u0010,J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl;", "Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", "Lcom/avito/android/calls_shared/AppCallInfo;", "call", "Lcom/avito/android/calls_shared/AppCallResult;", "result", "", "url", "", "requestReconnect", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Ljava/lang/String;)Z", "Lio/reactivex/Observable;", "clientConnectedStream", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callStateStream", "Lio/reactivex/disposables/Disposable;", "processReconnectRequests", "(Lio/reactivex/Observable;Lio/reactivex/Observable;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/in_app_calls/service/ReconnectClient;", "c", "Lcom/avito/android/in_app_calls/service/ReconnectClient;", "reconnectClient", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl$ReconnectRequest;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "requestStream", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "f", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "analyticsTracker", AuthSource.BOOKING_ORDER, "getReconnectFailures", "()Lcom/jakewharton/rxrelay2/Relay;", "reconnectFailures", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/in_app_calls/service/ReconnectClient;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;)V", "ReconnectRequest", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReconnectHandlerImpl implements CallReconnectHandler {
    public final Relay<ReconnectRequest> a = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    @NotNull
    public final Relay<String> b = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final ReconnectClient c;
    public final TimeSource d;
    public final SchedulersFactory e;
    public final CallAnalyticsTracker f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl$ReconnectRequest;", "", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Ljava/lang/String;", "call", "reconnectUrl", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;)Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl$ReconnectRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getReconnectUrl", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReconnectRequest {
        @NotNull
        public final AppCallInfo a;
        @NotNull
        public final String b;

        public ReconnectRequest(@NotNull AppCallInfo appCallInfo, @NotNull String str) {
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            Intrinsics.checkNotNullParameter(str, "reconnectUrl");
            this.a = appCallInfo;
            this.b = str;
        }

        public static /* synthetic */ ReconnectRequest copy$default(ReconnectRequest reconnectRequest, AppCallInfo appCallInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                appCallInfo = reconnectRequest.a;
            }
            if ((i & 2) != 0) {
                str = reconnectRequest.b;
            }
            return reconnectRequest.copy(appCallInfo, str);
        }

        @NotNull
        public final AppCallInfo component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ReconnectRequest copy(@NotNull AppCallInfo appCallInfo, @NotNull String str) {
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            Intrinsics.checkNotNullParameter(str, "reconnectUrl");
            return new ReconnectRequest(appCallInfo, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReconnectRequest)) {
                return false;
            }
            ReconnectRequest reconnectRequest = (ReconnectRequest) obj;
            return Intrinsics.areEqual(this.a, reconnectRequest.a) && Intrinsics.areEqual(this.b, reconnectRequest.b);
        }

        @NotNull
        public final AppCallInfo getCall() {
            return this.a;
        }

        @NotNull
        public final String getReconnectUrl() {
            return this.b;
        }

        public int hashCode() {
            AppCallInfo appCallInfo = this.a;
            int i = 0;
            int hashCode = (appCallInfo != null ? appCallInfo.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ReconnectRequest(call=");
            L.append(this.a);
            L.append(", reconnectUrl=");
            return a2.b.a.a.a.t(L, this.b, ")");
        }
    }

    public static final class a<T, R> implements Function<ReconnectRequest, CompletableSource> {
        public final /* synthetic */ CallReconnectHandlerImpl a;
        public final /* synthetic */ Observable b;
        public final /* synthetic */ Observable c;

        public a(CallReconnectHandlerImpl callReconnectHandlerImpl, Observable observable, Observable observable2) {
            this.a = callReconnectHandlerImpl;
            this.b = observable;
            this.c = observable2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(ReconnectRequest reconnectRequest) {
            ReconnectRequest reconnectRequest2 = reconnectRequest;
            Intrinsics.checkNotNullParameter(reconnectRequest2, "<name for destructuring parameter 0>");
            AppCallInfo component1 = reconnectRequest2.component1();
            String component2 = reconnectRequest2.component2();
            String callId = component1.getCallId();
            Long endTimestamp = component1.getEndTimestamp();
            if (55000 - (this.a.d.now() - (endTimestamp != null ? endTimestamp.longValue() : 0)) > 0) {
                return this.b.switchMapCompletable(new l(this, component2, callId, component1)).doOnError(new m(this, component1)).onErrorComplete().takeUntil(CallReconnectHandlerImpl.access$awaitForNewCallOrIdle(this.a, this.c, callId).doOnComplete(new n(this)));
            }
            return Completable.fromAction(new o(this, component1));
        }
    }

    @Inject
    public CallReconnectHandlerImpl(@NotNull ReconnectClient reconnectClient, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull CallAnalyticsTracker callAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(reconnectClient, "reconnectClient");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "analyticsTracker");
        this.c = reconnectClient;
        this.d = timeSource;
        this.e = schedulersFactory;
        this.f = callAnalyticsTracker;
    }

    public static final Completable access$awaitForNewCallOrIdle(CallReconnectHandlerImpl callReconnectHandlerImpl, Observable observable, String str) {
        Completable ignoreElements = observable.observeOn(callReconnectHandlerImpl.e.computation()).takeUntil(new k(str)).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "observeOn(schedulers.com…        .ignoreElements()");
        return ignoreElements;
    }

    public static final long access$expirationTimeout(CallReconnectHandlerImpl callReconnectHandlerImpl, AppCallInfo appCallInfo) {
        Objects.requireNonNull(callReconnectHandlerImpl);
        Long endTimestamp = appCallInfo.getEndTimestamp();
        return e.coerceIn(55000 - (callReconnectHandlerImpl.d.now() - (endTimestamp != null ? endTimestamp.longValue() : 0)), 0L, 55000L);
    }

    public static final Completable access$requestReconnectWithRetry(CallReconnectHandlerImpl callReconnectHandlerImpl, String str, String str2) {
        Completable ignoreElement = callReconnectHandlerImpl.c.requestReconnect(str, str2).observeOn(callReconnectHandlerImpl.e.computation()).retryWhen(new q(callReconnectHandlerImpl)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "reconnectClient.requestR…         .ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.in_app_calls.service.CallReconnectHandler
    @NotNull
    public Disposable processReconnectRequests(@NotNull Observable<Boolean> observable, @NotNull Observable<CallState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "clientConnectedStream");
        Intrinsics.checkNotNullParameter(observable2, "callStateStream");
        Disposable subscribe = this.a.switchMapCompletable(new a(this, observable, observable2)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "requestStream\n          …\n            .subscribe()");
        return subscribe;
    }

    @Override // com.avito.android.in_app_calls.service.CallReconnectHandler
    public boolean requestReconnect(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable String str) {
        Intrinsics.checkNotNullParameter(appCallInfo, "call");
        Intrinsics.checkNotNullParameter(appCallResult, "result");
        if (str == null || !(appCallResult instanceof AppCallResult.Error)) {
            return false;
        }
        Long endTimestamp = appCallInfo.getEndTimestamp();
        if (e.coerceIn(55000 - (this.d.now() - (endTimestamp != null ? endTimestamp.longValue() : 0)), 0, 55000) == 0) {
            return false;
        }
        this.f.trackReconnectStarted();
        this.a.accept(new ReconnectRequest(appCallInfo, str));
        return true;
    }

    @Override // com.avito.android.in_app_calls.service.CallReconnectHandler
    @NotNull
    public Relay<String> getReconnectFailures() {
        return this.b;
    }
}
