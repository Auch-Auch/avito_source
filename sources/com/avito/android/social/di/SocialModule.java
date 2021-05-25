package com.avito.android.social.di;

import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.AppleSignInManagerImpl;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.EsiaSignInManagerImpl;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.GoogleSocialManagerImpl;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.LiveJournalSocialManagerImpl;
import com.avito.android.social.MailSocialManager;
import com.avito.android.social.MailSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.TwitterSocialManager;
import com.avito.android.social.TwitterSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020$H'¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/avito/android/social/di/SocialModule;", "", "Lcom/avito/android/social/GoogleSocialManagerImpl;", "value", "Lcom/avito/android/social/GoogleSocialManager;", "bindsGoogleSocialManager", "(Lcom/avito/android/social/GoogleSocialManagerImpl;)Lcom/avito/android/social/GoogleSocialManager;", "Lcom/avito/android/social/FacebookSocialManagerImpl;", "Lcom/avito/android/social/FacebookSocialManager;", "bindsFacebookSocialManager", "(Lcom/avito/android/social/FacebookSocialManagerImpl;)Lcom/avito/android/social/FacebookSocialManager;", "Lcom/avito/android/social/OdnoklassnikiSocialManagerImpl;", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "bindsOdnoklassnikiSocialManager", "(Lcom/avito/android/social/OdnoklassnikiSocialManagerImpl;)Lcom/avito/android/social/OdnoklassnikiSocialManager;", "Lcom/avito/android/social/VkontakteSocialManagerImpl;", "Lcom/avito/android/social/VkontakteSocialManager;", "bindsVkontakteSocialManager", "(Lcom/avito/android/social/VkontakteSocialManagerImpl;)Lcom/avito/android/social/VkontakteSocialManager;", "Lcom/avito/android/social/TwitterSocialManagerImpl;", "Lcom/avito/android/social/TwitterSocialManager;", "bindsTwitterSocialManager", "(Lcom/avito/android/social/TwitterSocialManagerImpl;)Lcom/avito/android/social/TwitterSocialManager;", "Lcom/avito/android/social/LiveJournalSocialManagerImpl;", "Lcom/avito/android/social/LiveJournalSocialManager;", "bindsLiveJournalSocialManager", "(Lcom/avito/android/social/LiveJournalSocialManagerImpl;)Lcom/avito/android/social/LiveJournalSocialManager;", "Lcom/avito/android/social/MailSocialManagerImpl;", "Lcom/avito/android/social/MailSocialManager;", "bindsMailSocialManager", "(Lcom/avito/android/social/MailSocialManagerImpl;)Lcom/avito/android/social/MailSocialManager;", "Lcom/avito/android/social/EsiaSignInManagerImpl;", "impl", "Lcom/avito/android/social/EsiaSignInManager;", "bindEsiaSocialManager", "(Lcom/avito/android/social/EsiaSignInManagerImpl;)Lcom/avito/android/social/EsiaSignInManager;", "Lcom/avito/android/social/AppleSignInManagerImpl;", "Lcom/avito/android/social/AppleSignInManager;", "bindsAppleSocialManager", "(Lcom/avito/android/social/AppleSignInManagerImpl;)Lcom/avito/android/social/AppleSignInManager;", "social_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SocialModule {
    @Reusable
    @Binds
    @NotNull
    EsiaSignInManager bindEsiaSocialManager(@NotNull EsiaSignInManagerImpl esiaSignInManagerImpl);

    @Reusable
    @Binds
    @NotNull
    AppleSignInManager bindsAppleSocialManager(@NotNull AppleSignInManagerImpl appleSignInManagerImpl);

    @Reusable
    @Binds
    @NotNull
    FacebookSocialManager bindsFacebookSocialManager(@NotNull FacebookSocialManagerImpl facebookSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    GoogleSocialManager bindsGoogleSocialManager(@NotNull GoogleSocialManagerImpl googleSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    LiveJournalSocialManager bindsLiveJournalSocialManager(@NotNull LiveJournalSocialManagerImpl liveJournalSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    MailSocialManager bindsMailSocialManager(@NotNull MailSocialManagerImpl mailSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    OdnoklassnikiSocialManager bindsOdnoklassnikiSocialManager(@NotNull OdnoklassnikiSocialManagerImpl odnoklassnikiSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    TwitterSocialManager bindsTwitterSocialManager(@NotNull TwitterSocialManagerImpl twitterSocialManagerImpl);

    @Reusable
    @Binds
    @NotNull
    VkontakteSocialManager bindsVkontakteSocialManager(@NotNull VkontakteSocialManagerImpl vkontakteSocialManagerImpl);
}
