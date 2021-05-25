package com.avito.android.social.di;

import android.os.Bundle;
import com.avito.android.di.PerActivity;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SocialActivityPresenter;
import com.avito.android.social.SocialActivityPresenterImpl;
import com.avito.android.social.VkontakteSocialManager;
import dagger.Module;
import dagger.Provides;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/social/di/SocialActivityModule;", "", "Lcom/avito/android/social/FacebookSocialManager;", "facebookSocialManager", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "odnoklassnikiSocialManager", "Lcom/avito/android/social/VkontakteSocialManager;", "vkontakteSocialManager", "Lcom/avito/android/social/GoogleSocialManager;", "googleSocialManager", "Lcom/avito/android/social/AppleSignInManager;", "appleSignInManager", "Lcom/avito/android/social/EsiaSignInManager;", "esiaSignInManager", "Landroid/os/Bundle;", "presenterState", "Lcom/avito/android/social/SocialActivityPresenter;", "provideSocialActivityPresenter", "(Lcom/avito/android/social/FacebookSocialManager;Lcom/avito/android/social/OdnoklassnikiSocialManager;Lcom/avito/android/social/VkontakteSocialManager;Lcom/avito/android/social/GoogleSocialManager;Lcom/avito/android/social/AppleSignInManager;Lcom/avito/android/social/EsiaSignInManager;Landroid/os/Bundle;)Lcom/avito/android/social/SocialActivityPresenter;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SocialModule.class})
public final class SocialActivityModule {
    @NotNull
    public static final SocialActivityModule INSTANCE = new SocialActivityModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SocialActivityPresenter provideSocialActivityPresenter(@NotNull FacebookSocialManager facebookSocialManager, @NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull VkontakteSocialManager vkontakteSocialManager, @NotNull GoogleSocialManager googleSocialManager, @NotNull AppleSignInManager appleSignInManager, @NotNull EsiaSignInManager esiaSignInManager, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(facebookSocialManager, "facebookSocialManager");
        Intrinsics.checkNotNullParameter(odnoklassnikiSocialManager, "odnoklassnikiSocialManager");
        Intrinsics.checkNotNullParameter(vkontakteSocialManager, "vkontakteSocialManager");
        Intrinsics.checkNotNullParameter(googleSocialManager, "googleSocialManager");
        Intrinsics.checkNotNullParameter(appleSignInManager, "appleSignInManager");
        Intrinsics.checkNotNullParameter(esiaSignInManager, "esiaSignInManager");
        List asList = Arrays.asList(vkontakteSocialManager, odnoklassnikiSocialManager, appleSignInManager, facebookSocialManager, esiaSignInManager, googleSocialManager);
        Intrinsics.checkNotNullExpressionValue(asList, "asList<SignInManager>(\n …cialManager\n            )");
        return new SocialActivityPresenterImpl(asList, bundle);
    }
}
