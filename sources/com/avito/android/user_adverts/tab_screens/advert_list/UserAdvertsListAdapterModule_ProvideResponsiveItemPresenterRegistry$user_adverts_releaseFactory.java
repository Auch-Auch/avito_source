package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory implements Factory<CallableResponsiveItemPresenterRegistry> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (CallableResponsiveItemPresenterRegistry) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideResponsiveItemPresenterRegistry$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public CallableResponsiveItemPresenterRegistry get() {
        return provideResponsiveItemPresenterRegistry$user_adverts_release(this.a);
    }
}
