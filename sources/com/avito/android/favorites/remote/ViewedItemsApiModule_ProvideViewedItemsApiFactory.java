package com.avito.android.favorites.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ViewedItemsApiModule_ProvideViewedItemsApiFactory implements Factory<ViewedItemsApi> {
    public final Provider<RetrofitFactory> a;

    public ViewedItemsApiModule_ProvideViewedItemsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ViewedItemsApiModule_ProvideViewedItemsApiFactory create(Provider<RetrofitFactory> provider) {
        return new ViewedItemsApiModule_ProvideViewedItemsApiFactory(provider);
    }

    public static ViewedItemsApi provideViewedItemsApi(RetrofitFactory retrofitFactory) {
        return (ViewedItemsApi) Preconditions.checkNotNullFromProvides(ViewedItemsApiModule.INSTANCE.provideViewedItemsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ViewedItemsApi get() {
        return provideViewedItemsApi(this.a.get());
    }
}
