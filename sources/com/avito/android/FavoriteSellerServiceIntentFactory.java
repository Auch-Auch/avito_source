package com.avito.android;

import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JG\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/FavoriteSellerServiceIntentFactory;", "", "", "userKey", "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "favoriteSellerServiceMuteIntent", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellerServiceIntentFactory {
    @NotNull
    Intent favoriteSellerServiceMuteIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map);
}
