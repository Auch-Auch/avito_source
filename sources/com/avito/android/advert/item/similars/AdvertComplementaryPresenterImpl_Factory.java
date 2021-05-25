package com.avito.android.advert.item.similars;

import com.avito.android.Features;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverter;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.section.SectionItemConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertComplementaryPresenterImpl_Factory implements Factory<AdvertComplementaryPresenterImpl> {
    public final Provider<AdvertSimilarPresenterResourceProvider> a;
    public final Provider<SectionItemConverter> b;
    public final Provider<AdvertCommercialsConverter> c;
    public final Provider<AdvertDetailsTracker> d;
    public final Provider<Features> e;

    public AdvertComplementaryPresenterImpl_Factory(Provider<AdvertSimilarPresenterResourceProvider> provider, Provider<SectionItemConverter> provider2, Provider<AdvertCommercialsConverter> provider3, Provider<AdvertDetailsTracker> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertComplementaryPresenterImpl_Factory create(Provider<AdvertSimilarPresenterResourceProvider> provider, Provider<SectionItemConverter> provider2, Provider<AdvertCommercialsConverter> provider3, Provider<AdvertDetailsTracker> provider4, Provider<Features> provider5) {
        return new AdvertComplementaryPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertComplementaryPresenterImpl newInstance(AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, SectionItemConverter sectionItemConverter, AdvertCommercialsConverter advertCommercialsConverter, AdvertDetailsTracker advertDetailsTracker, Features features) {
        return new AdvertComplementaryPresenterImpl(advertSimilarPresenterResourceProvider, sectionItemConverter, advertCommercialsConverter, advertDetailsTracker, features);
    }

    @Override // javax.inject.Provider
    public AdvertComplementaryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
