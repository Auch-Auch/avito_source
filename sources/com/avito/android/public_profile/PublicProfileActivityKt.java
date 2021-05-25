package com.avito.android.public_profile;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t\"\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/public_profile/PublicProfileArguments;", "args", "Landroid/content/Intent;", "createPublicProfileActivityIntent", "(Landroid/content/Context;Lcom/avito/android/public_profile/PublicProfileArguments;)Landroid/content/Intent;", "", "REQ_AUTH", "I", "REQ_DEEPLINK", "", "EXTRA_ARGS", "Ljava/lang/String;", "REQ_ADD_PHONE", "public-profile_release"}, k = 2, mv = {1, 4, 2})
public final class PublicProfileActivityKt {
    @NotNull
    public static final String EXTRA_ARGS = "extra_args";
    public static final int REQ_ADD_PHONE = 3;
    public static final int REQ_AUTH = 2;
    public static final int REQ_DEEPLINK = 1;

    @NotNull
    public static final Intent createPublicProfileActivityIntent(@NotNull Context context, @NotNull PublicProfileArguments publicProfileArguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicProfileArguments, "args");
        Intent putExtra = new Intent(context, PublicProfileActivity.class).putExtra("extra_args", publicProfileArguments);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…utExtra(EXTRA_ARGS, args)");
        return putExtra;
    }
}
