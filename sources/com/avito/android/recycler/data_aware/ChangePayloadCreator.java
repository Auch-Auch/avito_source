package com.avito.android.recycler.data_aware;

import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "", "Lcom/avito/konveyor/blueprint/Item;", "oldItem", "newItem", "getChangePayload", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Ljava/lang/Object;", "recycler_release"}, k = 1, mv = {1, 4, 2})
public interface ChangePayloadCreator {
    @Nullable
    Object getChangePayload(@Nullable Item item, @Nullable Item item2);
}
