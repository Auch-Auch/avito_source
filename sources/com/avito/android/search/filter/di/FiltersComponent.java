package com.avito.android.search.filter.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.filter.FiltersFragment;
import com.avito.android.search.filter.di.FiltersModule;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersComponent;", "", "Lcom/avito/android/search/filter/FiltersFragment;", "fragment", "", "inject", "(Lcom/avito/android/search/filter/FiltersFragment;)V", "Builder", "filter_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {FiltersDependencies.class, LocationDependencies.class}, modules = {FiltersModule.class, FiltersTrackerModule.class, SavedLocationInteractorModule.class})
@PerFragment
public interface FiltersComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\rH'¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#H'¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010'H'¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010+H'¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\rH'¢\u0006\u0004\b0\u0010\u0010J\u001b\u00103\u001a\u00020\u00002\n\b\u0001\u00102\u001a\u0004\u0018\u000101H'¢\u0006\u0004\b3\u00104J\u001b\u00106\u001a\u00020\u00002\n\b\u0001\u00105\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b6\u0010\fJ\u001b\u00108\u001a\u00020\u00002\n\b\u0001\u00107\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b8\u0010\fJ\u000f\u0010:\u001a\u000209H&¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "", "Lcom/avito/android/search/filter/di/FiltersDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/search/filter/di/FiltersDependencies;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "", "isOnlySortShown", "withIsOnlySortShown", "(Z)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "isFirstStart", "withIsFirstStart", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "withActivityInteractor", "(Lcom/avito/android/ui/ActivityInteractor;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "withSearchParams", "(Lcom/avito/android/remote/model/SearchParams;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/FilterAnalyticsData;", "analyticsData", "withFilterAnalyticsData", "(Lcom/avito/android/FilterAnalyticsData;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "withSearchArea", "(Lcom/avito/android/remote/model/search/map/Area;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "ShowSimpleMap", "withShowSimpleMap", "", "mapSerpState", "withMapSerpState", "(Ljava/lang/String;)Lcom/avito/android/search/filter/di/FiltersComponent$Builder;", "interactorState", "withInteractorState", "bubblesSelectItemPresenterState", "withBubblePresenterState", "Lcom/avito/android/search/filter/di/FiltersComponent;", "build", "()Lcom/avito/android/search/filter/di/FiltersComponent;", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FiltersComponent build();

        @NotNull
        Builder dependentOn(@NotNull FiltersDependencies filtersDependencies);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withActivityInteractor(@NotNull ActivityInteractor activityInteractor);

        @BindsInstance
        @NotNull
        Builder withBubblePresenterState(@FiltersModule.BubblePresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withFilterAnalyticsData(@Nullable FilterAnalyticsData filterAnalyticsData);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder withInteractorState(@FiltersModule.InteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withIsFirstStart(@FiltersModule.IsFirstStart boolean z);

        @BindsInstance
        @NotNull
        Builder withIsOnlySortShown(@FiltersModule.IsOnlySortShown boolean z);

        @BindsInstance
        @NotNull
        Builder withMapSerpState(@FiltersModule.MapSerpState @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@FiltersModule.PresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSearchArea(@Nullable Area area);

        @BindsInstance
        @NotNull
        Builder withSearchParams(@Nullable SearchParams searchParams);

        @BindsInstance
        @NotNull
        Builder withShowSimpleMap(@FiltersModule.ShowSimpleMap boolean z);
    }

    void inject(@NotNull FiltersFragment filtersFragment);
}
