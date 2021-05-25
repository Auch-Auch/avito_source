package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory implements Factory<ResponsiveAdapterPresenter> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<CallableResponsiveItemPresenterRegistry> c;

    public UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        return new UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider, provider2);
    }

    public static ResponsiveAdapterPresenter provideAdapterPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, AdapterPresenter adapterPresenter, CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        return (ResponsiveAdapterPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideAdapterPresenter$user_adverts_release(adapterPresenter, callableResponsiveItemPresenterRegistry));
    }

    @Override // javax.inject.Provider
    public ResponsiveAdapterPresenter get() {
        return provideAdapterPresenter$user_adverts_release(this.a, this.b.get(), this.c.get());
    }
}
