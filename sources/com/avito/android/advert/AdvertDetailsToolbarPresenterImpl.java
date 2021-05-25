package com.avito.android.advert;

import a2.a.a.f.e;
import a2.a.a.f.f;
import a2.a.a.f.h;
import a2.a.a.f.i;
import a2.a.a.f.j;
import a2.a.a.f.k;
import a2.a.a.f.l;
import a2.a.a.f.m;
import a2.a.a.f.n;
import a2.a.a.f.o;
import a2.a.a.f.p;
import a2.a.a.f.q;
import a2.a.a.f.r;
import a2.a.a.f.s;
import a2.a.a.f.t;
import a2.g.r.g;
import androidx.room.RoomMasterTable;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_details.R;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010a\u001a\b\u0012\u0004\u0012\u00020^0]\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u00102\u001a\u00020/\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?\u0012\u0006\u00106\u001a\u000203\u0012\n\b\u0001\u0010b\u001a\u0004\u0018\u00010!¢\u0006\u0004\bc\u0010dJ\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010DR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010KR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020^0]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006e"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsToolbarPresenterImpl;", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "Lcom/avito/android/advert/AdvertDetailsToolbarView;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/advert/AdvertDetailsToolbarView;Lcom/avito/android/remote/model/AdvertDetails;)V", "toolbarView", "attachView", "(Lcom/avito/android/advert/AdvertDetailsToolbarView;)V", "detachView", "()V", "", "updateFavoriteState", "", "context", "onAdvertLoaded", "(Lcom/avito/android/remote/model/AdvertDetails;ZLjava/lang/String;)V", "Lcom/avito/android/advert/AdvertDetailsToolbarRouter;", "router", "attachRouter", "(Lcom/avito/android/advert/AdvertDetailsToolbarRouter;)V", "detachRouter", VKAttachments.TYPE_NOTE, "updateNoteMenuItemTitle", "(Ljava/lang/String;)V", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "fromActionBar", "handleBackPressed", "(Z)V", PanelStateKt.PANEL_EXPANDED, "toggleToolbarIcons", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "h", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "viewedAdvertsInteractor", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "advertItem", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", g.a, "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "favoriteInteractor", "Lcom/avito/android/account/AccountStateProvider;", "o", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/Features;", VKApiConst.Q, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "l", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "p", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "advertDetailsPriceSubscription", "Lcom/avito/android/advert/AdvertDetailsToolbarView;", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "k", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "resourcesProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "advertDisposables", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "n", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/AdvertDetailsToolbarRouter;", "d", "commonDisposables", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "f", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "sharingEventTracker", "Lcom/avito/android/util/Formatter;", "", "i", "Lcom/avito/android/util/Formatter;", "throwableFormatter", "state", "<init>", "(Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/AdvertDetailsResourcesProvider;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsToolbarPresenterImpl implements AdvertDetailsToolbarPresenter {
    public AdvertDetailsToolbarView a;
    public AdvertDetailsToolbarRouter b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public AdvertDetails e;
    public final AdvertSharingEventTracker f;
    public final AdvertDetailsFavoriteInteractor g;
    public final ViewedAdvertsInteractor h;
    public final Formatter<Throwable> i;
    public final SchedulersFactory3 j;
    public final AdvertDetailsResourcesProvider k;
    public final AdvertDetailsAnalyticsInteractor l;
    public final Preferences m;
    public final NotificationManagerProvider n;
    public final AccountStateProvider o;
    public final ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> p;
    public final Features q;

    public static final class a<T> implements Consumer<Unit> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ AdvertDetailsToolbarView a;

        public c(AdvertDetailsToolbarView advertDetailsToolbarView) {
            this.a = advertDetailsToolbarView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
            advertDetailsToolbarView.setFavorite(bool2.booleanValue());
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
        public final /* synthetic */ AdvertDetailsToolbarView b;

        public d(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView) {
            this.a = advertDetailsToolbarPresenterImpl;
            this.b = advertDetailsToolbarView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            AdvertDetailsToolbarPresenterImpl.access$showError(this.a, this.b, th);
        }
    }

    @Inject
    public AdvertDetailsToolbarPresenterImpl(@NotNull AdvertSharingEventTracker advertSharingEventTracker, @NotNull AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, @NotNull ViewedAdvertsInteractor viewedAdvertsInteractor, @NotNull Formatter<Throwable> formatter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdvertDetailsResourcesProvider advertDetailsResourcesProvider, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull Preferences preferences, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> manuallyExposedAbTestGroup, @NotNull Features features, @AdvertFragmentModule.ToolbarPresenterSavedState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(advertSharingEventTracker, "sharingEventTracker");
        Intrinsics.checkNotNullParameter(advertDetailsFavoriteInteractor, "favoriteInteractor");
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractor, "viewedAdvertsInteractor");
        Intrinsics.checkNotNullParameter(formatter, "throwableFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(advertDetailsResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "advertDetailsPriceSubscription");
        Intrinsics.checkNotNullParameter(features, "features");
        this.f = advertSharingEventTracker;
        this.g = advertDetailsFavoriteInteractor;
        this.h = viewedAdvertsInteractor;
        this.i = formatter;
        this.j = schedulersFactory3;
        this.k = advertDetailsResourcesProvider;
        this.l = advertDetailsAnalyticsInteractor;
        this.m = preferences;
        this.n = notificationManagerProvider;
        this.o = accountStateProvider;
        this.p = manuallyExposedAbTestGroup;
        this.q = features;
    }

    public static final Single access$isFavorite(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetails advertDetails) {
        return advertDetailsToolbarPresenterImpl.g.isFavorite(advertDetails.getId(), advertDetails.isFavorite());
    }

    public static final boolean access$isPriceSubscriptionAvailable(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, boolean z, AdvertDetails advertDetails) {
        Objects.requireNonNull(advertDetailsToolbarPresenterImpl);
        boolean z2 = z && advertDetailsToolbarPresenterImpl.q.getPriceSubscriptionInfo().invoke().booleanValue() && CollectionsKt___CollectionsKt.contains(CollectionsKt__CollectionsKt.listOf(new String[]{"4", "23", "24", "25", "26", RoomMasterTable.DEFAULT_ID, "85", "86"}), advertDetails.getCategoryId()) && advertDetailsToolbarPresenterImpl.o.isAuthorized();
        if (z2) {
            advertDetailsToolbarPresenterImpl.p.expose();
        }
        if (!z2 || !advertDetailsToolbarPresenterImpl.p.getTestGroup().isFavIcon()) {
            return false;
        }
        return true;
    }

    public static final void access$onShareClicked(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetails advertDetails) {
        Objects.requireNonNull(advertDetailsToolbarPresenterImpl);
        AdvertSharing sharing = advertDetails.getSharing();
        if (sharing != null) {
            if (advertDetailsToolbarPresenterImpl.q.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                advertDetailsToolbarPresenterImpl.f.trackItemSharing(advertDetails.getId(), advertDetailsToolbarPresenterImpl.l.getParent());
            } else {
                AdvertSharingEventTracker.DefaultImpls.trackItemSharing$default(advertDetailsToolbarPresenterImpl.f, advertDetails.getId(), null, 2, null);
            }
            AdvertDetailsToolbarRouter advertDetailsToolbarRouter = advertDetailsToolbarPresenterImpl.b;
            if (advertDetailsToolbarRouter != null) {
                String str = sharing.getNative();
                if (str == null) {
                    str = sharing.getUrl();
                }
                advertDetailsToolbarRouter.openShareDialog(str, advertDetails.getTitle());
            }
        }
    }

    public static final void access$showError(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView, Throwable th) {
        advertDetailsToolbarView.showMessage(advertDetailsToolbarPresenterImpl.i.format(th));
    }

    public final void a(AdvertDetailsToolbarView advertDetailsToolbarView, AdvertDetails advertDetails) {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.g.isFavorite(advertDetails.getId(), advertDetails.isFavorite()).observeOn(this.j.mainThread()).subscribe(new c(advertDetailsToolbarView), new d(this, advertDetailsToolbarView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "advert.isFavorite()\n    …Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void attachRouter(@NotNull AdvertDetailsToolbarRouter advertDetailsToolbarRouter) {
        Intrinsics.checkNotNullParameter(advertDetailsToolbarRouter, "router");
        this.b = advertDetailsToolbarRouter;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void attachView(@NotNull AdvertDetailsToolbarView advertDetailsToolbarView) {
        Intrinsics.checkNotNullParameter(advertDetailsToolbarView, "toolbarView");
        this.a = advertDetailsToolbarView;
        advertDetailsToolbarView.setupUpButton();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = advertDetailsToolbarView.upButtonClicks().observeOn(this.j.mainThread()).subscribe(new p(this), q.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "upButtonClicks()\n       …   }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void detachView() {
        this.c.clear();
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void handleBackPressed(boolean z) {
        AdvertDetails advertDetails = this.e;
        if (advertDetails != null) {
            AdvertDetailsAnalyticsInteractor.DefaultImpls.sendBackClick$default(this.l, advertDetails.getId(), z, null, 4, null);
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void onAdvertLoaded(@NotNull AdvertDetails advertDetails, boolean z, @Nullable String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
        if (advertDetailsToolbarView != null) {
            advertDetailsToolbarView.setupToolbar();
            this.c.clear();
            CompositeDisposable compositeDisposable = this.c;
            Observable<Unit> shareButtonClicks = advertDetailsToolbarView.shareButtonClicks();
            BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
            Disposable subscribe = shareButtonClicks.toFlowable(backpressureStrategy).observeOn(this.j.mainThread()).subscribe(new o(this, advertDetails));
            Intrinsics.checkNotNullExpressionValue(subscribe, "shareButtonClicks()\n    …ked(advert)\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.c;
            Disposable subscribe2 = advertDetailsToolbarView.favoriteButtonClicks().toFlowable(backpressureStrategy).flatMapSingle(new f(this, advertDetails)).flatMapSingle(new h(this, advertDetails, str)).observeOn(this.j.mainThread()).subscribe(new i(this, advertDetailsToolbarView, advertDetails), new j(this, advertDetailsToolbarView));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "toFlowable(BackpressureS…Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.c;
            Disposable subscribe3 = this.g.favoriteInvalidatedEvent().observeOn(this.j.mainThread()).subscribe(new m(this, advertDetailsToolbarView, advertDetails), new n(this, advertDetailsToolbarView));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "favoriteInteractor\n     …Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.c;
            Disposable subscribe4 = this.g.favoriteChangeEvents(advertDetails.getId()).observeOn(this.j.mainThread()).subscribe(new k(this, advertDetailsToolbarView, advertDetails), l.a);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "favoriteInteractor\n     …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            CompositeDisposable compositeDisposable5 = this.c;
            Disposable subscribe5 = advertDetailsToolbarView.addNoteMenuItemClicks().toFlowable(backpressureStrategy).observeOn(this.j.mainThread()).subscribe(new e(this, advertDetails));
            Intrinsics.checkNotNullExpressionValue(subscribe5, "addNoteMenuItemClicks()\n…ick(advert)\n            }");
            DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            CompositeDisposable compositeDisposable6 = this.c;
            Disposable subscribe6 = this.h.markAsViewed(advertDetails.getId()).subscribe(a.a, b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe6, "viewedAdvertsInteractor.…*/ }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            if (z) {
                CompositeDisposable compositeDisposable7 = this.c;
                Disposable subscribe7 = this.g.isFavorite(advertDetails.getId(), advertDetails.isFavorite()).flatMap(new r(this, advertDetails, str)).subscribe(s.a, t.a);
                Intrinsics.checkNotNullExpressionValue(subscribe7, "favoriteInteractor.isFav…*/ }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable7, subscribe7);
            }
            a(advertDetailsToolbarView, advertDetails);
            advertDetailsToolbarView.setSharingVisible(advertDetails.getSharing() != null);
            advertDetailsToolbarView.setAddNoteMenuItemVisible(advertDetails.isActive());
            updateNoteMenuItemTitle(advertDetails.getNote());
            this.e = advertDetails;
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
        kundle.putBoolean("EXPANDED_STATE", advertDetailsToolbarView != null ? Boolean.valueOf(advertDetailsToolbarView.getIsExpanded()) : null);
        return kundle;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void toggleToolbarIcons(boolean z) {
        if (z) {
            AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
            if (advertDetailsToolbarView != null) {
                advertDetailsToolbarView.setupExpandedToolbar();
                return;
            }
            return;
        }
        AdvertDetailsToolbarView advertDetailsToolbarView2 = this.a;
        if (advertDetailsToolbarView2 != null) {
            advertDetailsToolbarView2.setupCollapsedToolbar();
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void updateFavoriteState(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
        if (advertDetailsToolbarView != null) {
            a(advertDetailsToolbarView, advertDetails);
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarPresenter
    public void updateNoteMenuItemTitle(@Nullable String str) {
        int i2;
        AdvertDetailsToolbarView advertDetailsToolbarView = this.a;
        if (advertDetailsToolbarView != null) {
            if (str == null || str.length() == 0) {
                i2 = R.string.add_note_menu_item_title;
            } else {
                i2 = R.string.edit_note_menu_item_title;
            }
            advertDetailsToolbarView.setAddNoteMenuItemTitle(i2);
        }
    }
}
