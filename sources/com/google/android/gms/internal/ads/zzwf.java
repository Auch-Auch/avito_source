package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
public abstract class zzwf<T> {
    @Nullable
    private static final zzxh zzcix = zzpz();

    private static zzxh zzpz() {
        try {
            Object newInstance = zzvr.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbbd.zzfe("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxh) {
                return (zzxh) queryLocalInterface;
            }
            return new zzxj(iBinder);
        } catch (Exception unused) {
            zzbbd.zzfe("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzqa() {
        zzxh zzxh = zzcix;
        if (zzxh == null) {
            zzbbd.zzfe("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxh);
        } catch (RemoteException e) {
            zzbbd.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzqb() {
        try {
            return zzpo();
        } catch (RemoteException e) {
            zzbbd.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    @Nullable
    public abstract T zza(zzxh zzxh) throws RemoteException;

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzwe.zzpq();
            if (!zzbat.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbbd.zzef("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzaat.initialize(context);
        if (zzack.zzdae.get().booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = zzqa();
            if (t == null) {
                t = zzqb();
            }
        } else {
            T zzqb = zzqb();
            int i = zzqb == null ? 1 : 0;
            if (i != 0) {
                if (zzwe.zzpx().nextInt(zzact.zzdbh.get().intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwe.zzpq().zza(context, zzwe.zzpw().zzbra, "gmob-apps", bundle, true);
                }
            }
            t = zzqb == null ? zzqa() : zzqb;
        }
        return t == null ? zzpn() : t;
    }

    @NonNull
    public abstract T zzpn();

    @Nullable
    public abstract T zzpo() throws RemoteException;
}
