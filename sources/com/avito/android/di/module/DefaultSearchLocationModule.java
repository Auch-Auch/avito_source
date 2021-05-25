package com.avito.android.di.module;

import android.app.Activity;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.geo.GeoStorage;
import com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractorImpl;
import com.avito.android.home.default_search_location.DefaultSearchLocationInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationInteractorImpl;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenter;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.home.default_search_location.DefaultSearchLocationStorage;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.location.di.module.FindDetectLocationModule;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.server_time.TimeSource;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b)\u0010*JW\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/di/module/DefaultSearchLocationModule;", "", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "interactor", "Lcom/avito/android/location/SavedLocationInteractor;", "savedLocationInteractor", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/stories/StartupBannerInteractor;", "startupBannerInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "storage", "Lcom/avito/android/server_time/TimeSource;", "time", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "provideDefaultLocationPresenter$serp_release", "(Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;Lcom/avito/android/stories/StartupBannerInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/geo/GeoStorage;Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "provideDefaultLocationPresenter", "Landroid/app/Activity;", "activity", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "findDetectLocationPresenter", "provideDefaultLocationNotificationInteractor$serp_release", "(Lcom/avito/android/util/SchedulersFactory3;Landroid/app/Activity;Lcom/avito/android/location/find/FindDetectLocationPresenter;)Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "provideDefaultLocationNotificationInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "provideDefaultSearchLocationAnalyticsInteractorImpl$serp_release", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;", "provideDefaultSearchLocationAnalyticsInteractorImpl", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "provideLocationPermissionDialogPresenter$serp_release", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter", "<init>", "()V", "Declarations", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, DialogRouterModule.class, Declarations.class, FindDetectLocationModule.class})
public final class DefaultSearchLocationModule {
    @NotNull
    public static final DefaultSearchLocationModule INSTANCE = new DefaultSearchLocationModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/DefaultSearchLocationModule$Declarations;", "", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DefaultSearchLocationInteractor provideDefaultLocationNotificationInteractor$serp_release(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull Activity activity, @NotNull FindDetectLocationPresenter findDetectLocationPresenter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(findDetectLocationPresenter, "findDetectLocationPresenter");
        return new DefaultSearchLocationInteractorImpl(schedulersFactory3, activity, findDetectLocationPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DefaultSearchLocationPresenter provideDefaultLocationPresenter$serp_release(@NotNull DefaultSearchLocationInteractor defaultSearchLocationInteractor, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull DefaultSearchLocationAnalyticsInteractor defaultSearchLocationAnalyticsInteractor, @NotNull StartupBannerInteractor startupBannerInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull GeoStorage geoStorage, @NotNull DefaultSearchLocationStorage defaultSearchLocationStorage, @NotNull TimeSource timeSource, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        Intrinsics.checkNotNullParameter(defaultSearchLocationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "savedLocationInteractor");
        Intrinsics.checkNotNullParameter(defaultSearchLocationAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(startupBannerInteractor, "startupBannerInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        Intrinsics.checkNotNullParameter(defaultSearchLocationStorage, "storage");
        Intrinsics.checkNotNullParameter(timeSource, "time");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "locationPermissionDialogPresenter");
        return new DefaultSearchLocationPresenterImpl(schedulersFactory3, defaultSearchLocationInteractor, defaultSearchLocationAnalyticsInteractor, savedLocationInteractor, startupBannerInteractor, geoStorage, defaultSearchLocationStorage, timeSource, locationPermissionDialogPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DefaultSearchLocationAnalyticsInteractor provideDefaultSearchLocationAnalyticsInteractorImpl$serp_release(@NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        return new DefaultSearchLocationAnalyticsInteractorImpl(locationAnalyticsInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter$serp_release(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, GeoContract.PROVIDER);
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }
}
