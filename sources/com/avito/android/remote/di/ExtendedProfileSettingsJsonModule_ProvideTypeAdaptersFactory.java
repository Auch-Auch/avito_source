package com.avito.android.remote.di;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ExtendedProfileSettingsJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final ExtendedProfileSettingsJsonModule_ProvideTypeAdaptersFactory a = new ExtendedProfileSettingsJsonModule_ProvideTypeAdaptersFactory();
    }

    public static ExtendedProfileSettingsJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(ExtendedProfileSettingsJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
