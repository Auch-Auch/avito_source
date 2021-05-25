package com.avito.android.advert.item.sellerprofile;

import a2.g.r.g;
import com.avito.android.advert.item.AdvertDeeplinkRouter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.sellerprofile.SellerProfileClickSource;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.advert_core.utils.AdvertDetailsUtilsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DevelopmentsCatalogDeveloperLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertSeller;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010(\u001a\u00020%\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenterImpl;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "Lcom/avito/android/advert/item/AdvertDeeplinkRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDeeplinkRouter;)V", "detachRouter", "()V", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "view", "attachView", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "detachViews", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "bindData", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "bindExistingProfileData", "", "online", "updateOnlineStatus", "(Z)V", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "source", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "sendAnalyticsShowProfile", "(Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;Lcom/avito/android/deep_linking/links/DeepLink;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertDetails;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "clicksDisposable", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "e", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactPresenter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/AdvertDeeplinkRouter;", "", "Lcom/avito/android/advert_core/sellerprofile/SellerProfileClickSource;", "f", "Ljava/util/List;", "profileClickSources", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "d", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "profilePresenter", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", g.a, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Ljava/util/List;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerPresenterImpl implements AdvertSellerPresenter {
    public AdvertDetails a;
    public AdvertDeeplinkRouter b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final AdvertSellerProfilePresenter d;
    public final AdvertContactsPresenter e;
    public final List<SellerProfileClickSource> f;
    public final AdvertDetailsAnalyticsInteractor g;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerProfileClickSource a;
        public final /* synthetic */ AdvertSellerPresenterImpl b;

        public a(SellerProfileClickSource sellerProfileClickSource, AdvertSellerPresenterImpl advertSellerPresenterImpl) {
            this.a = sellerProfileClickSource;
            this.b = advertSellerPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            AdvertSellerPresenterImpl.access$handleContactsSelected(this.b, this.a.getProfileSourceName());
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            throw new RuntimeException("Can't handle contracts selected", th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.advert_core.sellerprofile.SellerProfileClickSource> */
    /* JADX WARN: Multi-variable type inference failed */
    public AdvertSellerPresenterImpl(@NotNull AdvertSellerProfilePresenter advertSellerProfilePresenter, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull List<? extends SellerProfileClickSource> list, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertSellerProfilePresenter, "profilePresenter");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "contactPresenter");
        Intrinsics.checkNotNullParameter(list, "profileClickSources");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.d = advertSellerProfilePresenter;
        this.e = advertContactsPresenter;
        this.f = list;
        this.g = advertDetailsAnalyticsInteractor;
    }

    public static final void access$handleContactsSelected(AdvertSellerPresenterImpl advertSellerPresenterImpl, ShowSellersProfileSource showSellersProfileSource) {
        AdvertSeller seller;
        DeepLink link;
        AdvertDetails advertDetails = advertSellerPresenterImpl.a;
        if (advertDetails != null && (seller = advertDetails.getSeller()) != null && (link = seller.getLink()) != null) {
            advertSellerPresenterImpl.sendAnalyticsShowProfile(showSellersProfileSource, link);
            AdvertDeeplinkRouter advertDeeplinkRouter = advertSellerPresenterImpl.b;
            if (advertDeeplinkRouter != null) {
                advertDeeplinkRouter.followDeeplinkWithTreeParent(link, advertSellerPresenterImpl.g.getParent());
            }
        }
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void attachRouter(@NotNull AdvertDeeplinkRouter advertDeeplinkRouter) {
        Intrinsics.checkNotNullParameter(advertDeeplinkRouter, "router");
        this.b = advertDeeplinkRouter;
        for (T t : this.f) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = t.profileClicks().subscribe(new a(t, this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "profileClickSource.profi…rror) }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void attachView(@NotNull AdvertSellerProfileView advertSellerProfileView) {
        Intrinsics.checkNotNullParameter(advertSellerProfileView, "view");
        this.d.attachView(advertSellerProfileView);
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void bindData(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.a = advertDetails;
        AdvertSeller seller = advertDetails.getSeller();
        if (seller != null) {
            this.d.bindSellerInfo(seller, advertDetails.isShopAdvert(), advertDetails.isFromCompany(), AdvertDetailsUtilsKt.getIconType(advertDetails));
        }
        AdvertContactsPresenter advertContactsPresenter = this.e;
        advertContactsPresenter.bindStickyData(advertContactsPresenter.getActions(), AdvertDetailsUtilsKt.toContactBarData$default(advertDetails, null, 1, null));
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void bindExistingProfileData() {
        AdvertSeller seller;
        AdvertDetails advertDetails = this.a;
        if (advertDetails != null && advertDetails != null && (seller = advertDetails.getSeller()) != null) {
            this.d.bindSellerInfo(seller, advertDetails.isShopAdvert(), advertDetails.isFromCompany(), AdvertDetailsUtilsKt.getIconType(advertDetails));
        }
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void detachViews() {
        this.e.detachView();
        this.d.detachView();
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void sendAnalyticsShowProfile(@NotNull ShowSellersProfileSource showSellersProfileSource, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(showSellersProfileSource, "source");
        Intrinsics.checkNotNullParameter(deepLink, "link");
        AdvertDetails advertDetails = this.a;
        if (advertDetails != null) {
            this.g.sendShowSellersProfile(advertDetails, showSellersProfileSource);
            if (deepLink instanceof DevelopmentsCatalogDeveloperLink) {
                this.g.sendShowDeveloperPage(advertDetails.getId(), ((DevelopmentsCatalogDeveloperLink) deepLink).getDeveloperId());
            }
        }
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void updateOnlineStatus(boolean z) {
        this.e.updateOnlineStatus(z);
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter
    public void attachView(@NotNull AdvertContactsView advertContactsView) {
        Intrinsics.checkNotNullParameter(advertContactsView, "view");
        this.e.attachStickyView(advertContactsView);
    }
}
