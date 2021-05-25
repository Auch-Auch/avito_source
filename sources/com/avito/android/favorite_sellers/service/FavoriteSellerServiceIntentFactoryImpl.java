package com.avito.android.favorite_sellers.service;

import android.content.Context;
import android.content.Intent;
import com.avito.android.FavoriteSellerServiceIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/favorite_sellers/service/FavoriteSellerServiceIntentFactoryImpl;", "Lcom/avito/android/FavoriteSellerServiceIntentFactory;", "", "userKey", "", "notificationId", "notificationTag", "notificationActionName", "", "analyticParameters", "Landroid/content/Intent;", "favoriteSellerServiceMuteIntent", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellerServiceIntentFactoryImpl implements FavoriteSellerServiceIntentFactory {
    public final Context a;

    @Inject
    public FavoriteSellerServiceIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    @Override // com.avito.android.FavoriteSellerServiceIntentFactory
    @NotNull
    public Intent favoriteSellerServiceMuteIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        return FavoriteSellerServiceKt.createFavoriteSellerServiceIntent(this.a, FavoriteSellerServiceAction.MUTE, str, i, str2, str3, map);
    }
}
