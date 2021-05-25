package com.avito.android.version_conflict.di.module;

import com.avito.android.remote.ConfigApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.version_conflict.CheckConfigTask;
import com.avito.android.version_conflict.ConfigUpdatedRouter;
import com.avito.android.version_conflict.MutableConfigStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VersionConflictTasksModule_ProvideCheckConfigTaskFactory implements Factory<CheckConfigTask> {
    public final Provider<ConfigApi> a;
    public final Provider<MutableConfigStorage> b;
    public final Provider<ConfigUpdatedRouter> c;
    public final Provider<BuildInfo> d;
    public final Provider<SchedulersFactory> e;

    public VersionConflictTasksModule_ProvideCheckConfigTaskFactory(Provider<ConfigApi> provider, Provider<MutableConfigStorage> provider2, Provider<ConfigUpdatedRouter> provider3, Provider<BuildInfo> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static VersionConflictTasksModule_ProvideCheckConfigTaskFactory create(Provider<ConfigApi> provider, Provider<MutableConfigStorage> provider2, Provider<ConfigUpdatedRouter> provider3, Provider<BuildInfo> provider4, Provider<SchedulersFactory> provider5) {
        return new VersionConflictTasksModule_ProvideCheckConfigTaskFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static CheckConfigTask provideCheckConfigTask(ConfigApi configApi, MutableConfigStorage mutableConfigStorage, ConfigUpdatedRouter configUpdatedRouter, BuildInfo buildInfo, SchedulersFactory schedulersFactory) {
        return (CheckConfigTask) Preconditions.checkNotNullFromProvides(VersionConflictTasksModule.provideCheckConfigTask(configApi, mutableConfigStorage, configUpdatedRouter, buildInfo, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public CheckConfigTask get() {
        return provideCheckConfigTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
