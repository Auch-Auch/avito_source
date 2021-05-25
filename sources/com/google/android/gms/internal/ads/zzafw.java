package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
public interface zzafw extends IInterface {
    void cancelUnconfirmedClick() throws RemoteException;

    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    List getMuteThisAdReasons() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzyg getVideoController() throws RemoteException;

    boolean isCustomClickGestureEnabled() throws RemoteException;

    boolean isCustomMuteThisAdEnabled() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    void recordCustomClickGesture() throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    void zza(zzafr zzafr) throws RemoteException;

    void zza(zzxr zzxr) throws RemoteException;

    void zza(zzxv zzxv) throws RemoteException;

    void zza(zzya zzya) throws RemoteException;

    zzyf zzkg() throws RemoteException;

    IObjectWrapper zzsg() throws RemoteException;

    zzadw zzsh() throws RemoteException;

    zzado zzsi() throws RemoteException;

    IObjectWrapper zzsj() throws RemoteException;

    void zzsr() throws RemoteException;

    zzadr zzss() throws RemoteException;
}
