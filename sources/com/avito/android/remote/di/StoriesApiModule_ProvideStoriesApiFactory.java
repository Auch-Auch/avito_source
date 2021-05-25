package com.avito.android.remote.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.StoriesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StoriesApiModule_ProvideStoriesApiFactory implements Factory<StoriesApi> {
    public final Provider<RetrofitFactory> a;

    public StoriesApiModule_ProvideStoriesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static StoriesApiModule_ProvideStoriesApiFactory create(Provider<RetrofitFactory> provider) {
        return new StoriesApiModule_ProvideStoriesApiFactory(provider);
    }

    public static StoriesApi provideStoriesApi(RetrofitFactory retrofitFactory) {
        return (StoriesApi) Preconditions.checkNotNullFromProvides(StoriesApiModule.INSTANCE.provideStoriesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public StoriesApi get() {
        return provideStoriesApi(this.a.get());
    }
}
