package com.avito.android.shop.detailed;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.SearchParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "shopId", "pageFrom", "shopContext", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Landroid/content/Intent;", "createShopDetailedActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)Landroid/content/Intent;", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopDetailedActivityKt {
    @NotNull
    public static final Intent createShopDetailedActivityIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intent putExtra = new Intent(context, ShopDetailedActivity.class).putExtra("shop_id", str).putExtra("page_from", str2).putExtra("shop_context", str3).putExtra("search_params", searchParams);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, ShopDeta…RCH_PARAMS, searchParams)");
        return putExtra;
    }
}
