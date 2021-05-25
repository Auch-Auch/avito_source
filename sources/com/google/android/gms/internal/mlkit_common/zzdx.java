package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzav;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
public final class zzdx {
    public static final Component<?> zza = Component.builder(zza.class).add(Dependency.required(zzds.class)).add(Dependency.required(SharedPrefManager.class)).factory(zzdw.zza).build();
    private static final GmsLogger zzb = new GmsLogger("ModelDownloadLogger", "");
    private final zzds zzc;
    private final RemoteModel zzd;
    private final SharedPrefManager zze;

    public static class zza extends LazyInstanceMap<RemoteModel, zzdx> {
        private final zzds zza;
        private final SharedPrefManager zzb;

        private zza(zzds zzds, SharedPrefManager sharedPrefManager) {
            this.zza = zzds;
            this.zzb = sharedPrefManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
        public /* synthetic */ zzdx create(RemoteModel remoteModel) {
            return new zzdx(this.zza, this.zzb, remoteModel);
        }
    }

    private zzdx(@NonNull zzds zzds, @NonNull SharedPrefManager sharedPrefManager, @NonNull RemoteModel remoteModel) {
        this.zzc = zzds;
        this.zzd = remoteModel;
        this.zze = sharedPrefManager;
    }

    private final void zza(zzbf zzbf, String str, boolean z, boolean z2, ModelType modelType, zzav.zzak.zza zza2, int i) {
        RemoteModel remoteModel = this.zzd;
        String modelHash = remoteModel.getModelHash();
        zzav.zzal.zzb zza3 = zzea.zza(modelType);
        zzav.zzam.zza zza4 = zzav.zzam.zza();
        zzav.zzal.zza zza5 = zzav.zzal.zza().zza(remoteModel.getModelNameForBackend()).zza(zzav.zzal.zzc.CLOUD);
        if (modelHash == null) {
            modelHash = "";
        }
        zzav.zzak.zzb zza6 = zzav.zzak.zza().zza(zzbf).zza(zza2).zzc((long) i).zza((zzav.zzam) ((zzfq) zza4.zza(zza5.zzb(modelHash).zza(zza3)).zzg()));
        if (z) {
            long modelDownloadBeginTimeMs = this.zze.getModelDownloadBeginTimeMs(this.zzd);
            if (modelDownloadBeginTimeMs == 0) {
                zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = this.zze.getModelFirstUseTimeMs(this.zzd);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    this.zze.setModelFirstUseTimeMs(this.zzd, modelFirstUseTimeMs);
                }
                zza6.zza(modelFirstUseTimeMs - modelDownloadBeginTimeMs);
            }
        }
        if (z2) {
            long modelDownloadBeginTimeMs2 = this.zze.getModelDownloadBeginTimeMs(this.zzd);
            if (modelDownloadBeginTimeMs2 == 0) {
                zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                zza6.zzb(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2);
            }
        }
        this.zzc.zza(zzav.zzad.zzb().zza(zzav.zzbh.zzb().zzd(str)).zza(zza6), zzbg.MODEL_DOWNLOAD);
    }

    public final void zza(int i, boolean z, ModelType modelType, int i2) {
        zza(zzeb.zza(i), "NA", z, false, modelType, zzdz.zza(i2), 0);
    }

    public final void zza(int i, ModelType modelType, int i2) {
        zza(zzeb.zza(0), "NA", false, true, modelType, zzdz.zza(6), 0);
    }

    public final void zza(boolean z, ModelType modelType, int i) {
        zza(zzbf.DOWNLOAD_FAILED, "NA", false, false, modelType, zzav.zzak.zza.FAILED, i);
    }

    public static final /* synthetic */ zza zza(ComponentContainer componentContainer) {
        return new zza((zzds) componentContainer.get(zzds.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class));
    }
}
