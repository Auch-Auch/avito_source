package com.avito.android.user_adverts.di;

import android.content.res.Resources;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory implements Factory<ShortcutBannerConverter> {
    public final Provider<Resources> a;
    public final Provider<DeepLinkFactory> b;

    public UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory(Provider<Resources> provider, Provider<DeepLinkFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory create(Provider<Resources> provider, Provider<DeepLinkFactory> provider2) {
        return new UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory(provider, provider2);
    }

    public static ShortcutBannerConverter provideShortcutBannerConverter$user_adverts_release(Resources resources, DeepLinkFactory deepLinkFactory) {
        return (ShortcutBannerConverter) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideShortcutBannerConverter$user_adverts_release(resources, deepLinkFactory));
    }

    @Override // javax.inject.Provider
    public ShortcutBannerConverter get() {
        return provideShortcutBannerConverter$user_adverts_release(this.a.get(), this.b.get());
    }
}
