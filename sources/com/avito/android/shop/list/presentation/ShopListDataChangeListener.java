package com.avito.android.shop.list.presentation;

import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "Lcom/avito/android/shop/list/presentation/AdapterPresenterWrapper;", "Lcom/avito/android/shop/list/presentation/PositionsProviderWrapper;", "Lcom/avito/android/shop/list/presentation/SpanProviderWrapper;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListDataChangeListener extends AdapterPresenterWrapper, PositionsProviderWrapper, SpanProviderWrapper {
    void onDataSourceChanged(@NotNull DataSource<SpannedItem> dataSource);
}
