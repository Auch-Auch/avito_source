package com.avito.android.navigation;

import com.avito.android.app.ActivityProvider;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NavigationTabProviderImpl_Factory implements Factory<NavigationTabProviderImpl> {
    public final Provider<ActivityProvider> a;
    public final Provider<ApplicationStartupTasksRegistry> b;

    public NavigationTabProviderImpl_Factory(Provider<ActivityProvider> provider, Provider<ApplicationStartupTasksRegistry> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NavigationTabProviderImpl_Factory create(Provider<ActivityProvider> provider, Provider<ApplicationStartupTasksRegistry> provider2) {
        return new NavigationTabProviderImpl_Factory(provider, provider2);
    }

    public static NavigationTabProviderImpl newInstance(ActivityProvider activityProvider, ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        return new NavigationTabProviderImpl(activityProvider, applicationStartupTasksRegistry);
    }

    @Override // javax.inject.Provider
    public NavigationTabProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
