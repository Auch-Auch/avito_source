package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    public final Provider<Context> a;
    public final Provider<String> b;
    public final Provider<Integer> c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SchemaManager_Factory create(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    @Override // javax.inject.Provider
    public SchemaManager get() {
        return new SchemaManager(this.a.get(), this.b.get(), this.c.get().intValue());
    }
}
