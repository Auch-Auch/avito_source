package ru.avito.messenger.internal.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.internal.gson.GsonDeserializer;
public final class GsonModule_ProvideGsonDeserializerFactory implements Factory<GsonDeserializer> {
    public final GsonModule a;
    public final Provider<Gson> b;

    public GsonModule_ProvideGsonDeserializerFactory(GsonModule gsonModule, Provider<Gson> provider) {
        this.a = gsonModule;
        this.b = provider;
    }

    public static GsonModule_ProvideGsonDeserializerFactory create(GsonModule gsonModule, Provider<Gson> provider) {
        return new GsonModule_ProvideGsonDeserializerFactory(gsonModule, provider);
    }

    public static GsonDeserializer provideGsonDeserializer(GsonModule gsonModule, Gson gson) {
        return (GsonDeserializer) Preconditions.checkNotNullFromProvides(gsonModule.provideGsonDeserializer(gson));
    }

    @Override // javax.inject.Provider
    public GsonDeserializer get() {
        return provideGsonDeserializer(this.a, this.b.get());
    }
}
