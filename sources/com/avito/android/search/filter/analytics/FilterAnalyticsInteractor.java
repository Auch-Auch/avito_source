package com.avito.android.search.filter.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "", "", "fromActionBar", "", "sendBackClick", "(Z)V", "sendStartEvent", "()V", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "categoryId", "sendChangeDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)V", "filterName", "sectionName", "locationId", "sendSectionedFilterUsageEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FilterAnalyticsInteractor {
    @NotNull
    TreeClickStreamParent getParent();

    void sendBackClick(boolean z);

    void sendChangeDisplayType(@NotNull SerpDisplayType serpDisplayType, @Nullable String str);

    void sendSectionedFilterUsageEvent(@NotNull String str, @Nullable String str2, @Nullable String str3);

    void sendStartEvent();
}
