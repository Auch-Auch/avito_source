package com.avito.android.authorization.auth;

import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0013J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/auth/AuthInteractor;", "", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "socialId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SocialAuthResult;", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "user", "loginWithApple", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "src", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/authorization/auth/AuthInteractor$FastLogin;", "checkFastLogin", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Maybe;", "FastLogin", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface AuthInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Maybe checkFastLogin$default(AuthInteractor authInteractor, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return authInteractor.checkFastLogin(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkFastLogin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/authorization/auth/AuthInteractor$FastLogin;", "", "<init>", "(Ljava/lang/String;I)V", "SMART_LOCK", "SUGGESTS", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public enum FastLogin {
        SMART_LOCK,
        SUGGESTS
    }

    @NotNull
    Maybe<FastLogin> checkFastLogin(@Nullable String str);

    @NotNull
    Observable<SocialAuthResult> login(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4);

    @NotNull
    Observable<SocialAuthResult> loginWithApple(@NotNull String str, @Nullable String str2, @Nullable String str3);
}
