package com.avito.android.profile_phones.phone_action.resource_providers;

import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "", "", "replacementPhone", "actionSuccessMessage", "(Ljava/lang/String;)Ljava/lang/String;", "getSelectSheetTitle", "()Ljava/lang/String;", "selectSheetTitle", "getDescription", "description", "getInputEmptyErrorMessage", "inputEmptyErrorMessage", "getHeader", TariffPackageInfoConverterKt.HEADER_STRING_ID, "getInputPlaceholder", "inputPlaceholder", "getSubmitButtonText", "submitButtonText", "getInputMotivation", "inputMotivation", "getActionErrorMessage", "actionErrorMessage", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneActionResourceProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static String actionSuccessMessage(@NotNull PhoneActionResourceProvider phoneActionResourceProvider, @Nullable String str) {
            return "";
        }

        @NotNull
        public static String getActionErrorMessage(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getDescription(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getHeader(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getInputEmptyErrorMessage(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getInputMotivation(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getInputPlaceholder(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getSelectSheetTitle(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }

        @NotNull
        public static String getSubmitButtonText(@NotNull PhoneActionResourceProvider phoneActionResourceProvider) {
            return "";
        }
    }

    @NotNull
    String actionSuccessMessage(@Nullable String str);

    @NotNull
    String getActionErrorMessage();

    @NotNull
    String getDescription();

    @NotNull
    String getHeader();

    @NotNull
    String getInputEmptyErrorMessage();

    @NotNull
    String getInputMotivation();

    @NotNull
    String getInputPlaceholder();

    @NotNull
    String getSelectSheetTitle();

    @NotNull
    String getSubmitButtonText();
}
