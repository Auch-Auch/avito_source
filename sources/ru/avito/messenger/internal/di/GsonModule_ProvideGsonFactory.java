package ru.avito.messenger.internal.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.internal.log.Logger;
public final class GsonModule_ProvideGsonFactory implements Factory<Gson> {
    public final GsonModule a;
    public final Provider<Logger> b;

    public GsonModule_ProvideGsonFactory(GsonModule gsonModule, Provider<Logger> provider) {
        this.a = gsonModule;
        this.b = provider;
    }

    public static GsonModule_ProvideGsonFactory create(GsonModule gsonModule, Provider<Logger> provider) {
        return new GsonModule_ProvideGsonFactory(gsonModule, provider);
    }

    public static Gson provideGson(GsonModule gsonModule, Logger logger) {
        return (Gson) Preconditions.checkNotNullFromProvides(gsonModule.provideGson(logger));
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideGson(this.a, this.b.get());
    }
}
