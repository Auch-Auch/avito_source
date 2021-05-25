package com.avito.android.publish.di;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class GsonModule_ProvideTypeAdapterFactoryFactory implements Factory<TypeAdapterFactory> {
    public final GsonModule a;

    public GsonModule_ProvideTypeAdapterFactoryFactory(GsonModule gsonModule) {
        this.a = gsonModule;
    }

    public static GsonModule_ProvideTypeAdapterFactoryFactory create(GsonModule gsonModule) {
        return new GsonModule_ProvideTypeAdapterFactoryFactory(gsonModule);
    }

    public static TypeAdapterFactory provideTypeAdapterFactory(GsonModule gsonModule) {
        return (TypeAdapterFactory) Preconditions.checkNotNullFromProvides(gsonModule.provideTypeAdapterFactory());
    }

    @Override // javax.inject.Provider
    public TypeAdapterFactory get() {
        return provideTypeAdapterFactory(this.a);
    }
}
