package com.avito.android.advert_details.remote;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AdvertDetailsJsonModule_ProvideCommonTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final AdvertDetailsJsonModule_ProvideCommonTypeAdapterFactoriesFactory a = new AdvertDetailsJsonModule_ProvideCommonTypeAdapterFactoriesFactory();
    }

    public static AdvertDetailsJsonModule_ProvideCommonTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideCommonTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(AdvertDetailsJsonModule.provideCommonTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCommonTypeAdapterFactories();
    }
}
