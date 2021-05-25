package com.avito.android.calls.voximplant.rx.core;

import a2.b.a.a.a;
import com.avito.android.calls.Credentials;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.OneTimeLoginCredentialsProvider;
import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay3.PublishRelay;
import com.voximplant.sdk.client.AuthParams;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.IClientLoginListener;
import com.voximplant.sdk.client.LoginError;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001%B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014RD\u0010\u001b\u001a0\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0017\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u0016¢\u0006\u0002\b\u00190\u0016¢\u0006\u0002\b\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager;", "", "Lcom/avito/android/calls/Credentials;", "credentials", "Lio/reactivex/rxjava3/core/Completable;", "login", "(Lcom/avito/android/calls/Credentials;)Lio/reactivex/rxjava3/core/Completable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/Credentials$AccessToken;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/calls/Credentials$AccessToken;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/voximplant/sdk/client/AuthParams;", "authParams", "c", "(Lcom/voximplant/sdk/client/AuthParams;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/voximplant/sdk/client/IClient;", "Lcom/voximplant/sdk/client/IClient;", "client", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "loginResultStream", "Lcom/avito/android/calls/CredentialsStorage;", "d", "Lcom/avito/android/calls/CredentialsStorage;", "credentialsStorage", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "oneTimeLoginCredentialsProvider", "<init>", "(Lcom/voximplant/sdk/client/IClient;Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;Lcom/avito/android/calls/CredentialsStorage;Lcom/avito/android/util/SchedulersFactory3;)V", "LoginResult", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxSessionManager {
    public final PublishRelay<LoginResult> a = PublishRelay.create();
    public final IClient b;
    public final OneTimeLoginCredentialsProvider c;
    public final CredentialsStorage d;
    public final SchedulersFactory3 e;

    public static abstract class LoginResult {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult$LoginFailed;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "Lcom/voximplant/sdk/client/LoginError;", AuthSource.SEND_ABUSE, "Lcom/voximplant/sdk/client/LoginError;", "getLoginError", "()Lcom/voximplant/sdk/client/LoginError;", "loginError", "<init>", "(Lcom/voximplant/sdk/client/LoginError;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoginFailed extends LoginResult {
            @Nullable
            public final LoginError a;

            public LoginFailed(@Nullable LoginError loginError) {
                super(null);
                this.a = loginError;
            }

            @Nullable
            public final LoginError getLoginError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult$LoginSuccessful;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "Lcom/voximplant/sdk/client/AuthParams;", AuthSource.SEND_ABUSE, "Lcom/voximplant/sdk/client/AuthParams;", "getAuthParams", "()Lcom/voximplant/sdk/client/AuthParams;", "authParams", "<init>", "(Lcom/voximplant/sdk/client/AuthParams;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoginSuccessful extends LoginResult {
            @Nullable
            public final AuthParams a;

            public LoginSuccessful(@Nullable AuthParams authParams) {
                super(null);
                this.a = authParams;
            }

            @Nullable
            public final AuthParams getAuthParams() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult$OneTimeKeyGenerated;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class OneTimeKeyGenerated extends LoginResult {
            @Nullable
            public final String a;

            public OneTimeKeyGenerated(@Nullable String str) {
                super(null);
                this.a = str;
            }

            @Nullable
            public final String getKey() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult$RefreshTokenFailed;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "Lcom/voximplant/sdk/client/LoginError;", AuthSource.SEND_ABUSE, "Lcom/voximplant/sdk/client/LoginError;", "getLoginError", "()Lcom/voximplant/sdk/client/LoginError;", "loginError", "<init>", "(Lcom/voximplant/sdk/client/LoginError;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class RefreshTokenFailed extends LoginResult {
            @Nullable
            public final LoginError a;

            public RefreshTokenFailed(@Nullable LoginError loginError) {
                super(null);
                this.a = loginError;
            }

            @Nullable
            public final LoginError getLoginError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult$RefreshTokenSuccess;", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager$LoginResult;", "Lcom/voximplant/sdk/client/AuthParams;", AuthSource.SEND_ABUSE, "Lcom/voximplant/sdk/client/AuthParams;", "getAuthParams", "()Lcom/voximplant/sdk/client/AuthParams;", "authParams", "<init>", "(Lcom/voximplant/sdk/client/AuthParams;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class RefreshTokenSuccess extends LoginResult {
            @Nullable
            public final AuthParams a;

            public RefreshTokenSuccess(@Nullable AuthParams authParams) {
                super(null);
                this.a = authParams;
            }

            @Nullable
            public final AuthParams getAuthParams() {
                return this.a;
            }
        }

        public LoginResult() {
        }

        public LoginResult(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            LoginError.values();
            int[] iArr = new int[9];
            $EnumSwitchMapping$0 = iArr;
            iArr[7] = 1;
            iArr[6] = 2;
            iArr[8] = 3;
            iArr[3] = 4;
            LoginError.values();
            int[] iArr2 = new int[9];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[6] = 1;
            iArr2[8] = 2;
            iArr2[3] = 3;
            iArr2[7] = 4;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            int i = this.a;
            if (i == 0) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Login via name=[" + ((Credentials.Password) ((Credentials) this.c)).getName() + "], and password", null, 4, null);
                ((VoxSessionManager) this.b).b.login(((Credentials.Password) ((Credentials) this.c)).getName(), ((Credentials.Password) ((Credentials) this.c)).getPassword());
                return Unit.INSTANCE;
            } else if (i == 1) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Login via name=[" + ((Credentials.AccessToken) ((Credentials) this.c)).getName() + "] and access token", null, 4, null);
                ((VoxSessionManager) this.b).b.loginWithAccessToken(((Credentials.AccessToken) ((Credentials) this.c)).getName(), ((Credentials.AccessToken) ((Credentials) this.c)).getToken());
                return Unit.INSTANCE;
            } else if (i == 2) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Request one time key, name=[" + ((Credentials.OneTimeKey) ((Credentials) this.c)).getName() + ']', null, 4, null);
                ((VoxSessionManager) this.b).b.requestOneTimeKey(((Credentials.OneTimeKey) ((Credentials) this.c)).getName());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<LoginResult, CompletableSource> {
        public final /* synthetic */ VoxSessionManager a;

        public b(VoxSessionManager voxSessionManager) {
            this.a = voxSessionManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            if (loginResult2 instanceof LoginResult.LoginSuccessful) {
                return VoxSessionManager.access$onLoginSuccessful(this.a, ((LoginResult.LoginSuccessful) loginResult2).getAuthParams());
            }
            if (loginResult2 instanceof LoginResult.LoginFailed) {
                return VoxSessionManager.access$onLoginFailed(this.a, ((LoginResult.LoginFailed) loginResult2).getLoginError());
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid result. Expected - [Login*], actual - [");
            L.append(loginResult2.getClass().getSimpleName());
            L.append(']');
            return Completable.error(new CallClientException.InternalException(L.toString()));
        }
    }

    public static final class c<T, R> implements Function<Throwable, CompletableSource> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof CallClientException) {
                return Completable.error(th2);
            }
            return Completable.error(new CallClientException.AuthorizationException(th2));
        }
    }

    public static final class d<T, R> implements Function<LoginResult.OneTimeKeyGenerated, CompletableSource> {
        public final /* synthetic */ VoxSessionManager a;
        public final /* synthetic */ Credentials b;

        public d(VoxSessionManager voxSessionManager, Credentials credentials) {
            this.a = voxSessionManager;
            this.b = credentials;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(LoginResult.OneTimeKeyGenerated oneTimeKeyGenerated) {
            return VoxSessionManager.access$onOneTimeKeyGenerated(this.a, ((Credentials.OneTimeKey) this.b).getName(), oneTimeKeyGenerated.getKey());
        }
    }

    public static final class e<V> implements Callable<Object> {
        public final /* synthetic */ VoxSessionManager a;
        public final /* synthetic */ Credentials.AccessToken b;

        public e(VoxSessionManager voxSessionManager, Credentials.AccessToken accessToken) {
            this.a = voxSessionManager;
            this.b = accessToken;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.b.refreshToken(this.b.getName(), this.b.getRefreshToken());
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements Predicate<LoginResult> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            return (loginResult2 instanceof LoginResult.RefreshTokenSuccess) || (loginResult2 instanceof LoginResult.RefreshTokenFailed);
        }
    }

    public static final class g<T, R> implements Function<LoginResult, CompletableSource> {
        public final /* synthetic */ VoxSessionManager a;

        public g(VoxSessionManager voxSessionManager) {
            this.a = voxSessionManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            if (loginResult2 instanceof LoginResult.RefreshTokenSuccess) {
                return VoxSessionManager.access$onRefreshTokenSuccess(this.a, ((LoginResult.RefreshTokenSuccess) loginResult2).getAuthParams());
            }
            if (loginResult2 instanceof LoginResult.RefreshTokenFailed) {
                return VoxSessionManager.access$onRefreshTokenFailed(this.a, ((LoginResult.RefreshTokenFailed) loginResult2).getLoginError());
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid result. Expected - [Refresh*], actual - [");
            L.append(loginResult2.getClass().getSimpleName());
            L.append(']');
            return Completable.error(new CallClientException.InternalException(L.toString()));
        }
    }

    public static final class h<V> implements Callable<Object> {
        public final /* synthetic */ VoxSessionManager a;
        public final /* synthetic */ AuthParams b;

        public h(VoxSessionManager voxSessionManager, AuthParams authParams) {
            this.a = voxSessionManager;
            this.b = authParams;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            CredentialsStorage credentialsStorage = this.a.d;
            String accessToken = this.b.getAccessToken();
            Intrinsics.checkNotNullExpressionValue(accessToken, "authParams.accessToken");
            long accessTokenTimeExpired = (long) this.b.getAccessTokenTimeExpired();
            String refreshToken = this.b.getRefreshToken();
            Intrinsics.checkNotNullExpressionValue(refreshToken, "authParams.refreshToken");
            credentialsStorage.saveTokens(accessToken, accessTokenTimeExpired, refreshToken, (long) this.b.getRefreshTokenTimeExpired());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VoxSessionManager(@NotNull IClient iClient, @NotNull OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider, @NotNull CredentialsStorage credentialsStorage, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(iClient, "client");
        Intrinsics.checkNotNullParameter(oneTimeLoginCredentialsProvider, "oneTimeLoginCredentialsProvider");
        Intrinsics.checkNotNullParameter(credentialsStorage, "credentialsStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.b = iClient;
        this.c = oneTimeLoginCredentialsProvider;
        this.d = credentialsStorage;
        this.e = schedulersFactory3;
        iClient.setClientLoginListener(new IClientLoginListener(this) { // from class: com.avito.android.calls.voximplant.rx.core.VoxSessionManager$listener$1
            public final /* synthetic */ VoxSessionManager a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.voximplant.sdk.client.IClientLoginListener
            public void onLoginFailed(@Nullable LoginError loginError) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Login: failed, error=[" + loginError + ']', null, 4, null);
                this.a.a.accept(new VoxSessionManager.LoginResult.LoginFailed(loginError));
            }

            @Override // com.voximplant.sdk.client.IClientLoginListener
            public void onLoginSuccessful(@Nullable String str, @NotNull AuthParams authParams) {
                Intrinsics.checkNotNullParameter(authParams, "authParams");
                Logs.debug$default(LogTagsKt.TAG_IAC, "Login: successful, displayName=[" + str + "], authParams=[" + authParams + ']', null, 4, null);
                this.a.a.accept(new VoxSessionManager.LoginResult.LoginSuccessful(authParams));
            }

            @Override // com.voximplant.sdk.client.IClientLoginListener
            public void onOneTimeKeyGenerated(@Nullable String str) {
                Logs.debug$default(LogTagsKt.TAG_IAC, a.d3("One time key generated, key=[", str, ']'), null, 4, null);
                this.a.a.accept(new VoxSessionManager.LoginResult.OneTimeKeyGenerated(str));
            }

            @Override // com.voximplant.sdk.client.IClientLoginListener
            public void onRefreshTokenFailed(@Nullable LoginError loginError) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Refresh token: failed, error=[" + loginError + ']', null, 4, null);
                this.a.a.accept(new VoxSessionManager.LoginResult.RefreshTokenFailed(loginError));
            }

            @Override // com.voximplant.sdk.client.IClientLoginListener
            public void onRefreshTokenSuccess(@Nullable AuthParams authParams) {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Refresh token: success, authParams=[" + authParams + ']', null, 4, null);
                this.a.a.accept(new VoxSessionManager.LoginResult.RefreshTokenSuccess(authParams));
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r2 != 8) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.core.Completable access$onLoginFailed(com.avito.android.calls.voximplant.rx.core.VoxSessionManager r1, com.voximplant.sdk.client.LoginError r2) {
        /*
            java.util.Objects.requireNonNull(r1)
            if (r2 != 0) goto L_0x0006
            goto L_0x0017
        L_0x0006:
            int r2 = r2.ordinal()
            r0 = 3
            if (r2 == r0) goto L_0x003f
            r0 = 6
            if (r2 == r0) goto L_0x003f
            r0 = 7
            if (r2 == r0) goto L_0x0027
            r1 = 8
            if (r2 == r1) goto L_0x003f
        L_0x0017:
            com.avito.android.calls.voximplant.rx.core.CallClientException$LoginFailedException r1 = new com.avito.android.calls.voximplant.rx.core.CallClientException$LoginFailedException
            r2 = 0
            r1.<init>(r2)
            io.reactivex.rxjava3.core.Completable r1 = io.reactivex.rxjava3.core.Completable.error(r1)
            java.lang.String r2 = "Completable.error(CallCl…ption(needRetry = false))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x004e
        L_0x0027:
            a2.a.a.z.a.g.q.a r2 = new a2.a.a.z.a.g.q.a
            r2.<init>(r1)
            io.reactivex.rxjava3.core.Single r2 = io.reactivex.rxjava3.core.Single.fromCallable(r2)
            a2.a.a.z.a.g.q.b r0 = new a2.a.a.z.a.g.q.b
            r0.<init>(r1)
            io.reactivex.rxjava3.core.Completable r1 = r2.flatMapCompletable(r0)
            java.lang.String r2 = "Single.fromCallable {\n  …      }\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x004e
        L_0x003f:
            com.avito.android.calls.voximplant.rx.core.CallClientException$LoginFailedException r1 = new com.avito.android.calls.voximplant.rx.core.CallClientException$LoginFailedException
            r2 = 1
            r1.<init>(r2)
            io.reactivex.rxjava3.core.Completable r1 = io.reactivex.rxjava3.core.Completable.error(r1)
            java.lang.String r2 = "Completable.error(CallCl…eption(needRetry = true))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.rx.core.VoxSessionManager.access$onLoginFailed(com.avito.android.calls.voximplant.rx.core.VoxSessionManager, com.voximplant.sdk.client.LoginError):io.reactivex.rxjava3.core.Completable");
    }

    public static final Completable access$onLoginSuccessful(VoxSessionManager voxSessionManager, AuthParams authParams) {
        return voxSessionManager.c(authParams);
    }

    public static final Completable access$onOneTimeKeyGenerated(VoxSessionManager voxSessionManager, String str, String str2) {
        Objects.requireNonNull(voxSessionManager);
        if (str2 != null) {
            Completable flatMapCompletable = InteropKt.toV3(voxSessionManager.c.getOneTimeLoginKey(str2)).flatMapCompletable(new a2.a.a.z.a.g.q.d(voxSessionManager, str));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "oneTimeLoginCredentialsP…      )\n                }");
            return flatMapCompletable;
        }
        Completable error = Completable.error(new CallClientException.InvalidOneTimeKeyException());
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(CallCl…lidOneTimeKeyException())");
        return error;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r5 != 8) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.core.Completable access$onRefreshTokenFailed(com.avito.android.calls.voximplant.rx.core.VoxSessionManager r4, com.voximplant.sdk.client.LoginError r5) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onRefreshTokenFailed, error = ["
            r0.append(r1)
            r0.append(r5)
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r2 = 4
            java.lang.String r3 = "IAC"
            com.avito.android.util.Logs.debug$default(r3, r0, r1, r2, r1)
            if (r5 != 0) goto L_0x0023
            goto L_0x0035
        L_0x0023:
            int r5 = r5.ordinal()
            r0 = 3
            r1 = 1
            if (r5 == r0) goto L_0x0061
            r0 = 6
            if (r5 == r0) goto L_0x0061
            r0 = 7
            if (r5 == r0) goto L_0x0045
            r4 = 8
            if (r5 == r4) goto L_0x0061
        L_0x0035:
            com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException r4 = new com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException
            r5 = 0
            r4.<init>(r5)
            io.reactivex.rxjava3.core.Completable r4 = io.reactivex.rxjava3.core.Completable.error(r4)
            java.lang.String r5 = "Completable.error(CallCl…ption(needRetry = false))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            goto L_0x006f
        L_0x0045:
            a2.a.a.z.a.g.q.e r5 = new a2.a.a.z.a.g.q.e
            r5.<init>(r4)
            io.reactivex.rxjava3.core.Completable r4 = io.reactivex.rxjava3.core.Completable.fromAction(r5)
            com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException r5 = new com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException
            r5.<init>(r1)
            io.reactivex.rxjava3.core.Completable r5 = io.reactivex.rxjava3.core.Completable.error(r5)
            io.reactivex.rxjava3.core.Completable r4 = r4.andThen(r5)
            java.lang.String r5 = "Completable.fromAction {…ption(needRetry = true)))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            goto L_0x006f
        L_0x0061:
            com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException r4 = new com.avito.android.calls.voximplant.rx.core.CallClientException$RefreshTokenFailedException
            r4.<init>(r1)
            io.reactivex.rxjava3.core.Completable r4 = io.reactivex.rxjava3.core.Completable.error(r4)
            java.lang.String r5 = "Completable.error(CallCl…eption(needRetry = true))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x006f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.rx.core.VoxSessionManager.access$onRefreshTokenFailed(com.avito.android.calls.voximplant.rx.core.VoxSessionManager, com.voximplant.sdk.client.LoginError):io.reactivex.rxjava3.core.Completable");
    }

    public static final Completable access$onRefreshTokenSuccess(VoxSessionManager voxSessionManager, AuthParams authParams) {
        Completable flatMapCompletable = voxSessionManager.c(authParams).andThen(Single.fromCallable(new a2.a.a.z.a.g.q.f(voxSessionManager))).flatMapCompletable(new a2.a.a.z.a.g.q.g(voxSessionManager));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "saveAuthParamsToStorage(…entials(it)\n            }");
        return flatMapCompletable;
    }

    public final Completable a(Credentials credentials) {
        Completable completable;
        if (Intrinsics.areEqual(credentials, Credentials.None.INSTANCE)) {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Error, credentials wasn't found", null, 4, null);
            Completable error = Completable.error(new CallClientException.InvalidCredentialsException("Credentials wasn't found"));
            Intrinsics.checkNotNullExpressionValue(error, "Completable.error(CallCl…edentials wasn't found\"))");
            return error;
        } else if (credentials instanceof Credentials.Password) {
            Completable fromCallable = Completable.fromCallable(new a(0, this, credentials));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…ssword)\n                }");
            return fromCallable;
        } else if (credentials instanceof Credentials.AccessToken) {
            Credentials.AccessToken accessToken = (Credentials.AccessToken) credentials;
            if (accessToken.getToken() != null) {
                completable = Completable.fromCallable(new a(1, this, credentials));
            } else {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Token wasn't found, try to refresh", null, 4, null);
                completable = b(accessToken);
            }
            Intrinsics.checkNotNullExpressionValue(completable, "if (credentials.token !=…ntials)\n                }");
            return completable;
        } else if (credentials instanceof Credentials.OneTimeKey) {
            Completable flatMapCompletable = Completable.fromCallable(new a(2, this, credentials)).andThen(this.a.ofType(LoginResult.OneTimeKeyGenerated.class).firstOrError().timeout(5000, TimeUnit.MILLISECONDS)).flatMapCompletable(new d(this, credentials));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Completable.fromCallable…ey)\n                    }");
            return flatMapCompletable;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final Completable b(Credentials.AccessToken accessToken) {
        Completable flatMapCompletable = Completable.fromCallable(new e(this, accessToken)).andThen(this.a.filter(f.a).firstOrError().timeout(5000, TimeUnit.MILLISECONDS)).flatMapCompletable(new g(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Completable.fromCallable…          }\n            }");
        return flatMapCompletable;
    }

    public final Completable c(AuthParams authParams) {
        if (authParams != null) {
            String accessToken = authParams.getAccessToken();
            boolean z = false;
            if (!(accessToken == null || m.isBlank(accessToken))) {
                String refreshToken = authParams.getRefreshToken();
                if (!(refreshToken == null || m.isBlank(refreshToken))) {
                    z = true;
                }
            }
            if (z) {
                Completable fromCallable = Completable.fromCallable(new h(this, authParams));
                Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…          )\n            }");
                return fromCallable;
            }
        }
        Completable error = Completable.error(new CallClientException.BadParamsException());
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(CallCl…ion.BadParamsException())");
        return error;
    }

    @NotNull
    public final Completable login(@NotNull Credentials credentials) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Completable retryWhen = a(credentials).andThen(this.a.firstOrError().timeout(5000, TimeUnit.MILLISECONDS)).flatMapCompletable(new b(this)).onErrorResumeNext(c.a).retryWhen(CallClientUtilsKt.exponentialRetryCallRequest$default(this.e.computation(), null, 2, null));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "loginWithCredentials(cre…          )\n            )");
        return retryWhen;
    }
}
