package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory implements Factory<ShortcutBannerItemPresenter> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<ShortcutBannerItemListener> b;
    public final Provider<ShortcutBannerWidthProvider> c;

    public UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<ShortcutBannerItemListener> provider, Provider<ShortcutBannerWidthProvider> provider2) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<ShortcutBannerItemListener> provider, Provider<ShortcutBannerWidthProvider> provider2) {
        return new UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider, provider2);
    }

    public static ShortcutBannerItemPresenter provideShortcutBannerItemPresenter$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Lazy<ShortcutBannerItemListener> lazy, ShortcutBannerWidthProvider shortcutBannerWidthProvider) {
        return (ShortcutBannerItemPresenter) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideShortcutBannerItemPresenter$user_adverts_release(lazy, shortcutBannerWidthProvider));
    }

    @Override // javax.inject.Provider
    public ShortcutBannerItemPresenter get() {
        return provideShortcutBannerItemPresenter$user_adverts_release(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}
