package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory implements Factory<ShortcutBannerBlueprint> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<ShortcutBannerItemPresenter> b;

    public UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<ShortcutBannerItemPresenter> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<ShortcutBannerItemPresenter> provider) {
        return new UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static ShortcutBannerBlueprint provideShortcutBannerItemBlueprint$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, ShortcutBannerItemPresenter shortcutBannerItemPresenter) {
        return (ShortcutBannerBlueprint) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideShortcutBannerItemBlueprint$user_adverts_release(shortcutBannerItemPresenter));
    }

    @Override // javax.inject.Provider
    public ShortcutBannerBlueprint get() {
        return provideShortcutBannerItemBlueprint$user_adverts_release(this.a, this.b.get());
    }
}
