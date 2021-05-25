package com.avito.android.shop.detailed;

import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UnsubscribeResult;
import com.avito.android.remote.model.search.Header;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.Result;
import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.remote.shop.detailed.ShopGold;
import com.avito.android.remote.shop.detailed.ShopRegular;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bw\b\u0007\u0012\b\b\u0001\u0010P\u001a\u00020\u0002\u0012\n\b\u0001\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00109\u001a\u000206\u0012\n\b\u0003\u0010Q\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bR\u0010SJ9\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010?R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010?¨\u0006T"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedInteractorImpl;", "Lcom/avito/android/shop/detailed/ShopAndSubscribeInteractor;", "", "query", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "shouldRefreshPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "loadShopAdvertsData", "(Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "getFiltersCount", "(Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "userKey", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "needActivate", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Completable;", "data", "", "refreshSubscriptionState", "(Lcom/avito/android/shop/detailed/ShopDetailedData;)V", "Lcom/avito/android/remote/SearchApi;", a2.g.r.g.a, "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/serp/InlineFiltersInteractor;", "k", "Lcom/avito/android/serp/InlineFiltersInteractor;", "inlineFiltersInteractor", "Lcom/avito/android/remote/model/PageParams;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/PageParams;", "pageParams", "Lcom/avito/android/remote/model/SearchParamsConverter;", "l", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "j", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/remote/FavoriteSellersApi;", "h", "Lcom/avito/android/remote/FavoriteSellersApi;", "favoriteSellersApi", "e", "Ljava/lang/String;", "shopContext", "Lcom/avito/android/shop/remote/ShopsApi;", "f", "Lcom/avito/android/shop/remote/ShopsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "d", "pageFrom", "Lcom/avito/android/remote/shop/detailed/ShopElement;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/shop/detailed/ShopElement;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "c", "shopId", "savedState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop/remote/ShopsApi;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/serp/InlineFiltersInteractor;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedInteractorImpl implements ShopAndSubscribeInteractor {
    public ShopElement a;
    public PageParams b;
    public final String c;
    public final String d;
    public final String e;
    public final ShopsApi f;
    public final SearchApi g;
    public final FavoriteSellersApi h;
    public final SchedulersFactory3 i;
    public final NotificationManagerProvider j;
    public final InlineFiltersInteractor k;
    public final SearchParamsConverter l;
    public final FavoriteSellersRepository m;

    public static final class a implements Action {
        public final /* synthetic */ ShopDetailedInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(ShopDetailedInteractorImpl shopDetailedInteractorImpl, String str, boolean z) {
            this.a = shopDetailedInteractorImpl;
            this.b = str;
            this.c = z;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscribeInfo access$getSubscribeInfo$p;
            this.a.m.updateSeller(this.b, Boolean.TRUE, Boolean.valueOf(this.c));
            ShopElement shopElement = this.a.a;
            if (shopElement != null && (access$getSubscribeInfo$p = ShopDetailedInteractorImpl.access$getSubscribeInfo$p(this.a, shopElement)) != null) {
                access$getSubscribeInfo$p.setNotificationsActivated(Boolean.valueOf(this.c));
            }
        }
    }

    public static final class b<T, R> implements Function<InlineFilters, Integer> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(InlineFilters inlineFilters) {
            Header header;
            Integer selectedFiltersCount;
            Result result = inlineFilters.getResult();
            return Integer.valueOf((result == null || (header = result.getHeader()) == null || (selectedFiltersCount = header.getSelectedFiltersCount()) == null) ? 0 : selectedFiltersCount.intValue());
        }
    }

    public static final class c<T> implements Consumer<Set<? extends FavoriteSeller>> {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ Ref.ObjectRef b;

        public c(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.a = objectRef;
            this.b = objectRef2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Set<? extends FavoriteSeller> set) {
            T t;
            Set<? extends FavoriteSeller> set2 = set;
            Intrinsics.checkNotNullExpressionValue(set2, SellersTrackerModule.NAME);
            Iterator<T> it = set2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getUserKey(), this.a.element)) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                this.b.element.setSubscribed(Boolean.valueOf(t2.isSubscribed()));
                this.b.element.setNotificationsActivated(t2.isNotificationsActivated());
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ ShopDetailedInteractorImpl a;

        public e(ShopDetailedInteractorImpl shopDetailedInteractorImpl) {
            this.a = shopDetailedInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscribeInfo access$getSubscribeInfo$p;
            ShopElement shopElement = this.a.a;
            if (shopElement != null && (access$getSubscribeInfo$p = ShopDetailedInteractorImpl.access$getSubscribeInfo$p(this.a, shopElement)) != null) {
                access$getSubscribeInfo$p.setSubscribed(Boolean.TRUE);
            }
        }
    }

    public static final class f<T, R> implements Function<SubscribeResult, SubscribeInfo> {
        public final /* synthetic */ ShopDetailedInteractorImpl a;
        public final /* synthetic */ String b;

        public f(ShopDetailedInteractorImpl shopDetailedInteractorImpl, String str) {
            this.a = shopDetailedInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SubscribeInfo apply(SubscribeResult subscribeResult) {
            SubscribeResult subscribeResult2 = subscribeResult;
            FavoriteSellersRepository favoriteSellersRepository = this.a.m;
            String str = this.b;
            Boolean bool = Boolean.TRUE;
            favoriteSellersRepository.updateSeller(str, bool, subscribeResult2.isNotificationsActivated());
            return new SubscribeInfo(bool, subscribeResult2.isNotificationsActivated(), null, null);
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ ShopDetailedInteractorImpl a;

        public g(ShopDetailedInteractorImpl shopDetailedInteractorImpl) {
            this.a = shopDetailedInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscribeInfo access$getSubscribeInfo$p;
            ShopElement shopElement = this.a.a;
            if (shopElement != null && (access$getSubscribeInfo$p = ShopDetailedInteractorImpl.access$getSubscribeInfo$p(this.a, shopElement)) != null) {
                access$getSubscribeInfo$p.setSubscribed(Boolean.FALSE);
            }
        }
    }

    public static final class h<T, R> implements Function<UnsubscribeResult, SubscribeInfo> {
        public final /* synthetic */ ShopDetailedInteractorImpl a;
        public final /* synthetic */ String b;

        public h(ShopDetailedInteractorImpl shopDetailedInteractorImpl, String str) {
            this.a = shopDetailedInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SubscribeInfo apply(UnsubscribeResult unsubscribeResult) {
            FavoriteSellersRepository favoriteSellersRepository = this.a.m;
            String str = this.b;
            Boolean bool = Boolean.FALSE;
            FavoriteSellersRepository.DefaultImpls.updateSeller$default(favoriteSellersRepository, str, bool, null, 4, null);
            return new SubscribeInfo(bool, null, null, null);
        }
    }

    @Inject
    public ShopDetailedInteractorImpl(@ShopDetailedModule.ShopId @NotNull String str, @ShopDetailedModule.PageFrom @Nullable String str2, @ShopDetailedModule.ShopContext @Nullable String str3, @NotNull ShopsApi shopsApi, @NotNull SearchApi searchApi, @NotNull FavoriteSellersApi favoriteSellersApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull InlineFiltersInteractor inlineFiltersInteractor, @NotNull SearchParamsConverter searchParamsConverter, @NotNull FavoriteSellersRepository favoriteSellersRepository, @ShopDetailedModule.InteractorState @Nullable Kundle kundle) {
        PageParams pageParams;
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "favoriteSellersApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(inlineFiltersInteractor, "inlineFiltersInteractor");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = shopsApi;
        this.g = searchApi;
        this.h = favoriteSellersApi;
        this.i = schedulersFactory3;
        this.j = notificationManagerProvider;
        this.k = inlineFiltersInteractor;
        this.l = searchParamsConverter;
        this.m = favoriteSellersRepository;
        this.a = kundle != null ? (ShopElement) kundle.getParcelable(ScreenPublicConstsKt.CONTENT_TYPE_SHOP) : null;
        if (kundle == null || (pageParams = (PageParams) kundle.getParcelable("page_params")) == null) {
            pageParams = new PageParams.Builder().incrementPage().build();
            Intrinsics.checkNotNullExpressionValue(pageParams, "PageParams.Builder().incrementPage().build()");
        }
        this.b = pageParams;
    }

    public static final SubscribeInfo access$getSubscribeInfo$p(ShopDetailedInteractorImpl shopDetailedInteractorImpl, ShopElement shopElement) {
        Objects.requireNonNull(shopDetailedInteractorImpl);
        if (shopElement instanceof ShopRegular) {
            return ((ShopRegular) shopElement).getSubscribeInfo();
        }
        if (shopElement instanceof ShopGold) {
            return ((ShopGold) shopElement).getSubscribeInfo();
        }
        throw new RuntimeException("Unknown shop type");
    }

    public static final SerpAdvert access$mapSubclassToSerpAdvert(ShopDetailedInteractorImpl shopDetailedInteractorImpl, SerpAdvert serpAdvert) {
        Objects.requireNonNull(shopDetailedInteractorImpl);
        return serpAdvert instanceof SerpAdvertXl ? new SerpAdvert(serpAdvert.getId(), serpAdvert.getAddress(), serpAdvert.getLocation(), serpAdvert.getDelivery(), serpAdvert.getDistance(), serpAdvert.getCoordinates(), serpAdvert.getTime(), serpAdvert.getTitle(), serpAdvert.getDescription(), serpAdvert.getUserType(), serpAdvert.getImage(), serpAdvert.getCategory(), serpAdvert.getShop(), serpAdvert.getServices(), serpAdvert.getPrice(), serpAdvert.getPriceWithoutDiscount(), serpAdvert.getPreviousPrice(), serpAdvert.getDiscountPercentage(), serpAdvert.getVideo(), serpAdvert.getStatus(), serpAdvert.isFavorite(), serpAdvert.isVerifiedSeller(), serpAdvert.getDeepLink(), serpAdvert.getAnalyticParams(), serpAdvert.getShortTermRent(), serpAdvert.getImageList(), serpAdvert.getAdditionalAction(), serpAdvert.getAdditionalName(), serpAdvert.getBadge(), serpAdvert.getBadgeBar(), serpAdvert.getMoreActions(), serpAdvert.getContacts(), serpAdvert.getGeoReferences(), serpAdvert.getRadiusInfo(), serpAdvert.getSellerInfo(), serpAdvert.getHasVideo(), serpAdvert.getInStock(), serpAdvert.getTrustFactor(), serpAdvert.getInfoImage(), serpAdvert.isMarketplace(), serpAdvert.getLocationId(), serpAdvert.getHidesViewedBadge()) : serpAdvert;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<TypedResult<Unit>> subscribeOn = this.h.changeNotifications("shop_page", str, z).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "favoriteSellersApi.chang…scribeOn(schedulers.io())");
        Completable doOnComplete = TypedObservablesKt.toTyped(subscribeOn).ignoreElements().doOnComplete(new a(this, str, z));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "favoriteSellersApi.chang…eedActivate\n            }");
        return doOnComplete;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedInteractor
    @NotNull
    public Observable<Integer> getFiltersCount(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Observable<Integer> onErrorReturnItem = InlineFiltersInteractor.DefaultImpls.loadInlineFilters$default(this.k, searchParams, r.emptyMap(), false, 4, null).map(b.a).onErrorReturnItem(0);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "inlineFiltersInteractor.…    .onErrorReturnItem(0)");
        return onErrorReturnItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0042, code lost:
        if (r5 != null) goto L_0x006a;
     */
    @Override // com.avito.android.shop.detailed.ShopDetailedInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<com.avito.android.shop.detailed.ShopDetailedData> loadShopAdvertsData(@org.jetbrains.annotations.Nullable java.lang.String r40, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.SerpDisplayType r41, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.SearchParams r42, boolean r43) {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.shop.detailed.ShopDetailedInteractorImpl.loadShopAdvertsData(java.lang.String, com.avito.android.remote.model.SerpDisplayType, com.avito.android.remote.model.SearchParams, boolean):io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable(ScreenPublicConstsKt.CONTENT_TYPE_SHOP, this.a);
        kundle.putParcelable("page_params", this.b);
        return kundle;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedInteractor
    public void refreshSubscriptionState(@NotNull ShopDetailedData shopDetailedData) {
        Intrinsics.checkNotNullParameter(shopDetailedData, "data");
        ShopElement shop = shopDetailedData.getShop();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        if (shop instanceof ShopGold) {
            ShopGold shopGold = (ShopGold) shop;
            objectRef.element = (T) shopGold.getUserKey();
            objectRef2.element = (T) shopGold.getSubscribeInfo();
        } else if (shop instanceof ShopRegular) {
            ShopRegular shopRegular = (ShopRegular) shop;
            objectRef.element = (T) shopRegular.getUserKey();
            objectRef2.element = (T) shopRegular.getSubscribeInfo();
        }
        if (objectRef2.element != null) {
            this.m.getSellers().subscribe(new c(objectRef, objectRef2), d.a);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> subscribe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable subscribeOn = FavoriteSellersApi.DefaultImpls.subscribe$default(this.h, "shop_page", str, this.j.getAreNotificationsEnabled(), false, 8, null).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "favoriteSellersApi.subsc…scribeOn(schedulers.io())");
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(subscribeOn).doOnComplete(new e(this)).map(new f(this, str)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "favoriteSellersApi.subsc…         }.firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> unsubscribe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable subscribeOn = FavoriteSellersApi.DefaultImpls.unsubscribe$default(this.h, "shop_page", str, false, 4, null).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "favoriteSellersApi.unsub…scribeOn(schedulers.io())");
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(subscribeOn).doOnComplete(new g(this)).map(new h(this, str)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "favoriteSellersApi.unsub…         }.firstOrError()");
        return firstOrError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopDetailedInteractorImpl(String str, String str2, String str3, ShopsApi shopsApi, SearchApi searchApi, FavoriteSellersApi favoriteSellersApi, SchedulersFactory3 schedulersFactory3, NotificationManagerProvider notificationManagerProvider, InlineFiltersInteractor inlineFiltersInteractor, SearchParamsConverter searchParamsConverter, FavoriteSellersRepository favoriteSellersRepository, Kundle kundle, int i2, j jVar) {
        this(str, str2, str3, shopsApi, searchApi, favoriteSellersApi, schedulersFactory3, notificationManagerProvider, inlineFiltersInteractor, searchParamsConverter, favoriteSellersRepository, (i2 & 2048) != 0 ? null : kundle);
    }
}
