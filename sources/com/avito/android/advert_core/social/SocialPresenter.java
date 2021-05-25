package com.avito.android.advert_core.social;

import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInSocialManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ#\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ#\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert_core/social/SocialPresenter;", "", "Lcom/avito/android/advert_core/social/SocialView;", "view", "", "attachView", "(Lcom/avito/android/advert_core/social/SocialView;)V", "detachView", "()V", "Lcom/avito/android/advert_core/social/SocialPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert_core/social/SocialPresenter$Router;)V", "detachRouter", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "onSocialLoginResult", "(Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginError", "Lcom/avito/android/remote/model/AdvertSharing;", "sharing", "", "isRoundButtons", "setSharing", "(Lcom/avito/android/remote/model/AdvertSharing;Z)V", "Lcom/avito/android/advert_core/social/SocialShareListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInstantShareListener", "(Lcom/avito/android/advert_core/social/SocialShareListener;)V", "Router", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface SocialPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setSharing$default(SocialPresenter socialPresenter, AdvertSharing advertSharing, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                socialPresenter.setSharing(advertSharing, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSharing");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/social/SocialPresenter$Router;", "", "Lcom/avito/android/social/SignInSocialManager;", "socialManager", "", "login", "(Lcom/avito/android/social/SignInSocialManager;)V", "Lcom/avito/android/social/SharingManager;", "", "link", "Lkotlin/Function1;", "Lcom/avito/android/social/SharingManager$ShareError;", "shareListener", "share", "(Lcom/avito/android/social/SharingManager;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "shouldRestoreShare", "(Lcom/avito/android/social/SharingManager;)Z", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void login(@NotNull SignInSocialManager signInSocialManager);

        void share(@NotNull SharingManager sharingManager, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1);

        boolean shouldRestoreShare(@NotNull SharingManager sharingManager);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SocialView socialView);

    void detachRouter();

    void detachView();

    void onSocialLoginError();

    void onSocialLoginResult(@Nullable String str, @Nullable String str2);

    void setInstantShareListener(@Nullable SocialShareListener socialShareListener);

    void setSharing(@Nullable AdvertSharing advertSharing, boolean z);
}
