package com.avito.android.rating.check;

import a2.g.r.g;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.check.RatingPublishCheckPresenter;
import com.avito.android.rating.check.error.NotAuthorizedException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00104\u001a\u000201\u0012\b\u00109\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0013\u0010\u0014\u001a\u00020\u0004*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/avito/android/rating/check/RatingPublishCheckPresenterImpl;", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "Lcom/avito/android/rating/check/RatingPublishCheckView;", "view", "", "attachView", "(Lcom/avito/android/rating/check/RatingPublishCheckView;)V", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/check/RatingPublishCheckPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onAuthSuccess", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/UserDialog;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/UserDialog;)V", "Lcom/avito/android/error_helper/ErrorHelper;", "j", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "", "f", "Z", "waitResult", "Lcom/avito/android/dialog/DialogPresenter;", "i", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter$Router;", "Lcom/avito/android/rating/check/RatingPublishCheckView;", "d", "viewDisposables", "Lcom/avito/android/rating/check/RatingPublishCheckInteractor;", g.a, "Lcom/avito/android/rating/check/RatingPublishCheckInteractor;", "interactor", "e", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "k", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "state", "<init>", "(Lcom/avito/android/rating/check/RatingPublishCheckInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishCheckPresenterImpl implements RatingPublishCheckPresenter {
    public RatingPublishCheckView a;
    public RatingPublishCheckPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public UserDialog e;
    public boolean f;
    public final RatingPublishCheckInteractor g;
    public final SchedulersFactory3 h;
    public final DialogPresenter i;
    public final ErrorHelper j;
    public final UnknownScreenTracker k;

    /* compiled from: java-style lambda group */
    public static final class a implements Action {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            int i = this.a;
            if (i == 0) {
                RatingPublishCheckView ratingPublishCheckView = ((RatingPublishCheckPresenterImpl) this.b).a;
                if (ratingPublishCheckView != null) {
                    ratingPublishCheckView.hideProgress();
                }
                ((RatingPublishCheckPresenterImpl) this.b).k.trackLoading();
            } else if (i == 1) {
                ((RatingPublishCheckPresenterImpl) this.b).f = true;
                RatingPublishCheckPresenter.Router router = ((RatingPublishCheckPresenterImpl) this.b).b;
                if (router != null) {
                    router.openRatingPublish();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ RatingPublishCheckPresenterImpl a;

        public b(RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl) {
            this.a = ratingPublishCheckPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            RatingPublishCheckView ratingPublishCheckView = this.a.a;
            if (ratingPublishCheckView != null) {
                ratingPublishCheckView.showProgress();
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ RatingPublishCheckPresenterImpl a;

        public c(RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl) {
            this.a = ratingPublishCheckPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof NotAuthorizedException) {
                this.a.f = true;
                RatingPublishCheckPresenter.Router router = this.a.b;
                if (router != null) {
                    router.openAuth();
                    return;
                }
                return;
            }
            RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            RatingPublishCheckPresenterImpl.access$handleError(ratingPublishCheckPresenterImpl, th2);
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ RatingPublishCheckPresenterImpl a;

        public d(RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl) {
            this.a = ratingPublishCheckPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            RatingPublishCheckPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class e<T> implements Consumer<DeepLink> {
        public final /* synthetic */ RatingPublishCheckPresenterImpl a;

        public e(RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl) {
            this.a = ratingPublishCheckPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            RatingPublishCheckPresenter.Router router = this.a.b;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                router.followDeepLink(deepLink2);
            }
        }
    }

    @Inject
    public RatingPublishCheckPresenterImpl(@NotNull RatingPublishCheckInteractor ratingPublishCheckInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull UnknownScreenTracker unknownScreenTracker, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(ratingPublishCheckInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "tracker");
        this.g = ratingPublishCheckInteractor;
        this.h = schedulersFactory3;
        this.i = dialogPresenter;
        this.j = errorHelper;
        this.k = unknownScreenTracker;
        this.e = kundle != null ? (UserDialog) kundle.getParcelable("dialog") : null;
        this.f = (kundle == null || (bool = kundle.getBoolean("wait_result")) == null) ? false : bool.booleanValue();
    }

    public static final void access$handleError(RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl, Throwable th) {
        UserDialog userDialog;
        TypedError handle = ratingPublishCheckPresenterImpl.j.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            userDialog = ((ErrorResult.ErrorDialog) handle).getUserDialog();
        } else {
            userDialog = new UserDialog("", ratingPublishCheckPresenterImpl.j.recycle(handle), CollectionsKt__CollectionsKt.emptyList(), false, 8, null);
        }
        ratingPublishCheckPresenterImpl.e = userDialog;
        if (userDialog != null) {
            ratingPublishCheckPresenterImpl.b(userDialog);
        }
    }

    public final void a() {
        if (!this.f && this.b != null) {
            this.k.startLoading();
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.g.checkRatingPublish().observeOn(this.h.mainThread()).doOnSubscribe(new b(this)).doOnTerminate(new a(0, this)).subscribe(new a(1, this), new c(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.checkRatingPu…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    public void attachRouter(@NotNull RatingPublishCheckPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        if (this.e == null) {
            a();
        }
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    public void attachView(@NotNull RatingPublishCheckView ratingPublishCheckView) {
        Intrinsics.checkNotNullParameter(ratingPublishCheckView, "view");
        this.a = ratingPublishCheckView;
        UserDialog userDialog = this.e;
        if (userDialog != null) {
            b(userDialog);
        }
    }

    public final void b(UserDialog userDialog) {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.i.showDialog3(userDialog).doAfterTerminate(new d(this)).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    public void onAuthSuccess() {
        this.f = false;
        a();
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("dialog", this.e).putBoolean("wait_result", Boolean.valueOf(this.f));
    }
}
