package com.avito.android.remote.shop.list.business;

import android.net.Uri;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/shop/list/business/ShopsSearchParametersFactory;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "createFromUri", "(Landroid/net/Uri;)Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsSearchParametersFactory {
    @NotNull
    public final ShopsSearchParameters createFromUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ShopsSearchParameters shopsSearchParameters = new ShopsSearchParameters(null, null, null, 7, null);
        String queryParameter = uri.getQueryParameter("categoryId");
        String queryParameter2 = uri.getQueryParameter("locationId");
        boolean z = false;
        if (!(queryParameter == null || m.isBlank(queryParameter))) {
            shopsSearchParameters.setCategoryId(queryParameter);
        }
        if (queryParameter2 == null || m.isBlank(queryParameter2)) {
            z = true;
        }
        if ((!z) && queryParameter2 != null) {
            shopsSearchParameters.setLocationId(queryParameter2);
        }
        return shopsSearchParameters;
    }
}
