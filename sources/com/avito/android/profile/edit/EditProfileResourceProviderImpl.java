package com.avito.android.profile.edit;

import android.content.res.Resources;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileResourceProviderImpl;", "Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "", "getNoCameraAccess", "()Ljava/lang/String;", "noCameraAccess", "getDisclaimer", "disclaimer", "getEmailTitle", "emailTitle", "getSettingsButton", "settingsButton", "getPhoneNumberTitle", "phoneNumberTitle", "getInvalidImageFormat", "invalidImageFormat", "getNoPlaceForSnapshot", "noPlaceForSnapshot", "getAllowStorage", "allowStorage", "getUserNameTitle", "userNameTitle", "getAllowCamera", "allowCamera", "getContactNameTitle", "contactNameTitle", "getNoStorageAccess", "noStorageAccess", "getCompanyNameTitle", "companyNameTitle", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditProfileResourceProviderImpl implements EditProfileResourceProvider {
    public final Resources a;

    public EditProfileResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getAllowCamera() {
        String string = this.a.getString(R.string.allow_camera);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(lega…er_R.string.allow_camera)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getAllowStorage() {
        String string = this.a.getString(R.string.allow_storage);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(lega…r_R.string.allow_storage)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getCompanyNameTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.company_name);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.company_name)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getContactNameTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.contact_name);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.contact_name)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getDisclaimer() {
        String string = this.a.getString(com.avito.android.profile.R.string.edit_profile_disclaimer);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….edit_profile_disclaimer)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getEmailTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.email);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.email)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getInvalidImageFormat() {
        String string = this.a.getString(com.avito.android.profile.R.string.invalid_image_format);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.invalid_image_format)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getNoCameraAccess() {
        String string = this.a.getString(R.string.no_camera_access);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(lega….string.no_camera_access)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getNoPlaceForSnapshot() {
        String string = this.a.getString(R.string.no_place_for_snapshot);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(lega…ng.no_place_for_snapshot)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getNoStorageAccess() {
        String string = this.a.getString(com.avito.android.profile.R.string.no_storage_access);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.no_storage_access)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getPhoneNumberTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…d.profile.R.string.phone)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getSettingsButton() {
        String string = this.a.getString(com.avito.android.app.core.R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(core_R.string.settings)");
        return string;
    }

    @Override // com.avito.android.profile.edit.EditProfileResourceProvider
    @NotNull
    public String getUserNameTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.username);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.username)");
        return string;
    }
}
