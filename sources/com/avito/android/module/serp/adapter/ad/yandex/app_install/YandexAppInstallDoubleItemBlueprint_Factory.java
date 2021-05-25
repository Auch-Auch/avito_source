package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexAppInstallDoubleItemBlueprint_Factory implements Factory<YandexAppInstallDoubleItemBlueprint> {
    public final Provider<YandexAppInstallItemPresenter> a;

    public YandexAppInstallDoubleItemBlueprint_Factory(Provider<YandexAppInstallItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexAppInstallDoubleItemBlueprint_Factory create(Provider<YandexAppInstallItemPresenter> provider) {
        return new YandexAppInstallDoubleItemBlueprint_Factory(provider);
    }

    public static YandexAppInstallDoubleItemBlueprint newInstance(YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        return new YandexAppInstallDoubleItemBlueprint(yandexAppInstallItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexAppInstallDoubleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
