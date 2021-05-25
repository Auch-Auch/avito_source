package com.avito.android.in_app_calls.workers;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.rxjava3.RxWorker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.workers.CallAvailabilityComponent;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityWorker;", "Landroidx/work/rxjava3/RxWorker;", "Lio/reactivex/rxjava3/core/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "callAvailabilityUpdater", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "getCallAvailabilityUpdater", "()Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "setCallAvailabilityUpdater", "(Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallAvailabilityWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    @Inject
    public CallAvailabilityUpdater callAvailabilityUpdater;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityWorker$Companion;", "", "Landroid/content/Context;", "context", "", "workPeriodMillis", "", "startWork", "(Landroid/content/Context;J)V", "stopWork", "(Landroid/content/Context;)V", "WORK_DEFAULT_PERIOD", "J", "", "WORK_NAME", "Ljava/lang/String;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ void startWork$default(Companion companion, Context context, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 36000000;
            }
            companion.startWork(context, j);
        }

        public final void startWork(@NotNull Context context, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            WorkRequest build2 = ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(CallAvailabilityWorker.class, j, TimeUnit.MILLISECONDS).setConstraints(build)).build();
            Intrinsics.checkNotNullExpressionValue(build2, "PeriodicWorkRequest.Buil…                 .build()");
            WorkManager.getInstance(context).enqueueUniquePeriodicWork("calls_availability_worker", ExistingPeriodicWorkPolicy.KEEP, (PeriodicWorkRequest) build2);
        }

        public final void stopWork(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager.getInstance(context).cancelUniqueWork("calls_availability_worker");
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ CallAvailabilityWorker a;

        public a(CallAvailabilityWorker callAvailabilityWorker) {
            this.a = callAvailabilityWorker;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.getAnalytics().track(new StatsdEvent.CountEvent("calls.availability.start", 0, 2, null));
        }
    }

    public static final class b<T, R> implements Function<Throwable, ListenableWorker.Result> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public ListenableWorker.Result apply(Throwable th) {
            return ListenableWorker.Result.failure();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallAvailabilityWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        CallAvailabilityComponent.Factory factory = DaggerCallAvailabilityComponent.factory();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        factory.create((CallAvailabilityComponentDependencies) ComponentDependenciesKt.getDependencies(CallAvailabilityComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(applicationContext))).inject(this);
    }

    @Override // androidx.work.rxjava3.RxWorker
    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        CallAvailabilityUpdater callAvailabilityUpdater2 = this.callAvailabilityUpdater;
        if (callAvailabilityUpdater2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callAvailabilityUpdater");
        }
        Single<ListenableWorker.Result> onErrorReturn = callAvailabilityUpdater2.updateAvailability(true).toSingleDefault(ListenableWorker.Result.success()).doOnSubscribe(new a(this)).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "callAvailabilityUpdater.…t.failure()\n            }");
        return onErrorReturn;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final CallAvailabilityUpdater getCallAvailabilityUpdater() {
        CallAvailabilityUpdater callAvailabilityUpdater2 = this.callAvailabilityUpdater;
        if (callAvailabilityUpdater2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callAvailabilityUpdater");
        }
        return callAvailabilityUpdater2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCallAvailabilityUpdater(@NotNull CallAvailabilityUpdater callAvailabilityUpdater2) {
        Intrinsics.checkNotNullParameter(callAvailabilityUpdater2, "<set-?>");
        this.callAvailabilityUpdater = callAvailabilityUpdater2;
    }
}
