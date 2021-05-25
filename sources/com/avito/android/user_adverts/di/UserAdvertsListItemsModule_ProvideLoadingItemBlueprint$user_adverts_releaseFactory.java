package com.avito.android.user_adverts.di;

import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory implements Factory<LoadingItemBlueprint> {
    public final Provider<LoadingItemPresenter> a;

    public UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory(Provider<LoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory create(Provider<LoadingItemPresenter> provider) {
        return new UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory(provider);
    }

    public static LoadingItemBlueprint provideLoadingItemBlueprint$user_adverts_release(LoadingItemPresenter loadingItemPresenter) {
        return (LoadingItemBlueprint) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideLoadingItemBlueprint$user_adverts_release(loadingItemPresenter));
    }

    @Override // javax.inject.Provider
    public LoadingItemBlueprint get() {
        return provideLoadingItemBlueprint$user_adverts_release(this.a.get());
    }
}
