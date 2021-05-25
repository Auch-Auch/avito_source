package com.avito.android.di.module;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvideApplicationBlockingStartupTasksFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final ApplicationDelegateModule a;
    public final Provider<List<ApplicationBlockingStartupTask>> b;
    public final Provider<List<ApplicationBlockingStartupTask>> c;
    public final Provider<List<ApplicationBlockingStartupTask>> d;
    public final Provider<List<ApplicationBlockingStartupTask>> e;
    public final Provider<List<ApplicationBlockingStartupTask>> f;
    public final Provider<Set<ApplicationBlockingStartupTask>> g;

    public ApplicationDelegateModule_ProvideApplicationBlockingStartupTasksFactory(ApplicationDelegateModule applicationDelegateModule, Provider<List<ApplicationBlockingStartupTask>> provider, Provider<List<ApplicationBlockingStartupTask>> provider2, Provider<List<ApplicationBlockingStartupTask>> provider3, Provider<List<ApplicationBlockingStartupTask>> provider4, Provider<List<ApplicationBlockingStartupTask>> provider5, Provider<Set<ApplicationBlockingStartupTask>> provider6) {
        this.a = applicationDelegateModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static ApplicationDelegateModule_ProvideApplicationBlockingStartupTasksFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<List<ApplicationBlockingStartupTask>> provider, Provider<List<ApplicationBlockingStartupTask>> provider2, Provider<List<ApplicationBlockingStartupTask>> provider3, Provider<List<ApplicationBlockingStartupTask>> provider4, Provider<List<ApplicationBlockingStartupTask>> provider5, Provider<Set<ApplicationBlockingStartupTask>> provider6) {
        return new ApplicationDelegateModule_ProvideApplicationBlockingStartupTasksFactory(applicationDelegateModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static List<ApplicationBlockingStartupTask> provideApplicationBlockingStartupTasks(ApplicationDelegateModule applicationDelegateModule, List<ApplicationBlockingStartupTask> list, List<ApplicationBlockingStartupTask> list2, List<ApplicationBlockingStartupTask> list3, List<ApplicationBlockingStartupTask> list4, List<ApplicationBlockingStartupTask> list5, Set<ApplicationBlockingStartupTask> set) {
        return (List) Preconditions.checkNotNullFromProvides(applicationDelegateModule.provideApplicationBlockingStartupTasks(list, list2, list3, list4, list5, set));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideApplicationBlockingStartupTasks(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
