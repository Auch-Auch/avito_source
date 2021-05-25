package com.avito.android.shop.filter;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "Landroid/content/Intent;", "createShopsFilterActivityIntent", "(Landroid/content/Context;Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Landroid/content/Intent;", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopsFilterActivityKt {
    @NotNull
    public static final Intent createShopsFilterActivityIntent(@NotNull Context context, @NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        Intent intent = new Intent(context, ShopsFilterActivity.class);
        intent.putExtra("search_parameters", shopsSearchParameters);
        return intent;
    }
}
