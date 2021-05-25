package com.avito.android.location_picker.view;

import android.app.Activity;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.providers.LocationPickerResourceProvider;
import com.avito.android.util.DialogRouter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPickerViewImpl_Factory implements Factory<LocationPickerViewImpl> {
    public final Provider<Activity> a;
    public final Provider<DialogRouter> b;
    public final Provider<Boolean> c;
    public final Provider<Boolean> d;
    public final Provider<SendLocationToJobAssistant> e;
    public final Provider<LocationPickerChooseButtonLocation> f;
    public final Provider<AvitoMapAttachHelper> g;
    public final Provider<AvitoMapTarget> h;
    public final Provider<LocationPickerResourceProvider> i;

    public LocationPickerViewImpl_Factory(Provider<Activity> provider, Provider<DialogRouter> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<SendLocationToJobAssistant> provider5, Provider<LocationPickerChooseButtonLocation> provider6, Provider<AvitoMapAttachHelper> provider7, Provider<AvitoMapTarget> provider8, Provider<LocationPickerResourceProvider> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static LocationPickerViewImpl_Factory create(Provider<Activity> provider, Provider<DialogRouter> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<SendLocationToJobAssistant> provider5, Provider<LocationPickerChooseButtonLocation> provider6, Provider<AvitoMapAttachHelper> provider7, Provider<AvitoMapTarget> provider8, Provider<LocationPickerResourceProvider> provider9) {
        return new LocationPickerViewImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static LocationPickerViewImpl newInstance(Activity activity, DialogRouter dialogRouter, boolean z, boolean z2, SendLocationToJobAssistant sendLocationToJobAssistant, LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, AvitoMapAttachHelper avitoMapAttachHelper, AvitoMapTarget avitoMapTarget, LocationPickerResourceProvider locationPickerResourceProvider) {
        return new LocationPickerViewImpl(activity, dialogRouter, z, z2, sendLocationToJobAssistant, locationPickerChooseButtonLocation, avitoMapAttachHelper, avitoMapTarget, locationPickerResourceProvider);
    }

    @Override // javax.inject.Provider
    public LocationPickerViewImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get().booleanValue(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
