package com.avito.android.account;

import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.rxjava3.core.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/account/AccountUpdateInteractor;", "", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "Lcom/avito/android/remote/model/ProfileInfo;", "profile", "", "source", "Lio/reactivex/rxjava3/core/Completable;", "login", "(Lcom/avito/android/remote/model/Session;Lcom/avito/android/remote/model/ProfileInfo;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "", "isUserAction", "logout", "(ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "", "error", "", "notifyLoginError", "(Ljava/lang/Throwable;)V", "notifyLogoutError", "AccountStateUpdatedListener", "UserLoggedListener", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface AccountUpdateInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/account/AccountUpdateInteractor$AccountStateUpdatedListener;", "", "", "onAccountStateUpdated", "()V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public interface AccountStateUpdatedListener {
        void onAccountStateUpdated();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable login$default(AccountUpdateInteractor accountUpdateInteractor, Session session, ProfileInfo profileInfo, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = null;
                }
                return accountUpdateInteractor.login(session, profileInfo, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Completable logout$default(AccountUpdateInteractor accountUpdateInteractor, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return accountUpdateInteractor.logout(z, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/account/AccountUpdateInteractor$UserLoggedListener;", "", "", ChannelContext.Item.USER_ID, "", "onUserLogged", "(Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public interface UserLoggedListener {
        void onUserLogged(@NotNull String str);
    }

    @NotNull
    Completable login(@NotNull Session session, @NotNull ProfileInfo profileInfo, @Nullable String str);

    @NotNull
    Completable logout(boolean z, @Nullable String str);

    void notifyLoginError(@NotNull Throwable th);

    void notifyLogoutError(@NotNull Throwable th);
}
