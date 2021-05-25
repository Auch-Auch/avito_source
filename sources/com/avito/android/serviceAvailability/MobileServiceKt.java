package com.avito.android.serviceAvailability;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/serviceAvailability/MobileService;", "getAvailableMobileService", "(Landroid/content/Context;)Lcom/avito/android/serviceAvailability/MobileService;", "push_release"}, k = 2, mv = {1, 4, 2})
public final class MobileServiceKt {
    @NotNull
    public static final MobileService getAvailableMobileService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            return MobileService.GOOGLE;
        }
        return MobileService.UNKNOWN;
    }
}
