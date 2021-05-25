package com.avito.android.brandspace.items.marketplace;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemBlueprint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\t\u0010\nR'\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselItemsBlueprints;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getBlueprints", "()Ljava/util/List;", "blueprints", "<init>", "(Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public class UniversalCarouselItemsBlueprints {
    @NotNull
    public final List<ItemBlueprint<?, ?>> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.ItemBlueprint<?, ?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public UniversalCarouselItemsBlueprints(@NotNull List<? extends ItemBlueprint<?, ?>> list) {
        Intrinsics.checkNotNullParameter(list, "blueprints");
        this.a = list;
    }

    @NotNull
    public final List<ItemBlueprint<?, ?>> getBlueprints() {
        return this.a;
    }
}
