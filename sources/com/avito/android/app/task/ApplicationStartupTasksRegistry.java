package com.avito.android.app.task;

import com.avito.android.app.task.ApplicationStartupTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "", "Ljava/lang/Class;", "Lcom/avito/android/app/task/ApplicationStartupTask;", "taskType", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "taskState", "(Ljava/lang/Class;)Lcom/avito/android/app/task/ApplicationStartupTask$State;", "state", "", "requireAtLeast", "(Ljava/lang/Class;Ljava/lang/Class;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicationStartupTasksRegistry {
    void requireAtLeast(@NotNull Class<? extends ApplicationStartupTask> cls, @NotNull Class<? extends ApplicationStartupTask.State> cls2);

    @NotNull
    ApplicationStartupTask.State taskState(@NotNull Class<? extends ApplicationStartupTask> cls);
}
