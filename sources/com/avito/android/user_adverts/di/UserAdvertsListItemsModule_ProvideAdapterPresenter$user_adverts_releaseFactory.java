package com.avito.android.user_adverts.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory create(Provider<ItemBinder> provider) {
        return new UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter$user_adverts_release(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideAdapterPresenter$user_adverts_release(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter$user_adverts_release(this.a.get());
    }
}
