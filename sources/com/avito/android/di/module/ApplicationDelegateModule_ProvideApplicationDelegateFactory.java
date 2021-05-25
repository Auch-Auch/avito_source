package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.account.AccountStorageMigrationManager;
import com.avito.android.app.ApplicationDelegate;
import com.avito.android.app.task.ApplicationStartupTasksExecutor;
import com.avito.android.app.task.SendStartupTimeTask;
import com.avito.android.enabler.RemoteFeaturesStartupMonitor;
import com.avito.android.preferences.migration.PreferencesMigrationManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvideApplicationDelegateFactory implements Factory<ApplicationDelegate> {
    public final ApplicationDelegateModule a;
    public final Provider<Application> b;
    public final Provider<ApplicationStartupTasksExecutor> c;
    public final Provider<AccountStorageMigrationManager> d;
    public final Provider<PreferencesMigrationManager> e;
    public final Provider<SendStartupTimeTask> f;
    public final Provider<RemoteFeaturesStartupMonitor> g;

    public ApplicationDelegateModule_ProvideApplicationDelegateFactory(ApplicationDelegateModule applicationDelegateModule, Provider<Application> provider, Provider<ApplicationStartupTasksExecutor> provider2, Provider<AccountStorageMigrationManager> provider3, Provider<PreferencesMigrationManager> provider4, Provider<SendStartupTimeTask> provider5, Provider<RemoteFeaturesStartupMonitor> provider6) {
        this.a = applicationDelegateModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static ApplicationDelegateModule_ProvideApplicationDelegateFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<Application> provider, Provider<ApplicationStartupTasksExecutor> provider2, Provider<AccountStorageMigrationManager> provider3, Provider<PreferencesMigrationManager> provider4, Provider<SendStartupTimeTask> provider5, Provider<RemoteFeaturesStartupMonitor> provider6) {
        return new ApplicationDelegateModule_ProvideApplicationDelegateFactory(applicationDelegateModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ApplicationDelegate provideApplicationDelegate(ApplicationDelegateModule applicationDelegateModule, Application application, ApplicationStartupTasksExecutor applicationStartupTasksExecutor, AccountStorageMigrationManager accountStorageMigrationManager, PreferencesMigrationManager preferencesMigrationManager, SendStartupTimeTask sendStartupTimeTask, RemoteFeaturesStartupMonitor remoteFeaturesStartupMonitor) {
        return (ApplicationDelegate) Preconditions.checkNotNullFromProvides(applicationDelegateModule.provideApplicationDelegate(application, applicationStartupTasksExecutor, accountStorageMigrationManager, preferencesMigrationManager, sendStartupTimeTask, remoteFeaturesStartupMonitor));
    }

    @Override // javax.inject.Provider
    public ApplicationDelegate get() {
        return provideApplicationDelegate(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
