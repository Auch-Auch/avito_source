package com.google.android.datatransport.runtime.scheduling.persistence;

import a2.j.b.a.c.m.d.c;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    public final Provider<Clock> a;
    public final Provider<Clock> b;
    public final Provider<c> c;
    public final Provider<SchemaManager> d;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<c> provider3, Provider<SchemaManager> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SQLiteEventStore_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<c> provider3, Provider<SchemaManager> provider4) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2) {
        return new SQLiteEventStore(clock, clock2, (c) obj, (SchemaManager) obj2);
    }

    @Override // javax.inject.Provider
    public SQLiteEventStore get() {
        return new SQLiteEventStore(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
