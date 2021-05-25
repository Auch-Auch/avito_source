package com.avito.android.enabler;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\"\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "getTogglesPreferences", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "getVersionPreferences", "", "VERSION_CODE_KEY", "Ljava/lang/String;", "features-enabler_release"}, k = 2, mv = {1, 4, 2})
public final class PersistentTogglesCacheKt {
    private static final String VERSION_CODE_KEY = "enabler_version_code_key";

    /* access modifiers changed from: private */
    public static final SharedPreferences getTogglesPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("enabler_toggles_cache", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…e\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    /* access modifiers changed from: private */
    public static final SharedPreferences getVersionPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("enabler_version_cache", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…e\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
