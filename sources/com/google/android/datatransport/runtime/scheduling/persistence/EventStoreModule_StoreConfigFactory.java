package com.google.android.datatransport.runtime.scheduling.persistence;

import a2.j.b.a.c.m.d.c;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EventStoreModule_StoreConfigFactory implements Factory<c> {
    public static final EventStoreModule_StoreConfigFactory a = new EventStoreModule_StoreConfigFactory();

    public static EventStoreModule_StoreConfigFactory create() {
        return a;
    }

    public static c storeConfig() {
        return (c) Preconditions.checkNotNull(c.a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public c get() {
        return storeConfig();
    }
}
