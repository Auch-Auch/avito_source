package com.avito.android.advert_core.social;

import com.avito.android.analytics.Analytics;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.MailSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.TwitterSocialManager;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.button.ShareSocialInfoProvider;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.social.di.SocialModule;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JW\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/social/ShareModule;", "", "Lcom/avito/android/social/FacebookSocialManager;", "facebookSocialManager", "Lcom/avito/android/social/LiveJournalSocialManager;", "liveJournalSocialManager", "Lcom/avito/android/social/MailSocialManager;", "mailSocialManager", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "odnoklassnikiSocialManager", "Lcom/avito/android/social/TwitterSocialManager;", "twitterSocialManager", "Lcom/avito/android/social/VkontakteSocialManager;", "vkontakteSocialManager", "Lcom/avito/android/social/button/SocialInfoProvider;", "socialInfoProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/advert_core/social/SocialPresenter;", "provideSocialPresenter", "(Lcom/avito/android/social/FacebookSocialManager;Lcom/avito/android/social/LiveJournalSocialManager;Lcom/avito/android/social/MailSocialManager;Lcom/avito/android/social/OdnoklassnikiSocialManager;Lcom/avito/android/social/TwitterSocialManager;Lcom/avito/android/social/VkontakteSocialManager;Lcom/avito/android/social/button/SocialInfoProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/social/SocialTypeToStringMapper;)Lcom/avito/android/advert_core/social/SocialPresenter;", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SocialModule.class, Declarations.class})
public final class ShareModule {
    @NotNull
    public static final ShareModule INSTANCE = new ShareModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/social/ShareModule$Declarations;", "", "Lcom/avito/android/social/button/ShareSocialInfoProvider;", GeoContract.PROVIDER, "Lcom/avito/android/social/button/SocialInfoProvider;", "bindSocialInfoProvider", "(Lcom/avito/android/social/button/ShareSocialInfoProvider;)Lcom/avito/android/social/button/SocialInfoProvider;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        SocialInfoProvider bindSocialInfoProvider(@NotNull ShareSocialInfoProvider shareSocialInfoProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SocialPresenter provideSocialPresenter(@NotNull FacebookSocialManager facebookSocialManager, @NotNull LiveJournalSocialManager liveJournalSocialManager, @NotNull MailSocialManager mailSocialManager, @NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull TwitterSocialManager twitterSocialManager, @NotNull VkontakteSocialManager vkontakteSocialManager, @NotNull SocialInfoProvider socialInfoProvider, @NotNull Analytics analytics, @NotNull SocialTypeToStringMapper socialTypeToStringMapper) {
        Intrinsics.checkNotNullParameter(facebookSocialManager, "facebookSocialManager");
        Intrinsics.checkNotNullParameter(liveJournalSocialManager, "liveJournalSocialManager");
        Intrinsics.checkNotNullParameter(mailSocialManager, "mailSocialManager");
        Intrinsics.checkNotNullParameter(odnoklassnikiSocialManager, "odnoklassnikiSocialManager");
        Intrinsics.checkNotNullParameter(twitterSocialManager, "twitterSocialManager");
        Intrinsics.checkNotNullParameter(vkontakteSocialManager, "vkontakteSocialManager");
        Intrinsics.checkNotNullParameter(socialInfoProvider, "socialInfoProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper, "socialTypeToStringMapper");
        return new SocialPresenterImpl(CollectionsKt__CollectionsKt.listOf((Object[]) new SharingManager[]{vkontakteSocialManager, odnoklassnikiSocialManager, facebookSocialManager, twitterSocialManager, mailSocialManager, liveJournalSocialManager}), socialInfoProvider, analytics, socialTypeToStringMapper);
    }
}
