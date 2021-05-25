package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.remote.PaymentsPlanHeaderProvider;
import com.avito.android.remote.interceptor.AppHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.HeadersInterceptor;
import com.avito.android.remote.interceptor.InfomodelBranchHeaderProvider;
import com.avito.android.remote.interceptor.SchemaCheckHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideHeadersInterceptorFactory implements Factory<HeadersInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<Features> b;
    public final Provider<DeviceIdHeaderProvider> c;
    public final Provider<AppHeaderProvider> d;
    public final Provider<SchemaCheckHeaderProvider> e;
    public final Provider<InfomodelBranchHeaderProvider> f;
    public final Provider<FingerprintHeaderProvider> g;
    public final Provider<PaymentsPlanHeaderProvider> h;
    public final Provider<GeoHeaderProvider> i;
    public final Provider<MessengerInfoProvider> j;

    public ApiInterceptorsModule_ProvideHeadersInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<Features> provider, Provider<DeviceIdHeaderProvider> provider2, Provider<AppHeaderProvider> provider3, Provider<SchemaCheckHeaderProvider> provider4, Provider<InfomodelBranchHeaderProvider> provider5, Provider<FingerprintHeaderProvider> provider6, Provider<PaymentsPlanHeaderProvider> provider7, Provider<GeoHeaderProvider> provider8, Provider<MessengerInfoProvider> provider9) {
        this.a = apiInterceptorsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
    }

    public static ApiInterceptorsModule_ProvideHeadersInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<Features> provider, Provider<DeviceIdHeaderProvider> provider2, Provider<AppHeaderProvider> provider3, Provider<SchemaCheckHeaderProvider> provider4, Provider<InfomodelBranchHeaderProvider> provider5, Provider<FingerprintHeaderProvider> provider6, Provider<PaymentsPlanHeaderProvider> provider7, Provider<GeoHeaderProvider> provider8, Provider<MessengerInfoProvider> provider9) {
        return new ApiInterceptorsModule_ProvideHeadersInterceptorFactory(apiInterceptorsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static HeadersInterceptor provideHeadersInterceptor(ApiInterceptorsModule apiInterceptorsModule, Features features, DeviceIdHeaderProvider deviceIdHeaderProvider, AppHeaderProvider appHeaderProvider, SchemaCheckHeaderProvider schemaCheckHeaderProvider, InfomodelBranchHeaderProvider infomodelBranchHeaderProvider, FingerprintHeaderProvider fingerprintHeaderProvider, PaymentsPlanHeaderProvider paymentsPlanHeaderProvider, GeoHeaderProvider geoHeaderProvider, MessengerInfoProvider messengerInfoProvider) {
        return (HeadersInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideHeadersInterceptor(features, deviceIdHeaderProvider, appHeaderProvider, schemaCheckHeaderProvider, infomodelBranchHeaderProvider, fingerprintHeaderProvider, paymentsPlanHeaderProvider, geoHeaderProvider, messengerInfoProvider));
    }

    @Override // javax.inject.Provider
    public HeadersInterceptor get() {
        return provideHeadersInterceptor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
