package com.avito.android.user_subscribers.adapter;

import android.os.Parcelable;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "Lcom/avito/conveyor_item/Item;", "Landroid/os/Parcelable;", "<init>", "()V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public abstract class UserSubscriberItem implements Item, Parcelable {
    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }
}
