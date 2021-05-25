package com.avito.android.grouping_adverts.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.di.module.AppendingLoaderModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.RichGalleryState;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.di.module.SpanAdapterModule;
import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.grouping_adverts.GroupingAdvertsFragment;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent;", "", "Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment;", "activity", "", "inject", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsFragment;)V", "Builder", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {GroupingAdvertsDependencies.class}, modules = {GroupingAdvertsModule.class, AdvertItemModule.class, SerpItemConverterModule.class, FavoriteAdvertsPresenterModule.class, SpanAdapterModule.class, AppendingLoaderModule.class, GroupingAdvertsTrackerModule.class})
@PerFragment
public interface GroupingAdvertsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00002\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "", "Lcom/avito/android/grouping_adverts/di/GroupingAdvertsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/grouping_adverts/di/GroupingAdvertsDependencies;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "advertArguments", "withSearchParams", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "withRichGalleryState", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "withRichSnippetRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "handler", "withSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent$Builder;", "Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent;", "build", "()Lcom/avito/android/grouping_adverts/di/GroupingAdvertsComponent;", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        GroupingAdvertsComponent build();

        @NotNull
        Builder dependentOn(@NotNull GroupingAdvertsDependencies groupingAdvertsDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

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
        Builder withScreen(@NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder withSearchParams(@NotNull GroupingAdvertsArguments groupingAdvertsArguments);

        @BindsInstance
        @NotNull
        Builder withSerpOnboardingHandler(@Nullable SerpOnboardingHandler serpOnboardingHandler);
    }

    void inject(@NotNull GroupingAdvertsFragment groupingAdvertsFragment);
}
