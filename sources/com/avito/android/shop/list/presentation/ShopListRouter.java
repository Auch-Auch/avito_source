package com.avito.android.shop.list.presentation;

import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListRouter;", "", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "", "showClarifyScreen", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)V", "", "shopId", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "openShopDetailsScreen", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)V", Constants.LOCATION_NAME, "openShortcut", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;)V", "Landroid/net/Uri;", "link", "openLink", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "close", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListRouter {
    void close();

    void followDeepLink(@NotNull DeepLink deepLink);

    void openLink(@NotNull Uri uri);

    void openShopDetailsScreen(@NotNull String str, @NotNull SearchParams searchParams);

    void openShortcut(@NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str);

    void showClarifyScreen(@NotNull ShopsSearchParameters shopsSearchParameters);
}
