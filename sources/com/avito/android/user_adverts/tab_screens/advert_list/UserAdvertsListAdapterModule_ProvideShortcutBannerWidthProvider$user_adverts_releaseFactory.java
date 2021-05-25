package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory implements Factory<ShortcutBannerWidthProvider> {
    public final UserAdvertsListAdapterModule a;

    public UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        this.a = userAdvertsListAdapterModule;
    }

    public static UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return new UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory(userAdvertsListAdapterModule);
    }

    public static ShortcutBannerWidthProvider provideShortcutBannerWidthProvider$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
        return (ShortcutBannerWidthProvider) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideShortcutBannerWidthProvider$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public ShortcutBannerWidthProvider get() {
        return provideShortcutBannerWidthProvider$user_adverts_release(this.a);
    }
}
