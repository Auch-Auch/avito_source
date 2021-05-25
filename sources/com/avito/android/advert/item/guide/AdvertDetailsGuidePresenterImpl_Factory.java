package com.avito.android.advert.item.guide;

import com.avito.android.advert.item.guide.section.GuideSectionItemPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGuidePresenterImpl_Factory implements Factory<AdvertDetailsGuidePresenterImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<GuideSectionItemPresenter> b;
    public final Provider<AdvertDetailsAnalyticsInteractor> c;

    public AdvertDetailsGuidePresenterImpl_Factory(Provider<AdapterPresenter> provider, Provider<GuideSectionItemPresenter> provider2, Provider<AdvertDetailsAnalyticsInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsGuidePresenterImpl_Factory create(Provider<AdapterPresenter> provider, Provider<GuideSectionItemPresenter> provider2, Provider<AdvertDetailsAnalyticsInteractor> provider3) {
        return new AdvertDetailsGuidePresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsGuidePresenterImpl newInstance(AdapterPresenter adapterPresenter, GuideSectionItemPresenter guideSectionItemPresenter, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new AdvertDetailsGuidePresenterImpl(adapterPresenter, guideSectionItemPresenter, advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGuidePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
