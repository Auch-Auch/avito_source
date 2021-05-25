package com.avito.android.favorite_sellers.adapter.recommendation;

import android.os.Parcelable;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscribeSellerButtonEvent;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.event.favorite.UnsubscribeSellerButtonEvent;
import com.avito.android.deep_linking.links.ChainedDeepLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.SellerSubscribeLink;
import com.avito.android.favorite_sellers.RecommendationItem;
import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.action.RecommendationAction;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 j2\u00020\u0001:\u0001jBc\b\u0007\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010C\u001a\u00020@\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020T0S\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u00100\u001a\u00020-\u0012\n\b\u0001\u0010g\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bh\u0010iJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b%\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010ER8\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00130Gj\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0013`H8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010I\u001a\u0004\bJ\u0010KR8\u0010N\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00120Gj\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0012`H8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b!\u0010I\u001a\u0004\bM\u0010KR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020T0S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u00102R\u0018\u0010\\\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010]R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010ER\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006k"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "view", "", "attachView", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;)V", "detachView", "()V", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;)V", "detachRouter", "resetAutoScroll", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;", "Lcom/avito/android/favorite_sellers/RecommendationItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;Lcom/avito/android/favorite_sellers/RecommendationItem;I)V", "onSubscriptionDeepLinkReturned", "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "d", "(Lcom/avito/android/favorite_sellers/SellerCarouselItem;)V", AuthSource.BOOKING_ORDER, "e", "", "recommendationId", "c", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.SEND_ABUSE, "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/favorite_sellers/SellerCarouselItem;)V", "f", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "Lio/reactivex/rxjava3/disposables/Disposable;", "j", "Lio/reactivex/rxjava3/disposables/Disposable;", "autoScrollDisposable", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "s", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "h", "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "currentSubscriptionSeller", "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "n", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", "l", "Lcom/avito/android/FavoriteSellersRepository;", "sellerRepository", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getBoundItems$favorite_sellers_items_release", "()Ljava/util/HashMap;", "boundItems", "getBoundViews$favorite_sellers_items_release", "boundViews", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "k", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "interactor", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/core/Observable;", "itemActions", a2.g.r.g.a, "currentConfiguringSeller", "i", "Lcom/avito/android/deep_linking/links/DeepLink;", "nextDeepLink", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "Lcom/avito/android/util/ErrorFormatter;", "p", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "interactorDisposables", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "r", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "state", "<init>", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;Lcom/avito/android/FavoriteSellersRepository;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/util/Kundle;)V", "Companion", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendationItemPresenterImpl implements RecommendationItemPresenter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_CURRENT_CONFIGURING_SELLER = "current_configuring_seller";
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    @NotNull
    public final HashMap<String, RecommendationItemView> c = new HashMap<>();
    @NotNull
    public final HashMap<String, RecommendationItem> d = new HashMap<>();
    public SubscriptionSettingsView e;
    public RecommendationItemPresenter.Router f;
    public SellerCarouselItem g;
    public SellerCarouselItem h;
    public DeepLink i;
    public Disposable j;
    public final RecommendationInteractor k;
    public final FavoriteSellersRepository l;
    public final Observable<FavoriteSellersItemAction> m;
    public final NotificationManagerProvider n;
    public final SchedulersFactory3 o;
    public final ErrorFormatter p;
    public final Analytics q;
    public final SubscriptionSource r;
    public final CompositeSnackbarPresenter s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenterImpl$Companion;", "", "", "KEY_CURRENT_CONFIGURING_SELLER", "Ljava/lang/String;", "<init>", "()V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                SellerCarouselItem sellerCarouselItem = ((RecommendationItemPresenterImpl) this.b).g;
                if (sellerCarouselItem != null) {
                    RecommendationItemPresenterImpl.access$changeNotifications((RecommendationItemPresenterImpl) this.b, sellerCarouselItem);
                }
            } else if (i == 1) {
                SellerCarouselItem sellerCarouselItem2 = ((RecommendationItemPresenterImpl) this.b).g;
                if (sellerCarouselItem2 != null) {
                    ((RecommendationItemPresenterImpl) this.b).q.track(new UnsubscribeSellerButtonEvent(sellerCarouselItem2.getUserKey(), ((RecommendationItemPresenterImpl) this.b).r));
                    RecommendationItemPresenterImpl.access$unsubscribeFrom((RecommendationItemPresenterImpl) this.b, sellerCarouselItem2);
                }
            } else if (i == 2) {
                ((RecommendationItemPresenterImpl) this.b).g = null;
            } else if (i == 3) {
                RecommendationItemPresenterImpl.access$syncSellerState((RecommendationItemPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<FavoriteSellersItemAction> {
        public final /* synthetic */ RecommendationItemPresenterImpl a;

        public b(RecommendationItemPresenterImpl recommendationItemPresenterImpl) {
            this.a = recommendationItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(FavoriteSellersItemAction favoriteSellersItemAction) {
            FavoriteSellersItemAction favoriteSellersItemAction2 = favoriteSellersItemAction;
            if (favoriteSellersItemAction2 instanceof RecommendationAction.Subscribe) {
                RecommendationAction.Subscribe subscribe = (RecommendationAction.Subscribe) favoriteSellersItemAction2;
                this.a.q.track(new SubscribeSellerButtonEvent(subscribe.getItem().getUserKey(), this.a.r));
                this.a.d(subscribe.getItem());
            } else if (favoriteSellersItemAction2 instanceof RecommendationAction.OpenSubscriptionSettings) {
                this.a.b(((RecommendationAction.OpenSubscriptionSettings) favoriteSellersItemAction2).getItem());
            }
            this.a.resetAutoScroll();
        }
    }

    public static final class c<T> implements Consumer<Parcelable> {
        public final /* synthetic */ RecommendationItem a;

        public c(RecommendationItemPresenterImpl recommendationItemPresenterImpl, RecommendationItem recommendationItem) {
            this.a = recommendationItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Parcelable parcelable) {
            this.a.setScrollState(parcelable);
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RecommendationItemView a;
        public final /* synthetic */ Disposable b;
        public final /* synthetic */ RecommendationItemPresenterImpl c;
        public final /* synthetic */ RecommendationItem d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RecommendationItemView recommendationItemView, Disposable disposable, RecommendationItemPresenterImpl recommendationItemPresenterImpl, RecommendationItem recommendationItem) {
            super(0);
            this.a = recommendationItemView;
            this.b = disposable;
            this.c = recommendationItemPresenterImpl;
            this.d = recommendationItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.dispose();
            this.c.getBoundViews$favorite_sellers_items_release().remove(this.d.getStringId());
            this.c.getBoundItems$favorite_sellers_items_release().remove(this.d.getStringId());
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ RecommendationItemPresenterImpl a;
        public final /* synthetic */ String b;

        public e(RecommendationItemPresenterImpl recommendationItemPresenterImpl, String str) {
            this.a = recommendationItemPresenterImpl;
            this.b = str;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            RecommendationItemView recommendationItemView = this.a.getBoundViews$favorite_sellers_items_release().get(this.b);
            if (recommendationItemView != null) {
                recommendationItemView.scrollToNextItem();
            }
        }
    }

    public static final class f<T> implements Consumer<Disposable> {
        public final /* synthetic */ RecommendationItemPresenterImpl a;
        public final /* synthetic */ SellerCarouselItem b;

        public f(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
            this.a = recommendationItemPresenterImpl;
            this.b = sellerCarouselItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.b.setSubscribeLoading(true);
            this.a.e(this.b);
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ RecommendationItemPresenterImpl a;
        public final /* synthetic */ SellerCarouselItem b;

        public g(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
            this.a = recommendationItemPresenterImpl;
            this.b = sellerCarouselItem;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setSubscribeLoading(false);
            this.a.e(this.b);
        }
    }

    public static final class h<T> implements Consumer<SubscribeResult> {
        public final /* synthetic */ RecommendationItemPresenterImpl a;
        public final /* synthetic */ SellerCarouselItem b;

        public h(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
            this.a = recommendationItemPresenterImpl;
            this.b = sellerCarouselItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscribeResult subscribeResult) {
            this.b.setSubscribeLoading(false);
            this.b.setSubscribed(true);
            this.b.setNotificationsActivated(subscribeResult.isNotificationsActivated());
            this.a.e(this.b);
            RecommendationItemPresenterImpl.access$updateSeller(this.a, this.b);
            this.a.c(this.b.getRecommendationId());
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ RecommendationItemPresenterImpl a;
        public final /* synthetic */ SellerCarouselItem b;

        public i(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
            this.a = recommendationItemPresenterImpl;
            this.b = sellerCarouselItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            RecommendationItemPresenterImpl recommendationItemPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            RecommendationItemPresenterImpl.access$handleError(recommendationItemPresenterImpl, th2, this.b);
        }
    }

    @Inject
    public RecommendationItemPresenterImpl(@NotNull RecommendationInteractor recommendationInteractor, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull Observable<FavoriteSellersItemAction> observable, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorFormatter errorFormatter, @NotNull Analytics analytics, @NotNull SubscriptionSource subscriptionSource, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @ForRecommendation @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(recommendationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "sellerRepository");
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(subscriptionSource, "source");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        this.k = recommendationInteractor;
        this.l = favoriteSellersRepository;
        this.m = observable;
        this.n = notificationManagerProvider;
        this.o = schedulersFactory3;
        this.p = errorFormatter;
        this.q = analytics;
        this.r = subscriptionSource;
        this.s = compositeSnackbarPresenter;
        this.g = kundle != null ? (SellerCarouselItem) kundle.getParcelable(KEY_CURRENT_CONFIGURING_SELLER) : null;
    }

    public static final void access$changeNotifications(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
        SubscriptionSettingsView subscriptionSettingsView = recommendationItemPresenterImpl.e;
        if (subscriptionSettingsView == null) {
            return;
        }
        if (!recommendationItemPresenterImpl.n.getAreNotificationsEnabled()) {
            CompositeDisposable compositeDisposable = recommendationItemPresenterImpl.a;
            Disposable subscribe = subscriptionSettingsView.showEnableNotificationDialog().subscribe(new a2.a.a.s0.h0.a.a(recommendationItemPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.showEnableNotificat…NotificationsSettings() }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        Boolean isNotificationsActivated = sellerCarouselItem.isNotificationsActivated();
        if (isNotificationsActivated != null) {
            boolean booleanValue = isNotificationsActivated.booleanValue();
            String userKey = sellerCarouselItem.getUserKey();
            boolean z = !booleanValue;
            CompositeDisposable compositeDisposable2 = recommendationItemPresenterImpl.b;
            Disposable subscribe2 = recommendationItemPresenterImpl.k.changeNotifications(userKey, z, recommendationItemPresenterImpl.r).observeOn(recommendationItemPresenterImpl.o.mainThread()).doOnSubscribe(new a2.a.a.s0.h0.a.b(subscriptionSettingsView)).doFinally(new a2.a.a.s0.h0.a.c(subscriptionSettingsView)).subscribe(new a2.a.a.s0.h0.a.d(recommendationItemPresenterImpl, subscriptionSettingsView, z, sellerCarouselItem), new a2.a.a.s0.h0.a.e(recommendationItemPresenterImpl, sellerCarouselItem));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.changeNotific…r(it, item)\n            }");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    public static final void access$handleError(RecommendationItemPresenterImpl recommendationItemPresenterImpl, Throwable th, SellerCarouselItem sellerCarouselItem) {
        Objects.requireNonNull(recommendationItemPresenterImpl);
        Objects.requireNonNull(th, "null cannot be cast to non-null type com.avito.android.util.TypedResultException");
        TypedError errorResult = ((TypedResultException) th).getErrorResult();
        if (errorResult instanceof ErrorResult.ErrorDialog) {
            SubscriptionSettingsView subscriptionSettingsView = recommendationItemPresenterImpl.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.showErrorDialog((ErrorResult.ErrorDialog) errorResult, new a2.a.a.s0.h0.a.f(recommendationItemPresenterImpl, errorResult, sellerCarouselItem));
                return;
            }
            return;
        }
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(recommendationItemPresenterImpl.s, recommendationItemPresenterImpl.p.format(th), 0, null, 0, null, 0, null, null, 254, null);
    }

    public static final void access$syncSellerState(RecommendationItemPresenterImpl recommendationItemPresenterImpl) {
        CompositeDisposable compositeDisposable = recommendationItemPresenterImpl.a;
        Disposable subscribe = recommendationItemPresenterImpl.l.getSellers().map(a2.a.a.s0.h0.a.g.a).subscribe(new a2.a.a.s0.h0.a.h(recommendationItemPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sellerRepository.getSell…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$unsubscribeFrom(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
        Objects.requireNonNull(recommendationItemPresenterImpl);
        String userKey = sellerCarouselItem.getUserKey();
        CompositeDisposable compositeDisposable = recommendationItemPresenterImpl.b;
        Disposable subscribe = recommendationItemPresenterImpl.k.unsubscribe(userKey, recommendationItemPresenterImpl.r).observeOn(recommendationItemPresenterImpl.o.mainThread()).doOnSubscribe(new a2.a.a.s0.h0.a.i(recommendationItemPresenterImpl)).doFinally(new p3(0, recommendationItemPresenterImpl, sellerCarouselItem)).subscribe(new p3(1, recommendationItemPresenterImpl, sellerCarouselItem), new a2.a.a.s0.h0.a.j(recommendationItemPresenterImpl, sellerCarouselItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.unsubscribe(u…r(it, item)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$updateSeller(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
        recommendationItemPresenterImpl.l.updateSeller(sellerCarouselItem.getUserKey(), Boolean.valueOf(sellerCarouselItem.isSubscribed()), sellerCarouselItem.isNotificationsActivated()).subscribe();
    }

    public final void a(DeepLink deepLink, SellerCarouselItem sellerCarouselItem) {
        if (deepLink instanceof ChainedDeepLink) {
            this.h = sellerCarouselItem;
            this.i = ((ChainedDeepLink) deepLink).getThen();
        }
        RecommendationItemPresenter.Router router = this.f;
        if (router != null) {
            router.followDeepLinkFromRecommendations(deepLink);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void attachRouter(@NotNull RecommendationItemPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.f = router;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void attachView(@NotNull SubscriptionSettingsView subscriptionSettingsView) {
        Intrinsics.checkNotNullParameter(subscriptionSettingsView, "view");
        this.e = subscriptionSettingsView;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.m.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemActions.subscribe { …setAutoScroll()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = subscriptionSettingsView.notificationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.notificationClicks(…fications(it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe3 = subscriptionSettingsView.unsubscribeClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.unsubscribeClicks()…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe4 = subscriptionSettingsView.dismissEvents().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.dismissEvents().sub…ngSeller = null\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable subscribe5 = this.l.updates().subscribe(new a(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "sellerRepository.updates…ncSellerState()\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        SellerCarouselItem sellerCarouselItem = this.g;
        if (sellerCarouselItem != null) {
            b(sellerCarouselItem);
        }
    }

    public final void b(SellerCarouselItem sellerCarouselItem) {
        this.g = sellerCarouselItem;
        SubscriptionSettingsView subscriptionSettingsView = this.e;
        if (subscriptionSettingsView != null) {
            Boolean isNotificationsActivated = sellerCarouselItem.isNotificationsActivated();
            subscriptionSettingsView.setNotificationActivated(isNotificationsActivated != null ? isNotificationsActivated.booleanValue() : false);
            subscriptionSettingsView.openSubscriptionSettings();
        }
    }

    public final void c(String str) {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j = Completable.complete().delay(600, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new e(this, str));
    }

    public final void d(SellerCarouselItem sellerCarouselItem) {
        String userKey = sellerCarouselItem.getUserKey();
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = this.k.subscribe(userKey, this.r).observeOn(this.o.mainThread()).doOnSubscribe(new f(this, sellerCarouselItem)).doFinally(new g(this, sellerCarouselItem)).subscribe(new h(this, sellerCarouselItem), new i(this, sellerCarouselItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.subscribe(use…r(it, item)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void detachRouter() {
        this.b.clear();
        this.f = null;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void detachView() {
        this.a.clear();
        this.c.clear();
        this.d.clear();
        resetAutoScroll();
        this.e = null;
    }

    public final void e(SellerCarouselItem sellerCarouselItem) {
        RecommendationItemView recommendationItemView = this.c.get(sellerCarouselItem.getRecommendationId());
        if (recommendationItemView != null) {
            Intrinsics.checkNotNullExpressionValue(recommendationItemView, "boundViews[item.recommendationId] ?: return");
            RecommendationItem recommendationItem = this.d.get(sellerCarouselItem.getRecommendationId());
            if (recommendationItem != null) {
                Intrinsics.checkNotNullExpressionValue(recommendationItem, "boundItems[item.recommendationId] ?: return");
                recommendationItemView.notifyItemChanged(recommendationItem.getCarousel().indexOf(sellerCarouselItem));
            }
        }
    }

    @NotNull
    public final HashMap<String, RecommendationItem> getBoundItems$favorite_sellers_items_release() {
        return this.d;
    }

    @NotNull
    public final HashMap<String, RecommendationItemView> getBoundViews$favorite_sellers_items_release() {
        return this.c;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable(KEY_CURRENT_CONFIGURING_SELLER, this.g);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void onSubscriptionDeepLinkReturned() {
        DeepLink deepLink = this.i;
        if (deepLink == null || (deepLink instanceof NoMatchLink)) {
            SellerCarouselItem sellerCarouselItem = this.h;
            if (sellerCarouselItem != null) {
                sellerCarouselItem.setSubscribeLoading(false);
                e(sellerCarouselItem);
                c(sellerCarouselItem.getRecommendationId());
                this.h = null;
            }
            this.i = null;
            return;
        }
        Intrinsics.checkNotNull(deepLink);
        if (deepLink instanceof ChainedDeepLink) {
            a(deepLink, this.h);
        } else if (deepLink instanceof SellerSubscribeLink) {
            SellerCarouselItem sellerCarouselItem2 = this.h;
            if (sellerCarouselItem2 != null) {
                d(sellerCarouselItem2);
            }
            this.i = null;
        } else {
            RecommendationItemPresenter.Router router = this.f;
            if (router != null) {
                router.followDeepLinkFromRecommendations(deepLink);
            }
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter
    public void resetAutoScroll() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void bindView(@NotNull RecommendationItemView recommendationItemView, @NotNull RecommendationItem recommendationItem, int i2) {
        Intrinsics.checkNotNullParameter(recommendationItemView, "view");
        Intrinsics.checkNotNullParameter(recommendationItem, "item");
        this.c.put(recommendationItem.getStringId(), recommendationItemView);
        this.d.put(recommendationItem.getStringId(), recommendationItem);
        recommendationItemView.setTitle(recommendationItem.getTitle());
        recommendationItemView.setCarouselItems(new ListDataSource(recommendationItem.getCarousel()));
        Parcelable scrollState = recommendationItem.getScrollState();
        if (scrollState != null) {
            recommendationItemView.restoreScrollState(scrollState);
        }
        recommendationItemView.setUnbindListener(new d(recommendationItemView, recommendationItemView.getScrollStateUpdates().subscribe(new c(this, recommendationItem)), this, recommendationItem));
    }
}
