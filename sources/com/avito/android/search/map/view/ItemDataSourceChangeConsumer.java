package com.avito.android.search.map.view;

import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/ItemDataSourceChangeConsumer;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "columnCount", "", "dataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
public interface ItemDataSourceChangeConsumer {
    void dataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource, int i);
}
