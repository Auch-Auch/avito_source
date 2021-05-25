package com.avito.android.di.module;

import com.avito.android.remote.parse.adapter.SearchDeviceResourcesProvider;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class SearchJsonModule_ProvideCommonTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {
    public final Provider<SearchDeviceResourcesProvider> a;

    public SearchJsonModule_ProvideCommonTypeAdapterFactoriesFactory(Provider<SearchDeviceResourcesProvider> provider) {
        this.a = provider;
    }

    public static SearchJsonModule_ProvideCommonTypeAdapterFactoriesFactory create(Provider<SearchDeviceResourcesProvider> provider) {
        return new SearchJsonModule_ProvideCommonTypeAdapterFactoriesFactory(provider);
    }

    public static Set<TypeAdapterFactory> provideCommonTypeAdapterFactories(SearchDeviceResourcesProvider searchDeviceResourcesProvider) {
        return (Set) Preconditions.checkNotNullFromProvides(SearchJsonModule.provideCommonTypeAdapterFactories(searchDeviceResourcesProvider));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCommonTypeAdapterFactories(this.a.get());
    }
}
