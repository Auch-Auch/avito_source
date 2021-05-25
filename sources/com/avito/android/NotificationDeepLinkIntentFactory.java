package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.notification.Payload;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JS\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/NotificationDeepLinkIntentFactory;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "tag", "", "id", "Lcom/avito/android/remote/model/notification/Payload;", "payload", "", "analytics", "notificationButtonName", "Landroid/content/Intent;", "notificationDeepLinkActivityIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;ILcom/avito/android/remote/model/notification/Payload;Ljava/util/Map;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationDeepLinkIntentFactory {
    @NotNull
    Intent notificationDeepLinkActivityIntent(@NotNull DeepLink deepLink, @Nullable String str, int i, @Nullable Payload payload, @Nullable Map<String, String> map, @Nullable String str2);
}
