package com.avito.android.search.map;

import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.SearchMapIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.SearchMapFragment;
import com.avito.android.util.UrlParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J[\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/map/SearchMapIntentFactoryImpl;", "Lcom/avito/android/SearchMapIntentFactory;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "context", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "mapArea", "mapSerpState", "", "mapZoomLevel", "", UrlParams.SIMPLE_MAP, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/content/Intent;", "searchByMapIntent", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/Float;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public class SearchMapIntentFactoryImpl implements SearchMapIntentFactory {
    public final CoreActivityIntentFactory a;

    @Inject
    public SearchMapIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = coreActivityIntentFactory;
    }

    @Override // com.avito.android.SearchMapIntentFactory
    @NotNull
    public Intent searchByMapIntent(@NotNull SearchParams searchParams, @Nullable String str, @Nullable Area area, @Nullable Area area2, @Nullable String str2, @Nullable Float f, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return this.a.mainScreenWithTab(new SearchMapFragmentData(new SearchMapFragment.Factory.Arguments(searchParams, str, area, area2, str2, f, treeClickStreamParent, z), NavigationTab.SEARCH.INSTANCE));
    }
}
