package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexAppInstallRichBlueprint_Factory implements Factory<YandexAppInstallRichBlueprint> {
    public final Provider<YandexAppInstallItemPresenter> a;

    public YandexAppInstallRichBlueprint_Factory(Provider<YandexAppInstallItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexAppInstallRichBlueprint_Factory create(Provider<YandexAppInstallItemPresenter> provider) {
        return new YandexAppInstallRichBlueprint_Factory(provider);
    }

    public static YandexAppInstallRichBlueprint newInstance(YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        return new YandexAppInstallRichBlueprint(yandexAppInstallItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexAppInstallRichBlueprint get() {
        return newInstance(this.a.get());
    }
}
