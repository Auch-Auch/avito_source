package com.avito.android.remote.di;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class TnsGalleryImageJsonModule_ProvideCommonTypeAdapterFactoryFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final TnsGalleryImageJsonModule_ProvideCommonTypeAdapterFactoryFactory a = new TnsGalleryImageJsonModule_ProvideCommonTypeAdapterFactoryFactory();
    }

    public static TnsGalleryImageJsonModule_ProvideCommonTypeAdapterFactoryFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideCommonTypeAdapterFactory() {
        return (Set) Preconditions.checkNotNullFromProvides(TnsGalleryImageJsonModule.provideCommonTypeAdapterFactory());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCommonTypeAdapterFactory();
    }
}
