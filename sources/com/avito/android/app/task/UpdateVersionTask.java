package com.avito.android.app.task;

import android.app.Application;
import android.os.Bundle;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.app_update.AppUpdateTask;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/task/UpdateVersionTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/service/short_task/app_update/AppUpdateTask;", "task", "Lcom/avito/android/service/short_task/app_update/AppUpdateTask;", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "taskScheduler", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "<init>", "(Lcom/avito/android/service/short_task/app_update/AppUpdateTask;Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class UpdateVersionTask implements ApplicationBackgroundStartupTask {
    public final AppUpdateTask task;
    public final ShortTaskExactScheduler taskScheduler;

    public UpdateVersionTask(@NotNull AppUpdateTask appUpdateTask, @NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(appUpdateTask, "task");
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        this.task = appUpdateTask;
        this.taskScheduler = shortTaskExactScheduler;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        AppUpdateTask appUpdateTask = this.task;
        Bundle bundle = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(bundle, "Bundle.EMPTY");
        appUpdateTask.initialize(bundle);
        if (!this.task.isAppUpdatePersisted()) {
            ShortTaskExactScheduler.DefaultImpls.schedule$default(this.taskScheduler, this.task, null, false, null, 14, null);
        }
    }
}
