package com.avito.android.authorization.auth;

import com.avito.android.account.Credentials;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.SocialCredentials;
import com.avito.android.authorization.auth.AuthInteractor;
import com.avito.android.authorization.auth.AuthPresenter;
import com.avito.android.authorization.auth.di.PresenterState;
import com.avito.android.authorization.event.SocialButtonClickedEvent;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010K\u001a\u00020H\u0012\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020T0Sj\b\u0012\u0004\u0012\u00020T`U\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010f\u001a\u00020c\u0012\b\b\u0001\u0010^\u001a\u00020[\u0012\u0006\u0010*\u001a\u00020'\u0012\n\b\u0001\u0010h\u001a\u0004\u0018\u00010\u001f\u0012\b\u00108\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bi\u0010jJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ7\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u000fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010=\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u0010<R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u00104R\u0016\u0010R\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020T0Sj\b\u0012\u0004\u0012\u00020T`U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u00107¨\u0006k"}, d2 = {"Lcom/avito/android/authorization/auth/AuthPresenterImpl;", "Lcom/avito/android/authorization/auth/AuthPresenter;", "", AuthSource.SEND_ABUSE, "()Z", "Lcom/avito/android/authorization/auth/AuthView;", "view", "", "attachView", "(Lcom/avito/android/authorization/auth/AuthView;)V", "Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/auth/AuthPresenter$Router;)V", "detachRouter", "()V", "detachView", "show", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "onSocialLoginSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginFailure", "onSocialLoginCanceled", "socialId", "saveSocialId", "(Ljava/lang/String;)V", "onSmartLockLoginFailure", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/social/SocialTypeToStringMapper;", "s", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/authorization/SocialCredentials;", "e", "Lcom/avito/android/authorization/SocialCredentials;", "credentials", a2.g.r.g.a, "Z", "fastLogin", "t", "Ljava/lang/String;", "src", "i", "getSkipSavedLogin", "setSkipSavedLogin", "(Z)V", "skipSavedLogin", "c", "Lcom/avito/android/authorization/auth/AuthView;", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/authorization/auth/AuthInteractor;", "j", "Lcom/avito/android/authorization/auth/AuthInteractor;", "interactor", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "k", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLock", "Lcom/avito/android/authorization/auth/AuthResourceProvider;", "p", "Lcom/avito/android/authorization/auth/AuthResourceProvider;", "resourceProvider", "h", "isShown", "viewDisposables", "Ljava/util/ArrayList;", "Lcom/avito/android/social/SignInManager;", "Lkotlin/collections/ArrayList;", "l", "Ljava/util/ArrayList;", "signInManagers", "d", "Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "Lcom/avito/android/performance/ContentTracker;", "r", "Lcom/avito/android/performance/ContentTracker;", "checkTracker", "Lcom/avito/android/social/button/SocialInfoProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/social/button/SocialInfoProvider;", "socialInfoProvider", "Lcom/avito/android/performance/ScreenTracker;", VKApiConst.Q, "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "f", "state", "<init>", "(Lcom/avito/android/authorization/auth/AuthInteractor;Lcom/avito/android/authorization/smart_lock/SmartLockLoader;Ljava/util/ArrayList;Lcom/avito/android/social/button/SocialInfoProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/authorization/auth/AuthResourceProvider;Lcom/avito/android/performance/ScreenTracker;Lcom/avito/android/performance/ContentTracker;Lcom/avito/android/social/SocialTypeToStringMapper;Lcom/avito/android/util/Kundle;Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthPresenterImpl implements AuthPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public AuthView c;
    public AuthPresenter.Router d;
    public SocialCredentials e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final AuthInteractor j;
    public final SmartLockLoader k;
    public final ArrayList<SignInManager> l;
    public final SocialInfoProvider m;
    public final Analytics n;
    public final SchedulersFactory3 o;
    public final AuthResourceProvider p;
    public final ScreenTracker q;
    public final ContentTracker r;
    public final SocialTypeToStringMapper s;
    public final String t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AuthInteractor.FastLogin.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
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
                AuthPresenter.Router router = ((AuthPresenterImpl) this.b).d;
                if (router != null) {
                    router.cancel();
                }
            } else if (i == 1) {
                AuthPresenter.Router router2 = ((AuthPresenterImpl) this.b).d;
                if (router2 != null) {
                    router2.openLogin(((AuthPresenterImpl) this.b).getSkipSavedLogin());
                }
            } else if (i == 2) {
                AuthPresenter.Router router3 = ((AuthPresenterImpl) this.b).d;
                if (router3 != null) {
                    router3.openRegistration();
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b implements Action {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            int i = this.a;
            if (i == 0) {
                ((AuthPresenterImpl) this.b).g = false;
            } else if (i == 1) {
                AuthView authView = ((AuthPresenterImpl) this.b).c;
                if (authView != null) {
                    authView.hideScreenProgress();
                }
            } else if (i == 2) {
                ContentTracker.DefaultImpls.loaded$default(((AuthPresenterImpl) this.b).r, null, 1, null);
                ContentTracker.DefaultImpls.preparing$default(((AuthPresenterImpl) this.b).r, null, a2.a.a.b.b.h.a, 1, null);
                ((AuthPresenterImpl) this.b).r.drawing();
                ((AuthPresenterImpl) this.b).show();
                ContentTracker.DefaultImpls.drawn$default(((AuthPresenterImpl) this.b).r, null, 1, null);
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<Maybe<Credentials.PasswordCredentials>> {
        public final /* synthetic */ AuthPresenterImpl a;
        public final /* synthetic */ AuthPresenter.Router b;

        public c(AuthPresenterImpl authPresenterImpl, AuthPresenter.Router router) {
            this.a = authPresenterImpl;
            this.b = router;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Maybe<Credentials.PasswordCredentials> maybe) {
            CompositeDisposable compositeDisposable = this.a.b;
            Disposable subscribe = maybe.doOnSubscribe(new a2.a.a.b.b.b(this)).doOnTerminate(new a2.a.a.b.b.c(this)).subscribe(new a2.a.a.b.b.d(this), new a2.a.a.b.b.e(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "process\n                …  }\n                    )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ AuthPresenterImpl a;

        public e(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AuthView authView = this.a.c;
            if (authView != null) {
                authView.showScreenProgress();
            }
            this.a.r.loading(ContentTracker.StorageType.Local);
        }
    }

    public static final class f<T> implements Consumer<AuthInteractor.FastLogin> {
        public final /* synthetic */ AuthPresenterImpl a;
        public final /* synthetic */ AuthPresenter.Router b;

        public f(AuthPresenterImpl authPresenterImpl, AuthPresenter.Router router) {
            this.a = authPresenterImpl;
            this.b = router;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AuthInteractor.FastLogin fastLogin) {
            AuthInteractor.FastLogin fastLogin2 = fastLogin;
            ContentTracker.DefaultImpls.loaded$default(this.a.r, null, 1, null);
            ContentTracker.DefaultImpls.preparing$default(this.a.r, null, a2.a.a.b.b.f.a, 1, null);
            this.a.r.drawing();
            if (fastLogin2 != null) {
                int ordinal = fastLogin2.ordinal();
                if (ordinal == 0) {
                    AuthPresenterImpl.access$showSmartLock(this.a);
                } else if (ordinal == 1) {
                    this.b.openSuggests();
                }
            }
            ContentTracker.DefaultImpls.drawn$default(this.a.r, null, 1, null);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ AuthPresenterImpl a;

        public g(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            ContentTracker contentTracker = this.a.r;
            ContentTracker.State state = ContentTracker.State.Failure;
            contentTracker.loaded(state);
            this.a.r.preparing(state, a2.a.a.b.b.g.a);
            this.a.r.drawing();
            this.a.show();
            this.a.r.drawn(state);
        }
    }

    public static final class h<T> implements Consumer<String> {
        public final /* synthetic */ AuthPresenterImpl a;

        public h(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Analytics analytics = this.a.n;
            Intrinsics.checkNotNullExpressionValue(str2, "socialType");
            analytics.track(new SocialButtonClickedEvent(SocialButtonClickedEventKt.AUTH, str2));
            this.a.f = null;
            AuthPresenter.Router router = this.a.d;
            if (router != null) {
                router.openSocialLogin(str2);
            }
        }
    }

    public static final class i<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AuthPresenterImpl a;

        public i(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AuthPresenter.Router router = this.a.d;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                router.followDeepLink(deepLink2);
            }
        }
    }

    public static final class j<T> implements Consumer<Disposable> {
        public final /* synthetic */ AuthPresenterImpl a;

        public j(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AuthView authView = this.a.c;
            if (authView != null) {
                authView.showProgress();
            }
            AuthView authView2 = this.a.c;
            if (authView2 != null) {
                authView2.disableSocialButtons();
            }
        }
    }

    public static final class k implements Action {
        public final /* synthetic */ AuthPresenterImpl a;

        public k(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            AuthView authView = this.a.c;
            if (authView != null) {
                authView.enableSocialButtons();
            }
            this.a.e = null;
        }
    }

    public static final class l<T> implements Consumer<SocialAuthResult> {
        public final /* synthetic */ AuthPresenterImpl a;
        public final /* synthetic */ AuthPresenter.Router b;
        public final /* synthetic */ SocialCredentials c;

        public l(AuthPresenterImpl authPresenterImpl, AuthPresenter.Router router, SocialCredentials socialCredentials) {
            this.a = authPresenterImpl;
            this.b = router;
            this.c = socialCredentials;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SocialAuthResult socialAuthResult) {
            SocialAuthResult socialAuthResult2 = socialAuthResult;
            if (socialAuthResult2 instanceof SocialAuthResult.Ok) {
                AuthView authView = this.a.c;
                if (authView != null) {
                    authView.showContent();
                }
                this.b.finishAuth();
            } else if (socialAuthResult2 instanceof SocialAuthResult.AccountSuggest) {
                AuthView authView2 = this.a.c;
                if (authView2 != null) {
                    authView2.showContent();
                }
                SocialAuthResult.AccountSuggest accountSuggest = (SocialAuthResult.AccountSuggest) socialAuthResult2;
                this.b.openSocialRegistrationSuggestsScreen(accountSuggest.getTitle(), accountSuggest.getSuggestKey(), accountSuggest.getAccountList(), this.c.getSocialType());
            }
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public final /* synthetic */ AuthPresenterImpl a;

        public m(AuthPresenterImpl authPresenterImpl) {
            this.a = authPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                TypedError errorResult = ((TypedResultException) th2).getErrorResult();
                if (errorResult instanceof ErrorWithMessage.ErrorDialog) {
                    AuthView authView = this.a.c;
                    if (authView != null) {
                        ErrorWithMessage.ErrorDialog errorDialog = (ErrorWithMessage.ErrorDialog) errorResult;
                        authView.showErrorDialog(errorDialog.getData().getTitle(), errorDialog.getData().getMessage());
                    }
                } else if (errorResult instanceof ErrorResult.NetworkIOError) {
                    AuthView authView2 = this.a.c;
                    if (authView2 != null) {
                        authView2.showError(((ErrorResult.NetworkIOError) errorResult).getMessage());
                    }
                } else {
                    AuthView authView3 = this.a.c;
                    if (authView3 != null) {
                        authView3.showError(this.a.p.getSocialAuthenticationError());
                    }
                }
            } else {
                AuthView authView4 = this.a.c;
                if (authView4 != null) {
                    authView4.showError(this.a.p.getSocialAuthenticationError());
                }
            }
        }
    }

    @Inject
    public AuthPresenterImpl(@NotNull AuthInteractor authInteractor, @NotNull SmartLockLoader smartLockLoader, @NotNull ArrayList<SignInManager> arrayList, @NotNull SocialInfoProvider socialInfoProvider, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AuthResourceProvider authResourceProvider, @NotNull ScreenTracker screenTracker, @Named("check") @NotNull ContentTracker contentTracker, @NotNull SocialTypeToStringMapper socialTypeToStringMapper, @PresenterState @Nullable Kundle kundle, @Nullable String str) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Intrinsics.checkNotNullParameter(authInteractor, "interactor");
        Intrinsics.checkNotNullParameter(smartLockLoader, "smartLock");
        Intrinsics.checkNotNullParameter(arrayList, "signInManagers");
        Intrinsics.checkNotNullParameter(socialInfoProvider, "socialInfoProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(authResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(screenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(contentTracker, "checkTracker");
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper, "socialTypeToStringMapper");
        this.j = authInteractor;
        this.k = smartLockLoader;
        this.l = arrayList;
        this.m = socialInfoProvider;
        this.n = analytics;
        this.o = schedulersFactory3;
        this.p = authResourceProvider;
        this.q = screenTracker;
        this.r = contentTracker;
        this.s = socialTypeToStringMapper;
        this.t = str;
        String str2 = null;
        this.e = kundle != null ? (SocialCredentials) kundle.getParcelable("credentials") : null;
        this.f = kundle != null ? kundle.getString(AuthParamsKt.KEY_SOCIAL_ID) : str2;
        this.g = (kundle == null || (bool3 = kundle.getBoolean("fast_login")) == null) ? true : bool3.booleanValue();
        boolean z = false;
        this.h = (kundle == null || (bool2 = kundle.getBoolean("shown")) == null) ? false : bool2.booleanValue();
        if (!(kundle == null || (bool = kundle.getBoolean("skip_saved_login")) == null)) {
            z = bool.booleanValue();
        }
        this.i = z;
    }

    public static final void access$showSmartLock(AuthPresenterImpl authPresenterImpl) {
        authPresenterImpl.show();
        SmartLockLoader.DefaultImpls.load$default(authPresenterImpl.k, false, 1, null);
    }

    public final boolean a() {
        AuthPresenter.Router router;
        Observable<SocialAuthResult> observable;
        SocialCredentials socialCredentials = this.e;
        if (socialCredentials == null || (router = this.d) == null) {
            return false;
        }
        CompositeDisposable compositeDisposable = this.b;
        String socialType = socialCredentials.getSocialType();
        if (socialType.hashCode() == 93029210 && socialType.equals("apple")) {
            observable = this.j.loginWithApple(socialCredentials.getToken(), socialCredentials.getUser(), this.f);
        } else {
            observable = this.j.login(socialCredentials.getSocialType(), socialCredentials.getToken(), socialCredentials.getEmail(), this.f);
        }
        Disposable subscribe = observable.observeOn(this.o.mainThread()).doOnSubscribe(new j(this)).doAfterTerminate(new k(this)).subscribe(new l(this, router, socialCredentials), new m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "when (credentials.social…     }\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        return true;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void attachRouter(@NotNull AuthPresenter.Router router) {
        AuthView authView;
        Intrinsics.checkNotNullParameter(router, "router");
        this.d = router;
        if (this.h && (authView = this.c) != null) {
            authView.show();
        }
        if (!a()) {
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.k.connectWithObservables().subscribe(new c(this, router), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "smartLock.connectWithObs…  //Ignore\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            if (this.g) {
                this.q.resetSession();
                CompositeDisposable compositeDisposable2 = this.b;
                Disposable subscribe2 = this.j.checkFastLogin(this.t).observeOn(this.o.mainThread()).doAfterTerminate(new b(0, this)).doOnSubscribe(new e(this)).doOnTerminate(new b(1, this)).subscribe(new f(this, router), new g(this), new b(2, this));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.checkFastLogi…  }\n                    )");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            }
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void attachView(@NotNull AuthView authView) {
        Intrinsics.checkNotNullParameter(authView, "view");
        this.c = authView;
        authView.setServiceAgreementText(authView.generateServiceAgreementAttributedText());
        authView.hideSocialButtons();
        CompositeDisposable compositeDisposable = this.a;
        ArrayList<SignInManager> arrayList = this.l;
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        for (T t2 : arrayList) {
            arrayList2.add(authView.addSocialButton(this.s.mapToString(t2.getType()), SocialInfoProvider.DefaultImpls.provide$default(this.m, t2, false, 2, null)));
        }
        Disposable subscribe = Observable.merge(arrayList2).subscribe(new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "signInManagers\n         …socialType)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = authView.closeClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.closeClicks()\n     …ribe { router?.cancel() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe3 = authView.loginClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.loginClicks()\n     …enLogin(skipSavedLogin) }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe4 = authView.registrationClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.registrationClicks(…ter?.openRegistration() }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable subscribe5 = authView.linkClicks().subscribe(new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.linkClicks()\n      …ter?.followDeepLink(it) }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void detachRouter() {
        this.b.clear();
        this.d = null;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void detachView() {
        this.a.clear();
        this.c = null;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public boolean getSkipSavedLogin() {
        return this.i;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void onBackPressed() {
        AuthView authView = this.c;
        if (authView != null) {
            authView.close();
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("credentials", this.e).putBoolean("shown", Boolean.valueOf(this.h)).putBoolean("fast_login", Boolean.valueOf(this.g)).putString(AuthParamsKt.KEY_SOCIAL_ID, this.f).putBoolean("skip_saved_login", Boolean.valueOf(getSkipSavedLogin()));
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void onSmartLockLoginFailure() {
        AuthView authView = this.c;
        if (authView != null) {
            authView.showError(this.p.getSmartLockError());
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void onSocialLoginCanceled() {
        AuthView authView = this.c;
        if (authView != null) {
            authView.enableSocialButtons();
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void onSocialLoginFailure() {
        AuthView authView = this.c;
        if (authView != null) {
            authView.enableSocialButtons();
        }
        AuthView authView2 = this.c;
        if (authView2 != null) {
            authView2.showError(this.p.getSocialAuthenticationError());
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void onSocialLoginSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (str == null || str2 == null) {
            onSocialLoginFailure();
            return;
        }
        this.e = new SocialCredentials(str, str2, str3, str4);
        a();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void saveSocialId(@Nullable String str) {
        this.f = str;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void setSkipSavedLogin(boolean z) {
        this.i = z;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter
    public void show() {
        this.h = true;
        AuthView authView = this.c;
        if (authView != null) {
            authView.show();
        }
    }
}
