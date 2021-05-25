package com.avito.konveyor.util;

import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/konveyor/blueprint/Item;", "T", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "items", "", "updateItems", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Ljava/util/List;)V", "konveyor_release"}, k = 2, mv = {1, 4, 2})
public final class AdapterPresentersKt {
    public static final <T extends Item> void updateItems(@NotNull AdapterPresenter adapterPresenter, @NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "$this$updateItems");
        Intrinsics.checkNotNullParameter(list, "items");
        adapterPresenter.onDataSourceChanged(new ListDataSource(list));
    }
}
