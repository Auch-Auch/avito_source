package com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LinkedInfoBannerBlueprint_Factory implements Factory<LinkedInfoBannerBlueprint> {
    public final Provider<LinkedInfoBannerPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public LinkedInfoBannerBlueprint_Factory(Provider<LinkedInfoBannerPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LinkedInfoBannerBlueprint_Factory create(Provider<LinkedInfoBannerPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new LinkedInfoBannerBlueprint_Factory(provider, provider2);
    }

    public static LinkedInfoBannerBlueprint newInstance(LinkedInfoBannerPresenter linkedInfoBannerPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new LinkedInfoBannerBlueprint(linkedInfoBannerPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public LinkedInfoBannerBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
