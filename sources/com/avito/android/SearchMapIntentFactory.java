package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J_\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/SearchMapIntentFactory;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "context", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "mapArea", "mapSerpState", "", "mapZoomLevel", "", UrlParams.SIMPLE_MAP, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/content/Intent;", "searchByMapIntent", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/Float;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SearchMapIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent searchByMapIntent$default(SearchMapIntentFactory searchMapIntentFactory, SearchParams searchParams, String str, Area area, Area area2, String str2, Float f, boolean z, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                return searchMapIntentFactory.searchByMapIntent(searchParams, str, area, area2, str2, f, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : treeClickStreamParent);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchByMapIntent");
        }
    }

    @NotNull
    Intent searchByMapIntent(@NotNull SearchParams searchParams, @Nullable String str, @Nullable Area area, @Nullable Area area2, @Nullable String str2, @Nullable Float f, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent);
}
