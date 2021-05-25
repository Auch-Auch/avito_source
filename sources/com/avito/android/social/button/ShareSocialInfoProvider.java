package com.avito.android.social.button;

import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.IsSocialNetwork;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.MailSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.R;
import com.avito.android.social.TwitterSocialManager;
import com.avito.android.social.VkontakteSocialManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/social/button/ShareSocialInfoProvider;", "Lcom/avito/android/social/button/SocialInfoProvider;", "Lcom/avito/android/social/IsSocialNetwork;", "socialManager", "", "isRoundButton", "Lcom/avito/android/social/button/SocialInfo;", "provide", "(Lcom/avito/android/social/IsSocialNetwork;Z)Lcom/avito/android/social/button/SocialInfo;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class ShareSocialInfoProvider implements SocialInfoProvider {
    @Override // com.avito.android.social.button.SocialInfoProvider
    @NotNull
    public SocialInfo provide(@NotNull IsSocialNetwork isSocialNetwork, boolean z) {
        SocialInfo socialInfo;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(isSocialNetwork, "socialManager");
        if (isSocialNetwork instanceof FacebookSocialManager) {
            if (z) {
                i6 = R.drawable.bg_btn_round_share_fb;
            } else {
                i6 = R.drawable.bg_btn_raised_share_fb;
            }
            socialInfo = new SocialInfo(i6, R.drawable.ic_facebook_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        } else if (isSocialNetwork instanceof VkontakteSocialManager) {
            if (z) {
                i5 = R.drawable.bg_btn_round_share_vk;
            } else {
                i5 = R.drawable.bg_btn_raised_share_vk;
            }
            socialInfo = new SocialInfo(i5, R.drawable.ic_vk_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        } else if (isSocialNetwork instanceof OdnoklassnikiSocialManager) {
            if (z) {
                i4 = R.drawable.bg_btn_round_share_ok;
            } else {
                i4 = R.drawable.bg_btn_raised_share_ok;
            }
            socialInfo = new SocialInfo(i4, R.drawable.ic_odnoklassniki_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        } else if (isSocialNetwork instanceof TwitterSocialManager) {
            if (z) {
                i3 = R.drawable.bg_btn_round_share_tw;
            } else {
                i3 = R.drawable.bg_btn_raised_share_tw;
            }
            socialInfo = new SocialInfo(i3, R.drawable.ic_twitter_24, Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        } else if (isSocialNetwork instanceof LiveJournalSocialManager) {
            if (z) {
                i2 = R.drawable.bg_btn_round_share_lj;
            } else {
                i2 = R.drawable.bg_btn_raised_share_lj;
            }
            socialInfo = new SocialInfo(i2, R.drawable.ic_btn_raised_share_lj, null, 4, null);
        } else if (isSocialNetwork instanceof MailSocialManager) {
            if (z) {
                i = R.drawable.bg_btn_round_share_mr;
            } else {
                i = R.drawable.bg_btn_raised_share_mr;
            }
            socialInfo = new SocialInfo(i, R.drawable.ic_btn_raised_share_mr, null, 4, null);
        } else {
            throw new RuntimeException("Unknown " + isSocialNetwork);
        }
        return socialInfo;
    }
}
