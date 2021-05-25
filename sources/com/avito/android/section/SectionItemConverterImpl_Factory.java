package com.avito.android.section;

import com.avito.android.Features;
import com.avito.android.favorite_sellers.SellerCarouselItemConverter;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SectionItemConverterImpl_Factory implements Factory<SectionItemConverterImpl> {
    public final Provider<SectionInsideItemsConverter> a;
    public final Provider<SellerCarouselItemConverter> b;
    public final Provider<FavoriteStatusResolver> c;
    public final Provider<ViewedStatusResolver> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<Features> f;

    public SectionItemConverterImpl_Factory(Provider<SectionInsideItemsConverter> provider, Provider<SellerCarouselItemConverter> provider2, Provider<FavoriteStatusResolver> provider3, Provider<ViewedStatusResolver> provider4, Provider<SchedulersFactory3> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static SectionItemConverterImpl_Factory create(Provider<SectionInsideItemsConverter> provider, Provider<SellerCarouselItemConverter> provider2, Provider<FavoriteStatusResolver> provider3, Provider<ViewedStatusResolver> provider4, Provider<SchedulersFactory3> provider5, Provider<Features> provider6) {
        return new SectionItemConverterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SectionItemConverterImpl newInstance(SectionInsideItemsConverter sectionInsideItemsConverter, SellerCarouselItemConverter sellerCarouselItemConverter, FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver, SchedulersFactory3 schedulersFactory3, Features features) {
        return new SectionItemConverterImpl(sectionInsideItemsConverter, sellerCarouselItemConverter, favoriteStatusResolver, viewedStatusResolver, schedulersFactory3, features);
    }

    @Override // javax.inject.Provider
    public SectionItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
