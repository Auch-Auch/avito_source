package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
public final class zzamj extends zzbia {
    private final AppMeasurementSdk zzdil;

    public zzamj(AppMeasurementSdk appMeasurementSdk) {
        this.zzdil = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdil.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdil.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdil.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final long generateEventId() throws RemoteException {
        return this.zzdil.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdil.getAppIdOrigin();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String getAppInstanceId() throws RemoteException {
        return this.zzdil.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdil.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdil.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdil.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String getGmpAppId() throws RemoteException {
        return this.zzdil.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdil.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdil.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdil.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdil.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdil.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdil.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdil.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdil.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}
