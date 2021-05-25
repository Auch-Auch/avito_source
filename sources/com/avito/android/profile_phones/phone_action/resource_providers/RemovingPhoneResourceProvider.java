package com.avito.android.profile_phones.phone_action.resource_providers;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.StringsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\tR\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\tR\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\tR\u001c\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\tR\u001c\u0010#\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t¨\u0006+"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/resource_providers/RemovingPhoneResourceProvider;", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "", "replacementPhone", "actionSuccessMessage", "(Ljava/lang/String;)Ljava/lang/String;", "i", "Ljava/lang/String;", "getSelectSheetTitle", "()Ljava/lang/String;", "selectSheetTitle", g.a, "getSubmitButtonText", "submitButtonText", "c", "getHeader", TariffPackageInfoConverterKt.HEADER_STRING_ID, AuthSource.SEND_ABUSE, "nonBreakingPhone", "h", "getInputEmptyErrorMessage", "inputEmptyErrorMessage", "d", "getDescription", "description", AuthSource.BOOKING_ORDER, "successMessage", "e", "getInputPlaceholder", "inputPlaceholder", "j", "getActionErrorMessage", "actionErrorMessage", "f", "getInputMotivation", "inputMotivation", "phone", "", "advertsCount", "Landroid/content/res/Resources;", "resources", "<init>", "(Ljava/lang/String;ILandroid/content/res/Resources;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class RemovingPhoneResourceProvider implements PhoneActionResourceProvider {
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
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;

    public RemovingPhoneResourceProvider(@NotNull String str, int i2, @NotNull Resources resources) {
        String str2;
        int i3;
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(resources, "resources");
        String nonBreakingText = StringsKt.nonBreakingText(str);
        this.a = nonBreakingText;
        String string = resources.getString(R.string.phone_removed_success, nonBreakingText);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…uccess, nonBreakingPhone)");
        this.b = string;
        String string2 = resources.getString(R.string.remove_phone_screen_title, nonBreakingText);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_title, nonBreakingPhone)");
        this.c = string2;
        if (i2 == 0) {
            str2 = resources.getString(R.string.phone_removing_details_with_pronoun);
            Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.st…ing_details_with_pronoun)");
        } else {
            str2 = resources.getString(R.string.remove_phone_usage_description, resources.getQuantityString(R.plurals.adverts_count_accusative, i2, Integer.valueOf(i2)));
            Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(\n   …, advertsCount)\n        )");
        }
        this.d = str2;
        String string3 = resources.getString(R.string.phone_input_placeholder);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st….phone_input_placeholder)");
        this.e = string3;
        String string4 = resources.getString(R.string.phone_removing_details);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…g.phone_removing_details)");
        this.f = string4;
        if (i2 == 0) {
            i3 = R.string.phone_remove_button_text;
        } else {
            i3 = R.string.phone_remove_countinue_button_text;
        }
        String string5 = resources.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(\n   …tton_text\n        }\n    )");
        this.g = string5;
        String string6 = resources.getString(R.string.phone_select_error);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.string.phone_select_error)");
        this.h = string6;
        String string7 = resources.getString(R.string.phone_select_title);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.string.phone_select_title)");
        this.i = string7;
        String string8 = resources.getString(R.string.phone_action_error);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.string.phone_action_error)");
        this.j = string8;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String actionSuccessMessage(@Nullable String str) {
        return this.b;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getActionErrorMessage() {
        return this.j;
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
        return this.h;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getInputMotivation() {
        return this.f;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getInputPlaceholder() {
        return this.e;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getSelectSheetTitle() {
        return this.i;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String getSubmitButtonText() {
        return this.g;
    }
}
