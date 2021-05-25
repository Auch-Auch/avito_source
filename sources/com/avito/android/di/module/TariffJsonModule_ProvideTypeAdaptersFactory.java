package com.avito.android.di.module;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class TariffJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final TariffJsonModule_ProvideTypeAdaptersFactory a = new TariffJsonModule_ProvideTypeAdaptersFactory();
    }

    public static TariffJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(TariffJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
