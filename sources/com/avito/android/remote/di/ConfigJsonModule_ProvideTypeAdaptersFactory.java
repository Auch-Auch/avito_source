package com.avito.android.remote.di;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ConfigJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final ConfigJsonModule_ProvideTypeAdaptersFactory a = new ConfigJsonModule_ProvideTypeAdaptersFactory();
    }

    public static ConfigJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(ConfigJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
