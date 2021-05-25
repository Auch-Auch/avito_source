package com.avito.android.screen_opener;

import a2.g.r.g;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.screen_opener.ProfileScreenResolverInteractorImpl;
import com.avito.android.screen_opener.ProfileScreenResolverPresenter;
import com.avito.android.screen_opener.di.ProfileScreenResolverFragmentModule;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\b\b\u0001\u0010+\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0011¨\u0006."}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverPresenterImpl;", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "Lcom/avito/android/screen_opener/ProfileScreenResolverView;", "view", "", "attachView", "(Lcom/avito/android/screen_opener/ProfileScreenResolverView;)V", "detachView", "()V", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;)V", "detachRouter", AuthSource.SEND_ABUSE, "", "e", "Ljava/lang/String;", "contextId", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "performanceTracker", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/screen_opener/ProfileScreenResolverView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;", "Lcom/avito/android/error_helper/ErrorHelper;", "i", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;", "f", "Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;", "interactor", "d", "userKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileScreenResolverPresenterImpl implements ProfileScreenResolverPresenter {
    public ProfileScreenResolverView a;
    public ProfileScreenResolverPresenter.Router b;
    public CompositeDisposable c = new CompositeDisposable();
    public final String d;
    public final String e;
    public final ProfileScreenResolverInteractor f;
    public final UnknownScreenTracker g;
    public final SchedulersFactory3 h;
    public final ErrorHelper i;

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
                ProfileScreenResolverPresenterImpl.access$onButtonClick((ProfileScreenResolverPresenterImpl) this.b);
            } else if (i == 1) {
                ProfileScreenResolverPresenter.Router router = ((ProfileScreenResolverPresenterImpl) this.b).b;
                if (router != null) {
                    router.closeScreen();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ ProfileScreenResolverPresenterImpl a;

        public b(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl) {
            this.a = profileScreenResolverPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            ProfileScreenResolverView profileScreenResolverView = this.a.a;
            if (profileScreenResolverView != null) {
                profileScreenResolverView.showProgress();
            }
        }
    }

    public static final class c<T> implements Consumer<PublicUserProfile> {
        public final /* synthetic */ ProfileScreenResolverPresenterImpl a;

        public c(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl) {
            this.a = profileScreenResolverPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(PublicUserProfile publicUserProfile) {
            PublicUserProfile publicUserProfile2 = publicUserProfile;
            ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(publicUserProfile2, "it");
            ProfileScreenResolverPresenterImpl.access$onPublicProfileLoaded(profileScreenResolverPresenterImpl, publicUserProfile2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileScreenResolverPresenterImpl a;

        public d(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl) {
            this.a = profileScreenResolverPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ProfileScreenResolverPresenterImpl.access$onError(profileScreenResolverPresenterImpl, th2);
        }
    }

    @Inject
    public ProfileScreenResolverPresenterImpl(@ProfileScreenResolverFragmentModule.UserKey @NotNull String str, @ProfileScreenResolverFragmentModule.ContextId @Nullable String str2, @NotNull ProfileScreenResolverInteractor profileScreenResolverInteractor, @NotNull UnknownScreenTracker unknownScreenTracker, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(profileScreenResolverInteractor, "interactor");
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.d = str;
        this.e = str2;
        this.f = profileScreenResolverInteractor;
        this.g = unknownScreenTracker;
        this.h = schedulersFactory3;
        this.i = errorHelper;
    }

    public static final void access$onButtonClick(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl) {
        profileScreenResolverPresenterImpl.a();
    }

    public static final void access$onError(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl, Throwable th) {
        TypedError handle = profileScreenResolverPresenterImpl.i.handle(th);
        if (handle instanceof ProfileScreenResolverInteractorImpl.UserBannedError) {
            ProfileScreenResolverView profileScreenResolverView = profileScreenResolverPresenterImpl.a;
            if (profileScreenResolverView != null) {
                profileScreenResolverView.showUserBanned(profileScreenResolverPresenterImpl.i.recycle(th));
            }
        } else if (handle instanceof ProfileScreenResolverInteractorImpl.UserRemovedError) {
            ProfileScreenResolverView profileScreenResolverView2 = profileScreenResolverPresenterImpl.a;
            if (profileScreenResolverView2 != null) {
                profileScreenResolverView2.showUserRemoved(profileScreenResolverPresenterImpl.i.recycle(th));
            }
        } else {
            ProfileScreenResolverView profileScreenResolverView3 = profileScreenResolverPresenterImpl.a;
            if (profileScreenResolverView3 != null) {
                profileScreenResolverView3.hideProgress();
            }
            ProfileScreenResolverView profileScreenResolverView4 = profileScreenResolverPresenterImpl.a;
            if (profileScreenResolverView4 != null) {
                profileScreenResolverView4.showError(profileScreenResolverPresenterImpl.i.recycle(th));
            }
        }
    }

    public static final void access$onPublicProfileLoaded(ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl, PublicUserProfile publicUserProfile) {
        ProfileScreenResolverPresenter.Router router;
        profileScreenResolverPresenterImpl.g.trackLoading();
        if (publicUserProfile instanceof DefaultPublicUserProfile) {
            ProfileScreenResolverPresenter.Router router2 = profileScreenResolverPresenterImpl.b;
            if (router2 != null) {
                router2.openPublicProfileScreen((DefaultPublicUserProfile) publicUserProfile, profileScreenResolverPresenterImpl.d, profileScreenResolverPresenterImpl.e, profileScreenResolverPresenterImpl.g.toScreenTransfer());
            }
        } else if ((publicUserProfile instanceof ExtendedPublicUserProfile) && (router = profileScreenResolverPresenterImpl.b) != null) {
            router.openExtendedProfileScreen((ExtendedPublicUserProfile) publicUserProfile, profileScreenResolverPresenterImpl.d, profileScreenResolverPresenterImpl.e, profileScreenResolverPresenterImpl.g.toScreenTransfer());
        }
    }

    public final void a() {
        this.g.startLoading();
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.f.loadPublicUserProfile(this.d, this.e).subscribeOn(this.h.io()).doOnSubscribe(new b(this)).observeOn(this.h.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadPublicUse…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter
    public void attachRouter(@Nullable ProfileScreenResolverPresenter.Router router) {
        this.b = router;
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter
    public void attachView(@NotNull ProfileScreenResolverView profileScreenResolverView) {
        Intrinsics.checkNotNullParameter(profileScreenResolverView, "view");
        this.a = profileScreenResolverView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = profileScreenResolverView.buttonClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.buttonClicks().subs…onButtonClick()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = profileScreenResolverView.navigationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…?.closeScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        a();
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }
}
