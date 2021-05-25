package ru.avito.messenger.internal.di;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SchedulersModule_ProvideSchedulersFactory implements Factory<SchedulersFactory> {
    public final SchedulersModule a;

    public SchedulersModule_ProvideSchedulersFactory(SchedulersModule schedulersModule) {
        this.a = schedulersModule;
    }

    public static SchedulersModule_ProvideSchedulersFactory create(SchedulersModule schedulersModule) {
        return new SchedulersModule_ProvideSchedulersFactory(schedulersModule);
    }

    public static SchedulersFactory provideSchedulers(SchedulersModule schedulersModule) {
        return (SchedulersFactory) Preconditions.checkNotNullFromProvides(schedulersModule.provideSchedulers());
    }

    @Override // javax.inject.Provider
    public SchedulersFactory get() {
        return provideSchedulers(this.a);
    }
}
