package com.avito.android.user_advert.advert.service;

import android.content.Context;
import android.content.Intent;
import com.avito.android.UserAdvertServiceIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.advert.service.UserAdvertServiceAction;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019JM\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJM\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_advert/advert/service/UserAdvertServiceIntentFactoryImpl;", "Lcom/avito/android/UserAdvertServiceIntentFactory;", "", BookingInfoActivity.EXTRA_ITEM_ID, "reasonId", "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "userAdvertCloseServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "", "enabled", "userAdvertAutoPublishServiceIntent", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "userAdvertActivateServiceIntent", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertServiceIntentFactoryImpl implements UserAdvertServiceIntentFactory {
    public final Context a;

    @Inject
    public UserAdvertServiceIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertActivateServiceIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return UserAdvertServiceKt.createUserAdvertServiceIntent(this.a, UserAdvertServiceAction.Activate.INSTANCE, str, i, str2, str3, map);
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertAutoPublishServiceIntent(@NotNull String str, boolean z, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return UserAdvertServiceKt.createUserAdvertServiceIntent(this.a, new UserAdvertServiceAction.AutoPublish(z), str, i, str2, str3, map);
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertCloseServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, @NotNull String str4, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "reasonId");
        Intrinsics.checkNotNullParameter(str4, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return UserAdvertServiceKt.createUserAdvertServiceIntent(this.a, new UserAdvertServiceAction.Close(str2), str, i, str3, str4, map);
    }
}
