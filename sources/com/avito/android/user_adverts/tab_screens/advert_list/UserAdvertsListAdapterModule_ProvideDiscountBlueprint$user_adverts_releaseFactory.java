package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory implements Factory<DiscountBannerBlueprint> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<DiscountBannerPresenter> b;

    public UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<DiscountBannerPresenter> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<DiscountBannerPresenter> provider) {
        return new UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static DiscountBannerBlueprint provideDiscountBlueprint$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, DiscountBannerPresenter discountBannerPresenter) {
        return (DiscountBannerBlueprint) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideDiscountBlueprint$user_adverts_release(discountBannerPresenter));
    }

    @Override // javax.inject.Provider
    public DiscountBannerBlueprint get() {
        return provideDiscountBlueprint$user_adverts_release(this.a, this.b.get());
    }
}
