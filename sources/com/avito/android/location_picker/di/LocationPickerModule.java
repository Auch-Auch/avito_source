package com.avito.android.location_picker.di;

import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationInteractorImpl;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.MapTransformationsProvider;
import com.avito.android.location_picker.MapTransformationsProviderImpl;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractorImpl;
import com.avito.android.location_picker.job.JobAssistantInteractor;
import com.avito.android.location_picker.job.JobAssistantInteractorImpl;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AddressValidationProvider;
import com.avito.android.location_picker.providers.AddressValidationProviderImpl;
import com.avito.android.location_picker.providers.AdvertsCountProvider;
import com.avito.android.location_picker.providers.AdvertsCountProviderImpl;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProviderImpl;
import com.avito.android.location_picker.providers.LocationPickerResourceProvider;
import com.avito.android.location_picker.providers.LocationPickerResourceProviderImpl;
import com.avito.android.location_picker.providers.RadiusListProvider;
import com.avito.android.location_picker.providers.RadiusListProviderImpl;
import com.avito.android.location_picker.view.LocationPickerInputView;
import com.avito.android.location_picker.view.LocationPickerOutputView;
import com.avito.android.location_picker.view.LocationPickerViewImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderWithActivityImpl;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/location_picker/di/LocationPickerModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideMapAttachHelper", "(Lcom/avito/android/Features;)Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "provideDefaultLocationInteractor", "(Lcom/avito/android/geo/GeoStorage;)Lcom/avito/android/location/find/DefaultLocationInteractor;", "<init>", "()V", "Declarations", "location-picker_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, Declarations.class})
public final class LocationPickerModule {
    @NotNull
    public static final LocationPickerModule INSTANCE = new LocationPickerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020-H'¢\u0006\u0004\b/\u00100J\u0017\u00104\u001a\u0002032\u0006\u00102\u001a\u000201H'¢\u0006\u0004\b4\u00105J\u0017\u00109\u001a\u0002082\u0006\u00107\u001a\u000206H'¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020;H'¢\u0006\u0004\b=\u0010>J\u0017\u0010B\u001a\u00020A2\u0006\u0010@\u001a\u00020?H'¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020E2\u0006\u00107\u001a\u00020DH'¢\u0006\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/avito/android/location_picker/di/LocationPickerModule$Declarations;", "", "Lcom/avito/android/location_picker/view/LocationPickerViewImpl;", "view", "Lcom/avito/android/location_picker/view/LocationPickerInputView;", "bindsLocationPickerInputView", "(Lcom/avito/android/location_picker/view/LocationPickerViewImpl;)Lcom/avito/android/location_picker/view/LocationPickerInputView;", "Lcom/avito/android/location_picker/view/LocationPickerOutputView;", "bindsLocationPickerOutputView", "(Lcom/avito/android/location_picker/view/LocationPickerViewImpl;)Lcom/avito/android/location_picker/view/LocationPickerOutputView;", "Lcom/avito/android/location_picker/providers/AvitoAddressGeoCoder;", "geoCoderInteractor", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "bindsGeoCoderInteractor", "(Lcom/avito/android/location_picker/providers/AvitoAddressGeoCoder;)Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "Lcom/avito/android/location_picker/job/JobAssistantInteractorImpl;", "jobAssistantInteractor", "Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "bindJobAssistantInteractor", "(Lcom/avito/android/location_picker/job/JobAssistantInteractorImpl;)Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "Lcom/avito/android/location/find/FusedLocationInteractorImpl;", GeoContract.PROVIDER, "Lcom/avito/android/location/find/FusedLocationInteractor;", "bindsFusedLocationProvider", "(Lcom/avito/android/location/find/FusedLocationInteractorImpl;)Lcom/avito/android/location/find/FusedLocationInteractor;", "Lcom/avito/android/location_picker/providers/RadiusListProviderImpl;", "Lcom/avito/android/location_picker/providers/RadiusListProvider;", "bindsRadiusListProvider", "(Lcom/avito/android/location_picker/providers/RadiusListProviderImpl;)Lcom/avito/android/location_picker/providers/RadiusListProvider;", "Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl;", "Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "bindsAdvertsCountProvider", "(Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl;)Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "Lcom/avito/android/location_picker/providers/AddressValidationProviderImpl;", "Lcom/avito/android/location_picker/providers/AddressValidationProvider;", "bindsAddressValidationProvider", "(Lcom/avito/android/location_picker/providers/AddressValidationProviderImpl;)Lcom/avito/android/location_picker/providers/AddressValidationProvider;", "Lcom/avito/android/permissions/LocationPermissionProviderWithActivityImpl;", "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderWithActivityImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProviderImpl;", "Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "bindsAnalyticsProvider", "(Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProviderImpl;)Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "Lcom/avito/android/location_picker/MapTransformationsProviderImpl;", "Lcom/avito/android/location_picker/MapTransformationsProvider;", "bindsMapTransformationsProvider", "(Lcom/avito/android/location_picker/MapTransformationsProviderImpl;)Lcom/avito/android/location_picker/MapTransformationsProvider;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindsSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "bindsAnalyticsInteractor", "(Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractorImpl;)Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "Lcom/avito/android/location_picker/providers/LocationPickerResourceProviderImpl;", "Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "bindsLocationPickerResourceProvider", "(Lcom/avito/android/location_picker/providers/LocationPickerResourceProviderImpl;)Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "Lcom/avito/android/location_picker/LocationPickerBinderImpl;", "binder", "Lcom/avito/android/location_picker/LocationPickerBinder;", "bindsBinder", "(Lcom/avito/android/location_picker/LocationPickerBinderImpl;)Lcom/avito/android/location_picker/LocationPickerBinder;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "bindsLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;)Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        JobAssistantInteractor bindJobAssistantInteractor(@NotNull JobAssistantInteractorImpl jobAssistantInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        AddressValidationProvider bindsAddressValidationProvider(@NotNull AddressValidationProviderImpl addressValidationProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        AdvertsCountProvider bindsAdvertsCountProvider(@NotNull AdvertsCountProviderImpl advertsCountProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerAnalyticsInteractor bindsAnalyticsInteractor(@NotNull LocationPickerAnalyticsInteractorImpl locationPickerAnalyticsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerAnalyticsProvider bindsAnalyticsProvider(@NotNull LocationPickerAnalyticsProviderImpl locationPickerAnalyticsProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerBinder bindsBinder(@NotNull LocationPickerBinderImpl locationPickerBinderImpl);

        @PerActivity
        @Binds
        @NotNull
        FusedLocationInteractor bindsFusedLocationProvider(@NotNull FusedLocationInteractorImpl fusedLocationInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        AddressGeoCoder bindsGeoCoderInteractor(@NotNull AvitoAddressGeoCoder avitoAddressGeoCoder);

        @PerActivity
        @Binds
        @NotNull
        LocationAnalyticsInteractor bindsLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractorImpl locationAnalyticsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderWithActivityImpl locationPermissionProviderWithActivityImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerInputView bindsLocationPickerInputView(@NotNull LocationPickerViewImpl locationPickerViewImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerOutputView bindsLocationPickerOutputView(@NotNull LocationPickerViewImpl locationPickerViewImpl);

        @PerActivity
        @Binds
        @NotNull
        LocationPickerResourceProvider bindsLocationPickerResourceProvider(@NotNull LocationPickerResourceProviderImpl locationPickerResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        MapTransformationsProvider bindsMapTransformationsProvider(@NotNull MapTransformationsProviderImpl mapTransformationsProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        RadiusListProvider bindsRadiusListProvider(@NotNull RadiusListProviderImpl radiusListProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        SearchParamsConverter bindsSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DefaultLocationInteractor provideDefaultLocationInteractor(@NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        return new DefaultLocationInteractorImpl(geoStorage, 2000, 1);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AvitoMapAttachHelper provideMapAttachHelper(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getYandexMapOnLocationPicker().invoke().booleanValue()) {
            return new YandexAvitoMapAttachHelper();
        }
        return new GoogleAvitoMapAttachHelper();
    }
}
