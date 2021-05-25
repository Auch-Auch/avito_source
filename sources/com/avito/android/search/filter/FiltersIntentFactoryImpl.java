package com.avito.android.search.filter;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.FiltersIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.filter.FiltersActivity;
import com.avito.android.util.UrlParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJM\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/search/filter/FiltersIntentFactoryImpl;", "Lcom/avito/android/FiltersIntentFactory;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "mapSerpState", "", "isOnlySortShown", "Lcom/avito/android/FilterAnalyticsData;", "analyticsData", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", UrlParams.SIMPLE_MAP, "Landroid/content/Intent;", "searchIntent", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/FilterAnalyticsData;Lcom/avito/android/bottom_navigation/NavigationTab;Z)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersIntentFactoryImpl implements FiltersIntentFactory {
    public final Application a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public FiltersIntentFactoryImpl(@NotNull Application application, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @Override // com.avito.android.FiltersIntentFactory
    @NotNull
    public Intent searchIntent(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, boolean z, @NotNull FilterAnalyticsData filterAnalyticsData, @Nullable NavigationTab navigationTab, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(filterAnalyticsData, "analyticsData");
        if (!this.b.getFiltersWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return new FiltersActivity.Factory().createIntent(this.a, searchParams, area, str, z, filterAnalyticsData, z2);
        }
        return this.c.mainScreenWithTab(new FiltersFragmentData(new FiltersArguments(searchParams, area, str, z, filterAnalyticsData, z2), navigationTab));
    }
}
