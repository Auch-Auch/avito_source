package com.avito.android.profile_phones.phone_management;

import android.content.res.Resources;
import com.avito.android.profile_phones.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/MessengerPhoneManagementResourceProvider;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "", "attachPhoneNumberTitle", "()Ljava/lang/String;", "replacePhoneNumberTitle", "phone", "", "itemsCount", "phoneUsedInAdverts", "(Ljava/lang/String;I)Ljava/lang/String;", "phoneNumberHint", "newPhoneNumberHint", "attachButtonText", "replaceButtonText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerPhoneManagementResourceProvider implements PhoneManagementResourceProvider {
    public final Resources a;

    public MessengerPhoneManagementResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String attachButtonText() {
        String string = this.a.getString(R.string.attach_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.attach_button_text)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String attachPhoneNumberTitle() {
        String string = this.a.getString(R.string.verify_phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.verify_phone_number)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String newPhoneNumberHint() {
        String string = this.a.getString(R.string.new_phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.new_phone_number)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String phoneNumberHint() {
        String string = this.a.getString(R.string.phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_number)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String phoneUsedInAdverts(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "phone");
        String string = this.a.getString(R.string.phone_used_in_adverts, str, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…verts, phone, itemsCount)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String replaceButtonText() {
        String string = this.a.getString(R.string.replace_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.replace_button_text)");
        return string;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider
    @NotNull
    public String replacePhoneNumberTitle() {
        String string = this.a.getString(R.string.remove_phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.remove_phone_number)");
        return string;
    }
}
