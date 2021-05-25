package com.avito.android.grouping_adverts;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.GroupingIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.deep_linking.links.AdvertListLink;
import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AreaSearchParams;
import com.avito.android.remote.model.SearchParam;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.view.PanelStateKt;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingIntentFactoryImpl;", "Lcom/avito/android/GroupingIntentFactory;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "context", PanelStateKt.PANEL_EXPANDED, "sellerId", "Landroid/content/Intent;", "expandedItemsListIntent", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/AdvertListLink;", "link", "advertItemListIntent", "(Lcom/avito/android/deep_linking/links/AdvertListLink;)Landroid/content/Intent;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "arguments", AuthSource.SEND_ABUSE, "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;)Landroid/content/Intent;", "Landroid/app/Application;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Lcom/avito/android/navigation/NavigationTabProvider;", "c", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/app/Application;Lcom/avito/android/CoreActivityIntentFactory;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/Features;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingIntentFactoryImpl implements GroupingIntentFactory {
    public final Application a;
    public final CoreActivityIntentFactory b;
    public final NavigationTabProvider c;
    public final Features d;

    @Inject
    public GroupingIntentFactoryImpl(@NotNull Application application, @NotNull CoreActivityIntentFactory coreActivityIntentFactory, @NotNull NavigationTabProvider navigationTabProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = application;
        this.b = coreActivityIntentFactory;
        this.c = navigationTabProvider;
        this.d = features;
    }

    public final Intent a(GroupingAdvertsArguments groupingAdvertsArguments) {
        NavigationTab currentTab = this.c.currentTab();
        if (!this.d.getGroupingAdvertsWithoutActivity().invoke().booleanValue() || currentTab == null) {
            return GroupingAdvertsActivity.Factory.create(this.a, groupingAdvertsArguments);
        }
        return this.b.mainScreenWithTab(new GroupingAdvertsFragmentData(groupingAdvertsArguments, currentTab));
    }

    @Override // com.avito.android.GroupingIntentFactory
    @NotNull
    public Intent advertItemListIntent(@NotNull AdvertListLink advertListLink) {
        Intrinsics.checkNotNullParameter(advertListLink, "link");
        return a(new GroupingAdvertsArguments.ItemList(advertListLink.getTitle(), advertListLink.getSubtitle(), advertListLink.getAdvertIds()));
    }

    @Override // com.avito.android.GroupingIntentFactory
    @NotNull
    public Intent expandedItemsListIntent(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        if (area != null) {
            Map<String, SearchParam<?>> params = searchParams.getParams();
            if (params == null) {
                params = r.emptyMap();
            }
            searchParams.setParams(r.plus(params, new Pair("searchArea", new AreaSearchParams(area))));
        }
        searchParams.setExpanded(str2);
        searchParams.setSellerId(str3);
        return a(new GroupingAdvertsArguments.Search(searchParams));
    }
}
