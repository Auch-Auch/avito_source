package com.google.android.gms.vision.face;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzfl;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;
@RetainForClient
@KeepForSdk
@DynamiteApi
public abstract class ChimeraNativeBaseFaceDetectorCreator extends zzl {
    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzf zzf, @Nullable String str, long j) {
        zzfl.zzg.zzb zzdm = zzfl.zzg.zzdm();
        int i = zzf.mode;
        if (i == 1) {
            zzdm.zzb(zzfl.zzg.zzd.MODE_ACCURATE);
        } else if (i == 0) {
            zzdm.zzb(zzfl.zzg.zzd.MODE_FAST);
        } else if (i == 2) {
            zzdm.zzb(zzfl.zzg.zzd.MODE_SELFIE);
        }
        int i2 = zzf.landmarkType;
        if (i2 == 1) {
            zzdm.zzb(zzfl.zzg.zzc.LANDMARK_ALL);
        } else if (i2 == 0) {
            zzdm.zzb(zzfl.zzg.zzc.LANDMARK_NONE);
        } else if (i2 == 2) {
            zzdm.zzb(zzfl.zzg.zzc.LANDMARK_CONTOUR);
        }
        int i3 = zzf.zzcw;
        if (i3 == 1) {
            zzdm.zzb(zzfl.zzg.zza.CLASSIFICATION_ALL);
        } else if (i3 == 0) {
            zzdm.zzb(zzfl.zzg.zza.CLASSIFICATION_NONE);
        }
        zzdm.zzh(zzf.zzcv).zzi(zzf.trackingEnabled).zzf(zzf.proportionalMinFaceSize);
        zzfl.zzk.zza zza = zzfl.zzk.zzdv().zzs("face").zzq(j).zza(zzdm);
        if (str != null) {
            zza.zzt(str);
        }
        zza.zzb(LogUtils.zza(context));
        dynamiteClearcutLogger.zza(2, (zzfl.zzo) ((zzid) zzfl.zzo.zzec().zza(zza).zzgw()));
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzi
    public zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzf) throws RemoteException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbi.zzj(context);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        try {
            zzh zza = zza(context, context, dynamiteClearcutLogger, zzf);
            if (zza != null) {
                zza(dynamiteClearcutLogger, context, zzf, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            return zza;
        } catch (RemoteException e) {
            e.getMessage();
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                zza(dynamiteClearcutLogger, context, zzf, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            throw th;
        }
    }

    public abstract zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf) throws RemoteException;
}
