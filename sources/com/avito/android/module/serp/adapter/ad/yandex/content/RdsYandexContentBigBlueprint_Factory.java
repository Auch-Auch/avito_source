package com.avito.android.module.serp.adapter.ad.yandex.content;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsYandexContentBigBlueprint_Factory implements Factory<RdsYandexContentBigBlueprint> {
    public final Provider<YandexContentItemPresenter> a;

    public RdsYandexContentBigBlueprint_Factory(Provider<YandexContentItemPresenter> provider) {
        this.a = provider;
    }

    public static RdsYandexContentBigBlueprint_Factory create(Provider<YandexContentItemPresenter> provider) {
        return new RdsYandexContentBigBlueprint_Factory(provider);
    }

    public static RdsYandexContentBigBlueprint newInstance(YandexContentItemPresenter yandexContentItemPresenter) {
        return new RdsYandexContentBigBlueprint(yandexContentItemPresenter);
    }

    @Override // javax.inject.Provider
    public RdsYandexContentBigBlueprint get() {
        return newInstance(this.a.get());
    }
}
