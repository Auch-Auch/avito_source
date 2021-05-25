package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideHotSwapStatsdEventStorageFactory implements Factory<InHouseEventStorage<StatsdRecord>> {
    public final Provider<InMemoryEventStorage<StatsdRecord>> a;
    public final Provider<OnDiskEventStorage<StatsdRecord>> b;
    public final Provider<OverflowTrimmer<StatsdRecord>> c;

    public StatsdCommonModule_ProvideHotSwapStatsdEventStorageFactory(Provider<InMemoryEventStorage<StatsdRecord>> provider, Provider<OnDiskEventStorage<StatsdRecord>> provider2, Provider<OverflowTrimmer<StatsdRecord>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static StatsdCommonModule_ProvideHotSwapStatsdEventStorageFactory create(Provider<InMemoryEventStorage<StatsdRecord>> provider, Provider<OnDiskEventStorage<StatsdRecord>> provider2, Provider<OverflowTrimmer<StatsdRecord>> provider3) {
        return new StatsdCommonModule_ProvideHotSwapStatsdEventStorageFactory(provider, provider2, provider3);
    }

    public static InHouseEventStorage<StatsdRecord> provideHotSwapStatsdEventStorage(Provider<InMemoryEventStorage<StatsdRecord>> provider, Lazy<OnDiskEventStorage<StatsdRecord>> lazy, OverflowTrimmer<StatsdRecord> overflowTrimmer) {
        return (InHouseEventStorage) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideHotSwapStatsdEventStorage(provider, lazy, overflowTrimmer));
    }

    @Override // javax.inject.Provider
    public InHouseEventStorage<StatsdRecord> get() {
        return provideHotSwapStatsdEventStorage(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}
