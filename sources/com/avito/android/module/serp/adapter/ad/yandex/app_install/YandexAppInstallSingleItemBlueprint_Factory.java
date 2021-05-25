package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexAppInstallSingleItemBlueprint_Factory implements Factory<YandexAppInstallSingleItemBlueprint> {
    public final Provider<YandexAppInstallItemPresenter> a;

    public YandexAppInstallSingleItemBlueprint_Factory(Provider<YandexAppInstallItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexAppInstallSingleItemBlueprint_Factory create(Provider<YandexAppInstallItemPresenter> provider) {
        return new YandexAppInstallSingleItemBlueprint_Factory(provider);
    }

    public static YandexAppInstallSingleItemBlueprint newInstance(YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        return new YandexAppInstallSingleItemBlueprint(yandexAppInstallItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexAppInstallSingleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
