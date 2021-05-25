package com.avito.android.search.filter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/filter/FiltersActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpCustomToolbar", "()Z", "", "getContentLayoutId", "()I", "onBackPressed", "()V", "<init>", "Factory", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/FiltersActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "mapSerpState", "", "isOnlySortShown", "Lcom/avito/android/FilterAnalyticsData;", "analyticsData", "ShowSimpleMap", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/FilterAnalyticsData;Z)Landroid/content/Intent;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, boolean z, @Nullable FilterAnalyticsData filterAnalyticsData, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(searchParams, "searchParams");
            Intent putExtra = new Intent(context, FiltersActivity.class).putExtra("search_params", searchParams).putExtra("is_only_sort_shown", z).putExtra("show_simple_map", z2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…IMPLE_MAP, ShowSimpleMap)");
            if (area != null) {
                putExtra = putExtra.putExtra("search_area", area);
                Intrinsics.checkNotNullExpressionValue(putExtra, "intent.putExtra(KEY_SEARCH_AREA, searchArea)");
            }
            if (str != null) {
                putExtra = putExtra.putExtra("map_search_state", str);
                Intrinsics.checkNotNullExpressionValue(putExtra, "intent.putExtra(KEY_MAP_SERP_STATE, mapSerpState)");
            }
            if (filterAnalyticsData == null) {
                return putExtra;
            }
            Intent putExtra2 = putExtra.putExtra("filtersAnalyticsData", filterAnalyticsData);
            Intrinsics.checkNotNullExpressionValue(putExtra2, "intent.putExtra(KEY_FILT…TICS_DATA, analyticsData)");
            return putExtra2;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z;
        T t;
        T t2;
        boolean z2;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            z = false;
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            Intrinsics.checkNotNullExpressionValue(t3, "it");
            if (!t3.isVisible() || !(t3 instanceof FiltersFragment)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t2 instanceof FiltersFragment) {
            t = t2;
        }
        T t4 = t;
        if (t4 != null) {
            z = t4.onBackPressed();
        }
        if (!z) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            SearchParams searchParams = (SearchParams) getIntent().getParcelableExtra("search_params");
            if (searchParams != null) {
                Area area = (Area) getIntent().getParcelableExtra("search_area");
                String stringExtra = getIntent().getStringExtra("map_search_state");
                boolean booleanExtra = getIntent().getBooleanExtra("is_only_sort_shown", false);
                FilterAnalyticsData filterAnalyticsData = (FilterAnalyticsData) getIntent().getParcelableExtra("filtersAnalyticsData");
                if (filterAnalyticsData != null) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, FiltersFragment.Companion.newInstance(new FiltersArguments(searchParams, area, stringExtra, booleanExtra, filterAnalyticsData, getIntent().getBooleanExtra("show_simple_map", false)))).commit();
                    return;
                }
                throw new IllegalArgumentException("filtersAnalyticsData intent parameter required");
            }
            throw new IllegalArgumentException("search_params intent parameter required");
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
