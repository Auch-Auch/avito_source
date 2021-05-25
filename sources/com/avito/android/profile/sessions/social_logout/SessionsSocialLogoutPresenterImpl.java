package com.avito.android.profile.sessions.social_logout;

import a2.a.a.b2.h1.b.b;
import a2.a.a.b2.h1.b.c;
import a2.g.r.g;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenterImpl;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;", "view", "", "attachView", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;)V", "detachView", "()V", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;)V", "detachRouter", "", "resultCode", "onAuthResult", "(I)V", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "requestDisposable", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProvider;", "h", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProvider;", "resourcesProvider", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;", "e", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;", "interactor", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;", "f", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;", "params", "<init>", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProvider;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsSocialLogoutPresenterImpl implements SessionsSocialLogoutPresenter {
    public SessionsSocialLogoutView a;
    public SessionsSocialLogoutPresenter.Router b;
    public CompositeDisposable c = new CompositeDisposable();
    public Disposable d;
    public final SessionsSocialLogoutInteractor e;
    public final SessionsSocialLogoutPresenter.SessionParams f;
    public final SchedulersFactory3 g;
    public final SessionsSocialLogoutResourcesProvider h;

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
                SessionsSocialLogoutPresenterImpl.access$logout((SessionsSocialLogoutPresenterImpl) this.b);
            } else if (i == 1) {
                SessionsSocialLogoutPresenter.Router router = ((SessionsSocialLogoutPresenterImpl) this.b).b;
                if (router != null) {
                    router.closeScreen();
                }
            } else {
                throw null;
            }
        }
    }

    @Inject
    public SessionsSocialLogoutPresenterImpl(@NotNull SessionsSocialLogoutInteractor sessionsSocialLogoutInteractor, @NotNull SessionsSocialLogoutPresenter.SessionParams sessionParams, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SessionsSocialLogoutResourcesProvider sessionsSocialLogoutResourcesProvider) {
        Intrinsics.checkNotNullParameter(sessionsSocialLogoutInteractor, "interactor");
        Intrinsics.checkNotNullParameter(sessionParams, "params");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(sessionsSocialLogoutResourcesProvider, "resourcesProvider");
        this.e = sessionsSocialLogoutInteractor;
        this.f = sessionParams;
        this.g = schedulersFactory3;
        this.h = sessionsSocialLogoutResourcesProvider;
    }

    public static final void access$handleLoadingResult(SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(sessionsSocialLogoutPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            SessionsSocialLogoutPresenter.Router router = sessionsSocialLogoutPresenterImpl.b;
            if (router != null) {
                router.openInfoScreen();
            }
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState).getError();
            if (error instanceof ErrorResult.NetworkIOError) {
                String message = ((ErrorResult.NetworkIOError) error).getMessage();
                SessionsSocialLogoutView sessionsSocialLogoutView = sessionsSocialLogoutPresenterImpl.a;
                if (sessionsSocialLogoutView != null) {
                    sessionsSocialLogoutView.showMessage(message);
                }
            } else if (error instanceof TypedError.UnauthorizedError) {
                SessionsSocialLogoutPresenter.Router router2 = sessionsSocialLogoutPresenterImpl.b;
                if (router2 != null) {
                    router2.openAuthScreen();
                }
            } else {
                SessionsSocialLogoutView sessionsSocialLogoutView2 = sessionsSocialLogoutPresenterImpl.a;
                if (sessionsSocialLogoutView2 != null) {
                    sessionsSocialLogoutView2.showMessage(sessionsSocialLogoutPresenterImpl.h.getCommonErrorMessageText());
                }
            }
        }
    }

    public static final void access$logout(SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl) {
        SessionsSocialLogoutView sessionsSocialLogoutView = sessionsSocialLogoutPresenterImpl.a;
        if (sessionsSocialLogoutView != null) {
            sessionsSocialLogoutView.showButtonProgress();
        }
        sessionsSocialLogoutPresenterImpl.d = sessionsSocialLogoutPresenterImpl.e.logout(sessionsSocialLogoutPresenterImpl.f.getDeviceId(), sessionsSocialLogoutPresenterImpl.f.getSessionHashId(), sessionsSocialLogoutPresenterImpl.f.getLoginType(), sessionsSocialLogoutPresenterImpl.f.getSource()).observeOn(sessionsSocialLogoutPresenterImpl.g.mainThread()).doOnTerminate(new a2.a.a.b2.h1.b.a(sessionsSocialLogoutPresenterImpl)).subscribe(new b(sessionsSocialLogoutPresenterImpl), c.a);
    }

    public final void a() {
        SessionsSocialLogoutPresenter.Router router;
        if (!this.e.isAuthorized()) {
            SessionsSocialLogoutPresenter.Router router2 = this.b;
            if (router2 != null) {
                router2.openAuthScreen();
            }
        } else if ((this.f.getUserId() == null || (!Intrinsics.areEqual(this.f.getUserId(), this.e.getCurrentUserId()))) && (router = this.b) != null) {
            router.closeScreen();
        }
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter
    public void attachRouter(@NotNull SessionsSocialLogoutPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter
    public void attachView(@NotNull SessionsSocialLogoutView sessionsSocialLogoutView) {
        Intrinsics.checkNotNullParameter(sessionsSocialLogoutView, "view");
        a();
        this.a = sessionsSocialLogoutView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = sessionsSocialLogoutView.getButtonClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.buttonClicks.subscribe { logout() }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = sessionsSocialLogoutView.getNavigationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks.su…{ router?.closeScreen() }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter
    public void detachView() {
        this.c.clear();
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.a = null;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter
    public void onAuthResult(int i) {
        if (i == -1) {
            a();
            return;
        }
        SessionsSocialLogoutPresenter.Router router = this.b;
        if (router != null) {
            router.openHomeScreen();
        }
    }
}
