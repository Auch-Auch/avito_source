package com.avito.android.rating.details.adapter;

import android.os.Parcelable;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "Lcom/avito/conveyor_item/Item;", "", "describeContents", "()I", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public abstract class RatingDetailsItem implements Item, Parcelable, com.avito.conveyor_item.Item {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }
}
