package com.avito.android.di.module;

import com.avito.android.util.BuildInfo;
import com.avito.android.util.OptimalTypeAdapterEntry;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreOptimalJsonModule_ProvideStreamGsonFactory implements Factory<Gson> {
    public final Provider<Set<OptimalTypeAdapterEntry>> a;
    public final Provider<Set<TypeAdapterFactory>> b;
    public final Provider<BuildInfo> c;

    public CoreOptimalJsonModule_ProvideStreamGsonFactory(Provider<Set<OptimalTypeAdapterEntry>> provider, Provider<Set<TypeAdapterFactory>> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CoreOptimalJsonModule_ProvideStreamGsonFactory create(Provider<Set<OptimalTypeAdapterEntry>> provider, Provider<Set<TypeAdapterFactory>> provider2, Provider<BuildInfo> provider3) {
        return new CoreOptimalJsonModule_ProvideStreamGsonFactory(provider, provider2, provider3);
    }

    public static Gson provideStreamGson(Set<OptimalTypeAdapterEntry> set, Set<TypeAdapterFactory> set2, BuildInfo buildInfo) {
        return (Gson) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.provideStreamGson(set, set2, buildInfo));
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideStreamGson(this.a.get(), this.b.get(), this.c.get());
    }
}
