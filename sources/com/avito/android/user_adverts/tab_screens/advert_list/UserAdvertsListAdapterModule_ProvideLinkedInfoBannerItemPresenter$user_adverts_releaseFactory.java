package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.analytics.Analytics;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory implements Factory<LinkedInfoBannerPresenter> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<Analytics> b;

    public UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<Analytics> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<Analytics> provider) {
        return new UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static LinkedInfoBannerPresenter provideLinkedInfoBannerItemPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Analytics analytics) {
        return (LinkedInfoBannerPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideLinkedInfoBannerItemPresenter$user_adverts_release(analytics));
    }

    @Override // javax.inject.Provider
    public LinkedInfoBannerPresenter get() {
        return provideLinkedInfoBannerItemPresenter$user_adverts_release(this.a, this.b.get());
    }
}
