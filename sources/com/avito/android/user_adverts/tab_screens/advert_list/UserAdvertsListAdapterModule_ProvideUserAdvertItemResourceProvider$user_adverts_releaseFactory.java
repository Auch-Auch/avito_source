package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.user_adverts.tab_screens.advert_list.user_advert.UserAdvertItemResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvideUserAdvertItemResourceProvider$user_adverts_releaseFactory implements Factory<UserAdvertItemResourceProvider> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvideUserAdvertItemResourceProvider$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvideUserAdvertItemResourceProvider$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvideUserAdvertItemResourceProvider$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static UserAdvertItemResourceProvider provideUserAdvertItemResourceProvider$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (UserAdvertItemResourceProvider) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideUserAdvertItemResourceProvider$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public UserAdvertItemResourceProvider get() {
        return provideUserAdvertItemResourceProvider$user_adverts_release(this.a);
    }
}
