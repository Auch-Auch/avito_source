package com.avito.android.section.item;

import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/section/item/SectionItemWidthProvider;", "", "", "spanCount", "getWidthBySpanCount", "(I)I", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "getWidthByViewType", "(Lcom/avito/android/serp/adapter/SerpViewType;)I", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionItemWidthProvider {
    int getWidthBySpanCount(int i);

    int getWidthByViewType(@NotNull SerpViewType serpViewType);
}
