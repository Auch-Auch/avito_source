package com.avito.android.advert.badge_details;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", "objectId", "objectEntity", "", "badgeId", "Landroid/content/Intent;", "createBadgeBarActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;", "KEY_BADGE_BAR_MESSAGE", "Ljava/lang/String;", "advert-details_release"}, k = 2, mv = {1, 4, 2})
public final class BadgeDetailsActivityKt {
    @NotNull
    public static final String KEY_BADGE_BAR_MESSAGE = "message";

    @NotNull
    public static final Intent createBadgeBarActivityIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, "objectEntity");
        Intent putExtra = new Intent(context, BadgeDetailsActivity.class).putExtra("objectId", str).putExtra("objectEntity", str2).putExtra("badgeId", i);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ra(KEY_BADGE_ID, badgeId)");
        return putExtra;
    }
}
