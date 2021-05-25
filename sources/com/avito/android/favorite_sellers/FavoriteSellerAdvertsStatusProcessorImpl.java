package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessorImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "list", "updateStatuses", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "<init>", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellerAdvertsStatusProcessorImpl implements FavoriteSellerAdvertsStatusProcessor {
    public final FavoriteStatusResolver a;
    public final ViewedStatusResolver b;

    @Inject
    public FavoriteSellerAdvertsStatusProcessorImpl(@NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver) {
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        this.a = favoriteStatusResolver;
        this.b = viewedStatusResolver;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.favorite_sellers.FavoriteSellersItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessor
    @NotNull
    public List<FavoriteSellersItem> updateStatuses(@NotNull List<? extends FavoriteSellersItem> list) {
        ArrayList<AdvertListItem> i0 = a.i0(list, "list");
        for (Object obj : list) {
            if (obj instanceof AdvertListItem) {
                i0.add(obj);
            }
        }
        for (AdvertListItem advertListItem : i0) {
            this.b.resolveSync(advertListItem.getItems());
            this.a.resolveSync(advertListItem.getItems());
        }
        return list;
    }
}
