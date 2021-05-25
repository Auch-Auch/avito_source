package com.avito.android.serp.dfp_mobile_ads;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.ads.MobileAds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "", "Landroid/content/Context;", "context", "", "adUnitId", "", "openDfpDebugMenu", "(Landroid/content/Context;Ljava/lang/String;)V", "", AuthSource.SEND_ABUSE, "Z", "isInitialized", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class DfpMobileAdsWrapper {
    public boolean a;

    public final void openDfpDebugMenu(@NotNull Context context, @NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        if (this.a) {
            MobileAds.openDebugMenu(context, str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        try {
            MobileAds.initialize(applicationContext);
            z = true;
        } catch (Throwable th) {
            Logs.error("Failed to initialize MobileAds sdk", th);
            z = false;
        }
        this.a = z;
        if (z) {
            MobileAds.openDebugMenu(context, str);
        }
    }
}
