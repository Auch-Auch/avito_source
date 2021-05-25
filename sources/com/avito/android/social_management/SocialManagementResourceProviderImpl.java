package com.avito.android.social_management;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/social_management/SocialManagementResourceProviderImpl;", "Lcom/avito/android/social_management/SocialManagementResourceProvider;", "", "connectSocial", "()Ljava/lang/String;", "socialLoginError", "removeSocialDialogMessage", "removeButtonText", "cancelButtonText", "facebookTitle", "vkontakteTitle", "odnoklassnikiTitle", "googleTitle", "appleTitle", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getEsiaTitle", "esiaTitle", "<init>", "(Landroid/content/res/Resources;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementResourceProviderImpl implements SocialManagementResourceProvider {
    @NotNull
    public final String a;
    public final Resources b;

    @Inject
    public SocialManagementResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        String string = resources.getString(R.string.esia);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.esia)");
        this.a = string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String appleTitle() {
        String string = this.b.getString(R.string.apple);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.apple)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String cancelButtonText() {
        String string = this.b.getString(R.string.cancel_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.cancel_button_text)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String connectSocial() {
        String string = this.b.getString(R.string.connect_social);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.connect_social)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String facebookTitle() {
        String string = this.b.getString(R.string.facebook);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.facebook)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String getEsiaTitle() {
        return this.a;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String googleTitle() {
        String string = this.b.getString(R.string.google);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.google)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String odnoklassnikiTitle() {
        String string = this.b.getString(R.string.odnoklassniki);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.odnoklassniki)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String removeButtonText() {
        String string = this.b.getString(R.string.remove_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.remove_button_text)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String removeSocialDialogMessage() {
        String string = this.b.getString(R.string.remove_social_dialog_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ve_social_dialog_message)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String socialLoginError() {
        String string = this.b.getString(R.string.social_login_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.social_login_error)");
        return string;
    }

    @Override // com.avito.android.social_management.SocialManagementResourceProvider
    @NotNull
    public String vkontakteTitle() {
        String string = this.b.getString(R.string.vkontakte);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.vkontakte)");
        return string;
    }
}
