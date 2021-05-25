package com.avito.android.profile.tfa.settings;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", "isEnabled", "", "warning", "Landroid/content/Intent;", "createTfaSettingsActivityIntent", "(Landroid/content/Context;ZLjava/lang/String;)Landroid/content/Intent;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class TfaSettingsActivityKt {
    @NotNull
    public static final Intent createTfaSettingsActivityIntent(@NotNull Context context, boolean z, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, TfaSettingsActivity.class);
        intent.putExtra(TfaSettingsActivity.EXTRA_IS_ENABLED, z);
        intent.putExtra(TfaSettingsActivity.EXTRA_WARNING, str);
        return intent;
    }
}
