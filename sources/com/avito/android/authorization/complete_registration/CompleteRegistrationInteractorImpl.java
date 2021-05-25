package com.avito.android.authorization.complete_registration;

import a2.g.r.g;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.LoginSuggest;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.analytics.event.SaveSuggestEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.complete_registration.di.Login;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.util.Observables;
import com.avito.android.util.ProfilesKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\b\u0007\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b)\u0010*J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractorImpl;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "", "hash", "name", Preference.PASSWORD, "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/AuthResult;", "register", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/preferences/TokenStorage;", "e", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "login", "Lcom/avito/android/account/AccountUpdateInteractor;", "c", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "Lcom/avito/android/account/LoginSuggestStorage;", "f", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/account/AccountUpdateInteractor;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/account/LoginSuggestStorage;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class CompleteRegistrationInteractorImpl implements CompleteRegistrationInteractor {
    public final String a;
    public final ProfileApi b;
    public final AccountUpdateInteractor c;
    public final TypedErrorThrowableConverter d;
    public final TokenStorage e;
    public final LoginSuggestStorage f;
    public final Analytics g;
    public final SchedulersFactory h;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends LoginResult>> {
        public final /* synthetic */ CompleteRegistrationInteractorImpl a;

        public a(CompleteRegistrationInteractorImpl completeRegistrationInteractorImpl) {
            this.a = completeRegistrationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends LoginResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "ex");
            this.a.c.notifyLoginError(th2);
            return Observables.toObservable(new TypedResultException(this.a.d.convert(th2)));
        }
    }

    public static final class b<T, R> implements Function<LoginResult, ObservableSource<? extends AuthResult>> {
        public final /* synthetic */ CompleteRegistrationInteractorImpl a;

        public b(CompleteRegistrationInteractorImpl completeRegistrationInteractorImpl) {
            this.a = completeRegistrationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: io.reactivex.Completable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends AuthResult> apply(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            Intrinsics.checkNotNullParameter(loginResult2, CommonKt.EXTRA_RESPONSE);
            if (loginResult2 instanceof LoginResult.Ok) {
                LoginResult.Ok ok = (LoginResult.Ok) loginResult2;
                CompleteRegistrationInteractorImpl.access$storeLoginSuggest(this.a, ok.getAuthResult().getProfile().getUserHashId(), this.a.a, null);
                return InteropKt.toV2(this.a.c.login(ok.getAuthResult().getSession(), ProfilesKt.toProfileInfo(ok.getAuthResult().getProfile()), "registration_complete")).toSingleDefault(ok.getAuthResult()).toObservable();
            } else if (loginResult2 instanceof LoginResult.FailedWithMessage) {
                return CompleteRegistrationInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((LoginResult.FailedWithMessage) loginResult2).getMessage()));
            } else {
                if (loginResult2 instanceof LoginResult.FailedWithMessages) {
                    return CompleteRegistrationInteractorImpl.access$toErrorObservable(this.a, new TypedError.ErrorMap(((LoginResult.FailedWithMessages) loginResult2).getMessages()));
                }
                if (loginResult2 instanceof LoginResult.FailedWithDialog) {
                    return CompleteRegistrationInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.ErrorDialog(((LoginResult.FailedWithDialog) loginResult2).getUserDialog()));
                }
                if (loginResult2 instanceof LoginResult.NeedPhoneVerification) {
                    throw new RuntimeException("Unexpected result was received: NeedPhoneVerification");
                } else if (loginResult2 instanceof LoginResult.AntihackCheck) {
                    throw new RuntimeException("Unexpected result was received: AntihackCheck");
                } else if (loginResult2 instanceof LoginResult.AntihackCheckPhone) {
                    throw new RuntimeException("Unexpected result was received: AntihackCheckPhone");
                } else if (loginResult2 instanceof LoginResult.TfaCheck) {
                    throw new RuntimeException("Unexpected result was received: AntihackCheck");
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    @Inject
    public CompleteRegistrationInteractorImpl(@Login @NotNull String str, @NotNull ProfileApi profileApi, @NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull TokenStorage tokenStorage, @NotNull LoginSuggestStorage loginSuggestStorage, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(accountUpdateInteractor, "accountUpdateInteractor");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = str;
        this.b = profileApi;
        this.c = accountUpdateInteractor;
        this.d = typedErrorThrowableConverter;
        this.e = tokenStorage;
        this.f = loginSuggestStorage;
        this.g = analytics;
        this.h = schedulersFactory;
    }

    public static final void access$storeLoginSuggest(CompleteRegistrationInteractorImpl completeRegistrationInteractorImpl, String str, String str2, String str3) {
        SaveSuggestEvent.LoginType loginType;
        Objects.requireNonNull(completeRegistrationInteractorImpl);
        if (str != null) {
            completeRegistrationInteractorImpl.f.put(new LoginSuggest(str, str2, str3, null));
            if (str3 != null) {
                loginType = SaveSuggestEvent.LoginType.SOCIAL;
            } else if (str2 == null || !Strings.isEmail(str2)) {
                loginType = SaveSuggestEvent.LoginType.PHONE;
            } else {
                loginType = SaveSuggestEvent.LoginType.EMAIL;
            }
            completeRegistrationInteractorImpl.g.track(new SaveSuggestEvent(SaveSuggestEvent.Source.REGISTRATION, loginType));
        }
    }

    public static final Observable access$toErrorObservable(CompleteRegistrationInteractorImpl completeRegistrationInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(completeRegistrationInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationInteractor
    @NotNull
    public Observable<AuthResult> register(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "hash", str2, "name", str3, Preference.PASSWORD);
        return a2.b.a.a.a.S1(this.h, TypedObservablesKt.toTyped(InteropKt.toV2(this.b.completeRegistrationLegacy(str, str2, str3, this.e.getGcmToken()))).onErrorResumeNext(new a(this)).flatMap(new b(this)), "registrationRequest\n    …scribeOn(schedulers.io())");
    }
}
