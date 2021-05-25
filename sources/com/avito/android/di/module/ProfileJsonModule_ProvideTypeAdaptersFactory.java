package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ProfileJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {
    public final Provider<Features> a;

    public ProfileJsonModule_ProvideTypeAdaptersFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static ProfileJsonModule_ProvideTypeAdaptersFactory create(Provider<Features> provider) {
        return new ProfileJsonModule_ProvideTypeAdaptersFactory(provider);
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(ProfileJsonModule.provideTypeAdapters(features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters(this.a.get());
    }
}
