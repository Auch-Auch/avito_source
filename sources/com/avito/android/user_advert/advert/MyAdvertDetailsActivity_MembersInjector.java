package com.avito.android.user_advert.advert;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTracker;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserViewFactory;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTracker;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MyAdvertDetailsActivity_MembersInjector implements MembersInjector<MyAdvertDetailsActivity> {
    public final Provider<Analytics> a;
    public final Provider<AdvertSharingEventTracker> b;
    public final Provider<DeliveryEventTracker> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<DeepLinkFactory> e;
    public final Provider<MyAdvertDetailsPresenter> f;
    public final Provider<MyAdvertContactsPresenter> g;
    public final Provider<ImplicitIntentFactory> h;
    public final Provider<ActivityIntentFactory> i;
    public final Provider<SocialPresenter> j;
    public final Provider<MyAdvertDetailsInteractor> k;
    public final Provider<Features> l;
    public final Provider<AttributedTextFormatter> m;
    public final Provider<DialogRouter> n;
    public final Provider<SocialTypeToStringMapper> o;
    public final Provider<MyAdvertDetailsTracker> p;
    public final Provider<MyAdvertDetailsFeatureTeaserViewFactory> q;
    public final Provider<AdvertDetailsImvBadgePresenter> r;
    public final Provider<CarMarketPriceChartPresenter> s;

    public MyAdvertDetailsActivity_MembersInjector(Provider<Analytics> provider, Provider<AdvertSharingEventTracker> provider2, Provider<DeliveryEventTracker> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DeepLinkFactory> provider5, Provider<MyAdvertDetailsPresenter> provider6, Provider<MyAdvertContactsPresenter> provider7, Provider<ImplicitIntentFactory> provider8, Provider<ActivityIntentFactory> provider9, Provider<SocialPresenter> provider10, Provider<MyAdvertDetailsInteractor> provider11, Provider<Features> provider12, Provider<AttributedTextFormatter> provider13, Provider<DialogRouter> provider14, Provider<SocialTypeToStringMapper> provider15, Provider<MyAdvertDetailsTracker> provider16, Provider<MyAdvertDetailsFeatureTeaserViewFactory> provider17, Provider<AdvertDetailsImvBadgePresenter> provider18, Provider<CarMarketPriceChartPresenter> provider19) {
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
    }

    public static MembersInjector<MyAdvertDetailsActivity> create(Provider<Analytics> provider, Provider<AdvertSharingEventTracker> provider2, Provider<DeliveryEventTracker> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DeepLinkFactory> provider5, Provider<MyAdvertDetailsPresenter> provider6, Provider<MyAdvertContactsPresenter> provider7, Provider<ImplicitIntentFactory> provider8, Provider<ActivityIntentFactory> provider9, Provider<SocialPresenter> provider10, Provider<MyAdvertDetailsInteractor> provider11, Provider<Features> provider12, Provider<AttributedTextFormatter> provider13, Provider<DialogRouter> provider14, Provider<SocialTypeToStringMapper> provider15, Provider<MyAdvertDetailsTracker> provider16, Provider<MyAdvertDetailsFeatureTeaserViewFactory> provider17, Provider<AdvertDetailsImvBadgePresenter> provider18, Provider<CarMarketPriceChartPresenter> provider19) {
        return new MyAdvertDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(MyAdvertDetailsActivity myAdvertDetailsActivity, ActivityIntentFactory activityIntentFactory) {
        myAdvertDetailsActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.analytics")
    public static void injectAnalytics(MyAdvertDetailsActivity myAdvertDetailsActivity, Analytics analytics) {
        myAdvertDetailsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.attributedTextFormatter")
    public static void injectAttributedTextFormatter(MyAdvertDetailsActivity myAdvertDetailsActivity, AttributedTextFormatter attributedTextFormatter) {
        myAdvertDetailsActivity.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.contactsPresenter")
    public static void injectContactsPresenter(MyAdvertDetailsActivity myAdvertDetailsActivity, MyAdvertContactsPresenter myAdvertContactsPresenter) {
        myAdvertDetailsActivity.contactsPresenter = myAdvertContactsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.deepLinkFactory")
    public static void injectDeepLinkFactory(MyAdvertDetailsActivity myAdvertDetailsActivity, DeepLinkFactory deepLinkFactory) {
        myAdvertDetailsActivity.deepLinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(MyAdvertDetailsActivity myAdvertDetailsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        myAdvertDetailsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.deliveryEventTracker")
    public static void injectDeliveryEventTracker(MyAdvertDetailsActivity myAdvertDetailsActivity, DeliveryEventTracker deliveryEventTracker) {
        myAdvertDetailsActivity.deliveryEventTracker = deliveryEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.dialogRouter")
    public static void injectDialogRouter(MyAdvertDetailsActivity myAdvertDetailsActivity, DialogRouter dialogRouter) {
        myAdvertDetailsActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.eventTracker")
    public static void injectEventTracker(MyAdvertDetailsActivity myAdvertDetailsActivity, AdvertSharingEventTracker advertSharingEventTracker) {
        myAdvertDetailsActivity.eventTracker = advertSharingEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.featureTeasersViewFactory")
    public static void injectFeatureTeasersViewFactory(MyAdvertDetailsActivity myAdvertDetailsActivity, MyAdvertDetailsFeatureTeaserViewFactory myAdvertDetailsFeatureTeaserViewFactory) {
        myAdvertDetailsActivity.featureTeasersViewFactory = myAdvertDetailsFeatureTeaserViewFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.features")
    public static void injectFeatures(MyAdvertDetailsActivity myAdvertDetailsActivity, Features features) {
        myAdvertDetailsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(MyAdvertDetailsActivity myAdvertDetailsActivity, ImplicitIntentFactory implicitIntentFactory) {
        myAdvertDetailsActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.imvBadgePresenter")
    public static void injectImvBadgePresenter(MyAdvertDetailsActivity myAdvertDetailsActivity, AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter) {
        myAdvertDetailsActivity.imvBadgePresenter = advertDetailsImvBadgePresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.imvChartPresenter")
    public static void injectImvChartPresenter(MyAdvertDetailsActivity myAdvertDetailsActivity, CarMarketPriceChartPresenter carMarketPriceChartPresenter) {
        myAdvertDetailsActivity.imvChartPresenter = carMarketPriceChartPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.interactor")
    public static void injectInteractor(MyAdvertDetailsActivity myAdvertDetailsActivity, MyAdvertDetailsInteractor myAdvertDetailsInteractor) {
        myAdvertDetailsActivity.interactor = myAdvertDetailsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.presenter")
    public static void injectPresenter(MyAdvertDetailsActivity myAdvertDetailsActivity, MyAdvertDetailsPresenter myAdvertDetailsPresenter) {
        myAdvertDetailsActivity.presenter = myAdvertDetailsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.socialPresenter")
    public static void injectSocialPresenter(MyAdvertDetailsActivity myAdvertDetailsActivity, SocialPresenter socialPresenter) {
        myAdvertDetailsActivity.socialPresenter = socialPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.socialTypeToStringMapper")
    public static void injectSocialTypeToStringMapper(MyAdvertDetailsActivity myAdvertDetailsActivity, SocialTypeToStringMapper socialTypeToStringMapper) {
        myAdvertDetailsActivity.socialTypeToStringMapper = socialTypeToStringMapper;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.MyAdvertDetailsActivity.tracker")
    public static void injectTracker(MyAdvertDetailsActivity myAdvertDetailsActivity, MyAdvertDetailsTracker myAdvertDetailsTracker) {
        myAdvertDetailsActivity.tracker = myAdvertDetailsTracker;
    }

    public void injectMembers(MyAdvertDetailsActivity myAdvertDetailsActivity) {
        injectAnalytics(myAdvertDetailsActivity, this.a.get());
        injectEventTracker(myAdvertDetailsActivity, this.b.get());
        injectDeliveryEventTracker(myAdvertDetailsActivity, this.c.get());
        injectDeepLinkIntentFactory(myAdvertDetailsActivity, this.d.get());
        injectDeepLinkFactory(myAdvertDetailsActivity, this.e.get());
        injectPresenter(myAdvertDetailsActivity, this.f.get());
        injectContactsPresenter(myAdvertDetailsActivity, this.g.get());
        injectImplicitIntentFactory(myAdvertDetailsActivity, this.h.get());
        injectActivityIntentFactory(myAdvertDetailsActivity, this.i.get());
        injectSocialPresenter(myAdvertDetailsActivity, this.j.get());
        injectInteractor(myAdvertDetailsActivity, this.k.get());
        injectFeatures(myAdvertDetailsActivity, this.l.get());
        injectAttributedTextFormatter(myAdvertDetailsActivity, this.m.get());
        injectDialogRouter(myAdvertDetailsActivity, this.n.get());
        injectSocialTypeToStringMapper(myAdvertDetailsActivity, this.o.get());
        injectTracker(myAdvertDetailsActivity, this.p.get());
        injectFeatureTeasersViewFactory(myAdvertDetailsActivity, this.q.get());
        injectImvBadgePresenter(myAdvertDetailsActivity, this.r.get());
        injectImvChartPresenter(myAdvertDetailsActivity, this.s.get());
    }
}
