package com.avito.android.social_management;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/social_management/SocialManagementResourceProvider;", "", "", "connectSocial", "()Ljava/lang/String;", "socialLoginError", "removeSocialDialogMessage", "removeButtonText", "cancelButtonText", "facebookTitle", "vkontakteTitle", "odnoklassnikiTitle", "googleTitle", "appleTitle", "getEsiaTitle", "esiaTitle", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public interface SocialManagementResourceProvider {
    @NotNull
    String appleTitle();

    @NotNull
    String cancelButtonText();

    @NotNull
    String connectSocial();

    @NotNull
    String facebookTitle();

    @NotNull
    String getEsiaTitle();

    @NotNull
    String googleTitle();

    @NotNull
    String odnoklassnikiTitle();

    @NotNull
    String removeButtonText();

    @NotNull
    String removeSocialDialogMessage();

    @NotNull
    String socialLoginError();

    @NotNull
    String vkontakteTitle();
}
