package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import dagger.internal.Factory;
import java.util.List;
public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {
    public static final EventStoreModule_SchemaVersionFactory a = new EventStoreModule_SchemaVersionFactory();

    public static EventStoreModule_SchemaVersionFactory create() {
        return a;
    }

    public static int schemaVersion() {
        List<SchemaManager.Migration> list = SchemaManager.c;
        return 4;
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
