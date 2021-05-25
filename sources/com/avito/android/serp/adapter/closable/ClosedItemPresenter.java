package com.avito.android.serp.adapter.closable;

import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "", "Lcom/avito/android/serp/adapter/closable/ClosedItemView;", "view", "", "attachView", "(Lcom/avito/android/serp/adapter/closable/ClosedItemView;)V", "detachView", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ClosedItemPresenter {
    void attachView(@NotNull ClosedItemView closedItemView);

    void detachView();

    void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource);
}
