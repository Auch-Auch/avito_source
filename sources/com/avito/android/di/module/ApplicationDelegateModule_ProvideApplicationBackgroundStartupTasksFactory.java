package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvideApplicationBackgroundStartupTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final ApplicationDelegateModule a;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> b;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> c;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> d;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> e;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> f;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> g;
    public final Provider<Set<TypedLazy<? extends ApplicationBackgroundStartupTask>>> h;

    public ApplicationDelegateModule_ProvideApplicationBackgroundStartupTasksFactory(ApplicationDelegateModule applicationDelegateModule, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider2, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider3, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider4, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider5, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider6, Provider<Set<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider7) {
        this.a = applicationDelegateModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static ApplicationDelegateModule_ProvideApplicationBackgroundStartupTasksFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider2, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider3, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider4, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider5, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider6, Provider<Set<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider7) {
        return new ApplicationDelegateModule_ProvideApplicationBackgroundStartupTasksFactory(applicationDelegateModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideApplicationBackgroundStartupTasks(ApplicationDelegateModule applicationDelegateModule, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list2, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list3, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list4, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list5, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list6, Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> set) {
        return (List) Preconditions.checkNotNullFromProvides(applicationDelegateModule.provideApplicationBackgroundStartupTasks(list, list2, list3, list4, list5, list6, set));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideApplicationBackgroundStartupTasks(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
