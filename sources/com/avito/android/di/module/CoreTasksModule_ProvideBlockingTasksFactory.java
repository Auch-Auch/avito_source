package com.avito.android.di.module;

import com.avito.android.app.task.ActivityListenerTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ConveyorConfigurationTask;
import com.avito.android.app.task.DarkThemeTask;
import com.avito.android.app.task.GlobalAnimationsStateTask;
import com.avito.android.app.task.InitFrescoTask;
import com.avito.android.app.task.InitRxTask;
import com.avito.android.app.task.SetDefaultLocaleTask;
import com.avito.android.app.task.SetupNotificationChannelsTask;
import com.avito.android.app.task.ShortcutsTask;
import com.avito.android.app.task.SubscribeToForegroundStateTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideBlockingTasksFactory implements Factory<Set<ApplicationBlockingStartupTask>> {
    public final Provider<InitRxTask> a;
    public final Provider<SetDefaultLocaleTask> b;
    public final Provider<InitFrescoTask> c;
    public final Provider<SubscribeToForegroundStateTask> d;
    public final Provider<ConveyorConfigurationTask> e;
    public final Provider<SetupNotificationChannelsTask> f;
    public final Provider<ActivityListenerTask> g;
    public final Provider<ShortcutsTask> h;
    public final Provider<DarkThemeTask> i;
    public final Provider<GlobalAnimationsStateTask> j;

    public CoreTasksModule_ProvideBlockingTasksFactory(Provider<InitRxTask> provider, Provider<SetDefaultLocaleTask> provider2, Provider<InitFrescoTask> provider3, Provider<SubscribeToForegroundStateTask> provider4, Provider<ConveyorConfigurationTask> provider5, Provider<SetupNotificationChannelsTask> provider6, Provider<ActivityListenerTask> provider7, Provider<ShortcutsTask> provider8, Provider<DarkThemeTask> provider9, Provider<GlobalAnimationsStateTask> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static CoreTasksModule_ProvideBlockingTasksFactory create(Provider<InitRxTask> provider, Provider<SetDefaultLocaleTask> provider2, Provider<InitFrescoTask> provider3, Provider<SubscribeToForegroundStateTask> provider4, Provider<ConveyorConfigurationTask> provider5, Provider<SetupNotificationChannelsTask> provider6, Provider<ActivityListenerTask> provider7, Provider<ShortcutsTask> provider8, Provider<DarkThemeTask> provider9, Provider<GlobalAnimationsStateTask> provider10) {
        return new CoreTasksModule_ProvideBlockingTasksFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static Set<ApplicationBlockingStartupTask> provideBlockingTasks(InitRxTask initRxTask, SetDefaultLocaleTask setDefaultLocaleTask, InitFrescoTask initFrescoTask, SubscribeToForegroundStateTask subscribeToForegroundStateTask, ConveyorConfigurationTask conveyorConfigurationTask, SetupNotificationChannelsTask setupNotificationChannelsTask, ActivityListenerTask activityListenerTask, ShortcutsTask shortcutsTask, DarkThemeTask darkThemeTask, GlobalAnimationsStateTask globalAnimationsStateTask) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideBlockingTasks(initRxTask, setDefaultLocaleTask, initFrescoTask, subscribeToForegroundStateTask, conveyorConfigurationTask, setupNotificationChannelsTask, activityListenerTask, shortcutsTask, darkThemeTask, globalAnimationsStateTask));
    }

    @Override // javax.inject.Provider
    public Set<ApplicationBlockingStartupTask> get() {
        return provideBlockingTasks(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
