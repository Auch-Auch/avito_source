package com.avito.android.in_app_calls.ui;

import a2.a.a.f1.h.b;
import a2.a.a.f1.h.c;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.Features;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.tracker.errors.CallUnexpectedException;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.remote.CallContactsResult;
import com.avito.android.remote.CallInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/in_app_calls/ui/CallInteractor;", "", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "request", "Lio/reactivex/rxjava3/core/Single;", "Larrow/core/Option;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Dial;", "startCallByRequest", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/calls/auth/UsernameProvider;", "d", "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "Lcom/avito/android/analytics/NetworkTypeProvider;", "c", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "f", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/calls/auth/UsernameProvider;Lcom/avito/android/Features;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallInteractor {
    public final CallsApi a;
    public final SchedulersFactory3 b;
    public final NetworkTypeProvider c;
    public final UsernameProvider d;
    public final Features e;
    public final ErrorTracker f;

    public static final class a<T, R> implements Function<Throwable, Option<? extends CallManagerService.StartRequest.Dial>> {
        public final /* synthetic */ CallInteractor a;

        public a(CallInteractor callInteractor) {
            this.a = callInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends CallManagerService.StartRequest.Dial> apply(Throwable th) {
            Throwable th2 = th;
            ErrorTracker.DefaultImpls.track$default(this.a.f, new CallUnexpectedException("Can't start call", th2), null, null, 6, null);
            Logs.error(LogTagsKt.TAG_CALL_INTERACTOR, "Can't start call :(", th2);
            return Option.Companion.empty();
        }
    }

    @Inject
    public CallInteractor(@NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull UsernameProvider usernameProvider, @NotNull Features features, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(usernameProvider, "usernameProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = callsApi;
        this.b = schedulersFactory3;
        this.c = networkTypeProvider;
        this.d = usernameProvider;
        this.e = features;
        this.f = errorTracker;
    }

    @NotNull
    public final Single<Option<CallManagerService.StartRequest.Dial>> startCallByRequest(@NotNull CallActivityRequest.Dial dial) {
        Single<R> single;
        Single<String> single2;
        Intrinsics.checkNotNullParameter(dial, "request");
        boolean z = false;
        if (dial instanceof CallActivityRequest.Dial.NewCall) {
            CallActivityRequest.Dial.NewCall newCall = (CallActivityRequest.Dial.NewCall) dial;
            if (this.e.getCallsDontDropCalls().invoke().booleanValue()) {
                String callAs = newCall.getCallAs();
                if (this.e.getCallsCanCallv4().invoke().booleanValue()) {
                    if (callAs == null || m.isBlank(callAs)) {
                        z = true;
                    }
                    if (z) {
                        single2 = this.d.getUsername();
                    } else {
                        single2 = Single.just(callAs);
                    }
                } else {
                    single2 = Single.just(callAs);
                }
                single = single2.map(new a2.a.a.f1.h.a(newCall));
                Intrinsics.checkNotNullExpressionValue(single, "loginRequest.map {\n     ….toOption()\n            }");
            } else {
                Single<TypedResult<Object>> observeOn = this.a.requestStartCall(newCall.getRecipient().getContact(), newCall.getCallUuid(), newCall.getItem().getItemId(), newCall.getCallAs()).subscribeOn(this.b.io()).observeOn(this.b.computation());
                Intrinsics.checkNotNullExpressionValue(observeOn, "callsApi.requestStartCal…schedulers.computation())");
                Single<R> flatMap = observeOn.flatMap(CallInteractor$prepareNewCall$$inlined$toTyped$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
                single = flatMap.doOnError(new b(this, newCall)).map(new c(newCall));
                Intrinsics.checkNotNullExpressionValue(single, "callsApi.requestStartCal…ption()\n                }");
            }
        } else if (dial instanceof CallActivityRequest.Dial.ByPreviousCall) {
            CallActivityRequest.Dial.ByPreviousCall byPreviousCall = (CallActivityRequest.Dial.ByPreviousCall) dial;
            String networkType = this.c.networkType();
            String prevCallUuid = byPreviousCall.getPrevCallUuid();
            Single<TypedResult<CallInfo>> retryWhen = this.a.getCallInfo(prevCallUuid).subscribeOn(this.b.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry$default(this.b, null, 2, null));
            Intrinsics.checkNotNullExpressionValue(retryWhen, "callsApi.getCallInfo(pre…nentialRetry(schedulers))");
            Single<R> flatMap2 = retryWhen.flatMap(CallInteractor$prepareRecall$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap2, "flatMap { it.toTypedSingle() }");
            Single<R> doOnError = flatMap2.doOnError(new p2(1, this, prevCallUuid));
            Single<TypedResult<CallContactsResult>> retryWhen2 = this.a.getCallContactsByPreviousCall(prevCallUuid, byPreviousCall.getCallUuid(), networkType).subscribeOn(this.b.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry$default(this.b, null, 2, null));
            Intrinsics.checkNotNullExpressionValue(retryWhen2, "callsApi.getCallContacts…nentialRetry(schedulers))");
            Single<R> flatMap3 = retryWhen2.flatMap(CallInteractor$prepareRecall$$inlined$toTyped$2.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap3, "flatMap { it.toTypedSingle() }");
            Intrinsics.checkNotNullExpressionValue(doOnError, "callInfoRequest");
            Single<R> zipWith = flatMap3.zipWith(doOnError, new BiFunction<CallContactsResult, CallInfo, R>() { // from class: com.avito.android.in_app_calls.ui.CallInteractor$prepareRecall$$inlined$zipWith$1
                @Override // io.reactivex.rxjava3.functions.BiFunction
                @NotNull
                public final R apply(CallContactsResult callContactsResult, CallInfo callInfo) {
                    CallerInfo callerInfo;
                    CallerInfo callerInfo2;
                    Intrinsics.checkExpressionValueIsNotNull(callContactsResult, "t");
                    Intrinsics.checkExpressionValueIsNotNull(callInfo, "u");
                    CallInfo callInfo2 = callInfo;
                    CallContactsResult callContactsResult2 = callContactsResult;
                    String callTo = callContactsResult2.getCallTo();
                    if (!callContactsResult2.getCallAvailable() || callTo == null) {
                        return (R) Option.Companion.empty();
                    }
                    if (Intrinsics.areEqual(callInfo2.getRecipient().getContact(), callTo)) {
                        callerInfo2 = new CallerInfo(callInfo2.getRecipient().getContact(), callInfo2.getRecipient().getDisplayName(), callInfo2.getRecipient().getImage());
                    } else if (Intrinsics.areEqual(callInfo2.getCaller().getContact(), callTo)) {
                        callerInfo2 = new CallerInfo(callInfo2.getCaller().getContact(), callInfo2.getCaller().getDisplayName(), callInfo2.getCaller().getImage());
                    } else {
                        callerInfo = new CallerInfo(callTo);
                        return (R) OptionKt.toOption(new CallManagerService.StartRequest.Dial(CallActivityRequest.Dial.ByPreviousCall.this.getCallUuid(), callerInfo, new ItemInfo(callInfo2.getItem().getId(), callInfo2.getItem().getTitle(), callInfo2.getItem().getPrice(), callInfo2.getItem().getImage()), callContactsResult2.getCallerName(), CallActivityRequest.Dial.ByPreviousCall.this.getScenario(), false));
                    }
                    callerInfo = callerInfo2;
                    return (R) OptionKt.toOption(new CallManagerService.StartRequest.Dial(CallActivityRequest.Dial.ByPreviousCall.this.getCallUuid(), callerInfo, new ItemInfo(callInfo2.getItem().getId(), callInfo2.getItem().getTitle(), callInfo2.getItem().getPrice(), callInfo2.getItem().getImage()), callContactsResult2.getCallerName(), CallActivityRequest.Dial.ByPreviousCall.this.getScenario(), false));
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
            single = zipWith.doOnError(new p2(0, this, byPreviousCall));
            Intrinsics.checkNotNullExpressionValue(single, "callsApi.getCallContacts…d}\", error)\n            }");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Single<Option<CallManagerService.StartRequest.Dial>> onErrorReturn = single.onErrorReturn(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "when (request) {\n       …ion.empty()\n            }");
        return onErrorReturn;
    }
}
