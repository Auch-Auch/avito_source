package com.avito.conveyor_item;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/conveyor_item/Item;", "Lcom/avito/konveyor/blueprint/Item;", "", "getStringId", "()Ljava/lang/String;", "stringId", "", "getId", "()J", "id", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface Item extends com.avito.konveyor.blueprint.Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull Item item) {
            return (long) item.getStringId().hashCode();
        }
    }

    @Override // com.avito.konveyor.blueprint.Item
    long getId();

    @NotNull
    String getStringId();
}
