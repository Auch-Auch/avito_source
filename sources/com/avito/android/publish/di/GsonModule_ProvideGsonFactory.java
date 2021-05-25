package com.avito.android.publish.di;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GsonModule_ProvideGsonFactory implements Factory<Gson> {
    public final GsonModule a;
    public final Provider<TypeAdapterFactory> b;

    public GsonModule_ProvideGsonFactory(GsonModule gsonModule, Provider<TypeAdapterFactory> provider) {
        this.a = gsonModule;
        this.b = provider;
    }

    public static GsonModule_ProvideGsonFactory create(GsonModule gsonModule, Provider<TypeAdapterFactory> provider) {
        return new GsonModule_ProvideGsonFactory(gsonModule, provider);
    }

    public static Gson provideGson(GsonModule gsonModule, TypeAdapterFactory typeAdapterFactory) {
        return (Gson) Preconditions.checkNotNullFromProvides(gsonModule.provideGson(typeAdapterFactory));
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideGson(this.a, this.b.get());
    }
}
