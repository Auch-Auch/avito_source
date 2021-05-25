package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory implements Factory<DiscountBannerPresenter> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static DiscountBannerPresenter provideDiscountBannerPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (DiscountBannerPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideDiscountBannerPresenter$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public DiscountBannerPresenter get() {
        return provideDiscountBannerPresenter$user_adverts_release(this.a);
    }
}
