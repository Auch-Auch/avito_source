package com.avito.android.profile.edit;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "", "", "getAllowStorage", "()Ljava/lang/String;", "allowStorage", "getCompanyNameTitle", "companyNameTitle", "getSettingsButton", "settingsButton", "getAllowCamera", "allowCamera", "getContactNameTitle", "contactNameTitle", "getEmailTitle", "emailTitle", "getNoPlaceForSnapshot", "noPlaceForSnapshot", "getNoStorageAccess", "noStorageAccess", "getInvalidImageFormat", "invalidImageFormat", "getUserNameTitle", "userNameTitle", "getNoCameraAccess", "noCameraAccess", "getDisclaimer", "disclaimer", "getPhoneNumberTitle", "phoneNumberTitle", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfileResourceProvider {
    @NotNull
    String getAllowCamera();

    @NotNull
    String getAllowStorage();

    @NotNull
    String getCompanyNameTitle();

    @NotNull
    String getContactNameTitle();

    @NotNull
    String getDisclaimer();

    @NotNull
    String getEmailTitle();

    @NotNull
    String getInvalidImageFormat();

    @NotNull
    String getNoCameraAccess();

    @NotNull
    String getNoPlaceForSnapshot();

    @NotNull
    String getNoStorageAccess();

    @NotNull
    String getPhoneNumberTitle();

    @NotNull
    String getSettingsButton();

    @NotNull
    String getUserNameTitle();
}
