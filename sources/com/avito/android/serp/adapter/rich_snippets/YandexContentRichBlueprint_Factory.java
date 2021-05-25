package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexContentRichBlueprint_Factory implements Factory<YandexContentRichBlueprint> {
    public final Provider<YandexContentItemPresenter> a;

    public YandexContentRichBlueprint_Factory(Provider<YandexContentItemPresenter> provider) {
        this.a = provider;
    }

    public static YandexContentRichBlueprint_Factory create(Provider<YandexContentItemPresenter> provider) {
        return new YandexContentRichBlueprint_Factory(provider);
    }

    public static YandexContentRichBlueprint newInstance(YandexContentItemPresenter yandexContentItemPresenter) {
        return new YandexContentRichBlueprint(yandexContentItemPresenter);
    }

    @Override // javax.inject.Provider
    public YandexContentRichBlueprint get() {
        return newInstance(this.a.get());
    }
}
