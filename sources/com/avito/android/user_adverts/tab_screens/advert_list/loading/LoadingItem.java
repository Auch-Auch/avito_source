package com.avito.android.user_adverts.tab_screens.advert_list.loading;

import com.avito.android.public_profile.adapter.loading_item.PageLoadingItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LoadingItem implements SerpItem {
    @NotNull
    public final String a = PageLoadingItem.ID;
    public final int b = 1;

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SerpItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
