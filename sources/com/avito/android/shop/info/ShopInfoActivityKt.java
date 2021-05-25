package com.avito.android.shop.info;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "shopId", "Landroid/content/Intent;", "createShopInfoActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopInfoActivityKt {
    @NotNull
    public static final Intent createShopInfoActivityIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "shopId", context, ShopInfoActivity.class, "shop_id", str, "context.createActivityIn…xtra(KEY_SHOP_ID, shopId)");
    }
}
