package com.avito.android.version_conflict.di.module;

import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.version_conflict.CheckConfigTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class VersionConflictTasksModule_ProvideForegroundTasksFactory implements Factory<List<ApplicationForegroundStartupTask>> {
    public final Provider<CheckConfigTask> a;

    public VersionConflictTasksModule_ProvideForegroundTasksFactory(Provider<CheckConfigTask> provider) {
        this.a = provider;
    }

    public static VersionConflictTasksModule_ProvideForegroundTasksFactory create(Provider<CheckConfigTask> provider) {
        return new VersionConflictTasksModule_ProvideForegroundTasksFactory(provider);
    }

    public static List<ApplicationForegroundStartupTask> provideForegroundTasks(CheckConfigTask checkConfigTask) {
        return (List) Preconditions.checkNotNullFromProvides(VersionConflictTasksModule.INSTANCE.provideForegroundTasks(checkConfigTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationForegroundStartupTask> get() {
        return provideForegroundTasks(this.a.get());
    }
}
