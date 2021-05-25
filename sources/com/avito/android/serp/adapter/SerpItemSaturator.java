package com.avito.android.serp.adapter;

import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemSaturator;", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "item", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "saturate", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpItemSaturator {
    @NotNull
    ViewTypeSerpItem saturate(@NotNull ViewTypeSerpItem viewTypeSerpItem, @NotNull SerpDisplayType serpDisplayType);
}
