package com.google.firebase.analytics.connector;

import a2.j.e.b.a.b;
import a2.j.e.b.a.c;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzb;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    public static volatile AnalyticsConnector c;
    @VisibleForTesting
    public final AppMeasurementSdk a;
    @VisibleForTesting
    public final Map<String, zza> b = new ConcurrentHashMap();

    public class a implements AnalyticsConnector.AnalyticsConnectorHandle {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        @KeepForSdk
        public void registerEventNames(Set<String> set) {
            if (AnalyticsConnectorImpl.this.a(this.a) && this.a.equals("fiam") && set != null && !set.isEmpty()) {
                AnalyticsConnectorImpl.this.b.get(this.a).zza(set);
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregister() {
            if (AnalyticsConnectorImpl.this.a(this.a)) {
                AnalyticsConnector.AnalyticsConnectorListener zza = AnalyticsConnectorImpl.this.b.get(this.a).zza();
                if (zza != null) {
                    zza.onMessageTriggered(0, null);
                }
                AnalyticsConnectorImpl.this.b.remove(this.a);
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        @KeepForSdk
        public void unregisterEventNames() {
            if (AnalyticsConnectorImpl.this.a(this.a) && this.a.equals("fiam")) {
                AnalyticsConnectorImpl.this.b.get(this.a).zzb();
            }
        }
    }

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.a = appMeasurementSdk;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (c == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, b.a, c.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    c = new AnalyticsConnectorImpl(zzag.zza(context, (String) null, (String) null, (String) null, bundle).zza());
                }
            }
        }
        return c;
    }

    public final boolean a(@NonNull String str) {
        return !str.isEmpty() && this.b.containsKey(str) && this.b.get(str) != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str2 == null || zzb.zza(str2, bundle)) {
            this.a.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    @WorkerThread
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.a.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzb.zza(bundle));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        return this.a.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    @WorkerThread
    public Map<String, Object> getUserProperties(boolean z) {
        return this.a.getUserProperties(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzb.zza(str) && zzb.zza(str2, bundle) && zzb.zza(str, str2, bundle)) {
            zzb.zzb(str, str2, bundle);
            this.a.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    @WorkerThread
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        zza zza;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzb.zza(str) || a(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.a;
        if ("fiam".equals(str)) {
            zza = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if ("crash".equals(str) || "clx".equals(str)) {
            zza = new zzg(appMeasurementSdk, analyticsConnectorListener);
        } else {
            zza = null;
        }
        if (zza == null) {
            return null;
        }
        this.b.put(str, zza);
        return new a(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzb.zza(conditionalUserProperty)) {
            this.a.setConditionalUserProperty(zzb.zzb(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
        if (zzb.zza(str) && zzb.zza(str, str2)) {
            this.a.setUserProperty(str, str2, obj);
        }
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }
}
