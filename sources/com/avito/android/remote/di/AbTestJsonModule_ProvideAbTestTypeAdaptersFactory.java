package com.avito.android.remote.di;

import com.avito.android.util.OptimalTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AbTestJsonModule_ProvideAbTestTypeAdaptersFactory implements Factory<Set<OptimalTypeAdapterEntry>> {

    public static final class a {
        public static final AbTestJsonModule_ProvideAbTestTypeAdaptersFactory a = new AbTestJsonModule_ProvideAbTestTypeAdaptersFactory();
    }

    public static AbTestJsonModule_ProvideAbTestTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<OptimalTypeAdapterEntry> provideAbTestTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(AbTestJsonModule.provideAbTestTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<OptimalTypeAdapterEntry> get() {
        return provideAbTestTypeAdapters();
    }
}
