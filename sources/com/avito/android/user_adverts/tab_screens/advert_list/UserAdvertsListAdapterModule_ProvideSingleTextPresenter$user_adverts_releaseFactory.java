package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory implements Factory<SingleTextPresenter> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static SingleTextPresenter provideSingleTextPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (SingleTextPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideSingleTextPresenter$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public SingleTextPresenter get() {
        return provideSingleTextPresenter$user_adverts_release(this.a);
    }
}
