package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StatsdCommonModule_ProvideInMemoryStatsdEventStorageFactory implements Factory<InMemoryEventStorage<StatsdRecord>> {

    public static final class a {
        public static final StatsdCommonModule_ProvideInMemoryStatsdEventStorageFactory a = new StatsdCommonModule_ProvideInMemoryStatsdEventStorageFactory();
    }

    public static StatsdCommonModule_ProvideInMemoryStatsdEventStorageFactory create() {
        return a.a;
    }

    public static InMemoryEventStorage<StatsdRecord> provideInMemoryStatsdEventStorage() {
        return (InMemoryEventStorage) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideInMemoryStatsdEventStorage());
    }

    @Override // javax.inject.Provider
    public InMemoryEventStorage<StatsdRecord> get() {
        return provideInMemoryStatsdEventStorage();
    }
}
