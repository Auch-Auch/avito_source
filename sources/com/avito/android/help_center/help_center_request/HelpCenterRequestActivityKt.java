package com.avito.android.help_center.help_center_request;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", "theme", "advertisementId", "contextId", "Landroid/content/Intent;", "createHelpCenterRequestIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "help-center_release"}, k = 2, mv = {1, 4, 2})
public final class HelpCenterRequestActivityKt {
    @NotNull
    public static final Intent createHelpCenterRequestIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, HelpCenterRequestActivity.class);
        intent.putExtra("key_theme", str);
        intent.putExtra("key_advertisement_id", str2);
        intent.putExtra("key_context_id", str3);
        return intent;
    }
}
