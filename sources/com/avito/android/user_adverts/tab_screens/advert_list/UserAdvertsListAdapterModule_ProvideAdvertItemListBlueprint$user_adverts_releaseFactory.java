package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory implements Factory<UserAdvertItemListBlueprint> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<UserAdvertItemPresenter> b;

    public UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<UserAdvertItemPresenter> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<UserAdvertItemPresenter> provider) {
        return new UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static UserAdvertItemListBlueprint provideAdvertItemListBlueprint$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, UserAdvertItemPresenter userAdvertItemPresenter) {
        return (UserAdvertItemListBlueprint) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideAdvertItemListBlueprint$user_adverts_release(userAdvertItemPresenter));
    }

    @Override // javax.inject.Provider
    public UserAdvertItemListBlueprint get() {
        return provideAdvertItemListBlueprint$user_adverts_release(this.a, this.b.get());
    }
}
