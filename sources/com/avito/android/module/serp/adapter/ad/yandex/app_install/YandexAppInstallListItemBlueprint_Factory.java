package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexAppInstallListItemBlueprint_Factory implements Factory<YandexAppInstallListItemBlueprint> {
    public final Provider<YandexAppInstallItemPresenter> a;

    public YandexAppInstallListItemBlueprint_Factory(Provider<YandexAppInstallItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexAppInstallListItemBlueprint_Factory create(Provider<YandexAppInstallItemPresenter> provider) {
        return new YandexAppInstallListItemBlueprint_Factory(provider);
    }

    public static YandexAppInstallListItemBlueprint newInstance(YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        return new YandexAppInstallListItemBlueprint(yandexAppInstallItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexAppInstallListItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
