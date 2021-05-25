package com.avito.android.notification_center.landing.unified;

import a2.a.a.p1.a.d.d;
import a2.a.a.p1.a.d.e;
import a2.a.a.p1.a.d.f;
import a2.g.r.g;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.di.ButtonFirst;
import com.avito.android.notification_center.landing.unified.di.ButtonSecond;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingUnified;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.webview.analytics.WebViewLandingClickEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B«\u0001\b\u0007\u0012\u0006\u0010J\u001a\u00020\u001c\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020C0 \u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0 \u0012\u000e\b\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002030 \u0012\u000e\b\u0001\u00105\u001a\b\u0012\u0004\u0012\u0002030 \u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020K0 \u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010;\u001a\u000208\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bZ\u0010[J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010#R\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010#R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020C0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010#R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010GR\u0016\u0010J\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010\u001eR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020K0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010NR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010=¨\u0006\\"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "", "c", "()V", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "data", "d", "(Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedView;", "view", "attachView", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedView;)V", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "detachView", "Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", "converter", "", "f", "Ljava/lang/String;", "error", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/serp/adapter/FavorableItem;", "o", "Lcom/jakewharton/rxrelay2/Relay;", "advertFavoriteObservable", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonItem;", "p", "buttonClickObservable", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "t", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", g.a, "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedRouter;", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;", "r", "pairButtonSecondClickObservable", VKApiConst.Q, "pairButtonFirstClickObservable", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "u", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "converterDisposable", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "n", "advertClickObservable", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "clicksDisposables", "h", "id", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItem;", "s", "subtitleClickObservable", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedView;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;", "k", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;", "interactor", "e", "dataDisposable", "state", "<init>", "(Ljava/lang/String;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingUnifiedPresenterImpl implements NotificationCenterLandingUnifiedPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public NotificationCenterLandingUnifiedRouter b;
    public NotificationCenterLandingUnifiedView c;
    public Disposable d;
    public Disposable e;
    public String f;
    public NotificationCenterLandingUnified g;
    public final String h;
    public final AdapterPresenter i;
    public final Analytics j;
    public final NotificationCenterLandingUnifiedInteractor k;
    public final SchedulersFactory l;
    public final NotificationsCenterLandingUnifiedConverter m;
    public final Relay<UnifiedAdvertItem> n;
    public final Relay<FavorableItem> o;
    public final Relay<UnifiedButtonItem> p;
    public final Relay<UnifiedPairButtonItem> q;
    public final Relay<UnifiedPairButtonItem> r;
    public final Relay<UnifiedSubtitleItem> s;
    public final FavoriteAdvertsPresenter t;
    public final ViewedAdvertsPresenter u;

    public static final class a<T> implements Consumer<NotificationCenterLandingUnified> {
        public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

        public a(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
            this.a = notificationCenterLandingUnifiedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(NotificationCenterLandingUnified notificationCenterLandingUnified) {
            NotificationCenterLandingUnified notificationCenterLandingUnified2 = notificationCenterLandingUnified;
            this.a.b();
            this.a.g = notificationCenterLandingUnified2;
            NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(notificationCenterLandingUnified2, "it");
            notificationCenterLandingUnifiedPresenterImpl.d(notificationCenterLandingUnified2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

        public b(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
            this.a = notificationCenterLandingUnifiedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.b();
            if (th2 instanceof TypedResultException) {
                String message = ((TypedResultException) th2).getMessage();
                this.a.f = message;
                NotificationCenterLandingUnifiedView notificationCenterLandingUnifiedView = this.a.c;
                if (notificationCenterLandingUnifiedView != null) {
                    notificationCenterLandingUnifiedView.showLoadingError(message);
                    return;
                }
                return;
            }
            NotificationCenterLandingUnifiedView notificationCenterLandingUnifiedView2 = this.a.c;
            if (notificationCenterLandingUnifiedView2 != null) {
                notificationCenterLandingUnifiedView2.showLoadingError();
            }
        }
    }

    public static final class c<T> implements Consumer<List<? extends Item>> {
        public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

        public c(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
            this.a = notificationCenterLandingUnifiedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            this.a.a();
            NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            NotificationCenterLandingUnifiedPresenterImpl.access$showContent(notificationCenterLandingUnifiedPresenterImpl, list2);
        }
    }

    @Inject
    public NotificationCenterLandingUnifiedPresenterImpl(@NotNull String str, @NotNull AdapterPresenter adapterPresenter, @NotNull Analytics analytics, @NotNull NotificationCenterLandingUnifiedInteractor notificationCenterLandingUnifiedInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull NotificationsCenterLandingUnifiedConverter notificationsCenterLandingUnifiedConverter, @NotNull Relay<UnifiedAdvertItem> relay, @NotNull Relay<FavorableItem> relay2, @NotNull Relay<UnifiedButtonItem> relay3, @ButtonFirst @NotNull Relay<UnifiedPairButtonItem> relay4, @ButtonSecond @NotNull Relay<UnifiedPairButtonItem> relay5, @NotNull Relay<UnifiedSubtitleItem> relay6, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(notificationCenterLandingUnifiedInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(notificationsCenterLandingUnifiedConverter, "converter");
        Intrinsics.checkNotNullParameter(relay, "advertClickObservable");
        Intrinsics.checkNotNullParameter(relay2, "advertFavoriteObservable");
        Intrinsics.checkNotNullParameter(relay3, "buttonClickObservable");
        Intrinsics.checkNotNullParameter(relay4, "pairButtonFirstClickObservable");
        Intrinsics.checkNotNullParameter(relay5, "pairButtonSecondClickObservable");
        Intrinsics.checkNotNullParameter(relay6, "subtitleClickObservable");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        this.h = str;
        this.i = adapterPresenter;
        this.j = analytics;
        this.k = notificationCenterLandingUnifiedInteractor;
        this.l = schedulersFactory;
        this.m = notificationsCenterLandingUnifiedConverter;
        this.n = relay;
        this.o = relay2;
        this.p = relay3;
        this.q = relay4;
        this.r = relay5;
        this.s = relay6;
        this.t = favoriteAdvertsPresenter;
        this.u = viewedAdvertsPresenter;
        NotificationCenterLandingUnified notificationCenterLandingUnified = null;
        this.f = kundle != null ? kundle.getString("key_error") : null;
        this.g = kundle != null ? (NotificationCenterLandingUnified) kundle.getParcelable("key_data") : notificationCenterLandingUnified;
    }

    public static final void access$sendEvent(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl, Map map) {
        Objects.requireNonNull(notificationCenterLandingUnifiedPresenterImpl);
        if (map != null) {
            notificationCenterLandingUnifiedPresenterImpl.j.track(new WebViewLandingClickEvent(map));
        }
    }

    public final void a() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter
    public void attachRouter(@NotNull NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingUnifiedRouter, "router");
        this.b = notificationCenterLandingUnifiedRouter;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter
    public void attachView(@NotNull NotificationCenterLandingUnifiedView notificationCenterLandingUnifiedView) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingUnifiedView, "view");
        this.c = notificationCenterLandingUnifiedView;
        this.t.attachView(notificationCenterLandingUnifiedView);
        this.t.attachErrorMessageView(notificationCenterLandingUnifiedView);
        this.u.attachView(notificationCenterLandingUnifiedView);
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.n.observeOn(this.l.mainThread()).subscribe(new a2.a.a.p1.a.d.a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "advertClickObservable.ob…t.deepLink)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = this.o.observeOn(this.l.mainThread()).subscribe(new a2.a.a.p1.a.d.b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "advertFavoriteObservable…voriteButtonClicked(it) }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe3 = notificationCenterLandingUnifiedView.getBackButtonClicks().observeOn(this.l.mainThread()).subscribe(new a2.a.a.p1.a.d.c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.getBackButtonClicks…{ router?.leaveScreen() }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe4 = this.p.observeOn(this.l.mainThread()).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "buttonClickObservable.ob…aveScreen()\n            }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable subscribe5 = this.q.observeOn(this.l.mainThread()).subscribe(new k2(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "pairButtonFirstClickObse…aveScreen()\n            }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.a;
        Disposable subscribe6 = this.r.observeOn(this.l.mainThread()).subscribe(new k2(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "pairButtonSecondClickObs…aveScreen()\n            }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.a;
        Disposable subscribe7 = notificationCenterLandingUnifiedView.getRetryButtonClicks().observeOn(this.l.mainThread()).subscribe(new e(this, notificationCenterLandingUnifiedView));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "view.getRetryButtonClick… loadData()\n            }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.a;
        Disposable subscribe8 = this.s.observeOn(this.l.mainThread()).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe8, "subtitleClickObservable.…ink(this) }\n            }");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        NotificationCenterLandingUnified notificationCenterLandingUnified = this.g;
        String str = this.f;
        if (notificationCenterLandingUnified != null) {
            d(notificationCenterLandingUnified);
        } else if (str == null) {
            notificationCenterLandingUnifiedView.showProgress();
            c();
        } else {
            notificationCenterLandingUnifiedView.showLoadingError(str);
        }
    }

    public final void b() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
    }

    public final void c() {
        b();
        this.e = this.k.getNotificationCenterLandingUnified(this.h).observeOn(this.l.mainThread()).subscribe(new a(this), new b(this));
    }

    public final void d(NotificationCenterLandingUnified notificationCenterLandingUnified) {
        a();
        this.d = this.m.convert(notificationCenterLandingUnified).subscribeOn(this.l.mainThread()).observeOn(this.l.mainThread()).subscribe(new c(this));
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter
    public void detachView() {
        this.t.detachViews();
        this.u.detachView();
        this.a.clear();
        a();
        b();
        this.c = null;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.g);
    }

    public static final void access$showContent(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl, List list) {
        NotificationCenterLandingUnifiedView notificationCenterLandingUnifiedView = notificationCenterLandingUnifiedPresenterImpl.c;
        if (notificationCenterLandingUnifiedView != null) {
            ListDataSource listDataSource = new ListDataSource(list);
            notificationCenterLandingUnifiedPresenterImpl.i.onDataSourceChanged(listDataSource);
            notificationCenterLandingUnifiedPresenterImpl.t.onDataSourceChanged(listDataSource);
            notificationCenterLandingUnifiedPresenterImpl.u.onDataSourceChanged(listDataSource);
            notificationCenterLandingUnifiedView.showContent();
            notificationCenterLandingUnifiedView.notifyDataChanged();
        }
    }
}
