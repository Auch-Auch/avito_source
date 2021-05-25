package com.avito.android.in_app_calls.task;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.workers.CallAvailabilityUpdater;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/in_app_calls/task/InitCallClientTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "onAppStart", "()V", "onAppStop", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/permissions/PermissionStateProvider;", "permissionStateProvider", "Lcom/avito/android/permissions/PermissionStateProvider;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "Lcom/jakewharton/rxrelay3/Relay;", "", "appIsActiveStream", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "callAvailabilityUpdater", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/permissions/PermissionStateProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class InitCallClientTask implements ApplicationBackgroundStartupTask, LifecycleObserver {
    public final AccountStateProvider accountStateProvider;
    public final Relay<Boolean> appIsActiveStream;
    public final CallAvailabilityUpdater callAvailabilityUpdater;
    public final ErrorTracker errorTracker;
    public final PermissionStateProvider permissionStateProvider;
    public final SchedulersFactory3 schedulers;

    public static final class a implements Action {
        public final /* synthetic */ InitCallClientTask a;

        public a(InitCallClientTask initCallClientTask) {
            this.a = initCallClientTask;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
            lifecycleOwner.getLifecycle().addObserver(this.a);
        }
    }

    public static final class b<T> implements Predicate<Boolean> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            return Intrinsics.areEqual(bool, Boolean.TRUE);
        }
    }

    public static final class c<T, R> implements Function<Boolean, CompletableSource> {
        public final /* synthetic */ InitCallClientTask a;

        public c(InitCallClientTask initCallClientTask) {
            this.a = initCallClientTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Boolean bool) {
            Observable combineLatest = Observable.combineLatest(this.a.permissionStateProvider.observePermissionState("android.permission.RECORD_AUDIO"), this.a.accountStateProvider.userId(), new InitCallClientTask$execute$3$$special$$inlined$combineLatestWith$1());
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
            return combineLatest.distinctUntilChanged().flatMapCompletable(new a2.a.a.f1.g.a(this));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ InitCallClientTask a;

        public d(InitCallClientTask initCallClientTask) {
            this.a = initCallClientTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.errorTracker, new CallApiRequestException("Can't init calls", th), null, null, 6, null);
        }
    }

    @Inject
    public InitCallClientTask(@NotNull CallAvailabilityUpdater callAvailabilityUpdater2, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PermissionStateProvider permissionStateProvider2, @NotNull AccountStateProvider accountStateProvider2, @NotNull Features features, @NotNull ErrorTracker errorTracker2) {
        Intrinsics.checkNotNullParameter(callAvailabilityUpdater2, "callAvailabilityUpdater");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(permissionStateProvider2, "permissionStateProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider2, "accountStateProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(errorTracker2, "errorTracker");
        this.callAvailabilityUpdater = callAvailabilityUpdater2;
        this.schedulers = schedulersFactory3;
        this.permissionStateProvider = permissionStateProvider2;
        this.accountStateProvider = accountStateProvider2;
        this.errorTracker = errorTracker2;
        BehaviorRelay createDefault = BehaviorRelay.createDefault(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(true)");
        this.appIsActiveStream = createDefault;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    @SuppressLint({"CheckResult"})
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Completable.fromAction(new a(this)).subscribeOn(this.schedulers.mainThread()).andThen(this.appIsActiveStream).filter(b.a).switchMapCompletable(new c(this)).doOnError(new d(this)).onErrorComplete().subscribe();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppStart() {
        this.appIsActiveStream.accept(Boolean.TRUE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppStop() {
        this.appIsActiveStream.accept(Boolean.FALSE);
    }
}
