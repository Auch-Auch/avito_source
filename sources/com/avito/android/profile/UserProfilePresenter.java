package com.avito.android.profile;

import android.net.Uri;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.profile.UserProfileView;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.Kundle;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\tJ\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u001c\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile/UserProfilePresenter;", "Lcom/avito/android/profile/UserProfileView$Presenter;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/profile/UserProfileView;", "view", "", "attachView", "(Lcom/avito/android/profile/UserProfileView;)V", "detachView", "()V", "Lcom/avito/android/profile/UserProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/UserProfilePresenter$Router;)V", "detachRouter", "onResume", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onAuthenticationSuccess", "onStateInvalidated", "onPhoneAttached", "", "message", "onPhoneAdded", "(Ljava/lang/String;)V", "onPhoneRemoved", "onPhoneVerified", "onDeepLinkResult", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfilePresenter extends UserProfileView.Presenter, OnDeepLinkClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0012H&¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b%\u0010\u0015J!\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/profile/UserProfilePresenter$Router;", "Lcom/avito/android/profile/header/ProfileHeaderPresenter$Router;", "", "showLoginScreen", "()V", "closeScreen", "openSubscriptionDetails", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openPasswordActionDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "openEditProfileScreen", "openUserAdvertsScreen", "openSocialNetworksScreen", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openDeliverySettings", "(Landroid/net/Uri;)V", "", "url", "openHelpCenter", "(Ljava/lang/String;)V", "openWebViewScreen", "openWalletPage", "openAttachPhone", "openAddPhone", "openPhonesList", "Lcom/avito/android/remote/model/user_profile/Phone;", "phone", "openRemovePhone", "(Lcom/avito/android/remote/model/user_profile/Phone;)V", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "codeInfo", "src", "openVerifyPhone", "(Lcom/avito/android/remote/model/user_profile/Phone;Lcom/avito/android/code_confirmation/model/CodeInfo;Ljava/lang/String;)V", "source", "openSessionsListScreen", "", "isEnabled", "warning", "openTfaSettings", "(ZLjava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends ProfileHeaderPresenter.Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void openHelpCenter$default(Router router, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    router.openHelpCenter(str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openHelpCenter");
            }
        }

        void closeScreen();

        void openAddPhone();

        void openAttachPhone();

        void openDeliverySettings(@NotNull Uri uri);

        void openEditProfileScreen();

        void openHelpCenter(@Nullable String str);

        void openPasswordActionDeeplink(@NotNull DeepLink deepLink);

        void openPhonesList();

        void openRemovePhone(@NotNull Phone phone);

        void openSessionsListScreen(@Nullable String str);

        void openSocialNetworksScreen();

        void openSubscriptionDetails();

        void openTfaSettings(boolean z, @Nullable String str);

        void openUserAdvertsScreen();

        void openVerifyPhone(@NotNull Phone phone, @NotNull CodeInfo codeInfo, @NotNull String str);

        void openWalletPage();

        void openWebViewScreen(@NotNull String str);

        void showLoginScreen();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull UserProfileView userProfileView);

    void detachRouter();

    void detachView();

    void onAuthenticationSuccess();

    void onDeepLinkResult(@Nullable String str);

    void onPhoneAdded(@Nullable String str);

    void onPhoneAttached();

    void onPhoneRemoved();

    void onPhoneVerified();

    void onResume();

    @NotNull
    Kundle onSaveState();

    void onStateInvalidated();
}
