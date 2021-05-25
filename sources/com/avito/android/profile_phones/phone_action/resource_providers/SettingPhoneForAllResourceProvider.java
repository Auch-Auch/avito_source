package com.avito.android.profile_phones.phone_action.resource_providers;

import android.content.res.Resources;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.StringsKt;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/resource_providers/SettingPhoneForAllResourceProvider;", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "", "replacementPhone", "actionSuccessMessage", "(Ljava/lang/String;)Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "nonBreakingPhone", "e", "getSubmitButtonText", "()Ljava/lang/String;", "submitButtonText", "d", "getDescription", "description", AuthSource.BOOKING_ORDER, "successMessage", "c", "getHeader", TariffPackageInfoConverterKt.HEADER_STRING_ID, "f", "getActionErrorMessage", "actionErrorMessage", "phone", "Landroid/content/res/Resources;", "resources", "<init>", "(Ljava/lang/String;Landroid/content/res/Resources;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class SettingPhoneForAllResourceProvider implements PhoneActionResourceProvider {
    public final String a;
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;

    public SettingPhoneForAllResourceProvider(@NotNull String str, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(resources, "resources");
        String nonBreakingText = StringsKt.nonBreakingText(str);
        this.a = nonBreakingText;
        String string = resources.getString(R.string.set_phone_for_all_success, nonBreakingText);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…uccess, nonBreakingPhone)");
        this.b = string;
        String string2 = resources.getString(R.string.set_phone_for_all_screen_title, nonBreakingText);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_title, nonBreakingPhone)");
        this.c = string2;
        String string3 = resources.getString(R.string.set_phone_for_all_description);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…hone_for_all_description)");
        this.d = string3;
        String string4 = resources.getString(R.string.set_phone_for_all_button_text);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…hone_for_all_button_text)");
        this.e = string4;
        String string5 = resources.getString(R.string.phone_action_error);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.phone_action_error)");
        this.f = string5;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String actionSuccessMessage(@Nullable String str) {
        return this.b;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getActionErrorMessage() {
        return this.f;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getDescription() {
        return this.d;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getHeader() {
        return this.c;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getInputEmptyErrorMessage() {
        return PhoneActionResourceProvider.DefaultImpls.getInputEmptyErrorMessage(this);
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getInputMotivation() {
        return PhoneActionResourceProvider.DefaultImpls.getInputMotivation(this);
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getInputPlaceholder() {
        return PhoneActionResourceProvider.DefaultImpls.getInputPlaceholder(this);
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getSelectSheetTitle() {
        return PhoneActionResourceProvider.DefaultImpls.getSelectSheetTitle(this);
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getSubmitButtonText() {
        return this.e;
    }
}
