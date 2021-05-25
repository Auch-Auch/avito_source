package com.avito.android.serp.ad;

import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/ad/AdResourceProvider;", "", "", "itemSpanCount", "bigSpanCount", "Lcom/avito/android/remote/model/AdSize;", "adSize", "getSpanCount", "(IILcom/avito/android/remote/model/AdSize;)I", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/SerpViewType;", "getSerpViewType", "(Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/AdSize;)Lcom/avito/android/serp/adapter/SerpViewType;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdResourceProvider {
    @NotNull
    SerpViewType getSerpViewType(@NotNull SerpDisplayType serpDisplayType, @NotNull AdSize adSize);

    int getSpanCount(int i, int i2, @NotNull AdSize adSize);
}
