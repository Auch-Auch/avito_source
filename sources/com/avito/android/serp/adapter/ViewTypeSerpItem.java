package com.avito.android.serp.adapter;

import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ViewTypeSerpItem extends SerpItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ViewTypeSerpItem viewTypeSerpItem) {
            return SerpItem.DefaultImpls.getId(viewTypeSerpItem);
        }
    }

    @NotNull
    SerpViewType getViewType();
}
