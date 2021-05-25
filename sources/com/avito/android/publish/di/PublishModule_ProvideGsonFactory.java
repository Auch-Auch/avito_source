package com.avito.android.publish.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishModule_ProvideGsonFactory implements Factory<Gson> {
    public final PublishModule a;

    public PublishModule_ProvideGsonFactory(PublishModule publishModule) {
        this.a = publishModule;
    }

    public static PublishModule_ProvideGsonFactory create(PublishModule publishModule) {
        return new PublishModule_ProvideGsonFactory(publishModule);
    }

    public static Gson provideGson(PublishModule publishModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(publishModule.provideGson());
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideGson(this.a);
    }
}
