package com.avito.android.authorization.auth.di;

import com.avito.android.Features;
import com.avito.android.authorization.auth.AuthInteractor;
import com.avito.android.authorization.auth.AuthInteractorImpl;
import com.avito.android.authorization.auth.AuthPresenter;
import com.avito.android.authorization.auth.AuthPresenterImpl;
import com.avito.android.authorization.auth.AuthResourceProvider;
import com.avito.android.authorization.auth.AuthResourceProviderImpl;
import com.avito.android.authorization.smart_lock.di.SmartLockLoaderModule;
import com.avito.android.di.PerActivity;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SignInManager;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.button.SignInSocialInfoProvider;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.social.di.SocialModule;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/authorization/auth/di/AuthModule;", "", "Lcom/avito/android/social/FacebookSocialManager;", "facebookSocialManager", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "odnoklassnikiSocialManager", "Lcom/avito/android/social/VkontakteSocialManager;", "vkontakteSocialManager", "Lcom/avito/android/social/GoogleSocialManager;", "googleSocialManager", "Lcom/avito/android/social/AppleSignInManager;", "appleSignInManager", "Lcom/avito/android/Features;", "features", "Ljava/util/ArrayList;", "Lcom/avito/android/social/SignInManager;", "Lkotlin/collections/ArrayList;", "provideSocialManagers", "(Lcom/avito/android/social/FacebookSocialManager;Lcom/avito/android/social/OdnoklassnikiSocialManager;Lcom/avito/android/social/VkontakteSocialManager;Lcom/avito/android/social/GoogleSocialManager;Lcom/avito/android/social/AppleSignInManager;Lcom/avito/android/Features;)Ljava/util/ArrayList;", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SocialModule.class, SmartLockLoaderModule.class, Declarations.class})
public final class AuthModule {
    @NotNull
    public static final AuthModule INSTANCE = new AuthModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/authorization/auth/di/AuthModule$Declarations;", "", "Lcom/avito/android/authorization/auth/AuthPresenterImpl;", "presenter", "Lcom/avito/android/authorization/auth/AuthPresenter;", "bindAuthPresenter", "(Lcom/avito/android/authorization/auth/AuthPresenterImpl;)Lcom/avito/android/authorization/auth/AuthPresenter;", "Lcom/avito/android/authorization/auth/AuthInteractorImpl;", "interactor", "Lcom/avito/android/authorization/auth/AuthInteractor;", "bindAuthInteractor", "(Lcom/avito/android/authorization/auth/AuthInteractorImpl;)Lcom/avito/android/authorization/auth/AuthInteractor;", "Lcom/avito/android/social/button/SignInSocialInfoProvider;", GeoContract.PROVIDER, "Lcom/avito/android/social/button/SocialInfoProvider;", "bindSocialInfoProvider", "(Lcom/avito/android/social/button/SignInSocialInfoProvider;)Lcom/avito/android/social/button/SocialInfoProvider;", "Lcom/avito/android/authorization/auth/AuthResourceProviderImpl;", "Lcom/avito/android/authorization/auth/AuthResourceProvider;", "bindAuthResourceProvider", "(Lcom/avito/android/authorization/auth/AuthResourceProviderImpl;)Lcom/avito/android/authorization/auth/AuthResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AuthInteractor bindAuthInteractor(@NotNull AuthInteractorImpl authInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        AuthPresenter bindAuthPresenter(@NotNull AuthPresenterImpl authPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        AuthResourceProvider bindAuthResourceProvider(@NotNull AuthResourceProviderImpl authResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        SocialInfoProvider bindSocialInfoProvider(@NotNull SignInSocialInfoProvider signInSocialInfoProvider);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003d: APUT  
      (r1v1 com.avito.android.social.SignInManager[])
      (2 ??[int, float, short, byte, char])
      (r7v1 com.avito.android.social.AppleSignInManager)
     */
    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ArrayList<SignInManager> provideSocialManagers(@NotNull FacebookSocialManager facebookSocialManager, @NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull VkontakteSocialManager vkontakteSocialManager, @NotNull GoogleSocialManager googleSocialManager, @NotNull AppleSignInManager appleSignInManager, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(facebookSocialManager, "facebookSocialManager");
        Intrinsics.checkNotNullParameter(odnoklassnikiSocialManager, "odnoklassnikiSocialManager");
        Intrinsics.checkNotNullParameter(vkontakteSocialManager, "vkontakteSocialManager");
        Intrinsics.checkNotNullParameter(googleSocialManager, "googleSocialManager");
        Intrinsics.checkNotNullParameter(appleSignInManager, "appleSignInManager");
        Intrinsics.checkNotNullParameter(features, "features");
        SignInManager[] signInManagerArr = new SignInManager[5];
        signInManagerArr[0] = vkontakteSocialManager;
        signInManagerArr[1] = odnoklassnikiSocialManager;
        if (!features.getSignInWithApple().invoke().booleanValue()) {
            appleSignInManager = null;
        }
        signInManagerArr[2] = appleSignInManager;
        signInManagerArr[3] = facebookSocialManager;
        if (!googleSocialManager.isAvailable()) {
            googleSocialManager = null;
        }
        signInManagerArr[4] = googleSocialManager;
        return new ArrayList<>(CollectionsKt__CollectionsKt.listOfNotNull((Object[]) signInManagerArr));
    }
}
