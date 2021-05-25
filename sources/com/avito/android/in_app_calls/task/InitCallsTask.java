package com.avito.android.in_app_calls.task;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.in_app_calls.logging.SendCallLogsWorker;
import com.avito.android.in_app_calls.workers.CallAvailabilityWorker;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/task/InitCallsTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "<init>", "(Lcom/avito/android/Features;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class InitCallsTask implements ApplicationBlockingStartupTask {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Features features;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/task/InitCallsTask$Companion;", "", "", "LIBRARY_NAME", "Ljava/lang/String;", "", "SEND_CALL_LOGS_DELAY_MS", "J", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public InitCallsTask(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "features");
        this.features = features2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        ApplicationStartupTask.ExecutionResult executionResult;
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (this.features.getCallsFastLibraryLoad().invoke().booleanValue()) {
            try {
                System.loadLibrary("jingle_peerconnection_so");
                executionResult = ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
            } catch (Exception e) {
                executionResult = new ApplicationStartupTask.ExecutionResult.Error("Can't load library", e);
            }
        } else {
            executionResult = ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
        }
        if (this.features.getCallsCheckAvailability().invoke().booleanValue()) {
            CallAvailabilityWorker.Companion.startWork$default(CallAvailabilityWorker.Companion, application, 0, 2, null);
        } else {
            CallAvailabilityWorker.Companion.stopWork(application);
        }
        if (this.features.getCallsSendLogs().invoke().booleanValue()) {
            SendCallLogsWorker.Companion.scheduleWork(application, Random.Default.nextLong(0, 30000));
        }
        return executionResult;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
