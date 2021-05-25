package com.avito.android.location_picker;

import android.app.Activity;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.job.JobAssistantInteractor;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AddressValidationProvider;
import com.avito.android.location_picker.providers.AdvertsCountProvider;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider;
import com.avito.android.location_picker.providers.RadiusListProvider;
import com.avito.android.location_picker.view.LocationPickerInputView;
import com.avito.android.location_picker.view.LocationPickerOutputView;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class LocationPickerBinderImpl_Factory implements Factory<LocationPickerBinderImpl> {
    public final Provider<LocationPickerState> a;
    public final Provider<LocationPickerInputView> b;
    public final Provider<LocationPickerOutputView> c;
    public final Provider<AddressGeoCoder> d;
    public final Provider<FusedLocationInteractor> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<LocationPermissionProvider> g;
    public final Provider<LocationPickerAnalyticsProvider> h;
    public final Provider<LocationAnalyticsInteractor> i;
    public final Provider<Observable<ActivityResult>> j;
    public final Provider<RadiusListProvider> k;
    public final Provider<AdvertsCountProvider> l;
    public final Provider<AddressValidationProvider> m;
    public final Provider<SearchParamsConverter> n;
    public final Provider<MapTransformationsProvider> o;
    public final Provider<LocationPickerAnalyticsInteractor> p;
    public final Provider<JobAssistantInteractor> q;
    public final Provider<SendLocationToJobAssistant> r;
    public final Provider<BuildInfo> s;
    public final Provider<Activity> t;

    public LocationPickerBinderImpl_Factory(Provider<LocationPickerState> provider, Provider<LocationPickerInputView> provider2, Provider<LocationPickerOutputView> provider3, Provider<AddressGeoCoder> provider4, Provider<FusedLocationInteractor> provider5, Provider<SchedulersFactory3> provider6, Provider<LocationPermissionProvider> provider7, Provider<LocationPickerAnalyticsProvider> provider8, Provider<LocationAnalyticsInteractor> provider9, Provider<Observable<ActivityResult>> provider10, Provider<RadiusListProvider> provider11, Provider<AdvertsCountProvider> provider12, Provider<AddressValidationProvider> provider13, Provider<SearchParamsConverter> provider14, Provider<MapTransformationsProvider> provider15, Provider<LocationPickerAnalyticsInteractor> provider16, Provider<JobAssistantInteractor> provider17, Provider<SendLocationToJobAssistant> provider18, Provider<BuildInfo> provider19, Provider<Activity> provider20) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
    }

    public static LocationPickerBinderImpl_Factory create(Provider<LocationPickerState> provider, Provider<LocationPickerInputView> provider2, Provider<LocationPickerOutputView> provider3, Provider<AddressGeoCoder> provider4, Provider<FusedLocationInteractor> provider5, Provider<SchedulersFactory3> provider6, Provider<LocationPermissionProvider> provider7, Provider<LocationPickerAnalyticsProvider> provider8, Provider<LocationAnalyticsInteractor> provider9, Provider<Observable<ActivityResult>> provider10, Provider<RadiusListProvider> provider11, Provider<AdvertsCountProvider> provider12, Provider<AddressValidationProvider> provider13, Provider<SearchParamsConverter> provider14, Provider<MapTransformationsProvider> provider15, Provider<LocationPickerAnalyticsInteractor> provider16, Provider<JobAssistantInteractor> provider17, Provider<SendLocationToJobAssistant> provider18, Provider<BuildInfo> provider19, Provider<Activity> provider20) {
        return new LocationPickerBinderImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20);
    }

    public static LocationPickerBinderImpl newInstance(LocationPickerState locationPickerState, LocationPickerInputView locationPickerInputView, LocationPickerOutputView locationPickerOutputView, AddressGeoCoder addressGeoCoder, FusedLocationInteractor fusedLocationInteractor, SchedulersFactory3 schedulersFactory3, LocationPermissionProvider locationPermissionProvider, LocationPickerAnalyticsProvider locationPickerAnalyticsProvider, LocationAnalyticsInteractor locationAnalyticsInteractor, Observable<ActivityResult> observable, RadiusListProvider radiusListProvider, AdvertsCountProvider advertsCountProvider, AddressValidationProvider addressValidationProvider, SearchParamsConverter searchParamsConverter, MapTransformationsProvider mapTransformationsProvider, LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor, JobAssistantInteractor jobAssistantInteractor, SendLocationToJobAssistant sendLocationToJobAssistant, BuildInfo buildInfo, Activity activity) {
        return new LocationPickerBinderImpl(locationPickerState, locationPickerInputView, locationPickerOutputView, addressGeoCoder, fusedLocationInteractor, schedulersFactory3, locationPermissionProvider, locationPickerAnalyticsProvider, locationAnalyticsInteractor, observable, radiusListProvider, advertsCountProvider, addressValidationProvider, searchParamsConverter, mapTransformationsProvider, locationPickerAnalyticsInteractor, jobAssistantInteractor, sendLocationToJobAssistant, buildInfo, activity);
    }

    @Override // javax.inject.Provider
    public LocationPickerBinderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get());
    }
}
