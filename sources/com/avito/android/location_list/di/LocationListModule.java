package com.avito.android.location_list.di;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.di.module.FindDetectLocationModule;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location_list.LocationItemSingleLinePresenterImpl;
import com.avito.android.location_list.LocationItemSingleLineRadioButtonBlueprint;
import com.avito.android.location_list.LocationItemTwoLinesPresenterImpl;
import com.avito.android.location_list.LocationItemTwoLinesRadioButtonBlueprint;
import com.avito.android.location_list.LocationListActivity;
import com.avito.android.location_list.LocationListFragment;
import com.avito.android.location_list.LocationListInteractor;
import com.avito.android.location_list.LocationListInteractorImpl;
import com.avito.android.location_list.LocationListPresenter;
import com.avito.android.location_list.LocationListPresenterImpl;
import com.avito.android.location_list.LocationListener;
import com.avito.android.location_list.analytics.LocationListAnalyticsInteractor;
import com.avito.android.location_list.analytics.LocationListAnalyticsInteractorImpl;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.LocationsNotFoundErrorCase;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Location;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001hB{\u0012\b\u0010Q\u001a\u0004\u0018\u00010L\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010e\u001a\u00020d\u0012\b\u0010O\u001a\u0004\u0018\u00010L\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010]\u001a\u00020Z\u0012\u0006\u0010E\u001a\u00020@\u0012\u0006\u0010W\u001a\u00020@\u0012\b\u0010a\u001a\u0004\u0018\u00010^\u0012\b\u0010c\u001a\u0004\u0018\u00010^\u0012\u0006\u0010C\u001a\u00020@\u0012\b\u0010Y\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010G\u001a\u00020@¢\u0006\u0004\bf\u0010gJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJG\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020%H\u0007¢\u0006\u0004\b+\u0010,J\u001d\u0010/\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190-H\u0007¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190-H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u0002032\u0006\u0010\u0016\u001a\u00020\u0019H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u00020*H\u0007¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010?\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020;H\u0001¢\u0006\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010BR\u0018\u0010Y\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010`¨\u0006i"}, d2 = {"Lcom/avito/android/location_list/di/LocationListModule;", "", "Lcom/avito/android/remote/LocationApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "converter", "Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;", "errorCase", "Lcom/avito/android/location_list/LocationListInteractor;", "provideInteractor", "(Lcom/avito/android/remote/LocationApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;)Lcom/avito/android/location_list/LocationListInteractor;", "interactor", "Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "findDetectLocationPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "presenter", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/location_list/LocationListPresenter;", "providePresenter", "(Lcom/avito/android/location_list/LocationListInteractor;Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/location/find/FindDetectLocationPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/permissions/LocationPermissionDialogPresenter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)Lcom/avito/android/location_list/LocationListPresenter;", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "provideLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "Lcom/avito/android/location_list/LocationItemTwoLinesPresenterImpl;", "Lcom/avito/android/location_list/LocationItemTwoLinesRadioButtonBlueprint;", "provideLocationItemTwoLinesBluePrint", "(Lcom/avito/android/location_list/LocationItemTwoLinesPresenterImpl;)Lcom/avito/android/location_list/LocationItemTwoLinesRadioButtonBlueprint;", "Lcom/avito/android/location_list/LocationItemSingleLinePresenterImpl;", "Lcom/avito/android/location_list/LocationItemSingleLineRadioButtonBlueprint;", "provideLocationItemSingleLineBluePrint", "(Lcom/avito/android/location_list/LocationItemSingleLinePresenterImpl;)Lcom/avito/android/location_list/LocationItemSingleLineRadioButtonBlueprint;", "twoLinesBlueprint", "singleLineBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideLocationItemBinder", "(Lcom/avito/android/location_list/LocationItemTwoLinesRadioButtonBlueprint;Lcom/avito/android/location_list/LocationItemSingleLineRadioButtonBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideLocationItemTwoLinesPresenter", "(Ldagger/Lazy;)Lcom/avito/android/location_list/LocationItemTwoLinesPresenterImpl;", "provideLocationItemSingleLinePresenter", "(Ldagger/Lazy;)Lcom/avito/android/location_list/LocationItemSingleLinePresenterImpl;", "Lcom/avito/android/location_list/LocationListener;", "provideLocationListener", "(Lcom/avito/android/location_list/LocationListPresenter;)Lcom/avito/android/location_list/LocationListener;", "itemBinder", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideLocationsNotFoundErrorCase", "()Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideAnalyticsInteractor$location_list_release", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/location_list/analytics/LocationListAnalyticsInteractor;", "provideAnalyticsInteractor", "", "j", "Z", "hasSearchArea", "f", "hasRegion", "l", "shouldTrackLocationEvents", "Lcom/avito/android/location_list/LocationListActivity;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location_list/LocationListActivity;", "activity", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "presenterState", AuthSource.SEND_ABUSE, "interactorState", "", "d", "Ljava/lang/String;", "stubLocationName", g.a, "showWholeLocation", "k", "categoryId", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "e", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "backPressedListener", "Lcom/avito/android/remote/model/Location;", "h", "Lcom/avito/android/remote/model/Location;", "selectedLocation", "i", "parentLocation", "Lcom/avito/android/location_list/LocationListFragment;", "fragment", "<init>", "(Landroid/os/Bundle;Lcom/avito/android/location_list/LocationListActivity;Lcom/avito/android/location_list/LocationListFragment;Landroid/os/Bundle;Ljava/lang/String;Lcom/avito/android/ui/fragments/OnBackPressedListener;ZZLcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;ZLjava/lang/String;Z)V", "Declarations", "location-list_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, FindDetectLocationModule.class})
public final class LocationListModule {
    public final Bundle a;
    public final LocationListActivity b;
    public final Bundle c;
    public final String d;
    public final OnBackPressedListener e;
    public final boolean f;
    public final boolean g;
    public final Location h;
    public final Location i;
    public final boolean j;
    public final String k;
    public final boolean l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/location_list/di/LocationListModule$Declarations;", "", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "location-list_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        LocationAnalyticsInteractor bindsLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractorImpl locationAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);
    }

    public LocationListModule(@Nullable Bundle bundle, @NotNull LocationListActivity locationListActivity, @NotNull LocationListFragment locationListFragment, @Nullable Bundle bundle2, @NotNull String str, @NotNull OnBackPressedListener onBackPressedListener, boolean z, boolean z2, @Nullable Location location, @Nullable Location location2, boolean z3, @Nullable String str2, boolean z4) {
        Intrinsics.checkNotNullParameter(locationListActivity, "activity");
        Intrinsics.checkNotNullParameter(locationListFragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "stubLocationName");
        Intrinsics.checkNotNullParameter(onBackPressedListener, "backPressedListener");
        this.a = bundle;
        this.b = locationListActivity;
        this.c = bundle2;
        this.d = str;
        this.e = onBackPressedListener;
        this.f = z;
        this.g = z2;
        this.h = location;
        this.i = location2;
        this.j = z3;
        this.k = str2;
        this.l = z4;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationListAnalyticsInteractor provideAnalyticsInteractor$location_list_release(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new LocationListAnalyticsInteractorImpl(analytics);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationListInteractor provideInteractor(@NotNull LocationApi locationApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocationsNotFoundErrorCase locationsNotFoundErrorCase) {
        Intrinsics.checkNotNullParameter(locationApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "converter");
        Intrinsics.checkNotNullParameter(locationsNotFoundErrorCase, "errorCase");
        return new LocationListInteractorImpl(this.a, locationApi, schedulersFactory, typedErrorThrowableConverter, locationsNotFoundErrorCase);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideLocationItemBinder(@NotNull LocationItemTwoLinesRadioButtonBlueprint locationItemTwoLinesRadioButtonBlueprint, @NotNull LocationItemSingleLineRadioButtonBlueprint locationItemSingleLineRadioButtonBlueprint) {
        Intrinsics.checkNotNullParameter(locationItemTwoLinesRadioButtonBlueprint, "twoLinesBlueprint");
        Intrinsics.checkNotNullParameter(locationItemSingleLineRadioButtonBlueprint, "singleLineBlueprint");
        return new ItemBinder.Builder().registerItem(locationItemTwoLinesRadioButtonBlueprint).registerItem(locationItemSingleLineRadioButtonBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationItemSingleLineRadioButtonBlueprint provideLocationItemSingleLineBluePrint(@NotNull LocationItemSingleLinePresenterImpl locationItemSingleLinePresenterImpl) {
        Intrinsics.checkNotNullParameter(locationItemSingleLinePresenterImpl, "presenter");
        return new LocationItemSingleLineRadioButtonBlueprint(locationItemSingleLinePresenterImpl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final LocationItemSingleLinePresenterImpl provideLocationItemSingleLinePresenter(@NotNull Lazy<LocationListPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new LocationItemSingleLinePresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationItemTwoLinesRadioButtonBlueprint provideLocationItemTwoLinesBluePrint(@NotNull LocationItemTwoLinesPresenterImpl locationItemTwoLinesPresenterImpl) {
        Intrinsics.checkNotNullParameter(locationItemTwoLinesPresenterImpl, "presenter");
        return new LocationItemTwoLinesRadioButtonBlueprint(locationItemTwoLinesPresenterImpl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final LocationItemTwoLinesPresenterImpl provideLocationItemTwoLinesPresenter(@NotNull Lazy<LocationListPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new LocationItemTwoLinesPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationListener provideLocationListener(@NotNull LocationListPresenter locationListPresenter) {
        Intrinsics.checkNotNullParameter(locationListPresenter, "presenter");
        return locationListPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, GeoContract.PROVIDER);
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationsNotFoundErrorCase provideLocationsNotFoundErrorCase() {
        return new LocationsNotFoundErrorCase();
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocationListPresenter providePresenter(@NotNull LocationListInteractor locationListInteractor, @NotNull LocationListAnalyticsInteractor locationListAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FindDetectLocationPresenter findDetectLocationPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(locationListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(locationListAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(findDetectLocationPresenter, "findDetectLocationPresenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "presenter");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        return new LocationListPresenterImpl(locationListInteractor, locationListAnalyticsInteractor, schedulersFactory3, this.c, adapterPresenter, this.b, findDetectLocationPresenter, this.e, this.d, this.f, this.g, this.h, this.i, this.j, this.k, this.l, locationPermissionDialogPresenter, locationAnalyticsInteractor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationListModule(Bundle bundle, LocationListActivity locationListActivity, LocationListFragment locationListFragment, Bundle bundle2, String str, OnBackPressedListener onBackPressedListener, boolean z, boolean z2, Location location, Location location2, boolean z3, String str2, boolean z4, int i2, j jVar) {
        this(bundle, locationListActivity, locationListFragment, bundle2, str, onBackPressedListener, z, z2, location, location2, z3, str2, (i2 & 4096) != 0 ? false : z4);
    }
}
