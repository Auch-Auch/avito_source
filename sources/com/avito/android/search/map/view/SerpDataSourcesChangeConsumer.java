package com.avito.android.search.map.view;

import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/map/view/SerpDataSourcesChangeConsumer;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "spannedItems", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "serpItems", "", "columnCount", "", "dataSourcesChanged", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SerpDataSourcesChangeConsumer {
    void dataSourcesChanged(@NotNull DataSource<SpannedItem> dataSource, @NotNull DataSource<ViewTypeSerpItem> dataSource2, int i);
}
