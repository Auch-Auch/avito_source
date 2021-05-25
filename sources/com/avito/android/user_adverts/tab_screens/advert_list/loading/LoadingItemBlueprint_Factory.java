package com.avito.android.user_adverts.tab_screens.advert_list.loading;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoadingItemBlueprint_Factory implements Factory<LoadingItemBlueprint> {
    public final Provider<LoadingItemPresenter> a;

    public LoadingItemBlueprint_Factory(Provider<LoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static LoadingItemBlueprint_Factory create(Provider<LoadingItemPresenter> provider) {
        return new LoadingItemBlueprint_Factory(provider);
    }

    public static LoadingItemBlueprint newInstance(LoadingItemPresenter loadingItemPresenter) {
        return new LoadingItemBlueprint(loadingItemPresenter);
    }

    @Override // javax.inject.Provider
    public LoadingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
