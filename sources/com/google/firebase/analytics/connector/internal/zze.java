package com.google.firebase.analytics.connector.internal;

import a2.j.e.b.a.a.b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;
public final class zze implements zza {
    public Set<String> a = new HashSet();
    public AnalyticsConnector.AnalyticsConnectorListener b;
    public AppMeasurementSdk c;
    public b d;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.b = analyticsConnectorListener;
        this.c = appMeasurementSdk;
        b bVar = new b(this);
        this.d = bVar;
        appMeasurementSdk.registerOnMeasurementEventListener(bVar);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.b;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
        this.a.clear();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
        this.a.clear();
        Set<String> set2 = this.a;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzb.zzd(str) && zzb.zzc(str)) {
                hashSet.add(zzb.zzf(str));
            }
        }
        set2.addAll(hashSet);
    }
}
