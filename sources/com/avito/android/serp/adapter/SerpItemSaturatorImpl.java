package com.avito.android.serp.adapter;

import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemSaturatorImpl;", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "item", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "saturate", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "viewedAdvertsInteractor", "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "c", "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "closedItemInteractor", "<init>", "(Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemSaturatorImpl implements SerpItemSaturator {
    public final FavoritesSyncDao a;
    public final ViewedAdvertsInteractor b;
    public final ClosedItemInteractor c;

    @Inject
    public SerpItemSaturatorImpl(@NotNull FavoritesSyncDao favoritesSyncDao, @NotNull ViewedAdvertsInteractor viewedAdvertsInteractor, @NotNull ClosedItemInteractor closedItemInteractor) {
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "favoritesSyncDao");
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractor, "viewedAdvertsInteractor");
        Intrinsics.checkNotNullParameter(closedItemInteractor, "closedItemInteractor");
        this.a = favoritesSyncDao;
        this.b = viewedAdvertsInteractor;
        this.c = closedItemInteractor;
    }

    @Override // com.avito.android.serp.adapter.SerpItemSaturator
    @NotNull
    public ViewTypeSerpItem saturate(@NotNull ViewTypeSerpItem viewTypeSerpItem, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(viewTypeSerpItem, "item");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (viewTypeSerpItem instanceof DisplayTypeAwareItem) {
            ((DisplayTypeAwareItem) viewTypeSerpItem).setDisplayType(serpDisplayType);
        }
        if (viewTypeSerpItem instanceof FavorableItem) {
            ((FavorableItem) viewTypeSerpItem).setFavorite(this.a.isFavorite(viewTypeSerpItem.getStringId(), ((FavorableItem) viewTypeSerpItem).isFavorite()));
        }
        if (viewTypeSerpItem instanceof ViewedAdvertItem) {
            ((ViewedAdvertItem) viewTypeSerpItem).setViewed(this.b.isViewed(viewTypeSerpItem.getStringId()));
        }
        if (viewTypeSerpItem instanceof ClosableSerpItem) {
            ((ClosableSerpItem) viewTypeSerpItem).setClosed(this.c.isClosed(viewTypeSerpItem.getStringId()));
        }
        return viewTypeSerpItem;
    }
}
