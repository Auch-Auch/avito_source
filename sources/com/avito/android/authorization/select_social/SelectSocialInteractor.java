package com.avito.android.authorization.select_social;

import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "", "Lio/reactivex/Observable;", "", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField;", "loadItems", "()Lio/reactivex/Observable;", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "suggestKey", "Lcom/avito/android/remote/model/SocialAuthResult;", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "user", "loginWithApple", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SelectSocialInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable login$default(SelectSocialInteractor selectSocialInteractor, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return selectSocialInteractor.login(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Observable loginWithApple$default(SelectSocialInteractor selectSocialInteractor, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return selectSocialInteractor.loginWithApple(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginWithApple");
        }
    }

    @NotNull
    Observable<List<SelectSocialField>> loadItems();

    @NotNull
    Observable<SocialAuthResult> login(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4);

    @NotNull
    Observable<SocialAuthResult> loginWithApple(@NotNull String str, @Nullable String str2, @Nullable String str3);
}
