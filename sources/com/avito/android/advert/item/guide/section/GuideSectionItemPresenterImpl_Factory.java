package com.avito.android.advert.item.guide.section;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GuideSectionItemPresenterImpl_Factory implements Factory<GuideSectionItemPresenterImpl> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;

    public GuideSectionItemPresenterImpl_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static GuideSectionItemPresenterImpl_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        return new GuideSectionItemPresenterImpl_Factory(provider);
    }

    public static GuideSectionItemPresenterImpl newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new GuideSectionItemPresenterImpl(advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public GuideSectionItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
