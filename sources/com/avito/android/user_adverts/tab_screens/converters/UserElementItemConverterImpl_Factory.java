package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.Features;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserElementItemConverterImpl_Factory implements Factory<UserElementItemConverterImpl> {
    public final Provider<UserAdvertConverter> a;
    public final Provider<ShortcutBannerConverter> b;
    public final Provider<LinkedInfoBannerConverter> c;
    public final Provider<DiscountBannerConverter> d;
    public final Provider<DisclaimerConverter> e;
    public final Provider<PerformanceVasBannerConverter> f;
    public final Provider<Features> g;

    public UserElementItemConverterImpl_Factory(Provider<UserAdvertConverter> provider, Provider<ShortcutBannerConverter> provider2, Provider<LinkedInfoBannerConverter> provider3, Provider<DiscountBannerConverter> provider4, Provider<DisclaimerConverter> provider5, Provider<PerformanceVasBannerConverter> provider6, Provider<Features> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static UserElementItemConverterImpl_Factory create(Provider<UserAdvertConverter> provider, Provider<ShortcutBannerConverter> provider2, Provider<LinkedInfoBannerConverter> provider3, Provider<DiscountBannerConverter> provider4, Provider<DisclaimerConverter> provider5, Provider<PerformanceVasBannerConverter> provider6, Provider<Features> provider7) {
        return new UserElementItemConverterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static UserElementItemConverterImpl newInstance(UserAdvertConverter userAdvertConverter, ShortcutBannerConverter shortcutBannerConverter, LinkedInfoBannerConverter linkedInfoBannerConverter, DiscountBannerConverter discountBannerConverter, DisclaimerConverter disclaimerConverter, PerformanceVasBannerConverter performanceVasBannerConverter, Features features) {
        return new UserElementItemConverterImpl(userAdvertConverter, shortcutBannerConverter, linkedInfoBannerConverter, discountBannerConverter, disclaimerConverter, performanceVasBannerConverter, features);
    }

    @Override // javax.inject.Provider
    public UserElementItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
