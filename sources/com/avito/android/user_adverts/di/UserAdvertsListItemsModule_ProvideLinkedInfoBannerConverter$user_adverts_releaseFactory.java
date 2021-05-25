package com.avito.android.user_adverts.di;

import android.content.res.Resources;
import com.avito.android.user_adverts.tab_screens.converters.LinkedInfoBannerConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory implements Factory<LinkedInfoBannerConverter> {
    public final Provider<Resources> a;

    public UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory create(Provider<Resources> provider) {
        return new UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory(provider);
    }

    public static LinkedInfoBannerConverter provideLinkedInfoBannerConverter$user_adverts_release(Resources resources) {
        return (LinkedInfoBannerConverter) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideLinkedInfoBannerConverter$user_adverts_release(resources));
    }

    @Override // javax.inject.Provider
    public LinkedInfoBannerConverter get() {
        return provideLinkedInfoBannerConverter$user_adverts_release(this.a.get());
    }
}
