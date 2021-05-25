package com.avito.android.favorite_sellers;

import android.os.Parcelable;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "Lcom/avito/conveyor_item/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "isEditable", "()Z", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersItem extends Item, Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static int describeContents(@NotNull FavoriteSellersItem favoriteSellersItem) {
            return 0;
        }

        public static long getId(@NotNull FavoriteSellersItem favoriteSellersItem) {
            return Item.DefaultImpls.getId(favoriteSellersItem);
        }
    }

    @Override // android.os.Parcelable
    int describeContents();

    boolean isEditable();
}
