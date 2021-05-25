package com.avito.android.publish.drafts.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDraftsModule_ProvideStreamGsonFactory implements Factory<Gson> {

    public static final class a {
        public static final PublishDraftsModule_ProvideStreamGsonFactory a = new PublishDraftsModule_ProvideStreamGsonFactory();
    }

    public static PublishDraftsModule_ProvideStreamGsonFactory create() {
        return a.a;
    }

    public static Gson provideStreamGson() {
        return (Gson) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideStreamGson());
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideStreamGson();
    }
}
