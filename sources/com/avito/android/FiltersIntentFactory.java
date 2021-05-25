package com.avito.android;

import android.content.Intent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JY\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/FiltersIntentFactory;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "mapSerpState", "", "isOnlySortShown", "Lcom/avito/android/FilterAnalyticsData;", "analyticsData", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", UrlParams.SIMPLE_MAP, "Landroid/content/Intent;", "searchIntent", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/FilterAnalyticsData;Lcom/avito/android/bottom_navigation/NavigationTab;Z)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent searchIntent$default(FiltersIntentFactory filtersIntentFactory, SearchParams searchParams, Area area, String str, boolean z, FilterAnalyticsData filterAnalyticsData, NavigationTab navigationTab, boolean z2, int i, Object obj) {
            if (obj == null) {
                NavigationTab navigationTab2 = null;
                Area area2 = (i & 2) != 0 ? null : area;
                String str2 = (i & 4) != 0 ? null : str;
                boolean z3 = false;
                boolean z4 = (i & 8) != 0 ? false : z;
                FilterAnalyticsData filterAnalyticsData2 = (i & 16) != 0 ? new FilterAnalyticsData(null, null, null, 7, null) : filterAnalyticsData;
                if ((i & 32) == 0) {
                    navigationTab2 = navigationTab;
                }
                if ((i & 64) == 0) {
                    z3 = z2;
                }
                return filtersIntentFactory.searchIntent(searchParams, area2, str2, z4, filterAnalyticsData2, navigationTab2, z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchIntent");
        }
    }

    @NotNull
    Intent searchIntent(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, boolean z, @NotNull FilterAnalyticsData filterAnalyticsData, @Nullable NavigationTab navigationTab, boolean z2);
}
