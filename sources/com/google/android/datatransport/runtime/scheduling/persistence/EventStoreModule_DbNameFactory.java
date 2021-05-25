package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EventStoreModule_DbNameFactory implements Factory<String> {
    public static final EventStoreModule_DbNameFactory a = new EventStoreModule_DbNameFactory();

    public static EventStoreModule_DbNameFactory create() {
        return a;
    }

    public static String dbName() {
        return (String) Preconditions.checkNotNull("com.google.android.datatransport.events", "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public String get() {
        return dbName();
    }
}
