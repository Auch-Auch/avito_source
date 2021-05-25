package com.avito.android.advert.item;

import android.content.ClipboardManager;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellerprofile.SellerStatusProvider;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class AdvertDetailsPresenterImpl_Factory implements Factory<AdvertDetailsPresenterImpl> {
    public final Provider<Analytics> A;
    public final Provider<Preferences> B;
    public final Provider<NotificationManagerProvider> C;
    public final Provider<Observable<FavoriteSellersItemAction>> D;
    public final Provider<FavoriteSellersRepository> E;
    public final Provider<AbTestGroup<SimpleTestGroupWithNoneControl2>> F;
    public final Provider<QuestionnairePresenter> G;
    public final Provider<MarketplaceDeliveryStorage> H;
    public final Provider<CompositeSnackbarPresenter> I;
    public final Provider<Features> J;
    public final Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> K;
    public final Provider<AdvertDetailsInteractor> a;
    public final Provider<AdvertContactsPresenter> b;
    public final Provider<AdvertSafeDealPresenter> c;
    public final Provider<AdvertSellerPresenter> d;
    public final Provider<MarketplacePresenter> e;
    public final Provider<AdvertDetailsToolbarPresenter> f;
    public final Provider<AdvertComplementaryPresenter> g;
    public final Provider<AdvertDetailsItemsPresenter> h;
    public final Provider<AccountStateProvider> i;
    public final Provider<String> j;
    public final Provider<String> k;
    public final Provider<AdvertDetailsFastOpenParams> l;
    public final Provider<Long> m;
    public final Provider<ProfileInfoStorage> n;
    public final Provider<ClipboardManager> o;
    public final Provider<ClipDataFactory> p;
    public final Provider<SchedulersFactory3> q;
    public final Provider<SellerStatusProvider> r;
    public final Provider<FavoriteAdvertsPresenter> s;
    public final Provider<AdvertDetailsAutotekaPresenter> t;
    public final Provider<AdvertDetailsAutotekaTeaserPresenter> u;
    public final Provider<AdvertDetailsNotePresenter> v;
    public final Provider<AdvertDetailsShortTermRentPresenter> w;
    public final Provider<AdvertDetailsFavoriteInteractor> x;
    public final Provider<AdvertDetailsAnalyticsInteractor> y;
    public final Provider<AdvertDetailsTracker> z;

    public AdvertDetailsPresenterImpl_Factory(Provider<AdvertDetailsInteractor> provider, Provider<AdvertContactsPresenter> provider2, Provider<AdvertSafeDealPresenter> provider3, Provider<AdvertSellerPresenter> provider4, Provider<MarketplacePresenter> provider5, Provider<AdvertDetailsToolbarPresenter> provider6, Provider<AdvertComplementaryPresenter> provider7, Provider<AdvertDetailsItemsPresenter> provider8, Provider<AccountStateProvider> provider9, Provider<String> provider10, Provider<String> provider11, Provider<AdvertDetailsFastOpenParams> provider12, Provider<Long> provider13, Provider<ProfileInfoStorage> provider14, Provider<ClipboardManager> provider15, Provider<ClipDataFactory> provider16, Provider<SchedulersFactory3> provider17, Provider<SellerStatusProvider> provider18, Provider<FavoriteAdvertsPresenter> provider19, Provider<AdvertDetailsAutotekaPresenter> provider20, Provider<AdvertDetailsAutotekaTeaserPresenter> provider21, Provider<AdvertDetailsNotePresenter> provider22, Provider<AdvertDetailsShortTermRentPresenter> provider23, Provider<AdvertDetailsFavoriteInteractor> provider24, Provider<AdvertDetailsAnalyticsInteractor> provider25, Provider<AdvertDetailsTracker> provider26, Provider<Analytics> provider27, Provider<Preferences> provider28, Provider<NotificationManagerProvider> provider29, Provider<Observable<FavoriteSellersItemAction>> provider30, Provider<FavoriteSellersRepository> provider31, Provider<AbTestGroup<SimpleTestGroupWithNoneControl2>> provider32, Provider<QuestionnairePresenter> provider33, Provider<MarketplaceDeliveryStorage> provider34, Provider<CompositeSnackbarPresenter> provider35, Provider<Features> provider36, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider37) {
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
    }

    public static AdvertDetailsPresenterImpl_Factory create(Provider<AdvertDetailsInteractor> provider, Provider<AdvertContactsPresenter> provider2, Provider<AdvertSafeDealPresenter> provider3, Provider<AdvertSellerPresenter> provider4, Provider<MarketplacePresenter> provider5, Provider<AdvertDetailsToolbarPresenter> provider6, Provider<AdvertComplementaryPresenter> provider7, Provider<AdvertDetailsItemsPresenter> provider8, Provider<AccountStateProvider> provider9, Provider<String> provider10, Provider<String> provider11, Provider<AdvertDetailsFastOpenParams> provider12, Provider<Long> provider13, Provider<ProfileInfoStorage> provider14, Provider<ClipboardManager> provider15, Provider<ClipDataFactory> provider16, Provider<SchedulersFactory3> provider17, Provider<SellerStatusProvider> provider18, Provider<FavoriteAdvertsPresenter> provider19, Provider<AdvertDetailsAutotekaPresenter> provider20, Provider<AdvertDetailsAutotekaTeaserPresenter> provider21, Provider<AdvertDetailsNotePresenter> provider22, Provider<AdvertDetailsShortTermRentPresenter> provider23, Provider<AdvertDetailsFavoriteInteractor> provider24, Provider<AdvertDetailsAnalyticsInteractor> provider25, Provider<AdvertDetailsTracker> provider26, Provider<Analytics> provider27, Provider<Preferences> provider28, Provider<NotificationManagerProvider> provider29, Provider<Observable<FavoriteSellersItemAction>> provider30, Provider<FavoriteSellersRepository> provider31, Provider<AbTestGroup<SimpleTestGroupWithNoneControl2>> provider32, Provider<QuestionnairePresenter> provider33, Provider<MarketplaceDeliveryStorage> provider34, Provider<CompositeSnackbarPresenter> provider35, Provider<Features> provider36, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider37) {
        return new AdvertDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37);
    }

    public static AdvertDetailsPresenterImpl newInstance(AdvertDetailsInteractor advertDetailsInteractor, AdvertContactsPresenter advertContactsPresenter, AdvertSafeDealPresenter advertSafeDealPresenter, AdvertSellerPresenter advertSellerPresenter, MarketplacePresenter marketplacePresenter, AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, AdvertComplementaryPresenter advertComplementaryPresenter, AdvertDetailsItemsPresenter advertDetailsItemsPresenter, AccountStateProvider accountStateProvider, String str, String str2, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, long j2, ProfileInfoStorage profileInfoStorage, ClipboardManager clipboardManager, ClipDataFactory clipDataFactory, SchedulersFactory3 schedulersFactory3, SellerStatusProvider sellerStatusProvider, FavoriteAdvertsPresenter favoriteAdvertsPresenter, AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter, AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter, AdvertDetailsNotePresenter advertDetailsNotePresenter, AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter, AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, AdvertDetailsTracker advertDetailsTracker, Analytics analytics, Preferences preferences, NotificationManagerProvider notificationManagerProvider, Observable<FavoriteSellersItemAction> observable, FavoriteSellersRepository favoriteSellersRepository, AbTestGroup<SimpleTestGroupWithNoneControl2> abTestGroup, QuestionnairePresenter questionnairePresenter, MarketplaceDeliveryStorage marketplaceDeliveryStorage, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features, ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        return new AdvertDetailsPresenterImpl(advertDetailsInteractor, advertContactsPresenter, advertSafeDealPresenter, advertSellerPresenter, marketplacePresenter, advertDetailsToolbarPresenter, advertComplementaryPresenter, advertDetailsItemsPresenter, accountStateProvider, str, str2, advertDetailsFastOpenParams, j2, profileInfoStorage, clipboardManager, clipDataFactory, schedulersFactory3, sellerStatusProvider, favoriteAdvertsPresenter, advertDetailsAutotekaPresenter, advertDetailsAutotekaTeaserPresenter, advertDetailsNotePresenter, advertDetailsShortTermRentPresenter, advertDetailsFavoriteInteractor, advertDetailsAnalyticsInteractor, advertDetailsTracker, analytics, preferences, notificationManagerProvider, observable, favoriteSellersRepository, abTestGroup, questionnairePresenter, marketplaceDeliveryStorage, compositeSnackbarPresenter, features, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get().longValue(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get(), this.K.get());
    }
}
