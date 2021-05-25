package com.avito.android.brandspace.items.marketplace;

import com.avito.konveyor.blueprint.ItemBlueprint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;", "Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselItemsBlueprints;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "blueprints", "<init>", "(Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class WrapUniversalCarouselItemsBlueprints extends UniversalCarouselItemsBlueprints {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapUniversalCarouselItemsBlueprints(@NotNull List<? extends ItemBlueprint<?, ?>> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "blueprints");
    }
}
