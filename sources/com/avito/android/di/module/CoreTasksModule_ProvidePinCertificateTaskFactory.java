package com.avito.android.di.module;

import com.avito.android.app.task.CheckRequestTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvidePinCertificateTaskFactory implements Factory<CheckRequestTask> {
    public final Provider<ShortTaskExactScheduler> a;

    public CoreTasksModule_ProvidePinCertificateTaskFactory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvidePinCertificateTaskFactory create(Provider<ShortTaskExactScheduler> provider) {
        return new CoreTasksModule_ProvidePinCertificateTaskFactory(provider);
    }

    public static CheckRequestTask providePinCertificateTask(ShortTaskExactScheduler shortTaskExactScheduler) {
        return (CheckRequestTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.providePinCertificateTask(shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public CheckRequestTask get() {
        return providePinCertificateTask(this.a.get());
    }
}
