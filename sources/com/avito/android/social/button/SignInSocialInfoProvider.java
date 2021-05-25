package com.avito.android.social.button;

import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.IsSocialNetwork;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.R;
import com.avito.android.social.VkontakteSocialManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/social/button/SignInSocialInfoProvider;", "Lcom/avito/android/social/button/SocialInfoProvider;", "Lcom/avito/android/social/IsSocialNetwork;", "socialManager", "", "isRoundButton", "Lcom/avito/android/social/button/SocialInfo;", "provide", "(Lcom/avito/android/social/IsSocialNetwork;Z)Lcom/avito/android/social/button/SocialInfo;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class SignInSocialInfoProvider implements SocialInfoProvider {
    @Override // com.avito.android.social.button.SocialInfoProvider
    @NotNull
    public SocialInfo provide(@NotNull IsSocialNetwork isSocialNetwork, boolean z) {
        Intrinsics.checkNotNullParameter(isSocialNetwork, "socialManager");
        if (isSocialNetwork instanceof FacebookSocialManager) {
            return new SocialInfo(R.drawable.bg_btn_raised_sign_in_fb, R.drawable.ic_facebook_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        }
        if (isSocialNetwork instanceof VkontakteSocialManager) {
            return new SocialInfo(R.drawable.bg_btn_raised_sign_in_vk, R.drawable.ic_vk_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        }
        if (isSocialNetwork instanceof OdnoklassnikiSocialManager) {
            return new SocialInfo(R.drawable.bg_btn_raised_sign_in_ok, R.drawable.ic_odnoklassniki_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        }
        if (isSocialNetwork instanceof GoogleSocialManager) {
            return new SocialInfo(R.drawable.bg_btn_raised_sign_in_gp, R.drawable.ic_google_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        }
        if (isSocialNetwork instanceof AppleSignInManager) {
            return new SocialInfo(R.drawable.bg_btn_raised_sign_in_ap, R.drawable.ic_apple_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_white));
        }
        throw new RuntimeException("Unknown " + isSocialNetwork);
    }
}
