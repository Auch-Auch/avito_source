package com.avito.android.rating.details.adapter.loading.di;

import com.avito.android.rating.details.adapter.loading.LoadingItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LoadingItemModule_ProvideBlueprint$rating_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<LoadingItemPresenter> a;

    public LoadingItemModule_ProvideBlueprint$rating_releaseFactory(Provider<LoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static LoadingItemModule_ProvideBlueprint$rating_releaseFactory create(Provider<LoadingItemPresenter> provider) {
        return new LoadingItemModule_ProvideBlueprint$rating_releaseFactory(provider);
    }

    public static ItemBlueprint<?, ?> provideBlueprint$rating_release(LoadingItemPresenter loadingItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(LoadingItemModule.provideBlueprint$rating_release(loadingItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideBlueprint$rating_release(this.a.get());
    }
}
