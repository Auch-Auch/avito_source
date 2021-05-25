package com.avito.android.app.task;

import com.avito.android.app.task.ApplicationStartupTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "Ljava/lang/Class;", "Lcom/avito/android/app/task/ApplicationStartupTask;", "taskType", "", "onSchedule", "(Ljava/lang/Class;)V", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "result", "onExecuted", "(Ljava/lang/Class;Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface MutableApplicationStartupTasksRegistry extends ApplicationStartupTasksRegistry {
    void onExecuted(@NotNull Class<? extends ApplicationStartupTask> cls, @NotNull ApplicationStartupTask.ExecutionResult executionResult);

    void onSchedule(@NotNull Class<? extends ApplicationStartupTask> cls);
}
