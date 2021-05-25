package com.avito.android.search.filter.analytics;

import com.avito.android.FilterAnalyticsData;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.filter.FilterOpenedEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u0010*\u001a\u0004\u0018\u00010'¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractorImpl;", "Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "", "fromActionBar", "", "sendBackClick", "(Z)V", "sendStartEvent", "()V", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "categoryId", "sendChangeDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)V", "filterName", "sectionName", "locationId", "sendSectionedFilterUsageEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "J", "stateId", "Lcom/avito/android/remote/model/SearchParams;", "c", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "d", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/FilterAnalyticsData;", "e", "Lcom/avito/android/FilterAnalyticsData;", "analyticsData", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/FilterAnalyticsData;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FilterAnalyticsInteractorImpl implements FilterAnalyticsInteractor {
    public long a;
    public final Analytics b;
    public final SearchParams c;
    public final TreeStateIdGenerator d;
    public final FilterAnalyticsData e;

    @Inject
    public FilterAnalyticsInteractorImpl(@NotNull Analytics analytics, @Nullable SearchParams searchParams, @NotNull TreeStateIdGenerator treeStateIdGenerator, @Nullable FilterAnalyticsData filterAnalyticsData) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        this.b = analytics;
        this.c = searchParams;
        this.d = treeStateIdGenerator;
        this.e = filterAnalyticsData;
        this.a = treeStateIdGenerator.nextStateId();
    }

    @Override // com.avito.android.search.filter.analytics.FilterAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.a, ScreenIdField.FILTERS.name(), null, null);
    }

    @Override // com.avito.android.search.filter.analytics.FilterAnalyticsInteractor
    public void sendBackClick(boolean z) {
        this.b.track(new BackPressFilterEvent(this.d.nextStateId(), getParent(), z));
    }

    @Override // com.avito.android.search.filter.analytics.FilterAnalyticsInteractor
    public void sendChangeDisplayType(@NotNull SerpDisplayType serpDisplayType, @Nullable String str) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.b.track(new ChangeDisplayTypeEvent(serpDisplayType, str));
    }

    @Override // com.avito.android.search.filter.analytics.FilterAnalyticsInteractor
    public void sendSectionedFilterUsageEvent(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "filterName");
        this.b.track(new SectionedFilterUsageEvent(str, str2, str3));
    }

    @Override // com.avito.android.search.filter.analytics.FilterAnalyticsInteractor
    public void sendStartEvent() {
        FilterAnalyticsData.Source source;
        Analytics analytics = this.b;
        long nextStateId = this.d.nextStateId();
        TreeClickStreamParent parent = getParent();
        SearchParams searchParams = this.c;
        String locationId = searchParams != null ? searchParams.getLocationId() : null;
        SearchParams searchParams2 = this.c;
        String categoryId = searchParams2 != null ? searchParams2.getCategoryId() : null;
        FilterAnalyticsData filterAnalyticsData = this.e;
        String profileType = filterAnalyticsData != null ? filterAnalyticsData.getProfileType() : null;
        FilterAnalyticsData filterAnalyticsData2 = this.e;
        String userKey = filterAnalyticsData2 != null ? filterAnalyticsData2.getUserKey() : null;
        FilterAnalyticsData filterAnalyticsData3 = this.e;
        String value = (filterAnalyticsData3 == null || (source = filterAnalyticsData3.getSource()) == null) ? null : source.getValue();
        SearchParams searchParams3 = this.c;
        analytics.track(new FilterOpenedEvent(nextStateId, parent, locationId, categoryId, profileType, userKey, value, searchParams3 != null ? searchParams3.getShopId() : null));
    }
}
