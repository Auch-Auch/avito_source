package com.avito.android.di.module;

import com.avito.android.app.task.DarkThemeTask;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideDarkThemeTaskFactory implements Factory<DarkThemeTask> {
    public final Provider<DarkThemeManager> a;
    public final Provider<DarkThemeConfig> b;

    public CoreTasksModule_ProvideDarkThemeTaskFactory(Provider<DarkThemeManager> provider, Provider<DarkThemeConfig> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreTasksModule_ProvideDarkThemeTaskFactory create(Provider<DarkThemeManager> provider, Provider<DarkThemeConfig> provider2) {
        return new CoreTasksModule_ProvideDarkThemeTaskFactory(provider, provider2);
    }

    public static DarkThemeTask provideDarkThemeTask(DarkThemeManager darkThemeManager, DarkThemeConfig darkThemeConfig) {
        return (DarkThemeTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.provideDarkThemeTask(darkThemeManager, darkThemeConfig));
    }

    @Override // javax.inject.Provider
    public DarkThemeTask get() {
        return provideDarkThemeTask(this.a.get(), this.b.get());
    }
}
