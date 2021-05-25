package com.avito.android.in_app_calls.logging;

import a2.a.a.f1.e.f;
import a2.a.a.f1.e.g;
import a2.a.a.f1.e.h;
import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.rxjava3.RxWorker;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.tracker.errors.CallCantSendLogException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.di.DaggerSendCallLogsComponent;
import com.avito.android.in_app_calls.di.SendCallLogsComponent;
import com.avito.android.in_app_calls.di.SendCallLogsDependencies;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006)"}, d2 = {"Lcom/avito/android/in_app_calls/logging/SendCallLogsWorker;", "Landroidx/work/rxjava3/RxWorker;", "Lio/reactivex/rxjava3/core/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "logFileProvider", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "getLogFileProvider", "()Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "setLogFileProvider", "(Lcom/avito/android/in_app_calls/logging/LogFileProvider;)V", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "getErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "setErrorTracker", "(Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "Lcom/avito/android/in_app_calls/logging/LogUploader;", "logUploader", "Lcom/avito/android/in_app_calls/logging/LogUploader;", "getLogUploader", "()Lcom/avito/android/in_app_calls/logging/LogUploader;", "setLogUploader", "(Lcom/avito/android/in_app_calls/logging/LogUploader;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class SendCallLogsWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    @Inject
    public ErrorTracker errorTracker;
    @Inject
    public LogFileProvider logFileProvider;
    @Inject
    public LogUploader logUploader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/logging/SendCallLogsWorker$Companion;", "", "Landroid/content/Context;", "context", "", "delayMillis", "", "scheduleWork", "(Landroid/content/Context;J)V", "", "RETRY_COUNT", "I", "", "TAG", "Ljava/lang/String;", "WORK_NAME", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ void scheduleWork$default(Companion companion, Context context, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 0;
            }
            companion.scheduleWork(context, j);
        }

        public final void scheduleWork(@NotNull Context context, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Logs.debug$default("SendCallLogsWorker", "Schedule new work, with delay=" + j + "ms", null, 4, null);
            Constraints build = new Constraints.Builder().setRequiresCharging(true).setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendCallLogsWorker.class);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) builder.setInitialDelay(j, timeUnit)).setConstraints(build)).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000, timeUnit)).build();
            Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…                 .build()");
            WorkManager.getInstance(context).enqueueUniqueWork("calls_send_logs", ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) build2);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<File, CompletableSource> {
        public final /* synthetic */ SendCallLogsWorker a;
        public final /* synthetic */ List b;

        public a(SendCallLogsWorker sendCallLogsWorker, List list) {
            this.a = sendCallLogsWorker;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(File file) {
            File file2 = file;
            LogUploader logUploader = this.a.getLogUploader();
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            return logUploader.uploadLogs(file2).doOnSubscribe(new f(this, file2)).doOnError(new g(file2)).doOnComplete(new h(file2));
        }
    }

    public static final class b<T, R> implements Function<Throwable, ListenableWorker.Result> {
        public final /* synthetic */ SendCallLogsWorker a;

        public b(SendCallLogsWorker sendCallLogsWorker) {
            this.a = sendCallLogsWorker;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ListenableWorker.Result apply(Throwable th) {
            Throwable th2 = th;
            Logs.error("SendCallLogsWorker", "Uploading failed", th2);
            ErrorTracker.DefaultImpls.track$default(this.a.getErrorTracker(), new CallCantSendLogException(th2), null, null, 6, null);
            if (this.a.getRunAttemptCount() <= 3) {
                StringBuilder L = a2.b.a.a.a.L("Retry upload, attempt=");
                L.append(this.a.getRunAttemptCount());
                Logs.debug$default("SendCallLogsWorker", L.toString(), null, 4, null);
                return ListenableWorker.Result.retry();
            }
            Logs.debug$default("SendCallLogsWorker", "Complete upload with error", null, 4, null);
            return ListenableWorker.Result.failure();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendCallLogsWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        SendCallLogsComponent.Factory factory = DaggerSendCallLogsComponent.factory();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        factory.create((SendCallLogsDependencies) ComponentDependenciesKt.getDependencies(SendCallLogsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(applicationContext))).inject(this);
    }

    @Override // androidx.work.rxjava3.RxWorker
    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        StringBuilder L = a2.b.a.a.a.L("Create work, attempt=[");
        L.append(getRunAttemptCount());
        L.append(']');
        Logs.debug$default("SendCallLogsWorker", L.toString(), null, 4, null);
        LogFileProvider logFileProvider2 = this.logFileProvider;
        if (logFileProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logFileProvider");
        }
        List<File> listAllLogs = logFileProvider2.listAllLogs();
        if (listAllLogs.isEmpty()) {
            Logs.debug$default("SendCallLogsWorker", "Call logs wasn't found, nothing to do.", null, 4, null);
            Single<ListenableWorker.Result> just = Single.just(ListenableWorker.Result.success());
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(Result.success())");
            return just;
        }
        StringBuilder L2 = a2.b.a.a.a.L("Start upload [");
        L2.append(listAllLogs.size());
        L2.append("] logs.");
        Logs.debug$default("SendCallLogsWorker", L2.toString(), null, 4, null);
        Single<ListenableWorker.Result> onErrorReturn = Observable.fromIterable(listAllLogs).concatMapCompletable(new a(this, listAllLogs)).toSingleDefault(ListenableWorker.Result.success()).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "Observable.fromIterable(…          }\n            }");
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
    public final ErrorTracker getErrorTracker() {
        ErrorTracker errorTracker2 = this.errorTracker;
        if (errorTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTracker");
        }
        return errorTracker2;
    }

    @NotNull
    public final LogFileProvider getLogFileProvider() {
        LogFileProvider logFileProvider2 = this.logFileProvider;
        if (logFileProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logFileProvider");
        }
        return logFileProvider2;
    }

    @NotNull
    public final LogUploader getLogUploader() {
        LogUploader logUploader2 = this.logUploader;
        if (logUploader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logUploader");
        }
        return logUploader2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setErrorTracker(@NotNull ErrorTracker errorTracker2) {
        Intrinsics.checkNotNullParameter(errorTracker2, "<set-?>");
        this.errorTracker = errorTracker2;
    }

    public final void setLogFileProvider(@NotNull LogFileProvider logFileProvider2) {
        Intrinsics.checkNotNullParameter(logFileProvider2, "<set-?>");
        this.logFileProvider = logFileProvider2;
    }

    public final void setLogUploader(@NotNull LogUploader logUploader2) {
        Intrinsics.checkNotNullParameter(logUploader2, "<set-?>");
        this.logUploader = logUploader2;
    }
}
