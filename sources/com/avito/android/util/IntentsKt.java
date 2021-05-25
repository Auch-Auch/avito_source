package com.avito.android.util;

import android.content.Intent;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\t\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\"(\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0012\",\u0010\u0017\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroid/content/Intent;", "", "flag", "", "hasFlag", "(Landroid/content/Intent;I)Z", "isLaunchedFromHistory", "(Landroid/content/Intent;)Z", "makeSafeForExternalApps", "(Landroid/content/Intent;)Landroid/content/Intent;", "withClearTopFlags", "", "name", "getNullableIntExtra", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/Integer;", "value", "getHasNestedIntentSupport", "setHasNestedIntentSupport", "(Landroid/content/Intent;Z)V", "hasNestedIntentSupport", "getNestedIntent", "setNestedIntent", "(Landroid/content/Intent;Landroid/content/Intent;)V", "nestedIntent", "android_release"}, k = 2, mv = {1, 4, 2})
public final class IntentsKt {
    public static final boolean getHasNestedIntentSupport(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$hasNestedIntentSupport");
        return intent.getBooleanExtra(Constants.SUPPORTS_NESTED_INTENT, false);
    }

    @Nullable
    public static final Intent getNestedIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$nestedIntent");
        return (Intent) intent.getParcelableExtra(Constants.NESTED_INTENT);
    }

    @Nullable
    public static final Integer getNullableIntExtra(@NotNull Intent intent, @NotNull String str) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(intent, "$this$getNullableIntExtra");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!intent.hasExtra(str) || (extras = intent.getExtras()) == null) {
            return null;
        }
        return Integer.valueOf(extras.getInt(str));
    }

    public static final boolean hasFlag(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "$this$hasFlag");
        return (intent.getFlags() & i) == i;
    }

    public static final boolean isLaunchedFromHistory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$isLaunchedFromHistory");
        return hasFlag(intent, 1048576);
    }

    @NotNull
    public static final Intent makeSafeForExternalApps(@NotNull Intent intent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(intent, "$this$makeSafeForExternalApps");
        if ((intent.getComponent() == null) && (extras = intent.getExtras()) != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "extras ?: return");
            Set<String> keySet = extras.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "extras.keySet()");
            for (T t : keySet) {
                Object obj = extras.get(t);
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "extras[it] ?: return@forEach");
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        Bundles.removeNonNativeObjects(bundle);
                        if (bundle.isEmpty()) {
                            intent.removeExtra(t);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(intent.putExtra((String) t, bundle), "putExtra(it, value)");
                        }
                    } else {
                        String name = obj.getClass().getName();
                        if (!(m.startsWith$default(name, "java.", false, 2, null) | m.startsWith$default(name, "android.", false, 2, null))) {
                            intent.removeExtra(t);
                        }
                    }
                }
            }
        }
        return intent;
    }

    public static final void setHasNestedIntentSupport(@NotNull Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "$this$hasNestedIntentSupport");
        intent.putExtra(Constants.SUPPORTS_NESTED_INTENT, z);
    }

    public static final void setNestedIntent(@NotNull Intent intent, @Nullable Intent intent2) {
        Intrinsics.checkNotNullParameter(intent, "$this$nestedIntent");
        intent.putExtra(Constants.NESTED_INTENT, intent2);
    }

    @NotNull
    public static final Intent withClearTopFlags(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$withClearTopFlags");
        intent.setFlags(603979776);
        return intent;
    }
}
