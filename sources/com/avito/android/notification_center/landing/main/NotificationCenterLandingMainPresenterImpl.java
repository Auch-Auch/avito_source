package com.avito.android.notification_center.landing.main;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationActionEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingMain;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\b\u00102\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u00100¨\u00065"}, d2 = {"Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenterImpl;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainView;)V", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;)V", AuthSource.BOOKING_ORDER, "d", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainRouter;", "c", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;", "e", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainView;", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", "f", "Ljava/lang/String;", "id", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;", g.a, "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingMainPresenterImpl implements NotificationCenterLandingMainPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public Disposable b;
    public NotificationCenterLandingMain c;
    public NotificationCenterLandingMainRouter d;
    public NotificationCenterLandingMainView e;
    public final String f;
    public final NotificationCenterLandingMainInteractor g;
    public final SchedulersFactory h;
    public final Analytics i;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            int i = this.a;
            Map map = null;
            if (i == 0) {
                NotificationCenterLandingMain notificationCenterLandingMain = ((NotificationCenterLandingMainPresenterImpl) this.b).c;
                if (notificationCenterLandingMain != null) {
                    Map<String, String> analyticParams = notificationCenterLandingMain.getAnalyticParams();
                    if (analyticParams != null) {
                        map = r.toMutableMap(analyticParams);
                    }
                    if (map != null) {
                        String uri = notificationCenterLandingMain.getAction().getDeepLink().getUri().toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "data.action.deepLink.uri.toString()");
                        map.put("action", uri);
                        ((NotificationCenterLandingMainPresenterImpl) this.b).i.track(new NotificationActionEvent(map));
                    }
                    NotificationCenterLandingMainRouter notificationCenterLandingMainRouter = ((NotificationCenterLandingMainPresenterImpl) this.b).d;
                    if (notificationCenterLandingMainRouter != null) {
                        notificationCenterLandingMainRouter.followDeepLink(notificationCenterLandingMain.getAction().getDeepLink());
                    }
                    NotificationCenterLandingMainRouter notificationCenterLandingMainRouter2 = ((NotificationCenterLandingMainPresenterImpl) this.b).d;
                    if (notificationCenterLandingMainRouter2 != null) {
                        notificationCenterLandingMainRouter2.leaveScreen();
                    }
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                NotificationCenterLandingMainRouter notificationCenterLandingMainRouter3 = ((NotificationCenterLandingMainPresenterImpl) this.b).d;
                if (notificationCenterLandingMainRouter3 != null) {
                    notificationCenterLandingMainRouter3.leaveScreen();
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((NotificationCenterLandingMainPresenterImpl) this.b).b();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<LoadingState<? super NotificationCenterLandingMain>, Unit> {
        public final /* synthetic */ NotificationCenterLandingMainPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NotificationCenterLandingMainPresenterImpl notificationCenterLandingMainPresenterImpl) {
            super(1);
            this.a = notificationCenterLandingMainPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super NotificationCenterLandingMain> loadingState) {
            LoadingState<? super NotificationCenterLandingMain> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                NotificationCenterLandingMainView notificationCenterLandingMainView = this.a.e;
                if (notificationCenterLandingMainView != null) {
                    notificationCenterLandingMainView.showProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorResult) {
                    NotificationCenterLandingMainView notificationCenterLandingMainView2 = this.a.e;
                    if (notificationCenterLandingMainView2 != null) {
                        notificationCenterLandingMainView2.showError(((ErrorResult) error).getMessage());
                    }
                } else {
                    NotificationCenterLandingMainView notificationCenterLandingMainView3 = this.a.e;
                    if (notificationCenterLandingMainView3 != null) {
                        notificationCenterLandingMainView3.showError();
                    }
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.c = (NotificationCenterLandingMain) loaded.getData();
                this.a.a((NotificationCenterLandingMain) loaded.getData());
                NotificationCenterLandingMainView notificationCenterLandingMainView4 = this.a.e;
                if (notificationCenterLandingMainView4 != null) {
                    notificationCenterLandingMainView4.showContent();
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationCenterLandingMainPresenterImpl(@NotNull String str, @NotNull NotificationCenterLandingMainInteractor notificationCenterLandingMainInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(notificationCenterLandingMainInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = str;
        this.g = notificationCenterLandingMainInteractor;
        this.h = schedulersFactory;
        this.i = analytics;
        this.c = kundle != null ? (NotificationCenterLandingMain) kundle.getParcelable("key_data") : null;
    }

    public final void a(NotificationCenterLandingMain notificationCenterLandingMain) {
        NotificationCenterLandingMainView notificationCenterLandingMainView = this.e;
        if (notificationCenterLandingMainView != null) {
            notificationCenterLandingMainView.setImage(notificationCenterLandingMain.getImage());
            notificationCenterLandingMainView.setTitle(notificationCenterLandingMain.getTitle());
            notificationCenterLandingMainView.setDescription(notificationCenterLandingMain.getDescription());
            notificationCenterLandingMainView.setActionButtonText(notificationCenterLandingMain.getAction().getTitle());
        }
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter
    public void attachRouter(@NotNull NotificationCenterLandingMainRouter notificationCenterLandingMainRouter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingMainRouter, "router");
        this.d = notificationCenterLandingMainRouter;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter
    public void attachView(@NotNull NotificationCenterLandingMainView notificationCenterLandingMainView) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingMainView, "view");
        this.e = notificationCenterLandingMainView;
        NotificationCenterLandingMain notificationCenterLandingMain = this.c;
        if (notificationCenterLandingMain == null) {
            b();
        } else {
            a(notificationCenterLandingMain);
        }
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, notificationCenterLandingMainView.getActionButtonClicks(), "view.getActionButtonClic…lersFactory.mainThread())"), new a(0, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, notificationCenterLandingMainView.getBackButtonClicks(), "view.getBackButtonClicks…lersFactory.mainThread())"), new a(1, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, notificationCenterLandingMainView.getRetryButtonClicks(), "view.getRetryButtonClick…lersFactory.mainThread())"), new a(2, this)));
    }

    public final void b() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, this.g.getNotificationCenterLandingMain(this.f), "interactor.getNotificati…lersFactory.mainThread())"), new b(this));
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter
    public void detachView() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a.clear();
        this.b = null;
        this.e = null;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.c);
    }
}
