package com.avito.android.notification_center.landing.feedback;

import a2.a.a.p1.a.a.b;
import a2.a.a.p1.a.a.c;
import a2.a.a.p1.a.a.d;
import a2.a.a.p1.a.a.e;
import a2.a.a.p1.a.a.f;
import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%\u0012\b\u00109\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\fR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenterImpl;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;)V", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "cancelDialog", "c", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;)V", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "initialDisposable", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "h", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "interactor", "f", "resultDisposable", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;", "d", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "k", "Lcom/jakewharton/rxrelay2/PublishRelay;", "onCancelDialogRelay", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", g.a, "Ljava/lang/String;", "id", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingFeedbackPresenterImpl implements NotificationCenterLandingFeedbackPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public NotificationCenterLandingFeedbackView b;
    public NotificationCenterLandingFeedback c;
    public NotificationCenterLandingFeedbackRouter d;
    public Disposable e;
    public Disposable f;
    public final String g;
    public final NotificationCenterLandingFeedbackInteractor h;
    public final SchedulersFactory i;
    public final Analytics j;
    public final PublishRelay<Unit> k;

    public static final class a extends Lambda implements Function1<LoadingState<? super NotificationCenterLandingFeedback>, Unit> {
        public final /* synthetic */ NotificationCenterLandingFeedbackPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl) {
            super(1);
            this.a = notificationCenterLandingFeedbackPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super NotificationCenterLandingFeedback> loadingState) {
            LoadingState<? super NotificationCenterLandingFeedback> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView = this.a.b;
                if (notificationCenterLandingFeedbackView != null) {
                    notificationCenterLandingFeedbackView.showProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.c = (NotificationCenterLandingFeedback) loaded.getData();
                this.a.a((NotificationCenterLandingFeedback) loaded.getData());
                NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView2 = this.a.b;
                if (notificationCenterLandingFeedbackView2 != null) {
                    notificationCenterLandingFeedbackView2.showContent();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorResult) {
                    NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView3 = this.a.b;
                    if (notificationCenterLandingFeedbackView3 != null) {
                        notificationCenterLandingFeedbackView3.showError(((ErrorResult) error).getMessage());
                    }
                } else {
                    NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView4 = this.a.b;
                    if (notificationCenterLandingFeedbackView4 != null) {
                        notificationCenterLandingFeedbackView4.showError();
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationCenterLandingFeedbackPresenterImpl(@NotNull String str, @NotNull NotificationCenterLandingFeedbackInteractor notificationCenterLandingFeedbackInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull PublishRelay<Unit> publishRelay, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(notificationCenterLandingFeedbackInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishRelay, "onCancelDialogRelay");
        this.g = str;
        this.h = notificationCenterLandingFeedbackInteractor;
        this.i = schedulersFactory;
        this.j = analytics;
        this.k = publishRelay;
        this.c = kundle != null ? (NotificationCenterLandingFeedback) kundle.getParcelable("key_data") : null;
    }

    public static final void access$sendFeedbackResult(NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl, boolean z) {
        Disposable disposable = notificationCenterLandingFeedbackPresenterImpl.f;
        if (disposable != null) {
            disposable.dispose();
        }
        notificationCenterLandingFeedbackPresenterImpl.f = Observables.subscribeOnNext(a2.b.a.a.a.T1(notificationCenterLandingFeedbackPresenterImpl.i, notificationCenterLandingFeedbackPresenterImpl.h.sendNotificationCenterLandingFeedbackResult(notificationCenterLandingFeedbackPresenterImpl.g, z), "interactor.sendNotificat…lersFactory.mainThread())"), new f(notificationCenterLandingFeedbackPresenterImpl));
    }

    public final void a(NotificationCenterLandingFeedback notificationCenterLandingFeedback) {
        NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView = this.b;
        if (notificationCenterLandingFeedbackView != null) {
            notificationCenterLandingFeedbackView.setImage(notificationCenterLandingFeedback.getImage());
            notificationCenterLandingFeedbackView.setTitle(notificationCenterLandingFeedback.getTitle());
            notificationCenterLandingFeedbackView.setDescription(notificationCenterLandingFeedback.getDescription());
            notificationCenterLandingFeedbackView.setPositiveActionButtonText(notificationCenterLandingFeedback.getPositiveActionTitle());
            notificationCenterLandingFeedbackView.setNegativeActionButtonText(notificationCenterLandingFeedback.getNegativeActionTitle());
        }
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    public void attachRouter(@NotNull NotificationCenterLandingFeedbackRouter notificationCenterLandingFeedbackRouter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingFeedbackRouter, "router");
        this.d = notificationCenterLandingFeedbackRouter;
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    public void attachView(@NotNull NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingFeedbackView, "view");
        this.b = notificationCenterLandingFeedbackView;
        CompositeDisposable compositeDisposable = this.a;
        Observable<Unit> observeOn = this.k.observeOn(this.i.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "onCancelDialogRelay\n    …lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(observeOn, new c(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.i, notificationCenterLandingFeedbackView.getPositiveActionButtonClicks(), "view.getPositiveActionBu…lersFactory.mainThread())"), new d(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.i, notificationCenterLandingFeedbackView.getNegativeActionButtonClicks(), "view.getNegativeActionBu…lersFactory.mainThread())"), new b(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.i, notificationCenterLandingFeedbackView.getBackButtonClicks(), "view.getBackButtonClicks…lersFactory.mainThread())"), new a2.a.a.p1.a.a.a(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.i, notificationCenterLandingFeedbackView.getRetryButtonClicks(), "view.getRetryButtonClick…lersFactory.mainThread())"), new e(this)));
        NotificationCenterLandingFeedback notificationCenterLandingFeedback = this.c;
        if (notificationCenterLandingFeedback == null) {
            c();
        } else {
            a(notificationCenterLandingFeedback);
        }
    }

    public final void b() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
    }

    public final void c() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = Observables.subscribeOnNext(a2.b.a.a.a.T1(this.i, this.h.getNotificationCenterLandingFeedback(this.g), "interactor.getNotificati…lersFactory.mainThread())"), new a(this));
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    public void cancelDialog() {
        b();
        NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView = this.b;
        if (notificationCenterLandingFeedbackView != null) {
            notificationCenterLandingFeedbackView.hideProgressDialog();
        }
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    public void detachView() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
        b();
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.c);
    }
}
