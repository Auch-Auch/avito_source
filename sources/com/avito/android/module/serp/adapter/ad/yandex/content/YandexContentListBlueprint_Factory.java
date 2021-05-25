package com.avito.android.module.serp.adapter.ad.yandex.content;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexContentListBlueprint_Factory implements Factory<YandexContentListBlueprint> {
    public final Provider<YandexContentItemPresenter> a;

    public YandexContentListBlueprint_Factory(Provider<YandexContentItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexContentListBlueprint_Factory create(Provider<YandexContentItemPresenter> provider) {
        return new YandexContentListBlueprint_Factory(provider);
    }

    public static YandexContentListBlueprint newInstance(YandexContentItemPresenter yandexContentItemPresenter) {
        return new YandexContentListBlueprint(yandexContentItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexContentListBlueprint get() {
        return newInstance(this.a.get());
    }
}
