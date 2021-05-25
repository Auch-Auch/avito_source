package com.avito.android.di.module;

import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ShortcutsTask;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ShortcutInfoFactory;
import com.avito.android.util.ShortcutManagerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class CoreTasksModule_ProvideShortcutsTaskFactory implements Factory<ShortcutsTask> {
    public final Provider<BuildInfo> a;
    public final Provider<ShortcutManagerFactory> b;
    public final Provider<ShortcutInfoFactory> c;
    public final Provider<Analytics> d;
    public final Provider<UserAdvertsTabTestGroup> e;

    public CoreTasksModule_ProvideShortcutsTaskFactory(Provider<BuildInfo> provider, Provider<ShortcutManagerFactory> provider2, Provider<ShortcutInfoFactory> provider3, Provider<Analytics> provider4, Provider<UserAdvertsTabTestGroup> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static CoreTasksModule_ProvideShortcutsTaskFactory create(Provider<BuildInfo> provider, Provider<ShortcutManagerFactory> provider2, Provider<ShortcutInfoFactory> provider3, Provider<Analytics> provider4, Provider<UserAdvertsTabTestGroup> provider5) {
        return new CoreTasksModule_ProvideShortcutsTaskFactory(provider, provider2, provider3, provider4, provider5);
    }

    @Nullable
    public static ShortcutsTask provideShortcutsTask(BuildInfo buildInfo, ShortcutManagerFactory shortcutManagerFactory, ShortcutInfoFactory shortcutInfoFactory, Analytics analytics, UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        return CoreTasksModule.INSTANCE.provideShortcutsTask(buildInfo, shortcutManagerFactory, shortcutInfoFactory, analytics, userAdvertsTabTestGroup);
    }

    @Override // javax.inject.Provider
    @Nullable
    public ShortcutsTask get() {
        return provideShortcutsTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
