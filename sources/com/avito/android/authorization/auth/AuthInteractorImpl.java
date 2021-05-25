package com.avito.android.authorization.auth;

import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.Credentials;
import com.avito.android.account.LoginSuggest;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.auth.AuthInteractor;
import com.avito.android.authorization.login_suggests.events.HasSuggestsEvent;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Maybies;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b+\u0010,J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/authorization/auth/AuthInteractorImpl;", "Lcom/avito/android/authorization/auth/AuthInteractor;", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "socialId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SocialAuthResult;", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "user", "loginWithApple", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "src", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/authorization/auth/AuthInteractor$FastLogin;", "checkFastLogin", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/account/LoginSuggestStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "c", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLock", "Lcom/avito/android/account/AccountInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/account/AccountInteractor;Lcom/avito/android/account/LoginSuggestStorage;Lcom/avito/android/authorization/smart_lock/SmartLockLoader;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthInteractorImpl implements AuthInteractor {
    public final AccountInteractor a;
    public final LoginSuggestStorage b;
    public final SmartLockLoader c;
    public final SchedulersFactory3 d;
    public final Features e;
    public final Analytics f;

    public static final class a<V> implements Callable<List<? extends LoginSuggest>> {
        public final /* synthetic */ AuthInteractorImpl a;

        public a(AuthInteractorImpl authInteractorImpl) {
            this.a = authInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends LoginSuggest> call() {
            return this.a.b.get();
        }
    }

    public static final class b<T1, T2, R> implements BiFunction<List<? extends LoginSuggest>, Long, List<? extends LoginSuggest>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public List<? extends LoginSuggest> apply(List<? extends LoginSuggest> list, Long l) {
            return list;
        }
    }

    public static final class c<T, R> implements Function<List<? extends LoginSuggest>, MaybeSource<? extends AuthInteractor.FastLogin>> {
        public final /* synthetic */ AuthInteractorImpl a;

        public c(AuthInteractorImpl authInteractorImpl) {
            this.a = authInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends AuthInteractor.FastLogin> apply(List<? extends LoginSuggest> list) {
            List<? extends LoginSuggest> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "suggests");
            return this.a.c.check().subscribeOn(this.a.d.mainThread()).flatMapMaybe(new a2.a.a.b.b.a(!list2.isEmpty()));
        }
    }

    public static final class d<T> implements Consumer<AuthInteractor.FastLogin> {
        public final /* synthetic */ AuthInteractorImpl a;
        public final /* synthetic */ String b;

        public d(AuthInteractorImpl authInteractorImpl, String str) {
            this.a = authInteractorImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AuthInteractor.FastLogin fastLogin) {
            if (fastLogin == AuthInteractor.FastLogin.SUGGESTS) {
                this.a.f.track(new HasSuggestsEvent(this.b));
            }
        }
    }

    @Inject
    public AuthInteractorImpl(@NotNull AccountInteractor accountInteractor, @NotNull LoginSuggestStorage loginSuggestStorage, @NotNull SmartLockLoader smartLockLoader, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        Intrinsics.checkNotNullParameter(smartLockLoader, "smartLock");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = accountInteractor;
        this.b = loginSuggestStorage;
        this.c = smartLockLoader;
        this.d = schedulersFactory3;
        this.e = features;
        this.f = analytics;
    }

    @Override // com.avito.android.authorization.auth.AuthInteractor
    @NotNull
    public Maybe<AuthInteractor.FastLogin> checkFastLogin(@Nullable String str) {
        Maybe maybe;
        if (this.e.getLoginSuggests().invoke().booleanValue()) {
            maybe = Single.fromCallable(new a(this)).zipWith(Single.timer(350, TimeUnit.MILLISECONDS, this.d.computation()), b.a).subscribeOn(this.d.io()).flatMapMaybe(new c(this));
        } else {
            maybe = Maybies.toMaybe(AuthInteractor.FastLogin.SMART_LOCK);
        }
        Maybe<AuthInteractor.FastLogin> doOnSuccess = maybe.doOnSuccess(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "if (features.loginSugges…)\n            }\n        }");
        return doOnSuccess;
    }

    @Override // com.avito.android.authorization.auth.AuthInteractor
    @NotNull
    public Observable<SocialAuthResult> login(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "socialType");
        Intrinsics.checkNotNullParameter(str2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Observable<SocialAuthResult> observable = AccountInteractor.DefaultImpls.login$default(this.a, new Credentials.SignInServiceCredentials.SocialCredentials(str2, str3, str), str4, null, 4, null).flatMap(AuthInteractorImpl$login$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable;
    }

    @Override // com.avito.android.authorization.auth.AuthInteractor
    @NotNull
    public Observable<SocialAuthResult> loginWithApple(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Observable<SocialAuthResult> observable = AccountInteractor.DefaultImpls.login$default(this.a, new Credentials.SignInServiceCredentials.AppleCredentials(str, str2, "apple"), str3, null, 4, null).flatMap(AuthInteractorImpl$loginWithApple$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable;
    }
}
