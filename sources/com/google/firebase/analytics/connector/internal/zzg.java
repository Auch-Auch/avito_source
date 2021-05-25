package com.google.firebase.analytics.connector.internal;

import a2.j.e.b.a.a.c;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;
public final class zzg implements zza {
    public AnalyticsConnector.AnalyticsConnectorListener a;
    public AppMeasurementSdk b;
    public c c;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.a = analyticsConnectorListener;
        this.b = appMeasurementSdk;
        c cVar = new c(this);
        this.c = cVar;
        appMeasurementSdk.registerOnMeasurementEventListener(cVar);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.a;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
    }
}
