package com.avito.android.help_center;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "url", "Landroid/content/Intent;", "createHelpCenterIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "help-center_release"}, k = 2, mv = {1, 4, 2})
public final class HelpCenterActivityKt {
    @NotNull
    public static final Intent createHelpCenterIntent(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, HelpCenterActivity.class).putExtra("key_url", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, HelpCent…  .putExtra(KEY_URL, url)");
        return putExtra;
    }
}
