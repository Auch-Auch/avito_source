package com.avito.android;

import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JM\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\f\u0010\rJM\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/UserAdvertServiceIntentFactory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "reasonId", "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "userAdvertCloseServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "", "enabled", "userAdvertAutoPublishServiceIntent", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "userAdvertActivateServiceIntent", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertServiceIntentFactory {
    @NotNull
    Intent userAdvertActivateServiceIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map);

    @NotNull
    Intent userAdvertAutoPublishServiceIntent(@NotNull String str, boolean z, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map);

    @NotNull
    Intent userAdvertCloseServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, @NotNull String str4, @NotNull Map<String, String> map);
}
