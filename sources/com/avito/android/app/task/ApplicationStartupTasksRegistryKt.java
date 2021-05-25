package com.avito.android.app.task;

import com.avito.android.app.task.ApplicationStartupTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a,\u0010\b\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\n\b\u0001\u0010\u0006\u0018\u0001*\u00020\u0003*\u00020\u0002H\b¢\u0006\u0004\b\b\u0010\t\u001a \u0010\n\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask;", "TASK", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "taskState", "(Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;)Lcom/avito/android/app/task/ApplicationStartupTask$State;", "STATE", "", "requireAtLeast", "(Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;)V", "requireAtLeastScheduled", "core_release"}, k = 2, mv = {1, 4, 2})
public final class ApplicationStartupTasksRegistryKt {
    public static final /* synthetic */ <TASK extends ApplicationStartupTask, STATE extends ApplicationStartupTask.State> void requireAtLeast(ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "$this$requireAtLeast");
        Intrinsics.reifiedOperationMarker(4, "TASK");
        Intrinsics.reifiedOperationMarker(4, "STATE");
        applicationStartupTasksRegistry.requireAtLeast(ApplicationStartupTask.class, ApplicationStartupTask.State.class);
    }

    public static final /* synthetic */ <TASK extends ApplicationStartupTask> void requireAtLeastScheduled(ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "$this$requireAtLeastScheduled");
        Intrinsics.reifiedOperationMarker(4, "TASK");
        applicationStartupTasksRegistry.requireAtLeast(ApplicationStartupTask.class, ApplicationStartupTask.State.Scheduled.class);
    }

    public static final /* synthetic */ <TASK extends ApplicationStartupTask> ApplicationStartupTask.State taskState(ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "$this$taskState");
        Intrinsics.reifiedOperationMarker(4, "TASK");
        return applicationStartupTasksRegistry.taskState(ApplicationStartupTask.class);
    }
}
