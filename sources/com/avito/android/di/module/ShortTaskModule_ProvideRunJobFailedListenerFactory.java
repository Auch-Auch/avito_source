package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.service.short_task.RunJobFailedListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShortTaskModule_ProvideRunJobFailedListenerFactory implements Factory<RunJobFailedListener> {
    public final ShortTaskModule a;
    public final Provider<Analytics> b;

    public ShortTaskModule_ProvideRunJobFailedListenerFactory(ShortTaskModule shortTaskModule, Provider<Analytics> provider) {
        this.a = shortTaskModule;
        this.b = provider;
    }

    public static ShortTaskModule_ProvideRunJobFailedListenerFactory create(ShortTaskModule shortTaskModule, Provider<Analytics> provider) {
        return new ShortTaskModule_ProvideRunJobFailedListenerFactory(shortTaskModule, provider);
    }

    public static RunJobFailedListener provideRunJobFailedListener(ShortTaskModule shortTaskModule, Analytics analytics) {
        return (RunJobFailedListener) Preconditions.checkNotNullFromProvides(shortTaskModule.provideRunJobFailedListener(analytics));
    }

    @Override // javax.inject.Provider
    public RunJobFailedListener get() {
        return provideRunJobFailedListener(this.a, this.b.get());
    }
}
