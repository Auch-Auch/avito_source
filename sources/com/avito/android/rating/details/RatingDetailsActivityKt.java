package com.avito.android.rating.details;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "createUserProfileRatingDetailsActivityIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "", "userKey", "createPublicProfileRatingDetailsActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "shopId", "createShopRatingDetailsActivityIntent", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class RatingDetailsActivityKt {
    @NotNull
    public static final Intent createPublicProfileRatingDetailsActivityIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "userKey", context, RatingDetailsActivity.class, "param_user_key", str, "context.createActivityIn…(PARAM_USER_KEY, userKey)");
    }

    @NotNull
    public static final Intent createShopRatingDetailsActivityIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "shopId", context, RatingDetailsActivity.class, "param_shop_id", str, "context.createActivityIn…ra(PARAM_SHOP_ID, shopId)");
    }

    @NotNull
    public static final Intent createUserProfileRatingDetailsActivityIntent(@NotNull Context context) {
        return a.X0(context, "context", context, RatingDetailsActivity.class);
    }
}
