package com.avito.android.di.component;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertXlState;
import com.avito.android.di.module.RichGalleryState;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.di.module.SerpInteractorModule;
import com.avito.android.di.module.SerpItemVisibilityTrackerState;
import com.avito.android.di.module.SerpModule;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.di.module.WitcherModule;
import com.avito.android.floating_views.FloatingViewsPresenterState;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.inline_filters.di.InlineFiltersState;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.saved_searches.di.SavedSearchState;
import com.avito.android.search.filter.di.FiltersModule;
import com.avito.android.serp.SerpArguments;
import com.avito.android.serp.SerpFragment;
import com.avito.android.serp.SerpPresenterState;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerState;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterState;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.serp.warning.WarningStateProviderState;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.Relay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/SerpComponent;", "", "Lcom/avito/android/serp/SerpFragment;", "serpFragment", "", "inject", "(Lcom/avito/android/serp/SerpFragment;)V", "Builder", "serp_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SerpDependencies.class, LocationDependencies.class, ScreenAnalyticsDependencies.class}, modules = {SerpModule.class, FpsModule.class})
@PerFragment
public interface SerpComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00002\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00002\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00002\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010 H'¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b#\u0010\u0018J\u001b\u0010%\u001a\u00020\u00002\n\b\u0001\u0010%\u001a\u0004\u0018\u00010$H'¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010'H'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*H'¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\u00002\b\b\u0001\u0010.\u001a\u00020-H'¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u00020\u00002\u001a\b\u0001\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030100H'¢\u0006\u0004\b5\u00106J+\u00107\u001a\u00020\u00002\u001a\b\u0001\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030100H'¢\u0006\u0004\b7\u00106J+\u00108\u001a\u00020\u00002\u001a\b\u0001\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-0100H'¢\u0006\u0004\b8\u00106J\u0017\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u000209H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=H'¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH'¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020\u00002\b\u0010F\u001a\u0004\u0018\u00010EH'¢\u0006\u0004\bG\u0010HJ\u0019\u0010K\u001a\u00020\u00002\b\u0010J\u001a\u0004\u0018\u00010IH'¢\u0006\u0004\bK\u0010LJ\u001b\u0010N\u001a\u00020\u00002\n\b\u0001\u0010M\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010Q\u001a\u00020\u00002\n\b\u0001\u0010P\u001a\u0004\u0018\u00010OH'¢\u0006\u0004\bQ\u0010RJ\u001b\u0010S\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\bS\u0010\u0018J\u001b\u0010U\u001a\u00020\u00002\n\b\u0001\u0010T\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\bU\u0010\u0018J\u001b\u0010W\u001a\u00020\u00002\n\b\u0001\u0010V\u001a\u0004\u0018\u00010$H'¢\u0006\u0004\bW\u0010&J\u0019\u0010Y\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010XH'¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H'¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020-H'¢\u0006\u0004\b`\u0010/J\u001b\u0010a\u001a\u00020\u00002\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\ba\u0010\u0018J\u0019\u0010c\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010bH'¢\u0006\u0004\bc\u0010dJ\u000f\u0010f\u001a\u00020eH&¢\u0006\u0004\bf\u0010g¨\u0006h"}, d2 = {"Lcom/avito/android/di/component/SerpComponent$Builder;", "", "Lcom/avito/android/di/component/SerpDependencies;", "dependencies", "serpDependencies", "(Lcom/avito/android/di/component/SerpDependencies;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/serp/SerpArguments;", "serpArguments", "(Lcom/avito/android/serp/SerpArguments;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withAdvertXlState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/di/component/SerpComponent$Builder;", "withRichGalleryState", "savedState", "withWitcherSavedState", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "withRichSnippetRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/serp/SerpPresenterState;", "presenterState", "(Lcom/avito/android/serp/SerpPresenterState;)Lcom/avito/android/di/component/SerpComponent$Builder;", "interactorState", "Landroid/os/Bundle;", "floatingViewsPresenterState", "(Landroid/os/Bundle;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/serp/warning/WarningStateProviderState;", "warningStates", "(Lcom/avito/android/serp/warning/WarningStateProviderState;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "(Landroidx/fragment/app/FragmentManager;)Lcom/avito/android/di/component/SerpComponent$Builder;", "", "showJobNearbyBanner", "(Z)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "", "relay", "snippetClick", "(Lcom/jakewharton/rxrelay3/Relay;)Lcom/avito/android/di/component/SerpComponent$Builder;", "snippetClose", "snippetVisibility", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "withActivityInteractor", "(Lcom/avito/android/ui/ActivityInteractor;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "withSearchParams", "(Lcom/avito/android/remote/model/SearchParams;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "withSearchArea", "(Lcom/avito/android/remote/model/search/map/Area;)Lcom/avito/android/di/component/SerpComponent$Builder;", "inlineFiltersState", "withInlineFiltersState", "", "mapSerpState", "withMapSerpState", "(Ljava/lang/String;)Lcom/avito/android/di/component/SerpComponent$Builder;", "withInteractorState", "bubblesSelectItemPresenterState", "withBubblePresenterState", "defaultVisibilityTrackerState", "withItemVisibilityTrackerState", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "withVerticalFilterState", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "bannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/di/component/SerpComponent$Builder;", "isFirstStart", "withIsFirstStart", "withSavedSearchState", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;", "withSerpOnboardingHandlerState", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerState;)Lcom/avito/android/di/component/SerpComponent$Builder;", "Lcom/avito/android/di/component/SerpComponent;", "build", "()Lcom/avito/android/di/component/SerpComponent;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bannerPageSource(@NotNull BannerPageSource bannerPageSource);

        @NotNull
        SerpComponent build();

        @BindsInstance
        @NotNull
        Builder floatingViewsPresenterState(@FloatingViewsPresenterState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder fragmentManager(@NotNull FragmentManager fragmentManager);

        @BindsInstance
        @NotNull
        Builder interactorState(@Nullable Kundle kundle);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @BindsInstance
        @NotNull
        Builder presenterState(@Nullable SerpPresenterState serpPresenterState);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);

        @NotNull
        Builder screenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);

        @BindsInstance
        @NotNull
        Builder serpArguments(@NotNull SerpArguments serpArguments);

        @NotNull
        Builder serpDependencies(@NotNull SerpDependencies serpDependencies);

        @BindsInstance
        @NotNull
        Builder showJobNearbyBanner(@SerpInteractorModule.ShowJobNearbyBanner boolean z);

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
        Builder warningStates(@Nullable WarningStateProviderState warningStateProviderState);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withActivityInteractor(@NotNull ActivityInteractor activityInteractor);

        @BindsInstance
        @NotNull
        Builder withAdvertXlState(@AdvertXlState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withBubblePresenterState(@FiltersModule.BubblePresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder withInlineFiltersState(@InlineFiltersState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withInteractorState(@FiltersModule.InteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withIsFirstStart(boolean z);

        @BindsInstance
        @NotNull
        Builder withItemVisibilityTrackerState(@SerpItemVisibilityTrackerState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withMapSerpState(@FiltersModule.MapSerpState @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withRichGalleryState(@RichGalleryState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withRichSnippetRecycledViewPool(@NotNull RecyclerView.RecycledViewPool recycledViewPool);

        @BindsInstance
        @NotNull
        Builder withSavedSearchState(@SavedSearchState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withSearchArea(@Nullable Area area);

        @BindsInstance
        @NotNull
        Builder withSearchParams(@Nullable SearchParams searchParams);

        @BindsInstance
        @NotNull
        Builder withSerpOnboardingHandlerState(@Nullable SerpOnboardingHandlerState serpOnboardingHandlerState);

        @BindsInstance
        @NotNull
        Builder withVerticalFilterState(@Nullable VerticalFilterState verticalFilterState);

        @BindsInstance
        @NotNull
        Builder withWitcherSavedState(@WitcherModule.WitcherItemsSavedState @Nullable Kundle kundle);
    }

    void inject(@NotNull SerpFragment serpFragment);
}
