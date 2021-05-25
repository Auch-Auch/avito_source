package com.avito.android.in_app_calls.workers;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdaterImpl;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "", "force", "Lio/reactivex/rxjava3/core/Completable;", "updateAvailability", "(Z)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/in_app_calls/CallManager;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/permissions/PermissionChecker;", "d", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "e", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "notifier", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/in_app_calls/CallManager;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/calls/CallClientAvailabilityNotifier;Lcom/avito/android/util/SchedulersFactory3;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallAvailabilityUpdaterImpl implements CallAvailabilityUpdater {
    public final Features a;
    public final CallManager b;
    public final AccountStateProvider c;
    public final PermissionChecker d;
    public final CallClientAvailabilityNotifier e;
    public final SchedulersFactory3 f;

    public static final class a<V> implements Callable<Pair<? extends Boolean, ? extends String>> {
        public final /* synthetic */ CallAvailabilityUpdaterImpl a;

        public a(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl) {
            this.a = callAvailabilityUpdaterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Pair<? extends Boolean, ? extends String> call() {
            boolean checkPermission = this.a.d.checkPermission("android.permission.RECORD_AUDIO");
            return new Pair<>(Boolean.valueOf(checkPermission), this.a.c.getCurrentUserId());
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            Logs.debug$default("CallAvailabilityUpdater", "Started", null, 4, null);
        }
    }

    public static final class c<T, R> implements Function<Pair<? extends Boolean, ? extends String>, CompletableSource> {
        public final /* synthetic */ CallAvailabilityUpdaterImpl a;
        public final /* synthetic */ boolean b;

        public c(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl, boolean z) {
            this.a = callAvailabilityUpdaterImpl;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Pair<? extends Boolean, ? extends String> pair) {
            Pair<? extends Boolean, ? extends String> pair2 = pair;
            boolean booleanValue = ((Boolean) pair2.component1()).booleanValue();
            String str = (String) pair2.component2();
            Logs.debug$default("CallAvailabilityUpdater", "permission=[" + booleanValue + "], userId=[" + str + ']', null, 4, null);
            if (str == null || !(!m.isBlank(str))) {
                return CallAvailabilityUpdaterImpl.access$unregisterForCalls(this.a, false);
            }
            if (booleanValue) {
                return CallAvailabilityUpdaterImpl.access$registerForCalls(this.a, str, this.b);
            }
            return CallAvailabilityUpdaterImpl.access$unregisterForCalls(this.a, true);
        }
    }

    @Inject
    public CallAvailabilityUpdaterImpl(@NotNull Features features, @NotNull CallManager callManager, @NotNull AccountStateProvider accountStateProvider, @NotNull PermissionChecker permissionChecker, @NotNull CallClientAvailabilityNotifier callClientAvailabilityNotifier, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(callManager, "callManager");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(callClientAvailabilityNotifier, "notifier");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = features;
        this.b = callManager;
        this.c = accountStateProvider;
        this.d = permissionChecker;
        this.e = callClientAvailabilityNotifier;
        this.f = schedulersFactory3;
    }

    public static final Completable access$registerForCalls(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl, String str, boolean z) {
        Completable completable;
        Objects.requireNonNull(callAvailabilityUpdaterImpl);
        Completable fromCallable = Completable.fromCallable(new a2.a.a.f1.i.a(callAvailabilityUpdaterImpl, str));
        if (z) {
            completable = callAvailabilityUpdaterImpl.e.notifyAvailable(true);
        } else {
            completable = Completable.complete();
        }
        Completable andThen = fromCallable.andThen(completable);
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromCallable…          }\n            )");
        return andThen;
    }

    public static final Completable access$unregisterForCalls(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl, boolean z) {
        Completable completable;
        Objects.requireNonNull(callAvailabilityUpdaterImpl);
        Completable fromCallable = Completable.fromCallable(new a2.a.a.f1.i.b(callAvailabilityUpdaterImpl));
        if (!z || !callAvailabilityUpdaterImpl.a.getCallsAvailabilityNotifiedState().invoke().booleanValue()) {
            completable = Completable.complete();
        } else {
            completable = callAvailabilityUpdaterImpl.e.notifyUnavailable(false);
        }
        Completable andThen = fromCallable.andThen(completable);
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromCallable…          }\n            )");
        return andThen;
    }

    @Override // com.avito.android.in_app_calls.workers.CallAvailabilityUpdater
    @NotNull
    public Completable updateAvailability(boolean z) {
        Completable onErrorComplete = Single.fromCallable(new a(this)).subscribeOn(this.f.io()).doOnSubscribe(b.a).flatMapCompletable(new c(this, z)).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "Single.fromCallable {\n  …       .onErrorComplete()");
        return onErrorComplete;
    }
}
