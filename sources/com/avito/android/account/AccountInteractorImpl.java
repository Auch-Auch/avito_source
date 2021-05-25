package com.avito.android.account;

import com.avito.android.Features;
import com.avito.android.account.Credentials;
import com.avito.android.account.analytics.event.SaveSuggestEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.LoadingState;
import com.avito.android.util.ProfilesKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Strings;
import com.avito.android.util.Throwables;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010B\u001a\u00020@\u0012\u0006\u0010?\u001a\u00020=\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\bG\u0010HJ-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\rJ7\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0011J+\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u001e*\u00020\u001d*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/avito/android/account/AccountInteractorImpl;", "Lcom/avito/android/account/AccountInteractor;", "Lcom/avito/android/account/Credentials$PasswordCredentials;", "credentials", "", "suggestKey", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/LoginResult;", "login", "(Lcom/avito/android/account/Credentials$PasswordCredentials;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "tfaCode", "userName", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "socialId", "Lcom/avito/android/remote/model/SocialAuthResult;", "(Lcom/avito/android/account/Credentials$SignInServiceCredentials;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "socialType", "Lcom/avito/android/remote/model/AuthResult;", "createProfile", "", "isUserAction", "source", "Lio/reactivex/rxjava3/core/Completable;", "logout", "(ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", AuthSource.BOOKING_ORDER, "(Lio/reactivex/rxjava3/core/Observable;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "T", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/account/AccountUpdateInteractor;", "f", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "Lcom/avito/android/util/BuildInfo;", "j", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "h", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", a2.g.r.g.a, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/account/LoginSuggestStorage;", "c", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "Lcom/avito/android/preferences/TokenStorage;", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/account/LoginSuggestStorage;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountUpdateInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class AccountInteractorImpl implements AccountInteractor {
    public final ProfileApi a;
    public final TokenStorage b;
    public final LoginSuggestStorage c;
    public final Features d;
    public final SchedulersFactory3 e;
    public final AccountUpdateInteractor f;
    public final AccountStateProvider g;
    public final TypedErrorThrowableConverter h;
    public final Analytics i;
    public final BuildInfo j;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Throwable th2 = th;
                AccountUpdateInteractor accountUpdateInteractor = ((AccountInteractorImpl) this.b).f;
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                accountUpdateInteractor.notifyLogoutError(th2);
            } else if (i == 1) {
                Throwable th3 = th;
                AccountUpdateInteractor accountUpdateInteractor2 = ((AccountInteractorImpl) this.b).f;
                Intrinsics.checkNotNullExpressionValue(th3, "it");
                accountUpdateInteractor2.notifyLogoutError(th3);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<TypedResult<AuthResult>, LoadingState<? super AuthResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AuthResult> apply(TypedResult<AuthResult> typedResult) {
            TypedResult<AuthResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function<LoadingState<? super AuthResult>, ObservableSource<? extends LoadingState<? super AuthResult>>> {
        public final /* synthetic */ AccountInteractorImpl a;
        public final /* synthetic */ String b;

        public c(AccountInteractorImpl accountInteractorImpl, String str) {
            this.a = accountInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super AuthResult>> apply(LoadingState<? super AuthResult> loadingState) {
            LoadingState<? super AuthResult> loadingState2 = loadingState;
            if (!(loadingState2 instanceof LoadingState.Loaded)) {
                return Observable.just(loadingState2);
            }
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            return AccountUpdateInteractorKt.login(this.a.f, ((AuthResult) loaded.getData()).getSession(), ((AuthResult) loaded.getData()).getProfile(), "proceed_social").doOnComplete(new a2.a.a.e.a(this, loadingState2)).toSingleDefault(loadingState2).toObservable();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ AccountInteractorImpl a;

        public d(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AccountInteractorImpl accountInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            AccountInteractorImpl.access$handleLoginError(accountInteractorImpl, th2);
        }
    }

    public static final class e<T, R> implements Function<Throwable, LoadingState<? super AuthResult>> {
        public final /* synthetic */ AccountInteractorImpl a;

        public e(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AuthResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.h;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class f<T, R> implements Function<LoadingState<? super SocialAuthResult>, ObservableSource<? extends LoadingState<? super SocialAuthResult>>> {
        public final /* synthetic */ AccountInteractorImpl a;
        public final /* synthetic */ Credentials.SignInServiceCredentials b;

        public f(AccountInteractorImpl accountInteractorImpl, Credentials.SignInServiceCredentials signInServiceCredentials) {
            this.a = accountInteractorImpl;
            this.b = signInServiceCredentials;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super SocialAuthResult>> apply(LoadingState<? super SocialAuthResult> loadingState) {
            LoadingState<? super SocialAuthResult> loadingState2 = loadingState;
            if (!(loadingState2 instanceof LoadingState.Loaded)) {
                return Observable.just(loadingState2);
            }
            SocialAuthResult socialAuthResult = (SocialAuthResult) ((LoadingState.Loaded) loadingState2).getData();
            if (socialAuthResult instanceof SocialAuthResult.Ok) {
                SocialAuthResult.Ok ok = (SocialAuthResult.Ok) socialAuthResult;
                return this.a.f.login(ok.getAuthResult().getSession(), ProfilesKt.toProfileInfo(ok.getAuthResult().getProfile()), "login").doOnComplete(new a2.a.a.e.b(this, socialAuthResult)).toSingleDefault(loadingState2).toObservable();
            } else if (socialAuthResult instanceof SocialAuthResult.AccountSuggest) {
                return Observable.just(new LoadingState.Loaded(socialAuthResult));
            } else {
                throw new IllegalStateException("Not supposed to get here");
            }
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ AccountInteractorImpl a;

        public g(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AccountInteractorImpl accountInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            AccountInteractorImpl.access$handleLoginError(accountInteractorImpl, th2);
        }
    }

    public static final class h<T, R> implements Function<Throwable, LoadingState<? super SocialAuthResult>> {
        public final /* synthetic */ AccountInteractorImpl a;

        public h(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SocialAuthResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.h;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class i<T, R> implements Function<SuccessResult, Unit> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(SuccessResult successResult) {
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Throwable, Boolean> {
        public static final j a = new j();

        public j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return Boolean.valueOf(!Throwables.isAuthProblem(th2));
        }
    }

    public static final class k<T, R> implements Function<Throwable, ObservableSource<? extends T>> {
        public final /* synthetic */ AccountInteractorImpl a;

        public k(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return this.a.g.currentAuthorized().flatMap(new a2.a.a.e.d(this, th2)).flatMapObservable(new a2.a.a.e.e(th2));
        }
    }

    public static final class l<T, R> implements Function<LoadingState<? super LoginResult>, ObservableSource<? extends LoadingState<? super LoginResult>>> {
        public final /* synthetic */ AccountInteractorImpl a;
        public final /* synthetic */ String b;

        public l(AccountInteractorImpl accountInteractorImpl, String str) {
            this.a = accountInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super LoginResult>> apply(LoadingState<? super LoginResult> loadingState) {
            LoadingState<? super LoginResult> loadingState2 = loadingState;
            if (!(loadingState2 instanceof LoadingState.Loaded)) {
                return Observable.just(loadingState2);
            }
            LoginResult loginResult = (LoginResult) ((LoadingState.Loaded) loadingState2).getData();
            if (loginResult instanceof LoginResult.Ok) {
                LoginResult.Ok ok = (LoginResult.Ok) loginResult;
                return this.a.f.login(ok.getAuthResult().getSession(), ProfilesKt.toProfileInfo(ok.getAuthResult().getProfile()), "login").doOnComplete(new a2.a.a.e.f(this, loginResult)).toSingleDefault(loadingState2).toObservable();
            } else if (loginResult instanceof LoginResult.AntihackCheck) {
                return Observable.just(loadingState2);
            } else {
                if (loginResult instanceof LoginResult.AntihackCheckPhone) {
                    return Observable.just(loadingState2);
                }
                if (loginResult instanceof LoginResult.NeedPhoneVerification) {
                    return Observable.just(loadingState2);
                }
                if (loginResult instanceof LoginResult.TfaCheck) {
                    return Observable.just(loadingState2);
                }
                return Observable.error(new RuntimeException("Expected ok result here but was " + loginResult));
            }
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public final /* synthetic */ AccountInteractorImpl a;

        public m(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AccountInteractorImpl accountInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            AccountInteractorImpl.access$handleLoginError(accountInteractorImpl, th2);
        }
    }

    public static final class n<T, R> implements Function<Throwable, LoadingState<? super LoginResult>> {
        public final /* synthetic */ AccountInteractorImpl a;

        public n(AccountInteractorImpl accountInteractorImpl) {
            this.a = accountInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super LoginResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.h;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public AccountInteractorImpl(@NotNull ProfileApi profileApi, @NotNull TokenStorage tokenStorage, @NotNull LoginSuggestStorage loginSuggestStorage, @NotNull Features features, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountUpdateInteractor, "accountUpdateInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "typedErrorThrowableConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = profileApi;
        this.b = tokenStorage;
        this.c = loginSuggestStorage;
        this.d = features;
        this.e = schedulersFactory3;
        this.f = accountUpdateInteractor;
        this.g = accountStateProvider;
        this.h = typedErrorThrowableConverter;
        this.i = analytics;
        this.j = buildInfo;
    }

    public static final void access$handleLoginError(AccountInteractorImpl accountInteractorImpl, Throwable th) {
        accountInteractorImpl.f.notifyLoginError(th);
    }

    public static final void access$storeLoginSuggest(AccountInteractorImpl accountInteractorImpl, String str, String str2, String str3, String str4) {
        SaveSuggestEvent.LoginType loginType;
        Objects.requireNonNull(accountInteractorImpl);
        if (str != null) {
            accountInteractorImpl.c.put(new LoginSuggest(str, str2, str3, str4));
            if (str3 != null) {
                loginType = SaveSuggestEvent.LoginType.SOCIAL;
            } else if (str2 == null || !Strings.isEmail(str2)) {
                loginType = SaveSuggestEvent.LoginType.PHONE;
            } else {
                loginType = SaveSuggestEvent.LoginType.EMAIL;
            }
            accountInteractorImpl.i.track(new SaveSuggestEvent(SaveSuggestEvent.Source.AUTH, loginType));
        }
    }

    public final <T> Observable<T> a(Observable<T> observable) {
        Observable<T> onErrorResumeNext = observable.onErrorResumeNext(new k(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "onErrorResumeNext { erro…ror<T>(error) }\n        }");
        return onErrorResumeNext;
    }

    public final Observable<LoadingState<LoginResult>> b(Observable<LoadingState<LoginResult>> observable, String str) {
        Observable<R> flatMap = observable.startWithItem(LoadingState.Loading.INSTANCE).flatMap(new l(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "startWithItem(Loading)\n …          }\n            }");
        Observable<LoadingState<LoginResult>> onErrorReturn = a(flatMap).doOnError(new m(this)).onErrorReturn(new n(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "startWithItem(Loading)\n …eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.account.AccountInteractor
    @NotNull
    public Observable<LoadingState<AuthResult>> createProfile(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "suggestKey");
        Intrinsics.checkNotNullParameter(str2, "socialType");
        Observable<R> flatMap = this.a.createProfile(str2, this.b.getGcmToken(), "fcm", this.j.isDebug(), str).subscribeOn(this.e.io()).map(b.a).flatMap(new c(this, str2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.createProfile(\n     …          }\n            }");
        Observable<LoadingState<AuthResult>> onErrorReturn = a(flatMap).doOnError(new d(this)).onErrorReturn(new e(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.createProfile(\n     …eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.account.AccountInteractor
    @NotNull
    public Observable<LoadingState<LoginResult>> login(@NotNull Credentials.PasswordCredentials passwordCredentials, @Nullable String str) {
        Observable<TypedResult<LoginResult>> observable;
        Intrinsics.checkNotNullParameter(passwordCredentials, "credentials");
        if (this.d.getAntihackPro().invoke().booleanValue()) {
            observable = this.a.authenticateWithAntihackProLegacy(passwordCredentials.getUserName(), passwordCredentials.getPassword(), this.b.getGcmToken(), str);
        } else if (this.d.getPhoneAntihack().invoke().booleanValue()) {
            observable = this.a.authenticateLegacy(passwordCredentials.getUserName(), passwordCredentials.getPassword(), this.b.getGcmToken());
        } else {
            observable = this.a.legacyAuthenticateLegacy(passwordCredentials.getUserName(), passwordCredentials.getPassword(), this.b.getGcmToken());
        }
        Observable<TypedResult<LoginResult>> subscribeOn = observable.subscribeOn(this.e.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "when {\n            featu…scribeOn(schedulers.io())");
        Observable<LoadingState<LoginResult>> b2 = b(AccountInteractorKt.access$toLoginLoadingState(subscribeOn), passwordCredentials.getUserName());
        Completable flatMapCompletable = this.g.currentAuthorized().flatMapCompletable(new a2.a.a.e.c(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "accountStateProvider.cur…)\n            }\n        }");
        Observable<LoadingState<LoginResult>> andThen = flatMapCompletable.andThen(b2);
        Intrinsics.checkNotNullExpressionValue(andThen, "logoutIfNeeded()\n            .andThen(authRequest)");
        return andThen;
    }

    @Override // com.avito.android.account.AccountInteractor
    @NotNull
    public Completable logout(boolean z, @Nullable String str) {
        if (this.d.getAccountManager().invoke().booleanValue()) {
            Completable doOnError = this.f.logout(z, str).doOnError(new a(0, this));
            Intrinsics.checkNotNullExpressionValue(doOnError, "accountUpdateInteractor.…r.notifyLogoutError(it) }");
            return doOnError;
        }
        Observable<R> map = this.a.logoutLegacy(this.b.getGcmToken()).subscribeOn(this.e.io()).map(i.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.logoutLegacy(tokenSt…            .map { Unit }");
        Completable doOnError2 = AccountInteractorKt.access$filterError(map, j.a).ignoreElements().andThen(this.f.logout(z, str)).doOnError(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(doOnError2, "api.logoutLegacy(tokenSt…r.notifyLogoutError(it) }");
        return doOnError2;
    }

    @Override // com.avito.android.account.AccountInteractor
    @NotNull
    public Observable<LoadingState<LoginResult>> login(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tfaCode");
        Intrinsics.checkNotNullParameter(str2, "userName");
        Observable<TypedResult<LoginResult>> subscribeOn = this.a.authenticateWithTfaCode(str).subscribeOn(this.e.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.authenticateWithTfaC…scribeOn(schedulers.io())");
        return b(AccountInteractorKt.access$toLoginLoadingState(subscribeOn), str2);
    }

    @Override // com.avito.android.account.AccountInteractor
    @NotNull
    public Observable<LoadingState<SocialAuthResult>> login(@NotNull Credentials.SignInServiceCredentials signInServiceCredentials, @Nullable String str, @Nullable String str2) {
        Observable<TypedResult<SocialAuthResult>> observable;
        Intrinsics.checkNotNullParameter(signInServiceCredentials, "credentials");
        if (signInServiceCredentials instanceof Credentials.SignInServiceCredentials.SocialCredentials) {
            Credentials.SignInServiceCredentials.SocialCredentials socialCredentials = (Credentials.SignInServiceCredentials.SocialCredentials) signInServiceCredentials;
            observable = this.a.authenticateSocialLegacy(signInServiceCredentials.getSocialNetworkType(), socialCredentials.getToken(), this.b.getGcmToken(), socialCredentials.getEmail(), str, str2);
        } else if (signInServiceCredentials instanceof Credentials.SignInServiceCredentials.AppleCredentials) {
            Credentials.SignInServiceCredentials.AppleCredentials appleCredentials = (Credentials.SignInServiceCredentials.AppleCredentials) signInServiceCredentials;
            observable = ProfileApi.DefaultImpls.authenticateWithAppleLegacy$default(this.a, appleCredentials.getToken(), this.b.getGcmToken(), appleCredentials.getUser(), null, str, str2, 8, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Observable<TypedResult<SocialAuthResult>> subscribeOn = observable.subscribeOn(this.e.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "request\n            .subscribeOn(schedulers.io())");
        Observable startWithItem = AccountInteractorKt.access$toSocialLoadingState(subscribeOn).flatMap(new f(this, signInServiceCredentials)).startWithItem(LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "request\n            .sub…  .startWithItem(Loading)");
        Observable<LoadingState<SocialAuthResult>> onErrorReturn = a(startWithItem).doOnError(new g(this)).onErrorReturn(new h(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "request\n            .sub…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
