package com.avito.android.brandspace.items.news;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NewsItemBlueprint_Factory implements Factory<NewsItemBlueprint> {
    public final Provider<NewsItemPresenter> a;

    public NewsItemBlueprint_Factory(Provider<NewsItemPresenter> provider) {
        this.a = provider;
    }

    public static NewsItemBlueprint_Factory create(Provider<NewsItemPresenter> provider) {
        return new NewsItemBlueprint_Factory(provider);
    }

    public static NewsItemBlueprint newInstance(NewsItemPresenter newsItemPresenter) {
        return new NewsItemBlueprint(newsItemPresenter);
    }

    @Override // javax.inject.Provider
    public NewsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
