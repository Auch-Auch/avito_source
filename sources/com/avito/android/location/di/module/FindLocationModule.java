package com.avito.android.location.di.module;

import android.app.Activity;
import com.avito.android.di.PerFragment;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationInteractorImpl;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.DefaultLocationProviderImpl;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.DetectLocationInteractorImpl;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.GoogleServicesLocationProvider;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.WeakHandler;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/location/di/module/FindLocationModule;", "", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "provideDefaultLocationInteractor", "(Lcom/avito/android/geo/GeoStorage;)Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "Lcom/avito/android/location/find/DefaultLocationProvider;", "provideDefaultLocationProvider", "(Lcom/avito/android/location/find/DefaultLocationInteractor;)Lcom/avito/android/location/find/DefaultLocationProvider;", "Landroid/app/Activity;", "activity", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "Lcom/avito/android/util/WeakHandler;", "handler", "Lcom/avito/android/location/find/util/DetectLocationHelper;", "provideDetectLocationHelper$user_location_release", "(Landroid/app/Activity;Lcom/avito/android/ui/ActivityInteractor;Lcom/avito/android/util/WeakHandler;)Lcom/avito/android/location/find/util/DetectLocationHelper;", "provideDetectLocationHelper", "provideWeakHandler$user_location_release", "()Lcom/avito/android/util/WeakHandler;", "provideWeakHandler", "locationHelper", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/location/find/DetectLocationInteractor;", "provideDetectLocationInteractor$user_location_release", "(Lcom/avito/android/location/find/util/DetectLocationHelper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/geo/GeoStorage;)Lcom/avito/android/location/find/DetectLocationInteractor;", "provideDetectLocationInteractor", "", AuthSource.SEND_ABUSE, "I", "DETECT_LOCATION_TIMEOUT_MS", "<init>", "()V", "Declarations", "user-location_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FindLocationModule {
    @NotNull
    public static final FindLocationModule INSTANCE = new FindLocationModule();
    public static final int a = ((int) TimeUnit.SECONDS.toMillis(5));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location/di/module/FindLocationModule$Declarations;", "", "Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;", "googleServicesLocationProvider", "Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "bindGoogleServicesLocationProvider", "(Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;)Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "Lcom/avito/android/location/find/FindLocationPresenterImpl;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "bindFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenterImpl;)Lcom/avito/android/location/find/FindLocationPresenter;", "Lcom/avito/android/location/find/FusedLocationInteractorImpl;", "fusedLocationInteractor", "Lcom/avito/android/location/find/FusedLocationInteractor;", "bindFusedLocationPresenter", "(Lcom/avito/android/location/find/FusedLocationInteractorImpl;)Lcom/avito/android/location/find/FusedLocationInteractor;", "user-location_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        FindLocationPresenter bindFindLocationPresenter(@NotNull FindLocationPresenterImpl findLocationPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FusedLocationInteractor bindFusedLocationPresenter(@NotNull FusedLocationInteractorImpl fusedLocationInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        GoogleServicesLocationProvider bindGoogleServicesLocationProvider(@NotNull GoogleServicesLocationProviderImpl googleServicesLocationProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DefaultLocationInteractor provideDefaultLocationInteractor(@NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        return new DefaultLocationInteractorImpl(geoStorage, 2000, 1);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DefaultLocationProvider provideDefaultLocationProvider(@NotNull DefaultLocationInteractor defaultLocationInteractor) {
        Intrinsics.checkNotNullParameter(defaultLocationInteractor, "defaultLocationInteractor");
        return new DefaultLocationProviderImpl(1000, defaultLocationInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DetectLocationHelper provideDetectLocationHelper$user_location_release(@NotNull Activity activity, @NotNull ActivityInteractor activityInteractor, @NotNull WeakHandler weakHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activityInteractor, "activityInteractor");
        Intrinsics.checkNotNullParameter(weakHandler, "handler");
        return new DetectLocationHelper(activity, activityInteractor, weakHandler);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DetectLocationInteractor provideDetectLocationInteractor$user_location_release(@NotNull DetectLocationHelper detectLocationHelper, @NotNull SchedulersFactory schedulersFactory, @NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(detectLocationHelper, "locationHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        return new DetectLocationInteractorImpl(detectLocationHelper, a, schedulersFactory, geoStorage);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final WeakHandler provideWeakHandler$user_location_release() {
        return new WeakHandler();
    }
}
