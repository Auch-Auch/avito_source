package com.avito.android.user_advert.advert.service;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/user_advert/advert/service/UserAdvertServiceAction;", "action", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "createUserAdvertServiceIntent", "(Landroid/content/Context;Lcom/avito/android/user_advert/advert/service/UserAdvertServiceAction;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class UserAdvertServiceKt {
    @NotNull
    public static final Intent createUserAdvertServiceIntent(@NotNull Context context, @NotNull UserAdvertServiceAction userAdvertServiceAction, @NotNull String str, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAdvertServiceAction, "action");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        Intent putExtra = new Intent(context, UserAdvertService.class).putExtra("action", userAdvertServiceAction).putExtra("advert_id", str).putExtra("notification_id", i).putExtra("notification_tag", str2).putExtra("notification_analytics", new NotificationAnalyticParams(map, str3));
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createServiceInt… notificationActionName))");
        return putExtra;
    }
}
