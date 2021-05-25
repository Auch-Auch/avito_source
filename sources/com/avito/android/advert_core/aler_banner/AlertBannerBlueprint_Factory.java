package com.avito.android.advert_core.aler_banner;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AlertBannerBlueprint_Factory implements Factory<AlertBannerBlueprint> {
    public final Provider<AlertBannerPresenter> a;

    public AlertBannerBlueprint_Factory(Provider<AlertBannerPresenter> provider) {
        this.a = provider;
    }

    public static AlertBannerBlueprint_Factory create(Provider<AlertBannerPresenter> provider) {
        return new AlertBannerBlueprint_Factory(provider);
    }

    public static AlertBannerBlueprint newInstance(AlertBannerPresenter alertBannerPresenter) {
        return new AlertBannerBlueprint(alertBannerPresenter);
    }

    @Override // javax.inject.Provider
    public AlertBannerBlueprint get() {
        return newInstance(this.a.get());
    }
}
