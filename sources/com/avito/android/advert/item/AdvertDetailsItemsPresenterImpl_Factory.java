package com.avito.android.advert.item;

import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsItemsPresenterImpl_Factory implements Factory<AdvertDetailsItemsPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<Integer> c;
    public final Provider<AdvertContactsPresenter> d;
    public final Provider<AdvertComplementaryPresenter> e;
    public final Provider<AdvertSimilarPresenterResourceProvider> f;
    public final Provider<Formatter<AdvertPrice>> g;
    public final Provider<Formatter<AdvertPrice>> h;
    public final Provider<AttributedTextFormatter> i;
    public final Provider<AdvertDetailsResourcesProvider> j;
    public final Provider<IdProvider> k;
    public final Provider<AdvertDetailsAnalyticsInteractor> l;
    public final Provider<Features> m;
    public final Provider<SellerSubscriptionPresenter> n;
    public final Provider<NotificationManagerProvider> o;
    public final Provider<AccountStateProvider> p;
    public final Provider<AdvertDetailsFastOpenParams> q;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> r;
    public final Provider<AdvertDetailsFeatureTeaserItemsAdapter> s;
    public final Provider<Boolean> t;
    public final Provider<AdvertDetailsImvBadgeItemConverter> u;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> v;
    public final Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> w;

    public AdvertDetailsItemsPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<Integer> provider3, Provider<AdvertContactsPresenter> provider4, Provider<AdvertComplementaryPresenter> provider5, Provider<AdvertSimilarPresenterResourceProvider> provider6, Provider<Formatter<AdvertPrice>> provider7, Provider<Formatter<AdvertPrice>> provider8, Provider<AttributedTextFormatter> provider9, Provider<AdvertDetailsResourcesProvider> provider10, Provider<IdProvider> provider11, Provider<AdvertDetailsAnalyticsInteractor> provider12, Provider<Features> provider13, Provider<SellerSubscriptionPresenter> provider14, Provider<NotificationManagerProvider> provider15, Provider<AccountStateProvider> provider16, Provider<AdvertDetailsFastOpenParams> provider17, Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> provider18, Provider<AdvertDetailsFeatureTeaserItemsAdapter> provider19, Provider<Boolean> provider20, Provider<AdvertDetailsImvBadgeItemConverter> provider21, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> provider22, Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> provider23) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
        this.w = provider23;
    }

    public static AdvertDetailsItemsPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<Integer> provider3, Provider<AdvertContactsPresenter> provider4, Provider<AdvertComplementaryPresenter> provider5, Provider<AdvertSimilarPresenterResourceProvider> provider6, Provider<Formatter<AdvertPrice>> provider7, Provider<Formatter<AdvertPrice>> provider8, Provider<AttributedTextFormatter> provider9, Provider<AdvertDetailsResourcesProvider> provider10, Provider<IdProvider> provider11, Provider<AdvertDetailsAnalyticsInteractor> provider12, Provider<Features> provider13, Provider<SellerSubscriptionPresenter> provider14, Provider<NotificationManagerProvider> provider15, Provider<AccountStateProvider> provider16, Provider<AdvertDetailsFastOpenParams> provider17, Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> provider18, Provider<AdvertDetailsFeatureTeaserItemsAdapter> provider19, Provider<Boolean> provider20, Provider<AdvertDetailsImvBadgeItemConverter> provider21, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> provider22, Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> provider23) {
        return new AdvertDetailsItemsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    public static AdvertDetailsItemsPresenterImpl newInstance(String str, String str2, int i2, AdvertContactsPresenter advertContactsPresenter, AdvertComplementaryPresenter advertComplementaryPresenter, AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, Formatter<AdvertPrice> formatter, Formatter<AdvertPrice> formatter2, AttributedTextFormatter attributedTextFormatter, AdvertDetailsResourcesProvider advertDetailsResourcesProvider, IdProvider idProvider, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, Features features, SellerSubscriptionPresenter sellerSubscriptionPresenter, NotificationManagerProvider notificationManagerProvider, AccountStateProvider accountStateProvider, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> manuallyExposedAbTestGroup, AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter, boolean z, AdvertDetailsImvBadgeItemConverter advertDetailsImvBadgeItemConverter, ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> manuallyExposedAbTestGroup2, ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> exposedAbTestGroup) {
        return new AdvertDetailsItemsPresenterImpl(str, str2, i2, advertContactsPresenter, advertComplementaryPresenter, advertSimilarPresenterResourceProvider, formatter, formatter2, attributedTextFormatter, advertDetailsResourcesProvider, idProvider, advertDetailsAnalyticsInteractor, features, sellerSubscriptionPresenter, notificationManagerProvider, accountStateProvider, advertDetailsFastOpenParams, manuallyExposedAbTestGroup, advertDetailsFeatureTeaserItemsAdapter, z, advertDetailsImvBadgeItemConverter, manuallyExposedAbTestGroup2, exposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsItemsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().intValue(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get().booleanValue(), this.u.get(), this.v.get(), this.w.get());
    }
}
