package com.avito.android.di.component;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.HomeModule;
import com.avito.android.di.module.LocationNotificationClick;
import com.avito.android.di.module.LocationNotificationVisibility;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.di.module.WitcherModule;
import com.avito.android.floating_views.FloatingViewsPresenterState;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.home.HomeFragment;
import com.avito.android.home.HomeInteractorState;
import com.avito.android.home.HomePresenterState;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.serp.adapter.location_notification.LocationNotificationActionData;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.Relay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/HomeComponent;", "", "Lcom/avito/android/home/HomeFragment;", "fragment", "", "inject", "(Lcom/avito/android/home/HomeFragment;)V", "Builder", "serp_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SerpDependencies.class, LocationDependencies.class, HomeDependencies.class, ScreenAnalyticsDependencies.class}, modules = {HomeModule.class, FpsModule.class})
@PerFragment
public interface HomeComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00002\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0010\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0011\u0010\u000eJ\u001b\u0010\u0013\u001a\u00020\u00002\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020.H&¢\u0006\u0004\b/\u00100J+\u00106\u001a\u00020\u00002\u001a\b\u0001\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040201H'¢\u0006\u0004\b6\u00107J+\u00108\u001a\u00020\u00002\u001a\b\u0001\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040201H'¢\u0006\u0004\b8\u00107J+\u0010:\u001a\u00020\u00002\u001a\b\u0001\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002090201H'¢\u0006\u0004\b:\u00107J\u001f\u0010<\u001a\u00020\u00002\u000e\b\u0001\u00105\u001a\b\u0012\u0004\u0012\u00020;01H'¢\u0006\u0004\b<\u00107J\u001f\u0010=\u001a\u00020\u00002\u000e\b\u0001\u00105\u001a\b\u0012\u0004\u0012\u00020;01H'¢\u0006\u0004\b=\u00107J\u0019\u0010@\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010>H'¢\u0006\u0004\b@\u0010AJ\u001b\u0010D\u001a\u00020\u00002\n\b\u0001\u0010C\u001a\u0004\u0018\u00010BH'¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH&¢\u0006\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/avito/android/di/component/HomeComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/home/HomePresenterState;", "state", "homePresenterState", "(Lcom/avito/android/home/HomePresenterState;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/home/HomeInteractorState;", "homeInteractorState", "(Lcom/avito/android/home/HomeInteractorState;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Landroid/os/Bundle;", "floatingViewsPresenterState", "(Landroid/os/Bundle;)Lcom/avito/android/di/component/HomeComponent$Builder;", "screenTrackerState", "defaultLocationPresenterState", "defaultLocationInteractorState", "defaultVisibilityTrackerState", "itemVisibilityTrackerState", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "(Lcom/avito/android/ui/ActivityInteractor;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "bannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/di/component/SerpDependencies;", "dependencies", "serpDependencies", "(Lcom/avito/android/di/component/SerpDependencies;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/di/component/HomeDependencies;", "homeDependencies", "(Lcom/avito/android/di/component/HomeDependencies;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "", "relay", "snippetClick", "(Lcom/jakewharton/rxrelay3/Relay;)Lcom/avito/android/di/component/HomeComponent$Builder;", "snippetClose", "", "snippetVisibility", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationActionData;", "locationNotificationClick", "locationNotificationVisibility", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "handler", "withSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/util/Kundle;", "savedState", "withWitcherSavedState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/di/component/HomeComponent$Builder;", "Lcom/avito/android/di/component/HomeComponent;", "build", "()Lcom/avito/android/di/component/HomeComponent;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder activityInteractor(@NotNull ActivityInteractor activityInteractor);

        @BindsInstance
        @NotNull
        Builder bannerPageSource(@NotNull BannerPageSource bannerPageSource);

        @NotNull
        HomeComponent build();

        @BindsInstance
        @NotNull
        Builder defaultLocationInteractorState(@DefaultLocationInteractorState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder defaultLocationPresenterState(@DefaultLocationPresenterState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder floatingViewsPresenterState(@FloatingViewsPresenterState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @NotNull
        Builder homeDependencies(@NotNull HomeDependencies homeDependencies);

        @BindsInstance
        @NotNull
        Builder homeInteractorState(@Nullable HomeInteractorState homeInteractorState);

        @BindsInstance
        @NotNull
        Builder homePresenterState(@Nullable HomePresenterState homePresenterState);

        @BindsInstance
        @NotNull
        Builder itemVisibilityTrackerState(@HomeItemVisibilityTrackerState @Nullable Bundle bundle);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @BindsInstance
        @NotNull
        Builder locationNotificationClick(@LocationNotificationClick @NotNull Relay<LocationNotificationActionData> relay);

        @BindsInstance
        @NotNull
        Builder locationNotificationVisibility(@LocationNotificationVisibility @NotNull Relay<LocationNotificationActionData> relay);

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
        Builder screenTrackerState(@ScreenTrackerState @Nullable Bundle bundle);

        @NotNull
        Builder serpDependencies(@NotNull SerpDependencies serpDependencies);

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
        Builder withSerpOnboardingHandler(@Nullable SerpOnboardingHandler serpOnboardingHandler);

        @BindsInstance
        @NotNull
        Builder withWitcherSavedState(@WitcherModule.WitcherItemsSavedState @Nullable Kundle kundle);
    }

    void inject(@NotNull HomeFragment homeFragment);
}
