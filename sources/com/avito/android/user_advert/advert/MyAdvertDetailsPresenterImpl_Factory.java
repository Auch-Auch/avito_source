package com.avito.android.user_advert.advert;

import android.content.ClipboardManager;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.server_time.TimeSource;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenter;
import com.avito.android.user_advert.advert.verification.VerificationItemConverter;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.limits_info.LimitsInfoInteractor;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTracker;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.user_adverts_common.safety.SafetyInfoProvider;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsPresenterImpl_Factory implements Factory<MyAdvertDetailsPresenterImpl> {
    public final Provider<TimeSource> A;
    public final Provider<MyAdvertDetailsTracker> B;
    public final Provider<MyAdvertDetailsFeatureTeaserPresenter> C;
    public final Provider<VerificationItemConverter> D;
    public final Provider<CharityInteractor> E;
    public final Provider<LimitsInfoInteractor> F;
    public final Provider<PermissionStorage> G;
    public final Provider<PermissionStateProvider> H;
    public final Provider<MyAdvertStorage> I;
    public final Provider<SafetyInfoProvider> J;
    public final Provider<AccountStateProvider> K;
    public final Provider<BivrostTutorialSessionStorage> L;
    public final Provider<AdvertDetailsImvBadgePresenter> M;
    public final Provider<AdvertDetailsImvBadgeItemConverter> N;
    public final Provider<CarMarketPriceChartPresenter> O;
    public final Provider<CarMarketPriceDescriptionPresenter> P;
    public final Provider<String> Q;
    public final Provider<Kundle> R;
    public final Provider<DetailsId> a;
    public final Provider<Boolean> b;
    public final Provider<Boolean> c;
    public final Provider<Boolean> d;
    public final Provider<Boolean> e;
    public final Provider<Boolean> f;
    public final Provider<String> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<MyAdvertDetailsActionMenuConverter> i;
    public final Provider<AdvertAddressFormatter> j;
    public final Provider<MyAdvertDetailsConverter> k;
    public final Provider<MyAdvertDetailsInteractor> l;
    public final Provider<MyDraftAdvertDetailsInteractor> m;
    public final Provider<MyAdvertContactsPresenter> n;
    public final Provider<SocialPresenter> o;
    public final Provider<Analytics> p;
    public final Provider<ClipboardManager> q;
    public final Provider<ClipDataFactory> r;
    public final Provider<Features> s;
    public final Provider<MyAdvertDetailsResourceProvider> t;
    public final Provider<DateTimeFormatter> u;
    public final Provider<ErrorFormatter> v;
    public final Provider<PublishRelay<AdvertDeliveryC2C>> w;
    public final Provider<PublishRelay<AdvertSellerShortTermRent>> x;
    public final Provider<Relay<MyAdvertSafeDeal>> y;
    public final Provider<AppRaterInteractor> z;

    public MyAdvertDetailsPresenterImpl_Factory(Provider<DetailsId> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<String> provider7, Provider<SchedulersFactory3> provider8, Provider<MyAdvertDetailsActionMenuConverter> provider9, Provider<AdvertAddressFormatter> provider10, Provider<MyAdvertDetailsConverter> provider11, Provider<MyAdvertDetailsInteractor> provider12, Provider<MyDraftAdvertDetailsInteractor> provider13, Provider<MyAdvertContactsPresenter> provider14, Provider<SocialPresenter> provider15, Provider<Analytics> provider16, Provider<ClipboardManager> provider17, Provider<ClipDataFactory> provider18, Provider<Features> provider19, Provider<MyAdvertDetailsResourceProvider> provider20, Provider<DateTimeFormatter> provider21, Provider<ErrorFormatter> provider22, Provider<PublishRelay<AdvertDeliveryC2C>> provider23, Provider<PublishRelay<AdvertSellerShortTermRent>> provider24, Provider<Relay<MyAdvertSafeDeal>> provider25, Provider<AppRaterInteractor> provider26, Provider<TimeSource> provider27, Provider<MyAdvertDetailsTracker> provider28, Provider<MyAdvertDetailsFeatureTeaserPresenter> provider29, Provider<VerificationItemConverter> provider30, Provider<CharityInteractor> provider31, Provider<LimitsInfoInteractor> provider32, Provider<PermissionStorage> provider33, Provider<PermissionStateProvider> provider34, Provider<MyAdvertStorage> provider35, Provider<SafetyInfoProvider> provider36, Provider<AccountStateProvider> provider37, Provider<BivrostTutorialSessionStorage> provider38, Provider<AdvertDetailsImvBadgePresenter> provider39, Provider<AdvertDetailsImvBadgeItemConverter> provider40, Provider<CarMarketPriceChartPresenter> provider41, Provider<CarMarketPriceDescriptionPresenter> provider42, Provider<String> provider43, Provider<Kundle> provider44) {
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
    }

    public static MyAdvertDetailsPresenterImpl_Factory create(Provider<DetailsId> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<String> provider7, Provider<SchedulersFactory3> provider8, Provider<MyAdvertDetailsActionMenuConverter> provider9, Provider<AdvertAddressFormatter> provider10, Provider<MyAdvertDetailsConverter> provider11, Provider<MyAdvertDetailsInteractor> provider12, Provider<MyDraftAdvertDetailsInteractor> provider13, Provider<MyAdvertContactsPresenter> provider14, Provider<SocialPresenter> provider15, Provider<Analytics> provider16, Provider<ClipboardManager> provider17, Provider<ClipDataFactory> provider18, Provider<Features> provider19, Provider<MyAdvertDetailsResourceProvider> provider20, Provider<DateTimeFormatter> provider21, Provider<ErrorFormatter> provider22, Provider<PublishRelay<AdvertDeliveryC2C>> provider23, Provider<PublishRelay<AdvertSellerShortTermRent>> provider24, Provider<Relay<MyAdvertSafeDeal>> provider25, Provider<AppRaterInteractor> provider26, Provider<TimeSource> provider27, Provider<MyAdvertDetailsTracker> provider28, Provider<MyAdvertDetailsFeatureTeaserPresenter> provider29, Provider<VerificationItemConverter> provider30, Provider<CharityInteractor> provider31, Provider<LimitsInfoInteractor> provider32, Provider<PermissionStorage> provider33, Provider<PermissionStateProvider> provider34, Provider<MyAdvertStorage> provider35, Provider<SafetyInfoProvider> provider36, Provider<AccountStateProvider> provider37, Provider<BivrostTutorialSessionStorage> provider38, Provider<AdvertDetailsImvBadgePresenter> provider39, Provider<AdvertDetailsImvBadgeItemConverter> provider40, Provider<CarMarketPriceChartPresenter> provider41, Provider<CarMarketPriceDescriptionPresenter> provider42, Provider<String> provider43, Provider<Kundle> provider44) {
        return new MyAdvertDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43, provider44);
    }

    public static MyAdvertDetailsPresenterImpl newInstance(DetailsId detailsId, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, String str, SchedulersFactory3 schedulersFactory3, MyAdvertDetailsActionMenuConverter myAdvertDetailsActionMenuConverter, AdvertAddressFormatter advertAddressFormatter, MyAdvertDetailsConverter myAdvertDetailsConverter, MyAdvertDetailsInteractor myAdvertDetailsInteractor, MyDraftAdvertDetailsInteractor myDraftAdvertDetailsInteractor, MyAdvertContactsPresenter myAdvertContactsPresenter, SocialPresenter socialPresenter, Analytics analytics, ClipboardManager clipboardManager, ClipDataFactory clipDataFactory, Features features, MyAdvertDetailsResourceProvider myAdvertDetailsResourceProvider, DateTimeFormatter dateTimeFormatter, ErrorFormatter errorFormatter, PublishRelay<AdvertDeliveryC2C> publishRelay, PublishRelay<AdvertSellerShortTermRent> publishRelay2, Relay<MyAdvertSafeDeal> relay, AppRaterInteractor appRaterInteractor, TimeSource timeSource, MyAdvertDetailsTracker myAdvertDetailsTracker, MyAdvertDetailsFeatureTeaserPresenter myAdvertDetailsFeatureTeaserPresenter, VerificationItemConverter verificationItemConverter, CharityInteractor charityInteractor, LimitsInfoInteractor limitsInfoInteractor, PermissionStorage permissionStorage, PermissionStateProvider permissionStateProvider, MyAdvertStorage myAdvertStorage, SafetyInfoProvider safetyInfoProvider, AccountStateProvider accountStateProvider, BivrostTutorialSessionStorage bivrostTutorialSessionStorage, AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter, AdvertDetailsImvBadgeItemConverter advertDetailsImvBadgeItemConverter, CarMarketPriceChartPresenter carMarketPriceChartPresenter, CarMarketPriceDescriptionPresenter carMarketPriceDescriptionPresenter, String str2, Kundle kundle) {
        return new MyAdvertDetailsPresenterImpl(detailsId, z2, z3, z4, z5, z7, str, schedulersFactory3, myAdvertDetailsActionMenuConverter, advertAddressFormatter, myAdvertDetailsConverter, myAdvertDetailsInteractor, myDraftAdvertDetailsInteractor, myAdvertContactsPresenter, socialPresenter, analytics, clipboardManager, clipDataFactory, features, myAdvertDetailsResourceProvider, dateTimeFormatter, errorFormatter, publishRelay, publishRelay2, relay, appRaterInteractor, timeSource, myAdvertDetailsTracker, myAdvertDetailsFeatureTeaserPresenter, verificationItemConverter, charityInteractor, limitsInfoInteractor, permissionStorage, permissionStateProvider, myAdvertStorage, safetyInfoProvider, accountStateProvider, bivrostTutorialSessionStorage, advertDetailsImvBadgePresenter, advertDetailsImvBadgeItemConverter, carMarketPriceChartPresenter, carMarketPriceDescriptionPresenter, str2, kundle);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get().booleanValue(), this.c.get().booleanValue(), this.d.get().booleanValue(), this.e.get().booleanValue(), this.f.get().booleanValue(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get(), this.K.get(), this.L.get(), this.M.get(), this.N.get(), this.O.get(), this.P.get(), this.Q.get(), this.R.get());
    }
}
