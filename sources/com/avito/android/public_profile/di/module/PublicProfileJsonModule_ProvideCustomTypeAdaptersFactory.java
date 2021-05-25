package com.avito.android.public_profile.di.module;

import com.avito.android.Features;
import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublicProfileJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {
    public final Provider<Features> a;

    public PublicProfileJsonModule_ProvideCustomTypeAdaptersFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static PublicProfileJsonModule_ProvideCustomTypeAdaptersFactory create(Provider<Features> provider) {
        return new PublicProfileJsonModule_ProvideCustomTypeAdaptersFactory(provider);
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(PublicProfileJsonModule.provideCustomTypeAdapters(features));
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters(this.a.get());
    }
}
