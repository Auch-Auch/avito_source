package com.avito.android.public_profile.di.module;

import com.avito.android.Features;
import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublicProfileJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {
    public final Provider<Features> a;

    public PublicProfileJsonModule_ProvideTypeAdaptersFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static PublicProfileJsonModule_ProvideTypeAdaptersFactory create(Provider<Features> provider) {
        return new PublicProfileJsonModule_ProvideTypeAdaptersFactory(provider);
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(PublicProfileJsonModule.provideTypeAdapters(features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters(this.a.get());
    }
}
