package com.avito.android.brandspace.interactor.events;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.brandspace.items.BlockType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/interactor/events/BrandspaceAdvertClickEvent;", "Lcom/avito/android/brandspace/interactor/events/BrandspaceEvent;", "", "", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/brandspace/items/BlockType;", "d", "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "brandSlug", "<init>", "(Ljava/lang/String;Lcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdvertClickEvent extends BrandspaceEvent {
    public final String c;
    public final BlockType d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceAdvertClickEvent(@NotNull String str, @NotNull BlockType blockType, @NotNull String str2) {
        super(str2, 4753, 1);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        Intrinsics.checkNotNullParameter(str2, "brandSlug");
        this.c = str;
        this.d = blockType;
    }

    @Override // com.avito.android.brandspace.interactor.events.BrandspaceEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        Map<String, Object> params = super.getParams();
        params.put("item_id", this.c);
        params.put("bs_block_type", this.d.getValue());
        return params;
    }
}
