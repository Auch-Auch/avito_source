package com.avito.android.brandspace.interactor.events;

import com.avito.android.brandspace.items.BlockType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/brandspace/interactor/events/BrandspaceBlockClickEvent;", "Lcom/avito/android/brandspace/interactor/events/BrandspaceEvent;", "", "", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/brandspace/items/BlockType;", "c", "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "brandSlug", "<init>", "(Lcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceBlockClickEvent extends BrandspaceEvent {
    public final BlockType c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceBlockClickEvent(@NotNull BlockType blockType, @NotNull String str) {
        super(str, 4752, 1);
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        Intrinsics.checkNotNullParameter(str, "brandSlug");
        this.c = blockType;
    }

    @Override // com.avito.android.brandspace.interactor.events.BrandspaceEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        Map<String, Object> params = super.getParams();
        params.put("bs_block_type", this.c.getValue());
        return params;
    }
}
