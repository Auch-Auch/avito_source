package com.avito.android.version_conflict.di.module;

import android.content.Context;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.version_conflict.ConfigUpdatedRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VersionConflictTasksModule_ProvideConfigUpdatedRouterFactory implements Factory<ConfigUpdatedRouter> {
    public final Provider<Context> a;
    public final Provider<ActivityIntentFactory> b;

    public VersionConflictTasksModule_ProvideConfigUpdatedRouterFactory(Provider<Context> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VersionConflictTasksModule_ProvideConfigUpdatedRouterFactory create(Provider<Context> provider, Provider<ActivityIntentFactory> provider2) {
        return new VersionConflictTasksModule_ProvideConfigUpdatedRouterFactory(provider, provider2);
    }

    public static ConfigUpdatedRouter provideConfigUpdatedRouter(Context context, ActivityIntentFactory activityIntentFactory) {
        return (ConfigUpdatedRouter) Preconditions.checkNotNullFromProvides(VersionConflictTasksModule.provideConfigUpdatedRouter(context, activityIntentFactory));
    }

    @Override // javax.inject.Provider
    public ConfigUpdatedRouter get() {
        return provideConfigUpdatedRouter(this.a.get(), this.b.get());
    }
}
