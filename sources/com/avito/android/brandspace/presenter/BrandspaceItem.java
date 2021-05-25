package com.avito.android.brandspace.presenter;

import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "Lcom/avito/android/brandspace/items/BlockType;", "getType", "()Lcom/avito/android/brandspace/items/BlockType;", "type", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceItem extends Item, Parcelable {
    @NotNull
    BlockType getType();
}
