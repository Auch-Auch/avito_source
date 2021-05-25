package com.avito.android.serp.adapter;

import com.avito.android.ui.adapter.AppendingListener;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/SerpSpanProvider;", "Lcom/avito/android/serp/adapter/SpanProvider;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "setAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "", "getColumnsCount", "()I", "setColumnsCount", "(I)V", "columnsCount", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpSpanProvider extends SpanProvider {
    int getColumnsCount();

    void onDataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource);

    void setAppendingListener(@NotNull AppendingListener appendingListener);

    void setColumnsCount(int i);
}
