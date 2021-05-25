package com.avito.android.favorite_sellers.action;

import com.avito.android.favorite_sellers.adapter.seller.SellerItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite_sellers/action/OpenSubscriptionSettings;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "getItem", "()Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "item", "<init>", "(Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class OpenSubscriptionSettings implements FavoriteSellersItemAction {
    @NotNull
    public final SellerItem a;

    public OpenSubscriptionSettings(@NotNull SellerItem sellerItem) {
        Intrinsics.checkNotNullParameter(sellerItem, "item");
        this.a = sellerItem;
    }

    @NotNull
    public final SellerItem getItem() {
        return this.a;
    }
}
