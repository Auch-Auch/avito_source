package com.avito.android.social;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInManager;
import com.avito.android.social.VkontakteSocialManager;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J-\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/avito/android/social/VkontakteSocialManagerImpl;", "Lcom/avito/android/social/VkontakteSocialManager;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "", "getToken", "()Ljava/lang/String;", "getEmail", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", "shouldRestoreShare", "(Landroid/app/Activity;)Z", "link", "Lcom/avito/android/social/SharingManager$ShareError;", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/ref/WeakReference;", "activityRef", AuthSource.SEND_ABUSE, "(Ljava/lang/ref/WeakReference;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class VkontakteSocialManagerImpl implements VkontakteSocialManager {
    @Inject
    public VkontakteSocialManagerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!VKSdk.isCustomInitialize()) {
            Context applicationContext = context.getApplicationContext();
            String string = context.getString(R.string.vkAppId);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.vkAppId)");
            VKSdk.customInitialize(applicationContext, Integer.parseInt(string), null);
        }
    }

    public static final void access$processShareError(VkontakteSocialManagerImpl vkontakteSocialManagerImpl, WeakReference weakReference, VKError vKError, Function1 function1) {
        Objects.requireNonNull(vkontakteSocialManagerImpl);
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activityRef.get() ?: return");
            Integer valueOf = vKError != null ? Integer.valueOf(vKError.errorCode) : null;
            if (valueOf != null && valueOf.intValue() == -101) {
                vkontakteSocialManagerImpl.login(activity, null);
            } else if (valueOf != null && valueOf.intValue() == -105) {
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(new SharingManager.ShareError.NoConnection());
                }
            } else if (function1 != null) {
                Unit unit2 = (Unit) function1.invoke(new SharingManager.ShareError.Unknown());
            }
        }
    }

    public final void a(WeakReference<Activity> weakReference) {
        Activity activity = weakReference.get();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activityRef.get() ?: return");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("tag_vk_dialog");
            if (!(findFragmentByTag instanceof DialogFragment)) {
                findFragmentByTag = null;
            }
            DialogFragment dialogFragment = (DialogFragment) findFragmentByTag;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getEmail() {
        VKAccessToken currentToken = VKAccessToken.currentToken();
        if (currentToken != null) {
            return currentToken.email;
        }
        return null;
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getToken() {
        VKAccessToken currentToken = VKAccessToken.currentToken();
        if (currentToken == null || currentToken.isExpired()) {
            return null;
        }
        return currentToken.accessToken;
    }

    @Override // com.avito.android.social.VkontakteSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return VkontakteSocialManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        return VKSdk.onActivityResult(i, i2, intent, new VKCallback<VKAccessToken>(function1) { // from class: com.avito.android.social.VkontakteSocialManagerImpl$handleActivityResult$vkCallback$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.vk.sdk.VKCallback
            public void onError(@Nullable VKError vKError) {
                if (vKError == null || vKError.errorCode != -102) {
                    Function1 function12 = this.a;
                    if (function12 != null) {
                        Unit unit = (Unit) function12.invoke(SignInManager.Result.Error.INSTANCE);
                        return;
                    }
                    return;
                }
                Function1 function13 = this.a;
                if (function13 != null) {
                    Unit unit2 = (Unit) function13.invoke(SignInManager.Result.Cancel.INSTANCE);
                }
            }

            public void onResult(@Nullable VKAccessToken vKAccessToken) {
                Function1 function12 = this.a;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Success.INSTANCE);
                }
            }
        });
    }

    @Override // com.avito.android.social.SignInManager
    public boolean hasToken() {
        return VkontakteSocialManager.DefaultImpls.hasToken(this);
    }

    @Override // com.avito.android.social.SignInManager
    public void login(@NotNull Activity activity, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logout();
        VKSdk.login(activity, "wall", "email");
    }

    @Override // com.avito.android.social.SignInManager
    public void logout() {
        VKSdk.logout();
    }

    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        a(weakReference);
        new VKShareDialogBuilder().setAttachmentLink("", str).setShareDialogListener(new VKShareDialogBuilder.VKShareDialogListener(this, weakReference, function1) { // from class: com.avito.android.social.VkontakteSocialManagerImpl$share$1
            public final /* synthetic */ VkontakteSocialManagerImpl a;
            public final /* synthetic */ WeakReference b;
            public final /* synthetic */ Function1 c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.vk.sdk.dialogs.VKShareDialogBuilder.VKShareDialogListener
            public void onVkShareCancel() {
            }

            @Override // com.vk.sdk.dialogs.VKShareDialogBuilder.VKShareDialogListener
            public void onVkShareComplete(int i) {
            }

            @Override // com.vk.sdk.dialogs.VKShareDialogBuilder.VKShareDialogListener
            public void onVkShareError(@Nullable VKError vKError) {
                this.a.a(this.b);
                VkontakteSocialManagerImpl.access$processShareError(this.a, this.b, vKError, this.c);
            }
        }).show(activity.getFragmentManager(), "tag_vk_dialog");
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("tag_vk_dialog");
        if (!(findFragmentByTag instanceof DialogFragment)) {
            findFragmentByTag = null;
        }
        return ((DialogFragment) findFragmentByTag) != null;
    }
}
