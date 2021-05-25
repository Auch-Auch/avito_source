package com.avito.android.favorite_sellers;

import android.content.Context;
import android.content.Intent;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a9\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "", "userKey", "Landroid/content/Intent;", "createSubscriptionListIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "createSubscribeListIntent", "title", "", "editable", "dataType", "createFavoriteSellersIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "favorite-sellers_release"}, k = 2, mv = {1, 4, 2})
public final class FavoriteSellersActivityKt {
    @NotNull
    public static final Intent createFavoriteSellersIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "userKey");
        Intent putExtra = new Intent(context, FavoriteSellersActivity.class).putExtra("title", str).putExtra("user_key", str2).putExtra("editable", z).putExtra("data_type", str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…(KEY_DATA_TYPE, dataType)");
        return putExtra;
    }

    public static /* synthetic */ Intent createFavoriteSellersIntent$default(Context context, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return createFavoriteSellersIntent(context, str, str2, z, str3);
    }

    @NotNull
    public static final Intent createSubscribeListIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userKey");
        String string = context.getString(R.string.subscribe_list_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.subscribe_list_title)");
        return createFavoriteSellersIntent(context, string, str, false, SubscribersReadInteractor.TYPE);
    }

    @NotNull
    public static final Intent createSubscriptionListIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userKey");
        String string = context.getString(R.string.subscription_list_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri….subscription_list_title)");
        return createFavoriteSellersIntent(context, string, str, false, "subscriptions");
    }
}
