package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory implements Factory<UserAdvertItemPresenter> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<UserAdvertItemClickListener> b;

    public UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<UserAdvertItemClickListener> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<UserAdvertItemClickListener> provider) {
        return new UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static UserAdvertItemPresenter provideAdvertItemPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Lazy<UserAdvertItemClickListener> lazy) {
        return (UserAdvertItemPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideAdvertItemPresenter$user_adverts_release(lazy));
    }

    @Override // javax.inject.Provider
    public UserAdvertItemPresenter get() {
        return provideAdvertItemPresenter$user_adverts_release(this.a, DoubleCheck.lazy(this.b));
    }
}
