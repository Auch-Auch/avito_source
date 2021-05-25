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
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\tR\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\tR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u001c\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\tR\u001c\u0010#\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t¨\u0006+"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/resource_providers/ReplacingPhoneResourceProvider;", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "", "replacementPhone", "actionSuccessMessage", "(Ljava/lang/String;)Ljava/lang/String;", "e", "Ljava/lang/String;", "getInputPlaceholder", "()Ljava/lang/String;", "inputPlaceholder", "j", "getActionErrorMessage", "actionErrorMessage", "f", "getInputMotivation", "inputMotivation", "d", "getDescription", "description", AuthSource.SEND_ABUSE, "nonBreakingPhone", "i", "getSelectSheetTitle", "selectSheetTitle", "h", "getInputEmptyErrorMessage", "inputEmptyErrorMessage", AuthSource.BOOKING_ORDER, "successMessage", g.a, "getSubmitButtonText", "submitButtonText", "c", "getHeader", TariffPackageInfoConverterKt.HEADER_STRING_ID, "phone", "", "advertsCount", "Landroid/content/res/Resources;", "resources", "<init>", "(Ljava/lang/String;ILandroid/content/res/Resources;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ReplacingPhoneResourceProvider implements PhoneActionResourceProvider {
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

    public ReplacingPhoneResourceProvider(@NotNull String str, int i2, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(resources, "resources");
        String nonBreakingText = StringsKt.nonBreakingText(str);
        this.a = nonBreakingText;
        String string = resources.getString(R.string.replace_phone_success, nonBreakingText, "*");
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ne, REPLACER_PLACEHOLDER)");
        this.b = string;
        String string2 = resources.getString(R.string.replace_phone_screen_title, nonBreakingText);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_title, nonBreakingPhone)");
        this.c = string2;
        String string3 = resources.getString(R.string.replace_phone_usage_description, resources.getQuantityString(R.plurals.adverts_count_accusative, i2, Integer.valueOf(i2)));
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(\n   …ount, advertsCount)\n    )");
        this.d = string3;
        String string4 = resources.getString(R.string.phone_input_placeholder);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st….phone_input_placeholder)");
        this.e = string4;
        String string5 = resources.getString(R.string.replace_phone_details);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…ng.replace_phone_details)");
        this.f = string5;
        String string6 = resources.getString(R.string.replace_phone_button_text);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…eplace_phone_button_text)");
        this.g = string6;
        String string7 = resources.getString(R.string.phone_select_error);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.string.phone_select_error)");
        this.h = string7;
        String string8 = resources.getString(R.string.phone_select_title);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.string.phone_select_title)");
        this.i = string8;
        String string9 = resources.getString(R.string.phone_action_error);
        Intrinsics.checkNotNullExpressionValue(string9, "resources.getString(R.string.phone_action_error)");
        this.j = string9;
    }

    @Override // com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider
    @NotNull
    public String actionSuccessMessage(@Nullable String str) {
        String str2 = this.b;
        if (str == null) {
            str = "";
        }
        return m.replace$default(str2, "*", str, false, 4, (Object) null);
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
