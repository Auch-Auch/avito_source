package com.avito.android.notification_center.landing.share;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationCenterLandingShareClickEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingShare;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.google.firebase.messaging.Constants;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001:\u0001\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;)V", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;)V", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "trackAppSelected", "(Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Impl", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingSharePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\b\u0010;\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00101R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00101R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter$Impl;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;)V", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;)V", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "trackAppSelected", "(Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare;)V", "d", AuthSource.BOOKING_ORDER, "c", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "k", "Ljava/lang/String;", "id", "Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "j", "Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "shareImageInteractor", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "e", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadContentDisposable", "f", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;", "loadImageDisposable", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;", "h", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;", "interactor", "state", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements NotificationCenterLandingSharePresenter {
        public final CompositeDisposable a = new CompositeDisposable();
        public NotificationCenterLandingShare b;
        public Disposable c;
        public Disposable d;
        public NotificationCenterLandingShareRouter e;
        public NotificationCenterLandingShareView f;
        public final Analytics g;
        public final NotificationCenterLandingShareInteractor h;
        public final SchedulersFactory i;
        public final ShareImageInteractor j;
        public final String k;

        /* compiled from: java-style lambda group */
        public static final class a<T> implements Consumer<Throwable> {
            public static final a b = new a(0);
            public static final a c = new a(1);
            public static final a d = new a(2);
            public static final a e = new a(3);
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Throwable th) {
                int i = this.a;
                if (i == 0) {
                    Logs.error(th);
                } else if (i == 1) {
                    Logs.error(th);
                } else if (i == 2) {
                    Logs.error(th);
                } else if (i == 3) {
                    Logs.error(th);
                } else {
                    throw null;
                }
            }
        }

        /* compiled from: java-style lambda group */
        public static final class b<T> implements Consumer<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            public b(int i, Object obj) {
                this.a = i;
                this.b = obj;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Unit unit) {
                int i = this.a;
                if (i == 0) {
                    NotificationCenterLandingShare notificationCenterLandingShare = ((Impl) this.b).b;
                    if (notificationCenterLandingShare != null) {
                        NotificationCenterLandingShare.Share share = notificationCenterLandingShare.getShare();
                        String urlImage = share.getUrlImage();
                        if (urlImage == null) {
                            NotificationCenterLandingShareRouter notificationCenterLandingShareRouter = ((Impl) this.b).e;
                            if (notificationCenterLandingShareRouter != null) {
                                notificationCenterLandingShareRouter.share(share.getTitle(), share.getUrl());
                                return;
                            }
                            return;
                        }
                        Impl.access$loadImage((Impl) this.b, share.getTitle(), share.getUrl(), urlImage);
                    }
                } else if (i == 1) {
                    NotificationCenterLandingShareRouter notificationCenterLandingShareRouter2 = ((Impl) this.b).e;
                    if (notificationCenterLandingShareRouter2 != null) {
                        notificationCenterLandingShareRouter2.close();
                    }
                } else if (i == 2) {
                    ((Impl) this.b).c();
                } else if (i == 3) {
                    ((Impl) this.b).d();
                } else {
                    throw null;
                }
            }
        }

        public static final class c<T> implements Consumer<LoadingState<? super NotificationCenterLandingShare>> {
            public final /* synthetic */ Impl a;

            public c(Impl impl) {
                this.a = impl;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(LoadingState<? super NotificationCenterLandingShare> loadingState) {
                LoadingState<? super NotificationCenterLandingShare> loadingState2 = loadingState;
                if (loadingState2 instanceof LoadingState.Loading) {
                    NotificationCenterLandingShareView notificationCenterLandingShareView = this.a.f;
                    if (notificationCenterLandingShareView != null) {
                        notificationCenterLandingShareView.showProgress();
                    }
                } else if (loadingState2 instanceof LoadingState.Error) {
                    this.a.b();
                    TypedError error = ((LoadingState.Error) loadingState2).getError();
                    if (error instanceof ErrorResult) {
                        NotificationCenterLandingShareView notificationCenterLandingShareView2 = this.a.f;
                        if (notificationCenterLandingShareView2 != null) {
                            notificationCenterLandingShareView2.showError(((ErrorResult) error).getMessage());
                            return;
                        }
                        return;
                    }
                    NotificationCenterLandingShareView notificationCenterLandingShareView3 = this.a.f;
                    if (notificationCenterLandingShareView3 != null) {
                        notificationCenterLandingShareView3.showError();
                    }
                } else if (loadingState2 instanceof LoadingState.Loaded) {
                    this.a.b();
                    LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                    this.a.b = (NotificationCenterLandingShare) loaded.getData();
                    this.a.a((NotificationCenterLandingShare) loaded.getData());
                    NotificationCenterLandingShareView notificationCenterLandingShareView4 = this.a.f;
                    if (notificationCenterLandingShareView4 != null) {
                        notificationCenterLandingShareView4.showContent();
                    }
                }
            }
        }

        public static final class d<T> implements Consumer<Throwable> {
            public static final d a = new d();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.error(th);
            }
        }

        public Impl(@NotNull Analytics analytics, @NotNull NotificationCenterLandingShareInteractor notificationCenterLandingShareInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ShareImageInteractor shareImageInteractor, @NotNull String str, @Nullable Kundle kundle) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(notificationCenterLandingShareInteractor, "interactor");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
            Intrinsics.checkNotNullParameter(shareImageInteractor, "shareImageInteractor");
            Intrinsics.checkNotNullParameter(str, "id");
            this.g = analytics;
            this.h = notificationCenterLandingShareInteractor;
            this.i = schedulersFactory;
            this.j = shareImageInteractor;
            this.k = str;
            this.b = kundle != null ? (NotificationCenterLandingShare) kundle.getParcelable("key_data") : null;
        }

        public static final void access$loadImage(Impl impl, String str, String str2, String str3) {
            impl.c();
            NotificationCenterLandingShareView notificationCenterLandingShareView = impl.f;
            if (notificationCenterLandingShareView != null) {
                notificationCenterLandingShareView.showProgressDialog();
            }
            impl.d = impl.j.load(str3).observeOn(impl.i.mainThread()).subscribe(new a2.a.a.p1.a.c.a(impl, str, str2), a2.a.a.p1.a.c.b.a);
        }

        public final void a(NotificationCenterLandingShare notificationCenterLandingShare) {
            NotificationCenterLandingShareView notificationCenterLandingShareView = this.f;
            if (notificationCenterLandingShareView != null) {
                notificationCenterLandingShareView.setImage(notificationCenterLandingShare.getImage());
                notificationCenterLandingShareView.setTitle(notificationCenterLandingShare.getTitle());
                notificationCenterLandingShareView.setDescription(notificationCenterLandingShare.getDescription());
                NotificationCenterLandingShare.Advert advert = notificationCenterLandingShare.getAdvert();
                if (advert == null) {
                    notificationCenterLandingShareView.setAdvertVisible(false);
                } else {
                    notificationCenterLandingShareView.setAdvertVisible(true);
                    notificationCenterLandingShareView.setAdvertImage(advert.getImage());
                    notificationCenterLandingShareView.setAdvertTitle(advert.getTitle());
                    notificationCenterLandingShareView.setAdvertPrice(advert.getPrice());
                    notificationCenterLandingShareView.setAdvertPriceWithoutDiscount(advert.getPriceWithoutDiscount());
                    notificationCenterLandingShareView.setAdvertLocation(advert.getLocation());
                }
                notificationCenterLandingShareView.setActionButtonText(notificationCenterLandingShare.getButton());
            }
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        public void attachRouter(@NotNull NotificationCenterLandingShareRouter notificationCenterLandingShareRouter) {
            Intrinsics.checkNotNullParameter(notificationCenterLandingShareRouter, "router");
            this.e = notificationCenterLandingShareRouter;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        public void attachView(@NotNull NotificationCenterLandingShareView notificationCenterLandingShareView) {
            Intrinsics.checkNotNullParameter(notificationCenterLandingShareView, "view");
            this.f = notificationCenterLandingShareView;
            NotificationCenterLandingShare notificationCenterLandingShare = this.b;
            if (notificationCenterLandingShare == null) {
                d();
            } else {
                a(notificationCenterLandingShare);
            }
            Scheduler mainThread = this.i.mainThread();
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = notificationCenterLandingShareView.getActionButtonClicks().observeOn(mainThread).subscribe(new b(0, this), a.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.a;
            Disposable subscribe2 = notificationCenterLandingShareView.getBackButtonClicks().observeOn(mainThread).subscribe(new b(1, this), a.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.a;
            Disposable subscribe3 = notificationCenterLandingShareView.getCancelDialogClicks().observeOn(mainThread).subscribe(new b(2, this), a.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.a;
            Disposable subscribe4 = notificationCenterLandingShareView.getRetryButtonClicks().observeOn(mainThread).subscribe(new b(3, this), a.e);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        }

        public final void b() {
            Disposable disposable = this.c;
            if (disposable != null) {
                disposable.dispose();
            }
            this.c = null;
        }

        public final void c() {
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = null;
        }

        public final void d() {
            b();
            this.c = this.h.getData(this.k).observeOn(this.i.mainThread()).subscribe(new c(this), d.a);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        public void detachRouter() {
            this.e = null;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        public void detachView() {
            b();
            c();
            this.a.clear();
            this.f = null;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        @NotNull
        public Kundle getState() {
            return new Kundle().putParcelable("key_data", this.b);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter
        public void trackAppSelected(@Nullable String str) {
            NotificationCenterLandingShare notificationCenterLandingShare = this.b;
            if (notificationCenterLandingShare != null) {
                HashMap hashMap = new HashMap(notificationCenterLandingShare.getAnalytics());
                if (str != null) {
                    hashMap.put("share_place", str);
                }
                this.g.track(new NotificationCenterLandingShareClickEvent(hashMap));
            }
        }
    }

    void attachRouter(@NotNull NotificationCenterLandingShareRouter notificationCenterLandingShareRouter);

    void attachView(@NotNull NotificationCenterLandingShareView notificationCenterLandingShareView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();

    void trackAppSelected(@Nullable String str);
}
