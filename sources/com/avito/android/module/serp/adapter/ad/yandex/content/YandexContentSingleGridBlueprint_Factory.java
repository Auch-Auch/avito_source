package com.avito.android.module.serp.adapter.ad.yandex.content;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexContentSingleGridBlueprint_Factory implements Factory<YandexContentSingleGridBlueprint> {
    public final Provider<YandexContentItemPresenter> a;

    public YandexContentSingleGridBlueprint_Factory(Provider<YandexContentItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexContentSingleGridBlueprint_Factory create(Provider<YandexContentItemPresenter> provider) {
        return new YandexContentSingleGridBlueprint_Factory(provider);
    }

    public static YandexContentSingleGridBlueprint newInstance(YandexContentItemPresenter yandexContentItemPresenter) {
        return new YandexContentSingleGridBlueprint(yandexContentItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexContentSingleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}
