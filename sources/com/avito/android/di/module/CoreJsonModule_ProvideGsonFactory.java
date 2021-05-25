package com.avito.android.di.module;

import com.avito.android.util.TypeAdapterEntry;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreJsonModule_ProvideGsonFactory implements Factory<Gson> {
    public final Provider<Set<TypeAdapterEntry>> a;
    public final Provider<Set<TypeAdapterFactory>> b;

    public CoreJsonModule_ProvideGsonFactory(Provider<Set<TypeAdapterEntry>> provider, Provider<Set<TypeAdapterFactory>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreJsonModule_ProvideGsonFactory create(Provider<Set<TypeAdapterEntry>> provider, Provider<Set<TypeAdapterFactory>> provider2) {
        return new CoreJsonModule_ProvideGsonFactory(provider, provider2);
    }

    public static Gson provideGson(Set<TypeAdapterEntry> set, Set<TypeAdapterFactory> set2) {
        return (Gson) Preconditions.checkNotNullFromProvides(CoreJsonModule.provideGson(set, set2));
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideGson(this.a.get(), this.b.get());
    }
}
