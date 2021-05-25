package com.avito.android.notification_center.list;

import a2.a.a.p1.b.c;
import a2.a.a.p1.b.d;
import a2.a.a.p1.b.e;
import a2.a.a.p1.b.f;
import a2.g.r.g;
import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationCenterItemClickEvent;
import com.avito.android.analytics.event.notification_center.NotificationCenterOpenEvent;
import com.avito.android.analytics.event.notification_center.NotificationCenterOpenItemEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NotificationCenterMarker;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.notification_center.counter.NotificationCenterCounterCleaner;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.avito.android.notification_center.push.NcPushClicksInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification.Notification;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020S0R\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010J\u001a\u00020G\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K\u0012\b\u0010[\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020S0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006^"}, d2 = {"Lcom/avito/android/notification_center/list/NotificationCenterListPresenterImpl;", "Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "c", "Lcom/avito/android/notification_center/list/NotificationCenterListView;", "view", "attachView", "(Lcom/avito/android/notification_center/list/NotificationCenterListView;)V", "detachView", "Lcom/avito/android/notification_center/list/NotificationCenterListRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/list/NotificationCenterListRouter;)V", "detachRouter", "onAppend", "", "canAppend", "()Z", "", VKApiConst.POSITION, "onItemClick", "(I)V", "onUpPressed", "onRefresh", "onRetry", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterCleaner;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/notification_center/counter/NotificationCenterCounterCleaner;", "notificationCenterCounterCleaner", "Lcom/avito/android/remote/notification/NotificationInteractor;", "k", "Lcom/avito/android/remote/notification/NotificationInteractor;", "notificationInteractor", "", "Lcom/avito/android/remote/model/notification/Notification;", "Ljava/util/List;", "items", "", "Ljava/lang/String;", "error", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "nextPage", g.a, "Lcom/avito/android/notification_center/list/NotificationCenterListView;", "Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;", "i", "Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;", "interactor", "Lcom/avito/android/notification_center/push/NcPushClicksInteractor;", "n", "Lcom/avito/android/notification_center/push/NcPushClicksInteractor;", "ncPushClicksInteractor", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "clicksDisposables", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "dataDisposable", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "l", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "notificationCenterCounterMarker", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "p", "Lcom/jakewharton/rxrelay2/PublishRelay;", "refreshClicks", "f", "Lcom/avito/android/notification_center/list/NotificationCenterListRouter;", "Ldagger/Lazy;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "h", "Ldagger/Lazy;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "kundle", "<init>", "(Ldagger/Lazy;Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/notification/NotificationInteractor;Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;Lcom/avito/android/notification_center/counter/NotificationCenterCounterCleaner;Lcom/avito/android/notification_center/push/NcPushClicksInteractor;Lcom/avito/android/analytics/Analytics;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterListPresenterImpl implements NotificationCenterListPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public List<Notification> b;
    public String c;
    public Uri d;
    public Disposable e;
    public NotificationCenterListRouter f;
    public NotificationCenterListView g;
    public final Lazy<AdapterPresenter> h;
    public final NotificationCenterListInteractor i;
    public final SchedulersFactory j;
    public final NotificationInteractor k;
    public final NotificationCenterCounterMarker l;
    public final NotificationCenterCounterCleaner m;
    public final NcPushClicksInteractor n;
    public final Analytics o;
    public final PublishRelay<NotificationCenterListItem.ErrorSnippet> p;

    public static final class a<T> implements Consumer<List<? extends Notification>> {
        public final /* synthetic */ NotificationCenterListPresenterImpl a;

        public a(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
            this.a = notificationCenterListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends Notification> list) {
            this.a.b = list;
            this.a.c();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ NotificationCenterListPresenterImpl a;

        public b(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
            this.a = notificationCenterListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                String message = ((TypedResultException) th2).getMessage();
                this.a.c = message;
                NotificationCenterListView notificationCenterListView = this.a.g;
                if (notificationCenterListView != null) {
                    notificationCenterListView.showError(message);
                }
                NotificationCenterListView notificationCenterListView2 = this.a.g;
                if (notificationCenterListView2 != null) {
                    notificationCenterListView2.hideRefreshProgress();
                }
            }
        }
    }

    @Inject
    public NotificationCenterListPresenterImpl(@NotNull Lazy<AdapterPresenter> lazy, @NotNull NotificationCenterListInteractor notificationCenterListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull NotificationInteractor notificationInteractor, @NotNull NotificationCenterCounterMarker notificationCenterCounterMarker, @NotNull NotificationCenterCounterCleaner notificationCenterCounterCleaner, @NotNull NcPushClicksInteractor ncPushClicksInteractor, @NotNull Analytics analytics, @NotNull PublishRelay<NotificationCenterListItem.ErrorSnippet> publishRelay, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(lazy, "adapterPresenter");
        Intrinsics.checkNotNullParameter(notificationCenterListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(notificationInteractor, "notificationInteractor");
        Intrinsics.checkNotNullParameter(notificationCenterCounterMarker, "notificationCenterCounterMarker");
        Intrinsics.checkNotNullParameter(notificationCenterCounterCleaner, "notificationCenterCounterCleaner");
        Intrinsics.checkNotNullParameter(ncPushClicksInteractor, "ncPushClicksInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishRelay, "refreshClicks");
        this.h = lazy;
        this.i = notificationCenterListInteractor;
        this.j = schedulersFactory;
        this.k = notificationInteractor;
        this.l = notificationCenterCounterMarker;
        this.m = notificationCenterCounterCleaner;
        this.n = ncPushClicksInteractor;
        this.o = analytics;
        this.p = publishRelay;
        Uri uri = null;
        this.b = kundle != null ? kundle.getParcelableList("key_data") : null;
        this.c = kundle != null ? kundle.getString("key_error") : null;
        this.d = kundle != null ? (Uri) kundle.getParcelable("key_next_page") : uri;
        if (kundle == null) {
            analytics.track(new NotificationCenterOpenEvent());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListPresenter
    public void attachRouter(@NotNull NotificationCenterListRouter notificationCenterListRouter) {
        Intrinsics.checkNotNullParameter(notificationCenterListRouter, "router");
        this.f = notificationCenterListRouter;
        Disposable disposable = this.e;
        if ((disposable != null ? disposable.isDisposed() : true) && this.n.needsRefresh()) {
            NotificationCenterListView notificationCenterListView = this.g;
            if (notificationCenterListView != null) {
                notificationCenterListView.showRefreshProgress();
            }
            b();
        }
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListPresenter
    public void attachView(@NotNull NotificationCenterListView notificationCenterListView) {
        Intrinsics.checkNotNullParameter(notificationCenterListView, "view");
        this.g = notificationCenterListView;
        String str = this.c;
        if (this.b != null) {
            c();
        } else if (str == null) {
            notificationCenterListView.showProgress();
            b();
        } else {
            notificationCenterListView.showError(str);
        }
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.p.subscribe(new a2.a.a.p1.b.b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "refreshClicks.subscribe …  showContent()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void b() {
        this.c = null;
        this.n.clear();
        a();
        Observable doOnNext = a2.b.a.a.a.T1(this.j, this.i.getNotifications(), "interactor.getNotificati…lersFactory.mainThread())").doOnNext(new f(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.getNotificati…          .saveNextPage()");
        Observable doOnNext2 = doOnNext.doOnNext(new a2.a.a.p1.b.a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext2, "interactor.getNotificati…          .cleanCounter()");
        Observable map = doOnNext2.map(new e(CollectionsKt__CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(map, "map {\n            val ne…tems + newItems\n        }");
        this.e = map.subscribe(new a(this), new b(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r17 = this;
            r0 = r17
            com.avito.android.notification_center.list.NotificationCenterListView r1 = r0.g
            if (r1 == 0) goto L_0x00b8
            java.util.List<com.avito.android.remote.model.notification.Notification> r2 = r0.b
            if (r2 == 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x000f:
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = t6.n.e.collectionSizeOrDefault(r2, r4)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
            r4 = 0
            r5 = 0
        L_0x0020:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r2.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x0031
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0031:
            com.avito.android.remote.model.notification.Notification r6 = (com.avito.android.remote.model.notification.Notification) r6
            com.avito.android.notification_center.list.item.NotificationCenterListItem$Notification r14 = new com.avito.android.notification_center.list.item.NotificationCenterListItem$Notification
            long r9 = (long) r5
            java.lang.String r11 = r6.getId()
            java.lang.String r12 = r6.getTitle()
            java.lang.String r13 = r6.getDescription()
            long r15 = r6.getDate()
            boolean r5 = r6.isRead()
            r8 = r14
            r6 = r14
            r14 = r15
            r16 = r5
            r8.<init>(r9, r11, r12, r13, r14, r16)
            r3.add(r6)
            r5 = r7
            goto L_0x0020
        L_0x0057:
            boolean r2 = r3.isEmpty()
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x0089
            java.lang.String r2 = r0.c
            if (r2 == 0) goto L_0x0069
            int r2 = r2.length()
            if (r2 != 0) goto L_0x006a
        L_0x0069:
            r4 = 1
        L_0x006a:
            if (r4 != 0) goto L_0x0089
            java.lang.String r2 = r0.c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r3)
            a2.a.a.p1.b.g r4 = a2.a.a.p1.b.g.a
            t6.n.h.removeAll(r3, r4)
            com.avito.android.notification_center.list.item.NotificationCenterListItem$ErrorSnippet r4 = new com.avito.android.notification_center.list.item.NotificationCenterListItem$ErrorSnippet
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.<init>(r5, r2)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r3, r4)
            goto L_0x0092
        L_0x0089:
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r3)
            a2.a.a.p1.b.g r3 = a2.a.a.p1.b.g.a
            t6.n.h.removeAll(r2, r3)
        L_0x0092:
            dagger.Lazy<com.avito.konveyor.adapter.AdapterPresenter> r3 = r0.h
            java.lang.Object r3 = r3.get()
            com.avito.konveyor.adapter.AdapterPresenter r3 = (com.avito.konveyor.adapter.AdapterPresenter) r3
            com.avito.konveyor.data_source.ListDataSource r4 = new com.avito.konveyor.data_source.ListDataSource
            r4.<init>(r2)
            r3.onDataSourceChanged(r4)
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00ac
            r1.showEmpty()
            goto L_0x00af
        L_0x00ac:
            r1.hideEmpty()
        L_0x00af:
            r1.showContent()
            r1.hideRefreshProgress()
            r1.notifyDataChanged()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.notification_center.list.NotificationCenterListPresenterImpl.c():void");
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        if (this.d != null) {
            String str = this.c;
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListPresenter
    public void detachRouter() {
        this.f = null;
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListPresenter
    public void detachView() {
        this.a.clear();
        a();
        this.g = null;
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelableList("key_data", this.b).putString("key_error", this.c).putParcelable("key_next_page", this.d);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        Observable observable;
        a();
        Uri uri = this.d;
        if (uri == null) {
            List<Notification> list = this.b;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            observable = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        } else {
            Observable doOnNext = a2.b.a.a.a.T1(this.j, this.i.getNotifications(uri), "interactor.getNotificati…lersFactory.mainThread())").doOnNext(new f(this));
            Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.getNotificati…          .saveNextPage()");
            List<Notification> list2 = this.b;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            observable = doOnNext.map(new e(list2));
            Intrinsics.checkNotNullExpressionValue(observable, "map {\n            val ne…tems + newItems\n        }");
        }
        this.e = observable.subscribe(new c(this), new d(this));
    }

    @Override // com.avito.android.notification_center.list.item.NotificationCenterListItemClickListener
    public void onItemClick(int i2) {
        List<Notification> list = this.b;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            Notification notification = list.get(i2);
            DeepLink uri = notification.getUri();
            notification.setRead(true);
            c();
            this.k.cancelNotificationCenterNotification(notification.getId());
            if (!(uri instanceof NotificationCenterMarker)) {
                this.l.markAsRead(notification.getId());
            }
            Map<String, String> analyticParams = notification.getAnalyticParams();
            CalledFrom.NotificationCenter notificationCenter = new CalledFrom.NotificationCenter(analyticParams != null ? analyticParams : r.emptyMap());
            if (analyticParams == null) {
                NotificationCenterListRouter notificationCenterListRouter = this.f;
                if (notificationCenterListRouter != null) {
                    notificationCenterListRouter.followDeepLink(uri, notificationCenter);
                    return;
                }
                return;
            }
            this.o.track(new NotificationCenterItemClickEvent(analyticParams));
            this.o.track(new NotificationCenterOpenItemEvent(analyticParams));
            if (uri instanceof PromoLink) {
                NotificationCenterListRouter notificationCenterListRouter2 = this.f;
                if (notificationCenterListRouter2 != null) {
                    notificationCenterListRouter2.openPromoScreen(((PromoLink) uri).getExtendedUrl(), notificationCenter);
                    return;
                }
                return;
            }
            NotificationCenterListRouter notificationCenterListRouter3 = this.f;
            if (notificationCenterListRouter3 != null) {
                notificationCenterListRouter3.followDeepLink(uri, notificationCenter);
            }
        }
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView.Callback
    public void onRefresh() {
        NotificationCenterListView notificationCenterListView = this.g;
        if (notificationCenterListView != null) {
            notificationCenterListView.showRefreshProgress();
        }
        this.b = null;
        b();
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView.Callback
    public void onRetry() {
        NotificationCenterListView notificationCenterListView = this.g;
        if (notificationCenterListView != null) {
            notificationCenterListView.showProgress();
        }
        b();
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView.Callback
    public void onUpPressed() {
        NotificationCenterListRouter notificationCenterListRouter = this.f;
        if (notificationCenterListRouter != null) {
            notificationCenterListRouter.onUpPressed();
        }
    }
}
