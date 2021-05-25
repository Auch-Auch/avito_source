package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory implements Factory<PerformanceVasBannerBlueprint> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<PerformanceVasBannerItemPresenter> b;

    public UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<PerformanceVasBannerItemPresenter> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<PerformanceVasBannerItemPresenter> provider) {
        return new UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static PerformanceVasBannerBlueprint providePerformanceVasBannerBlueprint$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, PerformanceVasBannerItemPresenter performanceVasBannerItemPresenter) {
        return (PerformanceVasBannerBlueprint) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.providePerformanceVasBannerBlueprint$user_adverts_release(performanceVasBannerItemPresenter));
    }

    @Override // javax.inject.Provider
    public PerformanceVasBannerBlueprint get() {
        return providePerformanceVasBannerBlueprint$user_adverts_release(this.a, this.b.get());
    }
}
