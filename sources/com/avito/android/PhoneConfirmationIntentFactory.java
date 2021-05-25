package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/PhoneConfirmationIntentFactory;", "", "", "phoneNumber", "manager", "", "isCompany", "confirmOnConsultationForm", "Landroid/content/Intent;", "phoneVerificationIntent", "(Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneConfirmationIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent phoneVerificationIntent$default(PhoneConfirmationIntentFactory phoneConfirmationIntentFactory, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z2 = false;
                }
                return phoneConfirmationIntentFactory.phoneVerificationIntent(str, str2, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: phoneVerificationIntent");
        }
    }

    @NotNull
    Intent phoneVerificationIntent(@NotNull String str, @Nullable String str2, boolean z, boolean z2);
}
