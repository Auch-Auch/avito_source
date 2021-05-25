package com.avito.android.account;

import com.avito.android.account.Credentials;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00072\u0006\u0010\u0003\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\u000eJ+\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00072\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u0011J%\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/avito/android/account/AccountInteractor;", "", "Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "credentials", "", "socialId", "suggestKey", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SocialAuthResult;", "login", "(Lcom/avito/android/account/Credentials$SignInServiceCredentials;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/account/Credentials$PasswordCredentials;", "Lcom/avito/android/remote/model/LoginResult;", "(Lcom/avito/android/account/Credentials$PasswordCredentials;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "tfaCode", "userName", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "isUserAction", "source", "Lio/reactivex/rxjava3/core/Completable;", "logout", "(ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "socialType", "Lcom/avito/android/remote/model/AuthResult;", "createProfile", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface AccountInteractor {
    @NotNull
    Observable<LoadingState<AuthResult>> createProfile(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<LoginResult>> login(@NotNull Credentials.PasswordCredentials passwordCredentials, @Nullable String str);

    @NotNull
    Observable<LoadingState<SocialAuthResult>> login(@NotNull Credentials.SignInServiceCredentials signInServiceCredentials, @Nullable String str, @Nullable String str2);

    @NotNull
    Observable<LoadingState<LoginResult>> login(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable logout(boolean z, @Nullable String str);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable login$default(AccountInteractor accountInteractor, Credentials.SignInServiceCredentials signInServiceCredentials, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return accountInteractor.login(signInServiceCredentials, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Completable logout$default(AccountInteractor accountInteractor, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                return accountInteractor.logout(z, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
        }

        public static /* synthetic */ Observable login$default(AccountInteractor accountInteractor, Credentials.PasswordCredentials passwordCredentials, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return accountInteractor.login(passwordCredentials, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }
    }
}
