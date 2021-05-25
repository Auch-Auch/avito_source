package com.avito.android.shop.filter;

import android.os.Bundle;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "Lcom/avito/android/shop/filter/ShopsFilterFragment;", "createShopsFilterFragment", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Lcom/avito/android/shop/filter/ShopsFilterFragment;", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopsFilterFragmentKt {
    @NotNull
    public static final ShopsFilterFragment createShopsFilterFragment(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        ShopsFilterFragment shopsFilterFragment = new ShopsFilterFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("category", shopsSearchParameters);
        Unit unit = Unit.INSTANCE;
        shopsFilterFragment.setArguments(bundle);
        return shopsFilterFragment;
    }
}
