package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.conversation.mvi.data.MessengerDbException;
import com.avito.android.messenger.di.MessengerDatabaseModuleKt;
import com.avito.android.messenger.util.DbMaintenance;
import com.avito.android.util.LogsT;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Map;
import javax.inject.Inject;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/app/task/MessengerDbMaintenanceTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "tracker", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerDbMaintenanceTask implements ApplicationBlockingStartupTask {
    public final MessengerErrorTracker tracker;

    @Inject
    public MessengerDbMaintenanceTask(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.tracker = new MessengerErrorTracker(analytics);
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @ExperimentalUnsignedTypes
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        LogsT.verbose$default("MessengerDbMaintenanceTask", "execute MessengerDbMaintenanceTask", null, 4, null);
        DbMaintenance dbMaintenance = new DbMaintenance(application, MessengerDatabaseModuleKt.MESSENGER_DATABASE_NAME);
        if (!dbMaintenance.getDbIsCorrupt()) {
            return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
        }
        LogsT.verbose$default("MessengerDbMaintenanceTask", "DB was corrupt on application start", null, 4, null);
        Map<String, Object> metaData = dbMaintenance.getMetaData(true);
        if (!dbMaintenance.getFileExists()) {
            return new ApplicationStartupTask.ExecutionResult.Error("DB was corrupt on application start", null, 2, null);
        }
        ErrorTracker.DefaultImpls.track$default(this.tracker, new MessengerDbException(dbMaintenance.getDbFileDeleted(), "DB was corrupt on application start", null, 4, null), null, metaData, 2, null);
        return new ApplicationStartupTask.ExecutionResult.Error("DB was corrupt on application start. File exists", null, 2, null);
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
