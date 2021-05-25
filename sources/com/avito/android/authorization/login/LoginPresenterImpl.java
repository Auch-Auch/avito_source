package com.avito.android.authorization.login;

import a2.a.a.b.d.a0;
import a2.a.a.b.d.h;
import a2.a.a.b.d.i;
import a2.a.a.b.d.j;
import a2.a.a.b.d.k;
import a2.a.a.b.d.l;
import a2.a.a.b.d.n;
import a2.a.a.b.d.o;
import a2.a.a.b.d.p;
import a2.a.a.b.d.q;
import a2.a.a.b.d.s;
import a2.a.a.b.d.t;
import a2.a.a.b.d.u;
import a2.a.a.b.d.v;
import a2.a.a.b.d.w;
import a2.a.a.b.d.x;
import a2.a.a.b.d.y;
import a2.a.a.b.d.z;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.LastLoggedEmailStorage;
import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.di.PresenterState;
import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.code_confirmation.CodeAlreadyConfirmedException;
import com.avito.android.code_confirmation.PhoneAntihackInteractor;
import com.avito.android.code_confirmation.RequestCodeInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.ResetPasswordLink;
import com.avito.android.deep_linking.links.SendEmailLink;
import com.avito.android.deep_linking.links.SendEmailToItemLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.ResetPasswordResult;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.AttributedTextCreator;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.ListUtils;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010l\u001a\u00020i\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00105\u001a\u000202\u0012\n\b\u0003\u0010m\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u0010R\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bn\u0010oJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010QR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010>R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010QR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006p"}, d2 = {"Lcom/avito/android/authorization/login/LoginPresenterImpl;", "Lcom/avito/android/authorization/login/LoginPresenter;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "d", "f", "Lcom/avito/android/remote/error/TypedError;", "error", "c", "(Lcom/avito/android/remote/error/TypedError;)V", "", "", "messages", "e", "(Ljava/util/Map;)V", "login", Preference.PASSWORD, "", "isHiddenLogin", "skipSavedLogin", "setStartLogin", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "onPhoneVerified", "Lcom/avito/android/authorization/login/LoginView;", "view", "attachView", "(Lcom/avito/android/authorization/login/LoginView;)V", "Lcom/avito/android/authorization/login/LoginPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login/LoginPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/account/LastLoggedEmailStorage;", "s", "Lcom/avito/android/account/LastLoggedEmailStorage;", "lastLoggedEmailStorage", "i", "Lcom/avito/android/authorization/login/LoginView;", "h", "Ljava/util/Map;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "t", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLock", "Lcom/avito/android/error_helper/ErrorHelper;", "w", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", g.a, "Z", "autoLogin", "Lcom/avito/android/util/SchedulersFactory;", VKApiConst.VERSION, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/authorization/login/LoginResourceProvider;", VKApiConst.Q, "Lcom/avito/android/authorization/login/LoginResourceProvider;", "loginResourceProvider", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "r", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "supportEmailResourceProvider", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "l", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "resetPasswordInteractor", "Lcom/avito/android/remote/model/text/AttributedTextCreator;", "o", "Lcom/avito/android/remote/model/text/AttributedTextCreator;", "attributedTextCreator", "x", "Ljava/lang/String;", "suggestKey", "j", "Lcom/avito/android/authorization/login/LoginPresenter$Router;", "Lcom/avito/android/Features;", "u", "Lcom/avito/android/Features;", "features", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loginDisposable", "Lcom/avito/android/authorization/login/LoginInteractor;", "k", "Lcom/avito/android/authorization/login/LoginInteractor;", "loginInteractor", "disposables", "Lcom/avito/android/util/text/AttributedTextFormatter;", "p", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "phoneAntihackInteractor", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "n", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "tfaInteractor", "state", "<init>", "(Lcom/avito/android/authorization/login/LoginInteractor;Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;Lcom/avito/android/code_confirmation/tfa/TfaInteractor;Lcom/avito/android/remote/model/text/AttributedTextCreator;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/authorization/login/LoginResourceProvider;Lcom/avito/android/shared_providers/SupportEmailResourceProvider;Lcom/avito/android/account/LastLoggedEmailStorage;Lcom/avito/android/authorization/smart_lock/SmartLockSaver;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/Kundle;Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginPresenterImpl implements LoginPresenter {
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public Disposable c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public Map<String, String> h;
    public LoginView i;
    public LoginPresenter.Router j;
    public final LoginInteractor k;
    public final ResetPasswordInteractor l;
    public final PhoneAntihackInteractor m;
    public final TfaInteractor n;
    public final AttributedTextCreator o;
    public final AttributedTextFormatter p;
    public final LoginResourceProvider q;
    public final SupportEmailResourceProvider r;
    public final LastLoggedEmailStorage s;
    public final SmartLockSaver t;
    public final Features u;
    public final SchedulersFactory v;
    public final ErrorHelper w;
    public final String x;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                LoginPresenterImpl.access$onCloseScreen((LoginPresenterImpl) this.b);
            } else if (i == 1) {
                ((LoginPresenterImpl) this.b).f();
            } else if (i != 2) {
                throw null;
            } else if (((LoginPresenterImpl) this.b).f) {
                LoginPresenterImpl.access$onResetPassword((LoginPresenterImpl) this.b);
            } else {
                LoginPresenterImpl.access$onForgotPassword((LoginPresenterImpl) this.b);
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                ((LoginPresenterImpl) this.b).d = str2;
                ((LoginPresenterImpl) this.b).b();
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullExpressionValue(str3, "it");
                ((LoginPresenterImpl) this.b).e = str3;
                ((LoginPresenterImpl) this.b).b();
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<Maybe<Unit>> {
        public final /* synthetic */ LoginPresenterImpl a;
        public final /* synthetic */ LoginPresenter.Router b;

        public c(LoginPresenterImpl loginPresenterImpl, LoginPresenter.Router router) {
            this.a = loginPresenterImpl;
            this.b = router;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Maybe<Unit> maybe) {
            Maybe<Unit> maybe2 = maybe;
            CompositeDisposable compositeDisposable = this.a.a;
            Intrinsics.checkNotNullExpressionValue(maybe2, "process");
            Disposable subscribe = InteropKt.toV2(maybe2).doOnSubscribe(new a2.a.a.b.d.a(this)).doOnComplete(new a2.a.a.b.d.b(this)).doOnError(new a2.a.a.b.d.c(this)).subscribe(new a2.a.a.b.d.d(this), new a2.a.a.b.d.e(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "process.toV2()\n         …      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final class d<T> implements Consumer<Disposable> {
        public final /* synthetic */ LoginPresenterImpl a;

        public d(LoginPresenterImpl loginPresenterImpl) {
            this.a = loginPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            LoginPresenterImpl.access$handleOperationStarted(this.a);
        }
    }

    public static final class e<T> implements Consumer<LoginResult> {
        public final /* synthetic */ LoginPresenterImpl a;

        public e(LoginPresenterImpl loginPresenterImpl) {
            this.a = loginPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            if (loginResult2 instanceof LoginResult.Ok) {
                LoginPresenterImpl loginPresenterImpl = this.a;
                LoginPresenterImpl.access$handleLoginCompleted(loginPresenterImpl, !loginPresenterImpl.g, ((LoginResult.Ok) loginResult2).getAuthResult().getMessage());
            } else if (loginResult2 instanceof LoginResult.AntihackCheck) {
                LoginPresenterImpl.access$handleAntihackCheck(this.a, (LoginResult.AntihackCheck) loginResult2);
            } else if (loginResult2 instanceof LoginResult.AntihackCheckPhone) {
                LoginPresenterImpl.access$handleAntihackCheckPhone(this.a, (LoginResult.AntihackCheckPhone) loginResult2);
            } else if (loginResult2 instanceof LoginResult.NeedPhoneVerification) {
                LoginPresenterImpl loginPresenterImpl2 = this.a;
                LoginPresenterImpl.access$handleNeedPhoneVerification(loginPresenterImpl2, loginPresenterImpl2.d);
            } else if (loginResult2 instanceof LoginResult.TfaCheck) {
                LoginPresenterImpl.access$handleTfaCheck(this.a, (LoginResult.TfaCheck) loginResult2);
            }
            this.a.g = false;
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ LoginPresenterImpl a;

        public f(LoginPresenterImpl loginPresenterImpl) {
            this.a = loginPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            LoginView loginView = this.a.i;
            if (loginView != null) {
                loginView.hideProgress();
            }
            LoginPresenterImpl.access$clearFieldErrors(this.a);
            if (th2 instanceof TypedResultException) {
                this.a.c(((TypedResultException) th2).getErrorResult());
            } else {
                LoginView loginView2 = this.a.i;
                if (loginView2 != null) {
                    loginView2.showUnknownError();
                }
            }
            this.a.g = false;
        }
    }

    @Inject
    public LoginPresenterImpl(@NotNull LoginInteractor loginInteractor, @NotNull ResetPasswordInteractor resetPasswordInteractor, @NotNull PhoneAntihackInteractor phoneAntihackInteractor, @NotNull TfaInteractor tfaInteractor, @NotNull AttributedTextCreator attributedTextCreator, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull LoginResourceProvider loginResourceProvider, @NotNull SupportEmailResourceProvider supportEmailResourceProvider, @NotNull LastLoggedEmailStorage lastLoggedEmailStorage, @NotNull SmartLockSaver smartLockSaver, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorHelper errorHelper, @PresenterState @Nullable Kundle kundle, @Named("suggest_key") @Nullable String str) {
        Map<String, String> emptyMap;
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(loginInteractor, "loginInteractor");
        Intrinsics.checkNotNullParameter(resetPasswordInteractor, "resetPasswordInteractor");
        Intrinsics.checkNotNullParameter(phoneAntihackInteractor, "phoneAntihackInteractor");
        Intrinsics.checkNotNullParameter(tfaInteractor, "tfaInteractor");
        Intrinsics.checkNotNullParameter(attributedTextCreator, "attributedTextCreator");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(loginResourceProvider, "loginResourceProvider");
        Intrinsics.checkNotNullParameter(supportEmailResourceProvider, "supportEmailResourceProvider");
        Intrinsics.checkNotNullParameter(lastLoggedEmailStorage, "lastLoggedEmailStorage");
        Intrinsics.checkNotNullParameter(smartLockSaver, "smartLock");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.k = loginInteractor;
        this.l = resetPasswordInteractor;
        this.m = phoneAntihackInteractor;
        this.n = tfaInteractor;
        this.o = attributedTextCreator;
        this.p = attributedTextFormatter;
        this.q = loginResourceProvider;
        this.r = supportEmailResourceProvider;
        this.s = lastLoggedEmailStorage;
        this.t = smartLockSaver;
        this.u = features;
        this.v = schedulersFactory;
        this.w = errorHelper;
        this.x = str;
        this.a = new CompositeDisposable();
        this.b = new CompositeDisposable();
        String str2 = null;
        String string = kundle != null ? kundle.getString("login") : null;
        String str3 = "";
        this.d = string == null ? str3 : string;
        str2 = kundle != null ? kundle.getString(Preference.PASSWORD) : str2;
        this.e = str2 != null ? str2 : str3;
        boolean z = false;
        this.f = (kundle == null || (bool2 = kundle.getBoolean("is_hidden_login")) == null) ? false : bool2.booleanValue();
        if (!(kundle == null || (bool = kundle.getBoolean("auto_login")) == null)) {
            z = bool.booleanValue();
        }
        this.g = z;
        this.h = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$clearFieldErrors(LoginPresenterImpl loginPresenterImpl) {
        Objects.requireNonNull(loginPresenterImpl);
        loginPresenterImpl.h = r.emptyMap();
    }

    public static final void access$handleAntihackCheck(LoginPresenterImpl loginPresenterImpl, LoginResult.AntihackCheck antihackCheck) {
        LoginPresenter.Router router;
        LoginView loginView = loginPresenterImpl.i;
        if (loginView != null) {
            loginView.hideProgress();
        }
        try {
            List<String> phoneList = antihackCheck.getPhoneList();
            if (phoneList != null) {
                if (phoneList.size() == 1) {
                    String str = phoneList.get(0);
                    String str2 = "+ " + str.charAt(0) + "  " + str.subSequence(1, 4) + ' ' + str.subSequence(4, 7);
                    LoginPresenter.Router router2 = loginPresenterImpl.j;
                    if (router2 != null) {
                        router2.openPhoneProving(antihackCheck.getChallengeId(), str2, "** **");
                    }
                }
                if (phoneList.size() > 1 && (router = loginPresenterImpl.j) != null) {
                    router.openPhoneList(null, phoneList, antihackCheck.getChallengeId(), true);
                    return;
                }
                return;
            }
            String phoneMask = antihackCheck.getPhoneMask();
            if (phoneMask != null) {
                String replace$default = m.replace$default(phoneMask, '-', ' ', false, 4, (Object) null);
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, "*", 0, false, 6, (Object) null);
                int i2 = indexOf$default - 1;
                if (replace$default != null) {
                    String substring = replace$default.substring(0, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = replace$default.substring(indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                    LoginPresenter.Router router3 = loginPresenterImpl.j;
                    if (router3 != null) {
                        router3.openPhoneProving(antihackCheck.getChallengeId(), substring, substring2);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable unused) {
            LoginView loginView2 = loginPresenterImpl.i;
            if (loginView2 != null) {
                loginView2.showUnknownError();
            }
        }
    }

    public static final void access$handleAntihackCheckPhone(LoginPresenterImpl loginPresenterImpl, LoginResult.AntihackCheckPhone antihackCheckPhone) {
        CompositeDisposable compositeDisposable = loginPresenterImpl.a;
        Disposable subscribe = loginPresenterImpl.m.requestCode(loginPresenterImpl.d).observeOn(loginPresenterImpl.v.mainThread()).doOnSubscribe(new a2.a.a.b.d.f(loginPresenterImpl)).doAfterTerminate(new a2.a.a.b.d.g(loginPresenterImpl)).subscribe(new h(loginPresenterImpl, antihackCheckPhone), new i(loginPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "phoneAntihackInteractor.…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleLoginCompleted(LoginPresenterImpl loginPresenterImpl, boolean z, String str) {
        LoginView loginView;
        if (!z || !loginPresenterImpl.u.getSmartLock().invoke().booleanValue()) {
            LoginView loginView2 = loginPresenterImpl.i;
            if (loginView2 != null) {
                loginView2.hideKeyboard();
            }
            LoginPresenter.Router router = loginPresenterImpl.j;
            if (router != null) {
                router.completeLogin();
            }
        } else {
            loginPresenterImpl.t.save(loginPresenterImpl.d, loginPresenterImpl.e);
        }
        if (str != null && (loginView = loginPresenterImpl.i) != null) {
            loginView.showToast(str);
        }
    }

    public static final void access$handleNeedPhoneVerification(LoginPresenterImpl loginPresenterImpl, String str) {
        CompositeDisposable compositeDisposable = loginPresenterImpl.a;
        Disposable subscribe = RequestCodeInteractor.DefaultImpls.requestCode$default(loginPresenterImpl.k, str, null, 2, null).observeOn(loginPresenterImpl.v.mainThread()).doOnSubscribe(new j(loginPresenterImpl)).doAfterTerminate(new k(loginPresenterImpl)).subscribe(new l(loginPresenterImpl), new a2.a.a.b.d.m(loginPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "loginInteractor.requestC…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleOperationStarted(LoginPresenterImpl loginPresenterImpl) {
        LoginView loginView = loginPresenterImpl.i;
        if (loginView != null) {
            loginView.hideKeyboard();
            loginView.showProgress();
            loginView.hideLoginError();
            loginView.hidePasswordError();
        }
    }

    public static final void access$handlePhoneAntihackCodeRequested(LoginPresenterImpl loginPresenterImpl, String str, CodeInfo codeInfo) {
        LoginPresenter.Router router = loginPresenterImpl.j;
        if (router != null) {
            String str2 = loginPresenterImpl.d;
            router.openPhoneAntihackLoginCodeConfirmation(str, str2, loginPresenterImpl.q.verifyPhoneText(str2), codeInfo.getTimeout(), codeInfo.getLength());
        }
    }

    public static final void access$handlePhoneVerificationCodeRequested(LoginPresenterImpl loginPresenterImpl, CodeInfo codeInfo) {
        LoginPresenter.Router router = loginPresenterImpl.j;
        if (router != null) {
            String str = loginPresenterImpl.d;
            router.openLoginCodeConfirmation(str, loginPresenterImpl.q.verifyPhoneText(str), codeInfo.getTimeout(), codeInfo.getLength());
        }
    }

    public static final void access$handlePhoneVerificationError(LoginPresenterImpl loginPresenterImpl, Throwable th) {
        Objects.requireNonNull(loginPresenterImpl);
        loginPresenterImpl.h = r.emptyMap();
        if (th instanceof CodeAlreadyConfirmedException) {
            CodeAlreadyConfirmedException codeAlreadyConfirmedException = (CodeAlreadyConfirmedException) th;
            String login = codeAlreadyConfirmedException.getInfo().getLogin();
            String hash = codeAlreadyConfirmedException.getInfo().getHash();
            LoginPresenter.Router router = loginPresenterImpl.j;
            if (router != null) {
                router.openChangePassword(login, hash);
            }
        } else if (th instanceof TypedResultException) {
            loginPresenterImpl.c(((TypedResultException) th).getErrorResult());
        } else {
            LoginView loginView = loginPresenterImpl.i;
            if (loginView != null) {
                loginView.showUnknownError();
            }
        }
    }

    public static final void access$handleResetPasswordRequestCompleted(LoginPresenterImpl loginPresenterImpl, ResetPasswordResult resetPasswordResult) {
        LoginView loginView;
        Objects.requireNonNull(loginPresenterImpl);
        if (resetPasswordResult instanceof ResetPasswordResult.ViaCode) {
            LoginPresenter.Router router = loginPresenterImpl.j;
            if (router != null) {
                String str = loginPresenterImpl.d;
                ResetPasswordResult.ViaCode viaCode = (ResetPasswordResult.ViaCode) resetPasswordResult;
                router.openPasswordResetCodeConfirmation(str, loginPresenterImpl.q.resetPasswordViaCodeText(str), viaCode.getCodeTimeout(), viaCode.getCodeLength());
            }
        } else if ((resetPasswordResult instanceof ResetPasswordResult.ViaLink) && (loginView = loginPresenterImpl.i) != null) {
            loginView.showUserDialog(((ResetPasswordResult.ViaLink) resetPasswordResult).getText());
        }
    }

    public static final void access$handleTfaCheck(LoginPresenterImpl loginPresenterImpl, LoginResult.TfaCheck tfaCheck) {
        Objects.requireNonNull(loginPresenterImpl);
        int size = tfaCheck.getPhoneList().size();
        if (size == 1) {
            String str = tfaCheck.getPhoneList().get(0);
            CompositeDisposable compositeDisposable = loginPresenterImpl.a;
            Disposable subscribe = RequestCodeInteractor.DefaultImpls.requestCode$default(loginPresenterImpl.n, str, null, 2, null).observeOn(loginPresenterImpl.v.mainThread()).doOnSubscribe(new x(loginPresenterImpl)).doAfterTerminate(new y(loginPresenterImpl)).subscribe(new z(loginPresenterImpl, str), new a0(loginPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "tfaInteractor.requestCod…Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else if (size > 1) {
            LoginPresenter.Router router = loginPresenterImpl.j;
            if (router != null) {
                router.openPhoneList(loginPresenterImpl.d, tfaCheck.getPhoneList(), null, false);
            }
        } else {
            LoginView loginView = loginPresenterImpl.i;
            if (loginView != null) {
                loginView.showUnknownError();
            }
        }
    }

    public static final void access$handleTfaCodeRequested(LoginPresenterImpl loginPresenterImpl, String str, CodeInfo codeInfo) {
        LoginPresenter.Router router = loginPresenterImpl.j;
        if (router != null) {
            router.openTfaCodeConfirmation(str, loginPresenterImpl.d, codeInfo.getText(), codeInfo.getTimeout(), codeInfo.getLength());
        }
    }

    public static final void access$onCloseScreen(LoginPresenterImpl loginPresenterImpl) {
        loginPresenterImpl.d();
        LoginPresenter.Router router = loginPresenterImpl.j;
        if (router != null) {
            router.leaveScreen();
        }
    }

    public static final void access$onForgotPassword(LoginPresenterImpl loginPresenterImpl) {
        loginPresenterImpl.d();
        LoginPresenter.Router router = loginPresenterImpl.j;
        if (router != null) {
            router.openPasswordRecovery(loginPresenterImpl.d);
        }
    }

    public static final void access$onResetPassword(LoginPresenterImpl loginPresenterImpl) {
        CompositeDisposable compositeDisposable = loginPresenterImpl.a;
        Disposable subscribe = loginPresenterImpl.l.resetPassword(loginPresenterImpl.d).observeOn(loginPresenterImpl.v.mainThread()).doOnSubscribe(new p(loginPresenterImpl)).doAfterTerminate(new q(loginPresenterImpl)).subscribe(new a2.a.a.b.d.r(loginPresenterImpl), new s(loginPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "resetPasswordInteractor.…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onResetPasswordWithoutPhoneEntry(LoginPresenterImpl loginPresenterImpl) {
        CompositeDisposable compositeDisposable = loginPresenterImpl.a;
        Disposable subscribe = loginPresenterImpl.l.loginResetPasswordForPhone(loginPresenterImpl.d).observeOn(loginPresenterImpl.v.mainThread()).doOnSubscribe(new t(loginPresenterImpl)).doAfterTerminate(new u(loginPresenterImpl)).subscribe(new v(loginPresenterImpl), new w(loginPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "resetPasswordInteractor.…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void a() {
        String str;
        LoginView loginView = this.i;
        if (loginView != null) {
            loginView.setLogin(this.d);
            loginView.setPassword(this.e);
            boolean z = true;
            if (this.d.length() > 0) {
                if (this.e.length() != 0) {
                    z = false;
                }
                if (z) {
                    loginView.setFocusOnPasswordField();
                }
            }
            if (this.f) {
                loginView.hideLogin();
                if (Strings.isPhone(this.d)) {
                    str = this.q.hiddenPhoneText(this.d);
                } else {
                    str = this.q.hiddenEmailText(this.d);
                }
                loginView.showText(str, LoginResourceProviderKt.maskIfNeeded(this.d));
            } else {
                loginView.showLogin();
                loginView.hideText();
            }
        }
        e(this.h);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    public void attachRouter(@NotNull LoginPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.j = router;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = InteropKt.toV2(this.t.connectWithObservables()).subscribe(new c(this, router));
        Intrinsics.checkNotNullExpressionValue(subscribe, "smartLock.connectWithObs…              )\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    public void attachView(@NotNull LoginView loginView) {
        Intrinsics.checkNotNullParameter(loginView, "view");
        this.i = loginView;
        a();
        b();
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = loginView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…cribe { onCloseScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = loginView.loginClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.loginClicks().subscribe { onLogin() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.b;
        Disposable subscribe3 = loginView.forgotPasswordClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.forgotPasswordClick…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.b;
        Disposable subscribe4 = loginView.loginChanges().subscribe(new b(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.loginChanges().subs…inButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.b;
        Disposable subscribe5 = loginView.passwordChanges().subscribe(new b(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.passwordChanges().s…inButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        if (this.g && this.i != null) {
            f();
        }
    }

    public final void b() {
        LoginView loginView = this.i;
        if (loginView != null) {
            boolean z = true;
            if (!(!m.isBlank(this.d)) || !(!m.isBlank(this.e))) {
                z = false;
            }
            loginView.setLoginButtonEnabled(z);
        }
    }

    public final void c(TypedError typedError) {
        Action action;
        LoginView loginView;
        Action action2;
        LoginView loginView2;
        boolean z;
        Action action3;
        List<Action> actions;
        Action action4;
        LoginView loginView3;
        Action action5;
        if (typedError instanceof TypedError.ErrorMap) {
            e(((TypedError.ErrorMap) typedError).getMessages());
        } else if (typedError instanceof ErrorWithMessage.ErrorDialog) {
            UserDialog data = ((ErrorWithMessage.ErrorDialog) typedError).getData();
            List<Action> actions2 = data.getActions();
            CharSequence charSequence = null;
            DeepLink deepLink = (actions2 == null || (action5 = (Action) CollectionsKt___CollectionsKt.first(actions2)) == null) ? null : action5.getDeepLink();
            if ((deepLink instanceof SendEmailLink) || (deepLink instanceof SendEmailToItemLink)) {
                List<Action> actions3 = data.getActions();
                if (actions3 != null) {
                    Action action6 = (Action) CollectionsKt___CollectionsKt.first((List<? extends Object>) actions3);
                    AttributedText from = this.o.from(action6.getDeepLink(), action6.getTitle());
                    from.setOnDeepLinkClickListener(new OnDeepLinkClickListener() { // from class: com.avito.android.authorization.login.LoginPresenterImpl$createActionLink$onDeepLinkClickListener$1
                        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                        public void onDeepLinkClick(@NotNull DeepLink deepLink2) {
                            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
                            if (deepLink2 instanceof SendEmailLink) {
                                SendEmailLink sendEmailLink = (SendEmailLink) deepLink2;
                                String toEmail = sendEmailLink.getToEmail();
                                String subject = sendEmailLink.getSubject();
                                StringBuilder sb = new StringBuilder();
                                sb.append(LoginPresenterImpl.this.r.getSupportEmailText());
                                String info = sendEmailLink.getInfo();
                                if (info == null) {
                                    info = "";
                                }
                                sb.append(info);
                                deepLink2 = new SendEmailLink(toEmail, subject, sb.toString());
                            }
                            LoginPresenterImpl.this.d();
                            LoginPresenter.Router router = LoginPresenterImpl.this.j;
                            if (router != null) {
                                router.followDeepLink(deepLink2);
                            }
                        }
                    });
                    charSequence = this.p.format(from);
                }
                if (charSequence != null) {
                    LoginView loginView4 = this.i;
                    if (loginView4 != null) {
                        loginView4.showUserDialog(data.getTitle(), data.getMessage(), charSequence);
                        return;
                    }
                    return;
                }
                LoginView loginView5 = this.i;
                if (loginView5 != null) {
                    loginView5.showUserDialog(data.getTitle(), data.getMessage());
                }
            } else if (ListUtils.isNotNullAndNotEmpty(data.getActions())) {
                List<Action> actions4 = data.getActions();
                Intrinsics.checkNotNull(actions4);
                if (actions4.size() == 2) {
                    List<Action> actions5 = data.getActions();
                    Intrinsics.checkNotNull(actions5);
                    if (!(actions5 instanceof Collection) || !actions5.isEmpty()) {
                        Iterator<T> it = actions5.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!(it.next().getDeepLink() instanceof ResetPasswordLink)) {
                                    z = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        List<Action> actions6 = data.getActions();
                        if (actions6 != null && (action3 = actions6.get(0)) != null && (actions = data.getActions()) != null && (action4 = actions.get(1)) != null && (loginView3 = this.i) != null) {
                            loginView3.showUserDialog(data.getTitle(), data.getMessage(), action3.getTitle(), new i6(0, this, action3), action4.getTitle(), new i6(1, this, action4));
                            return;
                        }
                        return;
                    }
                }
                if (this.u.getShortResetFlow().invoke().booleanValue()) {
                    if ((deepLink instanceof ResetPasswordLink) && ((ResetPasswordLink) deepLink).getSkipLoginEntry()) {
                        List<Action> actions7 = data.getActions();
                        if (actions7 != null && (action2 = (Action) CollectionsKt___CollectionsKt.first((List<? extends Object>) actions7)) != null && (loginView2 = this.i) != null) {
                            loginView2.showUserDialog(data.getTitle(), data.getMessage(), action2.getTitle(), new c6(0, this), new c6(1, this));
                            return;
                        }
                        return;
                    }
                }
                List<Action> actions8 = data.getActions();
                if (actions8 != null && (action = (Action) CollectionsKt___CollectionsKt.first((List<? extends Object>) actions8)) != null && (loginView = this.i) != null) {
                    loginView.showUserDialog(data.getTitle(), data.getMessage(), action.getTitle(), new n(this, action), new o(this));
                }
            } else {
                LoginView loginView6 = this.i;
                if (loginView6 != null) {
                    loginView6.showUserDialog(data.getTitle(), data.getMessage());
                }
            }
        } else if (typedError instanceof TypedError.UnauthorizedError) {
            LoginView loginView7 = this.i;
            if (loginView7 != null) {
                loginView7.showUnknownError();
            }
        } else {
            LoginView loginView8 = this.i;
            if (loginView8 != null) {
                loginView8.showError(this.w.recycle(typedError));
            }
        }
    }

    public final void d() {
        LoginView loginView = this.i;
        if (loginView != null) {
            loginView.hideProgress();
        }
        LoginView loginView2 = this.i;
        if (loginView2 != null) {
            loginView2.hideKeyboard();
        }
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    public void detachRouter() {
        this.a.clear();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        this.j = null;
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    public void detachView() {
        this.b.clear();
        this.i = null;
    }

    public final void e(Map<String, String> map) {
        LoginView loginView;
        LoginView loginView2;
        this.h = map;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int hashCode = key.hashCode();
            if (hashCode != 103149417) {
                if (hashCode == 1216985755 && key.equals(Preference.PASSWORD) && (loginView = this.i) != null) {
                    loginView.showPasswordError(value);
                }
            } else if (key.equals("login") && (loginView2 = this.i) != null) {
                loginView2.showLoginError(value);
            }
        }
    }

    public final void f() {
        Disposable disposable = this.c;
        if (disposable == null || disposable.isDisposed()) {
            this.c = this.k.login(this.d, this.e, this.x).firstOrError().observeOn(this.v.mainThread()).doOnSubscribe(new d(this)).subscribe(new e(this), new f(this));
        }
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    public void onPhoneVerified() {
        f();
    }

    @Override // com.avito.android.authorization.login.LoginPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("login", this.d).putString(Preference.PASSWORD, this.e).putBoolean("is_hidden_login", Boolean.valueOf(this.f)).putBoolean("auto_login", Boolean.valueOf(this.g)).putStringMap("messages", this.h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        if (r4 == false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032  */
    @Override // com.avito.android.authorization.login.LoginPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStartLogin(@org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.String r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            r0 = 1
            java.lang.String r1 = ""
            if (r4 == 0) goto L_0x0007
            r2 = r4
            goto L_0x0016
        L_0x0007:
            com.avito.android.account.LastLoggedEmailStorage r2 = r3.s
            java.lang.String r2 = r2.getEmail()
            r7 = r7 ^ r0
            if (r7 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            r3.d = r2
            if (r5 == 0) goto L_0x001b
            r1 = r5
        L_0x001b:
            r3.e = r1
            r3.f = r6
            r6 = 0
            if (r4 == 0) goto L_0x002f
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 == 0) goto L_0x0045
            if (r5 == 0) goto L_0x0041
            int r4 = r5.length()
            if (r4 <= 0) goto L_0x003c
            r4 = 1
            goto L_0x003d
        L_0x003c:
            r4 = 0
        L_0x003d:
            if (r4 == 0) goto L_0x0041
            r4 = 1
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            r3.g = r0
            r3.a()
            boolean r4 = r3.g
            if (r4 == 0) goto L_0x0056
            com.avito.android.authorization.login.LoginView r4 = r3.i
            if (r4 == 0) goto L_0x0056
            r3.f()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.login.LoginPresenterImpl.setStartLogin(java.lang.String, java.lang.String, boolean, boolean):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginPresenterImpl(LoginInteractor loginInteractor, ResetPasswordInteractor resetPasswordInteractor, PhoneAntihackInteractor phoneAntihackInteractor, TfaInteractor tfaInteractor, AttributedTextCreator attributedTextCreator, AttributedTextFormatter attributedTextFormatter, LoginResourceProvider loginResourceProvider, SupportEmailResourceProvider supportEmailResourceProvider, LastLoggedEmailStorage lastLoggedEmailStorage, SmartLockSaver smartLockSaver, Features features, SchedulersFactory schedulersFactory, ErrorHelper errorHelper, Kundle kundle, String str, int i2, t6.r.a.j jVar) {
        this(loginInteractor, resetPasswordInteractor, phoneAntihackInteractor, tfaInteractor, attributedTextCreator, attributedTextFormatter, loginResourceProvider, supportEmailResourceProvider, lastLoggedEmailStorage, smartLockSaver, features, schedulersFactory, errorHelper, (i2 & 8192) != 0 ? null : kundle, str);
    }
}
