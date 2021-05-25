package com.avito.android.di.module;

import com.avito.android.app.task.ApplicationForegroundStartupTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvideApplicationForegroundStartupTasksFactory implements Factory<List<ApplicationForegroundStartupTask>> {
    public final ApplicationDelegateModule a;
    public final Provider<Set<ApplicationForegroundStartupTask>> b;
    public final Provider<List<ApplicationForegroundStartupTask>> c;
    public final Provider<List<ApplicationForegroundStartupTask>> d;
    public final Provider<List<ApplicationForegroundStartupTask>> e;

    public ApplicationDelegateModule_ProvideApplicationForegroundStartupTasksFactory(ApplicationDelegateModule applicationDelegateModule, Provider<Set<ApplicationForegroundStartupTask>> provider, Provider<List<ApplicationForegroundStartupTask>> provider2, Provider<List<ApplicationForegroundStartupTask>> provider3, Provider<List<ApplicationForegroundStartupTask>> provider4) {
        this.a = applicationDelegateModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ApplicationDelegateModule_ProvideApplicationForegroundStartupTasksFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<Set<ApplicationForegroundStartupTask>> provider, Provider<List<ApplicationForegroundStartupTask>> provider2, Provider<List<ApplicationForegroundStartupTask>> provider3, Provider<List<ApplicationForegroundStartupTask>> provider4) {
        return new ApplicationDelegateModule_ProvideApplicationForegroundStartupTasksFactory(applicationDelegateModule, provider, provider2, provider3, provider4);
    }

    public static List<ApplicationForegroundStartupTask> provideApplicationForegroundStartupTasks(ApplicationDelegateModule applicationDelegateModule, Set<ApplicationForegroundStartupTask> set, List<ApplicationForegroundStartupTask> list, List<ApplicationForegroundStartupTask> list2, List<ApplicationForegroundStartupTask> list3) {
        return (List) Preconditions.checkNotNullFromProvides(applicationDelegateModule.provideApplicationForegroundStartupTasks(set, list, list2, list3));
    }

    @Override // javax.inject.Provider
    public List<ApplicationForegroundStartupTask> get() {
        return provideApplicationForegroundStartupTasks(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
