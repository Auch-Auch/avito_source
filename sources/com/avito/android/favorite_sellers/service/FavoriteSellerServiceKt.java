package com.avito.android.favorite_sellers.service;

import android.content.Context;
import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/favorite_sellers/service/FavoriteSellerServiceAction;", "action", "", "userKey", "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "createFavoriteSellerServiceIntent", "(Landroid/content/Context;Lcom/avito/android/favorite_sellers/service/FavoriteSellerServiceAction;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "favorite-sellers_release"}, k = 2, mv = {1, 4, 2})
public final class FavoriteSellerServiceKt {
    @NotNull
    public static final Intent createFavoriteSellerServiceIntent(@NotNull Context context, @NotNull FavoriteSellerServiceAction favoriteSellerServiceAction, @NotNull String str, int i, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(favoriteSellerServiceAction, "action");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intent putExtra = new Intent(context, FavoriteSellerService.class).putExtra("action", favoriteSellerServiceAction).putExtra("user_key", str).putExtra("notification_id", i).putExtra("notification_tag", str2);
        if (map == null) {
            map = r.emptyMap();
        }
        Intent putExtra2 = putExtra.putExtra("notification_analytics", new NotificationAnalyticParams(map, str3));
        Intrinsics.checkNotNullExpressionValue(putExtra2, "context.createServiceInt… notificationActionName))");
        return putExtra2;
    }
}
