package com.avito.android.remote.di;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ExtendedProfileJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final ExtendedProfileJsonModule_ProvideTypeAdaptersFactory a = new ExtendedProfileJsonModule_ProvideTypeAdaptersFactory();
    }

    public static ExtendedProfileJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(ExtendedProfileJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
