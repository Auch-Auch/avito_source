package com.avito.android.serp.adapter;

import com.avito.android.ui.adapter.GridPositionProvider;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SpannedGridPositionProvider extends GridPositionProvider {
    void onDataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource);
}
