package com.avito.android.extended_profile;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/extended_profile/ExtendedProfileArguments;", "args", "Landroid/content/Intent;", "createExtendedProfileActivityIntent", "(Landroid/content/Context;Lcom/avito/android/extended_profile/ExtendedProfileArguments;)Landroid/content/Intent;", "", "EXTRA_ARGS", "Ljava/lang/String;", "extended-profile_release"}, k = 2, mv = {1, 4, 2})
public final class ExtendedProfileActivityKt {
    @NotNull
    public static final String EXTRA_ARGS = "extra_args";

    @NotNull
    public static final Intent createExtendedProfileActivityIntent(@NotNull Context context, @NotNull ExtendedProfileArguments extendedProfileArguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extendedProfileArguments, "args");
        Intent putExtra = new Intent(context, ExtendedProfileActivity.class).putExtra("extra_args", extendedProfileArguments);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…utExtra(EXTRA_ARGS, args)");
        return putExtra;
    }
}
