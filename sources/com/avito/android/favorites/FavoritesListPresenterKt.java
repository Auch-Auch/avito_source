package com.avito.android.favorites;

import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"favorites_release"}, k = 2, mv = {1, 4, 2})
public final class FavoritesListPresenterKt {
    public static final String access$extractContext(FavoriteAdvertItem favoriteAdvertItem) {
        DeepLink deepLink = favoriteAdvertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null) {
            return advertDetailsLink.getContext();
        }
        return null;
    }
}
