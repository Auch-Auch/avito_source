package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JE\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/PhoneManagementIntentFactory;", "", "", "phone", "", "verified", "", "itemsCount", "fromProfile", "source", "Landroid/content/Intent;", "phoneManagementIntent", "(Ljava/lang/String;ZIZLjava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneManagementIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent phoneManagementIntent$default(PhoneManagementIntentFactory phoneManagementIntentFactory, String str, boolean z, int i, boolean z2, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                if ((i2 & 2) != 0) {
                    z = false;
                }
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                if ((i2 & 8) != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    str2 = null;
                }
                return phoneManagementIntentFactory.phoneManagementIntent(str, z, i, z2, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: phoneManagementIntent");
        }
    }

    @NotNull
    Intent phoneManagementIntent(@Nullable String str, boolean z, int i, boolean z2, @Nullable String str2);
}
