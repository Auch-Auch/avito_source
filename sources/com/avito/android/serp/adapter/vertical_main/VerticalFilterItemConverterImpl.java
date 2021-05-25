package com.avito.android.serp.adapter.vertical_main;

import com.avito.android.remote.model.vertical_main.SearchFormWidget;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidget;", "entity", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;", "convertItem", "(Lcom/avito/android/remote/model/vertical_main/SearchFormWidget;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItemConverterImpl implements VerticalFilterItemConverter {
    @Override // com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter
    @Nullable
    public VerticalFilterItem convertItem(@NotNull SearchFormWidget searchFormWidget) {
        Intrinsics.checkNotNullParameter(searchFormWidget, "entity");
        if (!(!searchFormWidget.getFilters().isEmpty()) || searchFormWidget.getAction() == null) {
            return null;
        }
        return new VerticalFilterItem(String.valueOf(searchFormWidget.getUniqueId()), searchFormWidget.getTitle(), searchFormWidget.getFilters(), searchFormWidget.getAction(), searchFormWidget.getSubmitParams(), searchFormWidget.getAnalyticParams());
    }
}
