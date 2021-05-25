package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory implements Factory<PerformanceVasBannerItemPresenter> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static PerformanceVasBannerItemPresenter providePerformanceVasBannerPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (PerformanceVasBannerItemPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.providePerformanceVasBannerPresenter$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public PerformanceVasBannerItemPresenter get() {
        return providePerformanceVasBannerPresenter$user_adverts_release(this.a);
    }
}
