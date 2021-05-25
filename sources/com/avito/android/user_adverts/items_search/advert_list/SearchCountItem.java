package com.avito.android.user_adverts.items_search.advert_list;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.single_text.SingleTextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/SearchCountItem;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SearchCountItem implements SingleTextItem, SerpItem {
    @NotNull
    public final String a = a.I2("UUID.randomUUID().toString()");
    public final int b = 1;
    @NotNull
    public final String c;

    public SearchCountItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c = str;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SingleTextItem.DefaultImpls.getId(this);
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

    @Override // com.avito.android.conveyor_shared_item.single_text.SingleTextItem
    @NotNull
    public String getTitle() {
        return this.c;
    }
}
