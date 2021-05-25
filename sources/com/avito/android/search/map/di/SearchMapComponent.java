package com.avito.android.search.map.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.avito_map.AvitoMapZoomLevel;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertXlState;
import com.avito.android.di.module.RichGalleryState;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.di.module.WitcherModule;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.inline_filters.di.InlineFiltersState;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.saved_searches.di.SavedSearchState;
import com.avito.android.search.map.SearchMapFragment;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.Relay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/search/map/di/SearchMapComponent;", "", "Lcom/avito/android/search/map/SearchMapFragment;", "fragment", "", "inject", "(Lcom/avito/android/search/map/SearchMapFragment;)V", "Builder", "map_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SearchMapDependencies.class, ScreenAnalyticsDependencies.class, LocationDependencies.class}, modules = {SearchMapModule.class, FpsModule.class, SavedLocationInteractorModule.class})
@PerFragment
public interface SearchMapComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\"H'¢\u0006\u0004\b$\u0010%J\u001b\u0010(\u001a\u00020\u00002\n\b\u0001\u0010'\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b(\u0010)J\u001b\u0010,\u001a\u00020\u00002\n\b\u0001\u0010+\u001a\u0004\u0018\u00010*H'¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010.H'¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u000202H'¢\u0006\u0004\b4\u00105J\u001b\u00106\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b6\u0010)J\u001b\u00107\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b7\u0010)J\u0017\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u000208H'¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b<\u0010)J\u001b\u0010=\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010&H'¢\u0006\u0004\b=\u0010)J\u001b\u0010@\u001a\u00020\u00002\n\b\u0001\u0010?\u001a\u0004\u0018\u00010>H'¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020\u00002\u0006\u0010C\u001a\u00020BH'¢\u0006\u0004\bD\u0010EJ+\u0010K\u001a\u00020\u00002\u001a\b\u0001\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G0FH'¢\u0006\u0004\bK\u0010LJ+\u0010M\u001a\u00020\u00002\u001a\b\u0001\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G0FH'¢\u0006\u0004\bM\u0010LJ+\u0010O\u001a\u00020\u00002\u001a\b\u0001\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020N0G0FH'¢\u0006\u0004\bO\u0010LJ\u0017\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020PH'¢\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010TH'¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH&¢\u0006\u0004\bY\u0010Z¨\u0006["}, d2 = {"Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "", "Lcom/avito/android/search/map/di/SearchMapDependencies;", "searchMapDependencies", "(Lcom/avito/android/search/map/di/SearchMapDependencies;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/search/map/di/SearchMapModule;", "searchMapModule", "(Lcom/avito/android/search/map/di/SearchMapModule;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "dependencies", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "arguments", "withArguments", "(Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/search/map/SearchMapState;", "state", "withSavedSearchMapState", "(Lcom/avito/android/search/map/SearchMapState;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/util/Kundle;", "savedState", "withWitcherSavedState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "initParent", "withInitTreeClickStreamParent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Landroid/view/View;", "view", "withViewProvider", "(Landroid/view/View;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/avito_map/AvitoMapZoomLevel;", "zoomLevel", "withMapZoomLevelBounds", "(Lcom/avito/android/avito_map/AvitoMapZoomLevel;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "withAdvertXlState", "withRichGalleryState", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "withRichSnippetRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "withInlineFiltersState", "withSavedSearchesPresenterState", "Landroid/os/Bundle;", "defaultVisibilityTrackerState", "withItemVisibilityTrackerState", "(Landroid/os/Bundle;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "bannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "", "relay", "snippetClick", "(Lcom/jakewharton/rxrelay3/Relay;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "snippetClose", "", "snippetVisibility", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "withFragmentManager", "(Landroidx/fragment/app/FragmentManager;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "handler", "withSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/search/map/di/SearchMapComponent$Builder;", "Lcom/avito/android/search/map/di/SearchMapComponent;", "build", "()Lcom/avito/android/search/map/di/SearchMapComponent;", "map_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bannerPageSource(@NotNull BannerPageSource bannerPageSource);

        @NotNull
        SearchMapComponent build();

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);

        @NotNull
        Builder screenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);

        @NotNull
        Builder searchMapDependencies(@NotNull SearchMapDependencies searchMapDependencies);

        @NotNull
        Builder searchMapModule(@NotNull SearchMapModule searchMapModule);

        @BindsInstance
        @NotNull
        Builder snippetClick(@SnippetClick @NotNull Relay<Pair<SnippetItem, Integer>> relay);

        @BindsInstance
        @NotNull
        Builder snippetClose(@SnippetClose @NotNull Relay<Pair<SnippetItem, Integer>> relay);

        @BindsInstance
        @NotNull
        Builder snippetVisibility(@SnippetVisibility @NotNull Relay<Pair<SnippetItem, Boolean>> relay);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withAdvertXlState(@AdvertXlState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withArguments(@NotNull SearchMapFragment.Factory.Arguments arguments);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder withFragmentManager(@NotNull FragmentManager fragmentManager);

        @BindsInstance
        @NotNull
        Builder withInitTreeClickStreamParent(@InitTreeClickStreamParent @Nullable TreeClickStreamParent treeClickStreamParent);

        @BindsInstance
        @NotNull
        Builder withInlineFiltersState(@InlineFiltersState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withItemVisibilityTrackerState(@SerpListItemVisibilityTrackerState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withMapZoomLevelBounds(@NotNull AvitoMapZoomLevel avitoMapZoomLevel);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withRichGalleryState(@RichGalleryState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withRichSnippetRecycledViewPool(@NotNull RecyclerView.RecycledViewPool recycledViewPool);

        @BindsInstance
        @NotNull
        Builder withSavedSearchMapState(@Nullable SearchMapState searchMapState);

        @BindsInstance
        @NotNull
        Builder withSavedSearchesPresenterState(@SavedSearchState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withSerpOnboardingHandler(@Nullable SerpOnboardingHandler serpOnboardingHandler);

        @BindsInstance
        @NotNull
        Builder withViewProvider(@Nullable View view);

        @BindsInstance
        @NotNull
        Builder withWitcherSavedState(@WitcherModule.WitcherItemsSavedState @Nullable Kundle kundle);
    }

    void inject(@NotNull SearchMapFragment searchMapFragment);
}
