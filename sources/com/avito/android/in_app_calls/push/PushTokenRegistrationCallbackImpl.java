package com.avito.android.in_app_calls.push;

import com.avito.android.calls.push.PushTokenRegistrationCallback;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/in_app_calls/push/PushTokenRegistrationCallbackImpl;", "Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "Lio/reactivex/rxjava3/core/Completable;", "onPushTokenRegistered", "()Lio/reactivex/rxjava3/core/Completable;", "onPushTokenUnregistered", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "c", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class PushTokenRegistrationCallbackImpl implements PushTokenRegistrationCallback {
    public final CallsApi a;
    public final SchedulersFactory3 b;
    public final ErrorTracker c;

    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ PushTokenRegistrationCallbackImpl a;

        public a(PushTokenRegistrationCallbackImpl pushTokenRegistrationCallbackImpl) {
            this.a = pushTokenRegistrationCallbackImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.c, new CallApiRequestException("Can't register push token", th), null, null, 6, null);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PushTokenRegistrationCallbackImpl a;

        public b(PushTokenRegistrationCallbackImpl pushTokenRegistrationCallbackImpl) {
            this.a = pushTokenRegistrationCallbackImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.c, new CallApiRequestException("Can't unregister push token", th), null, null, 6, null);
        }
    }

    @Inject
    public PushTokenRegistrationCallbackImpl(@NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = callsApi;
        this.b = schedulersFactory3;
        this.c = errorTracker;
    }

    @Override // com.avito.android.calls.push.PushTokenRegistrationCallback
    @NotNull
    public Completable onPushTokenRegistered() {
        Observable<TypedResult<Object>> observeOn = this.a.onRegisterPushToken().subscribeOn(this.b.io()).observeOn(this.b.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.onRegisterPushToken(…schedulers.computation())");
        Completable doOnError = TypedObservablesKt.toTyped(observeOn).ignoreElements().retry(1).doOnError(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "api.onRegisterPushToken(…oken\", it))\n            }");
        return doOnError;
    }

    @Override // com.avito.android.calls.push.PushTokenRegistrationCallback
    @NotNull
    public Completable onPushTokenUnregistered() {
        Observable<TypedResult<Object>> observeOn = this.a.onUnregisterPushToken().subscribeOn(this.b.io()).observeOn(this.b.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.onUnregisterPushToke…schedulers.computation())");
        Completable doOnError = TypedObservablesKt.toTyped(observeOn).ignoreElements().retry(1).doOnError(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "api.onUnregisterPushToke…oken\", it))\n            }");
        return doOnError;
    }
}
