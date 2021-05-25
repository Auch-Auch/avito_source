package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.serp.adapter.SpannedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", "newSpanCount", "copyWithNewSpanCount", "(I)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "", "d", "Z", "isEnabled", "()Z", "setEnabled", "(Z)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/ItemType;", "c", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/ItemType;", "getItemType", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/ItemType;", "itemType", "e", "I", "getSpanCount", "()I", "spanCount", "Lcom/avito/android/remote/model/search/Filter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/search/Filter;", "getFilter", "()Lcom/avito/android/remote/model/search/Filter;", "setFilter", "(Lcom/avito/android/remote/model/search/Filter;)V", "filter", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/ItemType;ZI)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalSearchFilterFormItem implements SpannedItem {
    @NotNull
    public final String a;
    @Nullable
    public Filter b;
    @NotNull
    public final ItemType c;
    public boolean d;
    public final int e;

    public VerticalSearchFilterFormItem(@NotNull String str, @Nullable Filter filter, @NotNull ItemType itemType, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.a = str;
        this.b = filter;
        this.c = itemType;
        this.d = z;
        this.e = i;
    }

    @NotNull
    public final VerticalSearchFilterFormItem copyWithNewSpanCount(int i) {
        return new VerticalSearchFilterFormItem(getStringId(), this.b, this.c, this.d, i);
    }

    @Nullable
    public final Filter getFilter() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final ItemType getItemType() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final boolean isEnabled() {
        return this.d;
    }

    public final void setEnabled(boolean z) {
        this.d = z;
    }

    public final void setFilter(@Nullable Filter filter) {
        this.b = filter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalSearchFilterFormItem(String str, Filter filter, ItemType itemType, boolean z, int i, int i2, j jVar) {
        this(str, filter, (i2 & 4) != 0 ? ItemType.SELECT : itemType, (i2 & 8) != 0 ? true : z, i);
    }
}
