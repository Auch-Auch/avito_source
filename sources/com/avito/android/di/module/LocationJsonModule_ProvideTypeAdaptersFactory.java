package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class LocationJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {
    public final Provider<Features> a;

    public LocationJsonModule_ProvideTypeAdaptersFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static LocationJsonModule_ProvideTypeAdaptersFactory create(Provider<Features> provider) {
        return new LocationJsonModule_ProvideTypeAdaptersFactory(provider);
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(LocationJsonModule.provideTypeAdapters(features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters(this.a.get());
    }
}
