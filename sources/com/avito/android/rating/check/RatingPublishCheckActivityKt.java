package com.avito.android.rating.check;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "", "userKey", "Landroid/content/Intent;", "targetIntent", "createRatingPublishCheckActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class RatingPublishCheckActivityKt {
    @NotNull
    public static final Intent createRatingPublishCheckActivityIntent(@NotNull Context context, @NotNull String str, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(intent, "targetIntent");
        Intent putExtra = new Intent(context, RatingPublishCheckActivity.class).putExtra("target_intent", intent).putExtra("user_key", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ra(KEY_USER_KEY, userKey)");
        return putExtra;
    }
}
