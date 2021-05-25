package com.avito.android.social;

import com.avito.android.social.SignInManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/social/EsiaSignInManager;", "Lcom/avito/android/social/SignInManager;", "Lcom/avito/android/social/SocialType;", "getType", "()Lcom/avito/android/social/SocialType;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface EsiaSignInManager extends SignInManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static String getEmail(@NotNull EsiaSignInManager esiaSignInManager) {
            return SignInManager.DefaultImpls.getEmail(esiaSignInManager);
        }

        @NotNull
        public static SocialType getType(@NotNull EsiaSignInManager esiaSignInManager) {
            return SocialType.ESIA;
        }

        public static boolean hasToken(@NotNull EsiaSignInManager esiaSignInManager) {
            return SignInManager.DefaultImpls.hasToken(esiaSignInManager);
        }
    }

    @Override // com.avito.android.social.IsSocialNetwork
    @NotNull
    SocialType getType();
}
