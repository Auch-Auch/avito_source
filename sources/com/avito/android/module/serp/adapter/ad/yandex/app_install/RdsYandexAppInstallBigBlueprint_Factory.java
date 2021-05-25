package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsYandexAppInstallBigBlueprint_Factory implements Factory<RdsYandexAppInstallBigBlueprint> {
    public final Provider<YandexAppInstallItemPresenter> a;

    public RdsYandexAppInstallBigBlueprint_Factory(Provider<YandexAppInstallItemPresenter> provider) {
        this.a = provider;
    }

    public static RdsYandexAppInstallBigBlueprint_Factory create(Provider<YandexAppInstallItemPresenter> provider) {
        return new RdsYandexAppInstallBigBlueprint_Factory(provider);
    }

    public static RdsYandexAppInstallBigBlueprint newInstance(YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        return new RdsYandexAppInstallBigBlueprint(yandexAppInstallItemPresenter);
    }

    @Override // javax.inject.Provider
    public RdsYandexAppInstallBigBlueprint get() {
        return newInstance(this.a.get());
    }
}
