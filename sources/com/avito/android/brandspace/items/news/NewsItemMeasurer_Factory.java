package com.avito.android.brandspace.items.news;

import com.avito.android.brandspace.items.news.NewsItemView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NewsItemMeasurer_Factory implements Factory<NewsItemMeasurer> {
    public final Provider<NewsItemView.Measurer> a;

    public NewsItemMeasurer_Factory(Provider<NewsItemView.Measurer> provider) {
        this.a = provider;
    }

    public static NewsItemMeasurer_Factory create(Provider<NewsItemView.Measurer> provider) {
        return new NewsItemMeasurer_Factory(provider);
    }

    public static NewsItemMeasurer newInstance(Lazy<NewsItemView.Measurer> lazy) {
        return new NewsItemMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public NewsItemMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
