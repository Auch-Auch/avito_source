package com.avito.android.module.serp.adapter.ad.yandex.content;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexContentDoubleGridBlueprint_Factory implements Factory<YandexContentDoubleGridBlueprint> {
    public final Provider<YandexContentItemPresenter> a;

    public YandexContentDoubleGridBlueprint_Factory(Provider<YandexContentItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexContentDoubleGridBlueprint_Factory create(Provider<YandexContentItemPresenter> provider) {
        return new YandexContentDoubleGridBlueprint_Factory(provider);
    }

    public static YandexContentDoubleGridBlueprint newInstance(YandexContentItemPresenter yandexContentItemPresenter) {
        return new YandexContentDoubleGridBlueprint(yandexContentItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexContentDoubleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}
