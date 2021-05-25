package com.avito.android.advert.item;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerPresenter;
import com.avito.android.advert.item.address.AdvertDetailsAddressPresenter;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenter;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.booking.AdvertBookingPresenter;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationPresenter;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionPresenter;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactory;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionPresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AdvertDetailsFragment_MembersInjector implements MembersInjector<AdvertDetailsFragment> {
    public final Provider<GridLayoutManager.SpanSizeLookup> A;
    public final Provider<SerpSpanProvider> B;
    public final Provider<FavoriteAdvertsPresenter> C;
    public final Provider<ViewedAdvertsPresenter> D;
    public final Provider<SectionActionPresenter> E;
    public final Provider<SectionItemPresenter> F;
    public final Provider<DfpCreditViewModelFactory> G;
    public final Provider<AdvertDetailsTracker> H;
    public final Provider<AdvertDetailsDescriptionPresenter> I;
    public final Provider<AdvertDetailsAddressPresenter> J;
    public final Provider<AdvertDetailsShowOnMapPresenter> K;
    public final Provider<AdvertDetailsPriceSubscriptionPresenter> L;
    public final Provider<AdvertDetailsConsultationPresenter> M;
    public final Provider<AdvertDetailsGeoReferencePresenter> N;
    public final Provider<AdvertDetailsShortTermRentPresenter> O;
    public final Provider<AdvertDetailsItemsPresenter> P;
    public final Provider<SellerSubscriptionPresenter> Q;
    public final Provider<AdvertDetailsAutoCatalogPresenter> R;
    public final Provider<AdvertDetailsCreditInfoPresenter> S;
    public final Provider<AdvertDetailsDeliveryInfoPresenter> T;
    public final Provider<AdvertDetailsRatingPublishPresenter> U;
    public final Provider<DomotekaTeaserInteractor> V;
    public final Provider<AdvertDetailsDomotekaTeaserPresenter> W;
    public final Provider<MarketplaceDeliveryPresenter> X;
    public final Provider<RecommendationItemPresenter> Y;
    public final Provider<AdvertDetailsGuidePresenter> Z;
    public final Provider<Analytics> a;
    public final Provider<AdvertDetailsIceBreakersPresenter> a0;
    public final Provider<AccountStateProvider> b;
    public final Provider<AdvertDetailsSafeDealServicesPresenter> b0;
    public final Provider<AdvertDetailsPresenter> c;
    public final Provider<AdvertBookingPresenter> c0;
    public final Provider<ImplicitIntentFactory> d;
    public final Provider<AdvertBadgeBarPresenter> d0;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<AdvertDetailsImvBadgePresenter> e0;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<CarMarketPriceChartPresenter> f0;
    public final Provider<DeviceMetrics> g;
    public final Provider<QuestionnairePresenter> g0;
    public final Provider<Formatter<String>> h;
    public final Provider<AdvertDetailsAnalyticsInteractor> h0;
    public final Provider<AdvertSellerPresenter> i;
    public final Provider<CreditBrokerAnalyticsInteractor> i0;
    public final Provider<AdditionalSellerPresenter> j;
    public final Provider<SparePartsPresenter> j0;
    public final Provider<AdvertContactsPresenter> k;
    public final Provider<SparePartsPresenter> k0;
    public final Provider<AdvertDetailsToolbarPresenter> l;
    public final Provider<FpsStateSupplier> l0;
    public final Provider<Features> m;
    public final Provider<ItemVisibilityTracker> m0;
    public final Provider<AdvertDeliveryPresenter> n;
    public final Provider<DialogRouter> n0;
    public final Provider<AdvertSafeDealPresenter> o;
    public final Provider<CompositeSnackbarPresenter> o0;
    public final Provider<AdapterPresenter> p;
    public final Provider<PromoCardItemPresenter> p0;
    public final Provider<AdvertSimilarPresenterResourceProvider> q;
    public final Provider<AdvertDetailsGeoReportTeaserPresenter> q0;
    public final Provider<AdvertDetailsAutotekaPresenter> r;
    public final Provider<CartFabViewModel> r0;
    public final Provider<AdvertDetailsAutotekaTeaserPresenter> s;
    public final Provider<CartQuantityChangesHandler> s0;
    public final Provider<AutotekaDetailsInteractor> t;
    public final Provider<MarketplacePresenter> t0;
    public final Provider<AutotekaTeaserInteractor> u;
    public final Provider<AdvertDetailsNotePresenter> v;
    public final Provider<DestroyableViewHolderBuilder> w;
    public final Provider<AdvertComplementaryPresenter> x;
    public final Provider<SafeRecyclerAdapter> y;
    public final Provider<SpannedGridPositionProvider> z;

    public AdvertDetailsFragment_MembersInjector(Provider<Analytics> provider, Provider<AccountStateProvider> provider2, Provider<AdvertDetailsPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeviceMetrics> provider7, Provider<Formatter<String>> provider8, Provider<AdvertSellerPresenter> provider9, Provider<AdditionalSellerPresenter> provider10, Provider<AdvertContactsPresenter> provider11, Provider<AdvertDetailsToolbarPresenter> provider12, Provider<Features> provider13, Provider<AdvertDeliveryPresenter> provider14, Provider<AdvertSafeDealPresenter> provider15, Provider<AdapterPresenter> provider16, Provider<AdvertSimilarPresenterResourceProvider> provider17, Provider<AdvertDetailsAutotekaPresenter> provider18, Provider<AdvertDetailsAutotekaTeaserPresenter> provider19, Provider<AutotekaDetailsInteractor> provider20, Provider<AutotekaTeaserInteractor> provider21, Provider<AdvertDetailsNotePresenter> provider22, Provider<DestroyableViewHolderBuilder> provider23, Provider<AdvertComplementaryPresenter> provider24, Provider<SafeRecyclerAdapter> provider25, Provider<SpannedGridPositionProvider> provider26, Provider<GridLayoutManager.SpanSizeLookup> provider27, Provider<SerpSpanProvider> provider28, Provider<FavoriteAdvertsPresenter> provider29, Provider<ViewedAdvertsPresenter> provider30, Provider<SectionActionPresenter> provider31, Provider<SectionItemPresenter> provider32, Provider<DfpCreditViewModelFactory> provider33, Provider<AdvertDetailsTracker> provider34, Provider<AdvertDetailsDescriptionPresenter> provider35, Provider<AdvertDetailsAddressPresenter> provider36, Provider<AdvertDetailsShowOnMapPresenter> provider37, Provider<AdvertDetailsPriceSubscriptionPresenter> provider38, Provider<AdvertDetailsConsultationPresenter> provider39, Provider<AdvertDetailsGeoReferencePresenter> provider40, Provider<AdvertDetailsShortTermRentPresenter> provider41, Provider<AdvertDetailsItemsPresenter> provider42, Provider<SellerSubscriptionPresenter> provider43, Provider<AdvertDetailsAutoCatalogPresenter> provider44, Provider<AdvertDetailsCreditInfoPresenter> provider45, Provider<AdvertDetailsDeliveryInfoPresenter> provider46, Provider<AdvertDetailsRatingPublishPresenter> provider47, Provider<DomotekaTeaserInteractor> provider48, Provider<AdvertDetailsDomotekaTeaserPresenter> provider49, Provider<MarketplaceDeliveryPresenter> provider50, Provider<RecommendationItemPresenter> provider51, Provider<AdvertDetailsGuidePresenter> provider52, Provider<AdvertDetailsIceBreakersPresenter> provider53, Provider<AdvertDetailsSafeDealServicesPresenter> provider54, Provider<AdvertBookingPresenter> provider55, Provider<AdvertBadgeBarPresenter> provider56, Provider<AdvertDetailsImvBadgePresenter> provider57, Provider<CarMarketPriceChartPresenter> provider58, Provider<QuestionnairePresenter> provider59, Provider<AdvertDetailsAnalyticsInteractor> provider60, Provider<CreditBrokerAnalyticsInteractor> provider61, Provider<SparePartsPresenter> provider62, Provider<SparePartsPresenter> provider63, Provider<FpsStateSupplier> provider64, Provider<ItemVisibilityTracker> provider65, Provider<DialogRouter> provider66, Provider<CompositeSnackbarPresenter> provider67, Provider<PromoCardItemPresenter> provider68, Provider<AdvertDetailsGeoReportTeaserPresenter> provider69, Provider<CartFabViewModel> provider70, Provider<CartQuantityChangesHandler> provider71, Provider<MarketplacePresenter> provider72) {
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
        this.x = provider24;
        this.y = provider25;
        this.z = provider26;
        this.A = provider27;
        this.B = provider28;
        this.C = provider29;
        this.D = provider30;
        this.E = provider31;
        this.F = provider32;
        this.G = provider33;
        this.H = provider34;
        this.I = provider35;
        this.J = provider36;
        this.K = provider37;
        this.L = provider38;
        this.M = provider39;
        this.N = provider40;
        this.O = provider41;
        this.P = provider42;
        this.Q = provider43;
        this.R = provider44;
        this.S = provider45;
        this.T = provider46;
        this.U = provider47;
        this.V = provider48;
        this.W = provider49;
        this.X = provider50;
        this.Y = provider51;
        this.Z = provider52;
        this.a0 = provider53;
        this.b0 = provider54;
        this.c0 = provider55;
        this.d0 = provider56;
        this.e0 = provider57;
        this.f0 = provider58;
        this.g0 = provider59;
        this.h0 = provider60;
        this.i0 = provider61;
        this.j0 = provider62;
        this.k0 = provider63;
        this.l0 = provider64;
        this.m0 = provider65;
        this.n0 = provider66;
        this.o0 = provider67;
        this.p0 = provider68;
        this.q0 = provider69;
        this.r0 = provider70;
        this.s0 = provider71;
        this.t0 = provider72;
    }

    public static MembersInjector<AdvertDetailsFragment> create(Provider<Analytics> provider, Provider<AccountStateProvider> provider2, Provider<AdvertDetailsPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeviceMetrics> provider7, Provider<Formatter<String>> provider8, Provider<AdvertSellerPresenter> provider9, Provider<AdditionalSellerPresenter> provider10, Provider<AdvertContactsPresenter> provider11, Provider<AdvertDetailsToolbarPresenter> provider12, Provider<Features> provider13, Provider<AdvertDeliveryPresenter> provider14, Provider<AdvertSafeDealPresenter> provider15, Provider<AdapterPresenter> provider16, Provider<AdvertSimilarPresenterResourceProvider> provider17, Provider<AdvertDetailsAutotekaPresenter> provider18, Provider<AdvertDetailsAutotekaTeaserPresenter> provider19, Provider<AutotekaDetailsInteractor> provider20, Provider<AutotekaTeaserInteractor> provider21, Provider<AdvertDetailsNotePresenter> provider22, Provider<DestroyableViewHolderBuilder> provider23, Provider<AdvertComplementaryPresenter> provider24, Provider<SafeRecyclerAdapter> provider25, Provider<SpannedGridPositionProvider> provider26, Provider<GridLayoutManager.SpanSizeLookup> provider27, Provider<SerpSpanProvider> provider28, Provider<FavoriteAdvertsPresenter> provider29, Provider<ViewedAdvertsPresenter> provider30, Provider<SectionActionPresenter> provider31, Provider<SectionItemPresenter> provider32, Provider<DfpCreditViewModelFactory> provider33, Provider<AdvertDetailsTracker> provider34, Provider<AdvertDetailsDescriptionPresenter> provider35, Provider<AdvertDetailsAddressPresenter> provider36, Provider<AdvertDetailsShowOnMapPresenter> provider37, Provider<AdvertDetailsPriceSubscriptionPresenter> provider38, Provider<AdvertDetailsConsultationPresenter> provider39, Provider<AdvertDetailsGeoReferencePresenter> provider40, Provider<AdvertDetailsShortTermRentPresenter> provider41, Provider<AdvertDetailsItemsPresenter> provider42, Provider<SellerSubscriptionPresenter> provider43, Provider<AdvertDetailsAutoCatalogPresenter> provider44, Provider<AdvertDetailsCreditInfoPresenter> provider45, Provider<AdvertDetailsDeliveryInfoPresenter> provider46, Provider<AdvertDetailsRatingPublishPresenter> provider47, Provider<DomotekaTeaserInteractor> provider48, Provider<AdvertDetailsDomotekaTeaserPresenter> provider49, Provider<MarketplaceDeliveryPresenter> provider50, Provider<RecommendationItemPresenter> provider51, Provider<AdvertDetailsGuidePresenter> provider52, Provider<AdvertDetailsIceBreakersPresenter> provider53, Provider<AdvertDetailsSafeDealServicesPresenter> provider54, Provider<AdvertBookingPresenter> provider55, Provider<AdvertBadgeBarPresenter> provider56, Provider<AdvertDetailsImvBadgePresenter> provider57, Provider<CarMarketPriceChartPresenter> provider58, Provider<QuestionnairePresenter> provider59, Provider<AdvertDetailsAnalyticsInteractor> provider60, Provider<CreditBrokerAnalyticsInteractor> provider61, Provider<SparePartsPresenter> provider62, Provider<SparePartsPresenter> provider63, Provider<FpsStateSupplier> provider64, Provider<ItemVisibilityTracker> provider65, Provider<DialogRouter> provider66, Provider<CompositeSnackbarPresenter> provider67, Provider<PromoCardItemPresenter> provider68, Provider<AdvertDetailsGeoReportTeaserPresenter> provider69, Provider<CartFabViewModel> provider70, Provider<CartQuantityChangesHandler> provider71, Provider<MarketplacePresenter> provider72) {
        return new AdvertDetailsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43, provider44, provider45, provider46, provider47, provider48, provider49, provider50, provider51, provider52, provider53, provider54, provider55, provider56, provider57, provider58, provider59, provider60, provider61, provider62, provider63, provider64, provider65, provider66, provider67, provider68, provider69, provider70, provider71, provider72);
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.accountStatus")
    public static void injectAccountStatus(AdvertDetailsFragment advertDetailsFragment, AccountStateProvider accountStateProvider) {
        advertDetailsFragment.accountStatus = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(AdvertDetailsFragment advertDetailsFragment, ActivityIntentFactory activityIntentFactory) {
        advertDetailsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.additionalSellerPresenter")
    public static void injectAdditionalSellerPresenter(AdvertDetailsFragment advertDetailsFragment, AdditionalSellerPresenter additionalSellerPresenter) {
        advertDetailsFragment.additionalSellerPresenter = additionalSellerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.addressPresenter")
    public static void injectAddressPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsAddressPresenter advertDetailsAddressPresenter) {
        advertDetailsFragment.addressPresenter = advertDetailsAddressPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertComplementaryPresenter")
    public static void injectAdvertComplementaryPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertComplementaryPresenter advertComplementaryPresenter) {
        advertDetailsFragment.advertComplementaryPresenter = advertComplementaryPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsAutoCatalogPresenter")
    public static void injectAdvertDetailsAutoCatalogPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter) {
        advertDetailsFragment.advertDetailsAutoCatalogPresenter = advertDetailsAutoCatalogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsConsultationPresenter")
    public static void injectAdvertDetailsConsultationPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter) {
        advertDetailsFragment.advertDetailsConsultationPresenter = advertDetailsConsultationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsCreditInfoPresenter")
    public static void injectAdvertDetailsCreditInfoPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter) {
        advertDetailsFragment.advertDetailsCreditInfoPresenter = advertDetailsCreditInfoPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsDeliveryInfoPresenter")
    public static void injectAdvertDetailsDeliveryInfoPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter) {
        advertDetailsFragment.advertDetailsDeliveryInfoPresenter = advertDetailsDeliveryInfoPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsGuidePresenter")
    public static void injectAdvertDetailsGuidePresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsGuidePresenter advertDetailsGuidePresenter) {
        advertDetailsFragment.advertDetailsGuidePresenter = advertDetailsGuidePresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsItemsPresenter")
    public static void injectAdvertDetailsItemsPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsItemsPresenter advertDetailsItemsPresenter) {
        advertDetailsFragment.advertDetailsItemsPresenter = advertDetailsItemsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsPriceSubscriptionPresenter")
    public static void injectAdvertDetailsPriceSubscriptionPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter) {
        advertDetailsFragment.advertDetailsPriceSubscriptionPresenter = advertDetailsPriceSubscriptionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsRatingPublishPresenter")
    public static void injectAdvertDetailsRatingPublishPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter) {
        advertDetailsFragment.advertDetailsRatingPublishPresenter = advertDetailsRatingPublishPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsShowOnMapPresenter")
    public static void injectAdvertDetailsShowOnMapPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter) {
        advertDetailsFragment.advertDetailsShowOnMapPresenter = advertDetailsShowOnMapPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.advertDetailsToolbarPresenter")
    public static void injectAdvertDetailsToolbarPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter) {
        advertDetailsFragment.advertDetailsToolbarPresenter = advertDetailsToolbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.analytics")
    public static void injectAnalytics(AdvertDetailsFragment advertDetailsFragment, Analytics analytics) {
        advertDetailsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.analyticsInteractor")
    public static void injectAnalyticsInteractor(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        advertDetailsFragment.analyticsInteractor = advertDetailsAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.autotekaDetailsInteractor")
    public static void injectAutotekaDetailsInteractor(AdvertDetailsFragment advertDetailsFragment, AutotekaDetailsInteractor autotekaDetailsInteractor) {
        advertDetailsFragment.autotekaDetailsInteractor = autotekaDetailsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.autotekaPresenter")
    public static void injectAutotekaPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter) {
        advertDetailsFragment.autotekaPresenter = advertDetailsAutotekaPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.autotekaTeaserInteractor")
    public static void injectAutotekaTeaserInteractor(AdvertDetailsFragment advertDetailsFragment, AutotekaTeaserInteractor autotekaTeaserInteractor) {
        advertDetailsFragment.autotekaTeaserInteractor = autotekaTeaserInteractor;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.autotekaTeaserPresenter")
    public static void injectAutotekaTeaserPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter) {
        advertDetailsFragment.autotekaTeaserPresenter = advertDetailsAutotekaTeaserPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.badgeBarPresenter")
    public static void injectBadgeBarPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertBadgeBarPresenter advertBadgeBarPresenter) {
        advertDetailsFragment.badgeBarPresenter = advertBadgeBarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.bookingPresenter")
    public static void injectBookingPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertBookingPresenter advertBookingPresenter) {
        advertDetailsFragment.bookingPresenter = advertBookingPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.cartFabQuantityHandler")
    public static void injectCartFabQuantityHandler(AdvertDetailsFragment advertDetailsFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        advertDetailsFragment.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.cartFabViewModel")
    public static void injectCartFabViewModel(AdvertDetailsFragment advertDetailsFragment, CartFabViewModel cartFabViewModel) {
        advertDetailsFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.compatibilitiesPresenter")
    @SparePartsModule.CompatibilitiesPresenter
    public static void injectCompatibilitiesPresenter(AdvertDetailsFragment advertDetailsFragment, SparePartsPresenter sparePartsPresenter) {
        advertDetailsFragment.compatibilitiesPresenter = sparePartsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.contactsPresenter")
    public static void injectContactsPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertContactsPresenter advertContactsPresenter) {
        advertDetailsFragment.contactsPresenter = advertContactsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.creGeoReportPresenter")
    public static void injectCreGeoReportPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter) {
        advertDetailsFragment.creGeoReportPresenter = advertDetailsGeoReportTeaserPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.creditBrokerAnalyticsInteractor")
    public static void injectCreditBrokerAnalyticsInteractor(AdvertDetailsFragment advertDetailsFragment, CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor) {
        advertDetailsFragment.creditBrokerAnalyticsInteractor = creditBrokerAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.creditViewModelFactory")
    public static void injectCreditViewModelFactory(AdvertDetailsFragment advertDetailsFragment, DfpCreditViewModelFactory dfpCreditViewModelFactory) {
        advertDetailsFragment.creditViewModelFactory = dfpCreditViewModelFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AdvertDetailsFragment advertDetailsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        advertDetailsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.deliveryPresenter")
    public static void injectDeliveryPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDeliveryPresenter advertDeliveryPresenter) {
        advertDetailsFragment.deliveryPresenter = advertDeliveryPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.descriptionPresenter")
    public static void injectDescriptionPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsDescriptionPresenter advertDetailsDescriptionPresenter) {
        advertDetailsFragment.descriptionPresenter = advertDetailsDescriptionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.destroyableComplementaryViewHolderBuilder")
    public static void injectDestroyableComplementaryViewHolderBuilder(AdvertDetailsFragment advertDetailsFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        advertDetailsFragment.destroyableComplementaryViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.deviceMetrics")
    public static void injectDeviceMetrics(AdvertDetailsFragment advertDetailsFragment, DeviceMetrics deviceMetrics) {
        advertDetailsFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.dialogRouter")
    public static void injectDialogRouter(AdvertDetailsFragment advertDetailsFragment, DialogRouter dialogRouter) {
        advertDetailsFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.domotekaTeaserInteractor")
    public static void injectDomotekaTeaserInteractor(AdvertDetailsFragment advertDetailsFragment, DomotekaTeaserInteractor domotekaTeaserInteractor) {
        advertDetailsFragment.domotekaTeaserInteractor = domotekaTeaserInteractor;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.domotekaTeaserPresenter")
    public static void injectDomotekaTeaserPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter) {
        advertDetailsFragment.domotekaTeaserPresenter = advertDetailsDomotekaTeaserPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(AdvertDetailsFragment advertDetailsFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        advertDetailsFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.features")
    public static void injectFeatures(AdvertDetailsFragment advertDetailsFragment, Features features) {
        advertDetailsFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.geoReferencePresenter")
    public static void injectGeoReferencePresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsGeoReferencePresenter advertDetailsGeoReferencePresenter) {
        advertDetailsFragment.geoReferencePresenter = advertDetailsGeoReferencePresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.gridPositionProvider")
    public static void injectGridPositionProvider(AdvertDetailsFragment advertDetailsFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        advertDetailsFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.iceBreakersPresenter")
    public static void injectIceBreakersPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter) {
        advertDetailsFragment.iceBreakersPresenter = advertDetailsIceBreakersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(AdvertDetailsFragment advertDetailsFragment, ImplicitIntentFactory implicitIntentFactory) {
        advertDetailsFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.imvBadgePresenter")
    public static void injectImvBadgePresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter) {
        advertDetailsFragment.imvBadgePresenter = advertDetailsImvBadgePresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.imvChartPresenter")
    public static void injectImvChartPresenter(AdvertDetailsFragment advertDetailsFragment, CarMarketPriceChartPresenter carMarketPriceChartPresenter) {
        advertDetailsFragment.imvChartPresenter = carMarketPriceChartPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.itemVisibilityTracker")
    public static void injectItemVisibilityTracker(AdvertDetailsFragment advertDetailsFragment, ItemVisibilityTracker itemVisibilityTracker) {
        advertDetailsFragment.itemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.itemsSafeRecyclerAdapter")
    public static void injectItemsSafeRecyclerAdapter(AdvertDetailsFragment advertDetailsFragment, SafeRecyclerAdapter safeRecyclerAdapter) {
        advertDetailsFragment.itemsSafeRecyclerAdapter = safeRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.marketplaceDeliveryPresenter")
    public static void injectMarketplaceDeliveryPresenter(AdvertDetailsFragment advertDetailsFragment, MarketplaceDeliveryPresenter marketplaceDeliveryPresenter) {
        advertDetailsFragment.marketplaceDeliveryPresenter = marketplaceDeliveryPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.notePresenter")
    public static void injectNotePresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsNotePresenter advertDetailsNotePresenter) {
        advertDetailsFragment.notePresenter = advertDetailsNotePresenter;
    }

    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.phoneNumberFormatter")
    public static void injectPhoneNumberFormatter(AdvertDetailsFragment advertDetailsFragment, Formatter<String> formatter) {
        advertDetailsFragment.phoneNumberFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.presenter")
    public static void injectPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsPresenter advertDetailsPresenter) {
        advertDetailsFragment.presenter = advertDetailsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.promoCardPresenter")
    public static void injectPromoCardPresenter(AdvertDetailsFragment advertDetailsFragment, PromoCardItemPresenter promoCardItemPresenter) {
        advertDetailsFragment.promoCardPresenter = promoCardItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.questionnairePresenter")
    public static void injectQuestionnairePresenter(AdvertDetailsFragment advertDetailsFragment, QuestionnairePresenter questionnairePresenter) {
        advertDetailsFragment.questionnairePresenter = questionnairePresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.recommendationPresenter")
    public static void injectRecommendationPresenter(AdvertDetailsFragment advertDetailsFragment, RecommendationItemPresenter recommendationItemPresenter) {
        advertDetailsFragment.recommendationPresenter = recommendationItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.replacementsPresenter")
    @SparePartsModule.ReplacementsPresenter
    public static void injectReplacementsPresenter(AdvertDetailsFragment advertDetailsFragment, SparePartsPresenter sparePartsPresenter) {
        advertDetailsFragment.replacementsPresenter = sparePartsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.safeDealServicesPresenter")
    public static void injectSafeDealServicesPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsSafeDealServicesPresenter advertDetailsSafeDealServicesPresenter) {
        advertDetailsFragment.safeDealServicesPresenter = advertDetailsSafeDealServicesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.safedealPresenter")
    public static void injectSafedealPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertSafeDealPresenter advertSafeDealPresenter) {
        advertDetailsFragment.safedealPresenter = advertSafeDealPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.sectionActionPresenter")
    public static void injectSectionActionPresenter(AdvertDetailsFragment advertDetailsFragment, SectionActionPresenter sectionActionPresenter) {
        advertDetailsFragment.sectionActionPresenter = sectionActionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.sectionItemPresenter")
    public static void injectSectionItemPresenter(AdvertDetailsFragment advertDetailsFragment, SectionItemPresenter sectionItemPresenter) {
        advertDetailsFragment.sectionItemPresenter = sectionItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.sectionsAdapterPresenter")
    public static void injectSectionsAdapterPresenter(AdvertDetailsFragment advertDetailsFragment, AdapterPresenter adapterPresenter) {
        advertDetailsFragment.sectionsAdapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.sellerPresenter")
    public static void injectSellerPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertSellerPresenter advertSellerPresenter) {
        advertDetailsFragment.sellerPresenter = advertSellerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.sellerSubscriptionPresenter")
    public static void injectSellerSubscriptionPresenter(AdvertDetailsFragment advertDetailsFragment, SellerSubscriptionPresenter sellerSubscriptionPresenter) {
        advertDetailsFragment.sellerSubscriptionPresenter = sellerSubscriptionPresenter;
    }

    public static void injectSetMarketplacePresenter(AdvertDetailsFragment advertDetailsFragment, MarketplacePresenter marketplacePresenter) {
        advertDetailsFragment.setMarketplacePresenter(marketplacePresenter);
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.shortTermRentPresenter")
    public static void injectShortTermRentPresenter(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter) {
        advertDetailsFragment.shortTermRentPresenter = advertDetailsShortTermRentPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.similarAdvertResources")
    public static void injectSimilarAdvertResources(AdvertDetailsFragment advertDetailsFragment, AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider) {
        advertDetailsFragment.similarAdvertResources = advertSimilarPresenterResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(AdvertDetailsFragment advertDetailsFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        advertDetailsFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.spanProvider")
    public static void injectSpanProvider(AdvertDetailsFragment advertDetailsFragment, SerpSpanProvider serpSpanProvider) {
        advertDetailsFragment.spanProvider = serpSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(AdvertDetailsFragment advertDetailsFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        advertDetailsFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.supplier")
    public static void injectSupplier(AdvertDetailsFragment advertDetailsFragment, FpsStateSupplier fpsStateSupplier) {
        advertDetailsFragment.supplier = fpsStateSupplier;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.tracker")
    public static void injectTracker(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsTracker advertDetailsTracker) {
        advertDetailsFragment.tracker = advertDetailsTracker;
    }

    @InjectedFieldSignature("com.avito.android.advert.item.AdvertDetailsFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(AdvertDetailsFragment advertDetailsFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        advertDetailsFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(AdvertDetailsFragment advertDetailsFragment) {
        injectAnalytics(advertDetailsFragment, this.a.get());
        injectAccountStatus(advertDetailsFragment, this.b.get());
        injectPresenter(advertDetailsFragment, this.c.get());
        injectImplicitIntentFactory(advertDetailsFragment, this.d.get());
        injectDeepLinkIntentFactory(advertDetailsFragment, this.e.get());
        injectActivityIntentFactory(advertDetailsFragment, this.f.get());
        injectDeviceMetrics(advertDetailsFragment, this.g.get());
        injectPhoneNumberFormatter(advertDetailsFragment, this.h.get());
        injectSellerPresenter(advertDetailsFragment, this.i.get());
        injectAdditionalSellerPresenter(advertDetailsFragment, this.j.get());
        injectContactsPresenter(advertDetailsFragment, this.k.get());
        injectAdvertDetailsToolbarPresenter(advertDetailsFragment, this.l.get());
        injectFeatures(advertDetailsFragment, this.m.get());
        injectDeliveryPresenter(advertDetailsFragment, this.n.get());
        injectSafedealPresenter(advertDetailsFragment, this.o.get());
        injectSectionsAdapterPresenter(advertDetailsFragment, this.p.get());
        injectSimilarAdvertResources(advertDetailsFragment, this.q.get());
        injectAutotekaPresenter(advertDetailsFragment, this.r.get());
        injectAutotekaTeaserPresenter(advertDetailsFragment, this.s.get());
        injectAutotekaDetailsInteractor(advertDetailsFragment, this.t.get());
        injectAutotekaTeaserInteractor(advertDetailsFragment, this.u.get());
        injectNotePresenter(advertDetailsFragment, this.v.get());
        injectDestroyableComplementaryViewHolderBuilder(advertDetailsFragment, this.w.get());
        injectAdvertComplementaryPresenter(advertDetailsFragment, this.x.get());
        injectItemsSafeRecyclerAdapter(advertDetailsFragment, this.y.get());
        injectGridPositionProvider(advertDetailsFragment, this.z.get());
        injectSpanSizeLookup(advertDetailsFragment, this.A.get());
        injectSpanProvider(advertDetailsFragment, this.B.get());
        injectFavoriteAdvertsPresenter(advertDetailsFragment, this.C.get());
        injectViewedAdvertsPresenter(advertDetailsFragment, this.D.get());
        injectSectionActionPresenter(advertDetailsFragment, this.E.get());
        injectSectionItemPresenter(advertDetailsFragment, this.F.get());
        injectCreditViewModelFactory(advertDetailsFragment, this.G.get());
        injectTracker(advertDetailsFragment, this.H.get());
        injectDescriptionPresenter(advertDetailsFragment, this.I.get());
        injectAddressPresenter(advertDetailsFragment, this.J.get());
        injectAdvertDetailsShowOnMapPresenter(advertDetailsFragment, this.K.get());
        injectAdvertDetailsPriceSubscriptionPresenter(advertDetailsFragment, this.L.get());
        injectAdvertDetailsConsultationPresenter(advertDetailsFragment, this.M.get());
        injectGeoReferencePresenter(advertDetailsFragment, this.N.get());
        injectShortTermRentPresenter(advertDetailsFragment, this.O.get());
        injectAdvertDetailsItemsPresenter(advertDetailsFragment, this.P.get());
        injectSellerSubscriptionPresenter(advertDetailsFragment, this.Q.get());
        injectAdvertDetailsAutoCatalogPresenter(advertDetailsFragment, this.R.get());
        injectAdvertDetailsCreditInfoPresenter(advertDetailsFragment, this.S.get());
        injectAdvertDetailsDeliveryInfoPresenter(advertDetailsFragment, this.T.get());
        injectAdvertDetailsRatingPublishPresenter(advertDetailsFragment, this.U.get());
        injectDomotekaTeaserInteractor(advertDetailsFragment, this.V.get());
        injectDomotekaTeaserPresenter(advertDetailsFragment, this.W.get());
        injectMarketplaceDeliveryPresenter(advertDetailsFragment, this.X.get());
        injectRecommendationPresenter(advertDetailsFragment, this.Y.get());
        injectAdvertDetailsGuidePresenter(advertDetailsFragment, this.Z.get());
        injectIceBreakersPresenter(advertDetailsFragment, this.a0.get());
        injectSafeDealServicesPresenter(advertDetailsFragment, this.b0.get());
        injectBookingPresenter(advertDetailsFragment, this.c0.get());
        injectBadgeBarPresenter(advertDetailsFragment, this.d0.get());
        injectImvBadgePresenter(advertDetailsFragment, this.e0.get());
        injectImvChartPresenter(advertDetailsFragment, this.f0.get());
        injectQuestionnairePresenter(advertDetailsFragment, this.g0.get());
        injectAnalyticsInteractor(advertDetailsFragment, this.h0.get());
        injectCreditBrokerAnalyticsInteractor(advertDetailsFragment, this.i0.get());
        injectReplacementsPresenter(advertDetailsFragment, this.j0.get());
        injectCompatibilitiesPresenter(advertDetailsFragment, this.k0.get());
        injectSupplier(advertDetailsFragment, this.l0.get());
        injectItemVisibilityTracker(advertDetailsFragment, this.m0.get());
        injectDialogRouter(advertDetailsFragment, this.n0.get());
        injectSnackbarPresenter(advertDetailsFragment, this.o0.get());
        injectPromoCardPresenter(advertDetailsFragment, this.p0.get());
        injectCreGeoReportPresenter(advertDetailsFragment, this.q0.get());
        injectCartFabViewModel(advertDetailsFragment, this.r0.get());
        injectCartFabQuantityHandler(advertDetailsFragment, this.s0.get());
        injectSetMarketplacePresenter(advertDetailsFragment, this.t0.get());
    }
}
