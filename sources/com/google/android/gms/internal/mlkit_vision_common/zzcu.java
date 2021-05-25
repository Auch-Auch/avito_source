package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.mlkit.common.sdkinternal.MlKitContext;
public final class zzcu {
    @WorkerThread
    public static void zza(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        ((zzcq) MlKitContext.getInstance().get(zzcq.class)).zza(new zzcq.zza(i, i2, i5, i3, i4, SystemClock.elapsedRealtime() - j, i6) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcv
            private final int zza;
            private final int zzb;
            private final int zzc;
            private final int zzd;
            private final int zze;
            private final long zzf;
            private final int zzg;

            {
                this.zza = r1;
                this.zzb = r2;
                this.zzc = r3;
                this.zzd = r4;
                this.zze = r5;
                this.zzf = r6;
                this.zzg = r8;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzcq.zza
            public final zzr.zzad.zza zza() {
                zzr.zzae.zza zza2;
                zzr.zzag.zzb zzb2;
                int i7 = this.zza;
                int i8 = this.zzb;
                int i9 = this.zzc;
                int i10 = this.zzd;
                int i11 = this.zze;
                long j2 = this.zzf;
                int i12 = this.zzg;
                zzr.zzag.zza zza3 = zzr.zzag.zza();
                if (i7 == -1) {
                    zza2 = zzr.zzae.zza.BITMAP;
                } else if (i7 == 35) {
                    zza2 = zzr.zzae.zza.YUV_420_888;
                } else if (i7 == 842094169) {
                    zza2 = zzr.zzae.zza.YV12;
                } else if (i7 == 16) {
                    zza2 = zzr.zzae.zza.NV16;
                } else if (i7 != 17) {
                    zza2 = zzr.zzae.zza.UNKNOWN_FORMAT;
                } else {
                    zza2 = zzr.zzae.zza.NV21;
                }
                zzr.zzag.zza zza4 = zza3.zza(zza2);
                if (i8 == 1) {
                    zzb2 = zzr.zzag.zzb.BITMAP;
                } else if (i8 == 2) {
                    zzb2 = zzr.zzag.zzb.BYTEARRAY;
                } else if (i8 == 3) {
                    zzb2 = zzr.zzag.zzb.BYTEBUFFER;
                } else if (i8 == 4) {
                    zzb2 = zzr.zzag.zzb.FILEPATH;
                } else if (i8 != 5) {
                    zzb2 = zzr.zzag.zzb.SOURCE_UNKNOWN;
                } else {
                    zzb2 = zzr.zzag.zzb.ANDROID_MEDIA_IMAGE;
                }
                return zzr.zzad.zzb().zza((zzr.zzag) ((zzej) zza4.zza(zzb2).zza(i9).zzc(i10).zzb(i11).zza(j2).zzd(i12).zzh()));
            }
        }, zzag.INPUT_IMAGE_CONSTRUCTION);
    }
}
