package com.avito.android.advert.item.autoteka.teaser;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutotekaTeaserPresenterImpl_Factory implements Factory<AdvertDetailsAutotekaTeaserPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AutotekaTeaserInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Analytics> d;
    public final Provider<AdvertDetailsAnalyticsInteractor> e;
    public final Provider<Features> f;
    public final Provider<TeaserObserver> g;
    public final Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> h;

    public AdvertDetailsAutotekaTeaserPresenterImpl_Factory(Provider<String> provider, Provider<AutotekaTeaserInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Features> provider6, Provider<TeaserObserver> provider7, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AdvertDetailsAutotekaTeaserPresenterImpl_Factory create(Provider<String> provider, Provider<AutotekaTeaserInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Features> provider6, Provider<TeaserObserver> provider7, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider8) {
        return new AdvertDetailsAutotekaTeaserPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AdvertDetailsAutotekaTeaserPresenterImpl newInstance(String str, AutotekaTeaserInteractor autotekaTeaserInteractor, SchedulersFactory3 schedulersFactory3, Analytics analytics, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, Features features, TeaserObserver teaserObserver, ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        return new AdvertDetailsAutotekaTeaserPresenterImpl(str, autotekaTeaserInteractor, schedulersFactory3, analytics, advertDetailsAnalyticsInteractor, features, teaserObserver, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutotekaTeaserPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
