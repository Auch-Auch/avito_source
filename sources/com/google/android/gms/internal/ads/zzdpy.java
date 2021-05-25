package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzdpy {
    private static volatile zzbw.zza.zzc zzhiv = zzbw.zza.zzc.UNKNOWN;
    private final Executor executor;
    private final Task<zztt> zzhiu;
    private final Context zzvr;

    private zzdpy(@NonNull Context context, @NonNull Executor executor2, @NonNull Task<zztt> task) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzhiu = task;
    }

    public static zzdpy zza(@NonNull Context context, @NonNull Executor executor2) {
        return new zzdpy(context, executor2, Tasks.call(executor2, new Callable(context) { // from class: com.google.android.gms.internal.ads.zzdqa
            private final Context zzcxz;

            {
                this.zzcxz = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdpy.zzci(this.zzcxz);
            }
        }));
    }

    public static void zzb(zzbw.zza.zzc zzc) {
        zzhiv = zzc;
    }

    public static final /* synthetic */ zztt zzci(Context context) throws Exception {
        return new zztt(context, "GLAS", null);
    }

    public final Task<Boolean> zzg(int i, long j) {
        return zza(i, j, null, null, null, null);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return zza(4007, 0, null, null, null, str);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, null, str, null, null);
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.C0189zza zzc = zzbw.zza.zzs().zzk(this.zzvr.getPackageName()).zzc(j);
        zzc.zza(zzhiv);
        if (exc != null) {
            zzc.zzl(zzdsy.zza(exc)).zzm(exc.getClass().getName());
        }
        if (str2 != null) {
            zzc.zzn(str2);
        }
        if (str != null) {
            zzc.zzo(str);
        }
        return this.zzhiu.continueWith(this.executor, new Continuation(zzc, i) { // from class: com.google.android.gms.internal.ads.zzdpz
            private final int zzeax;
            private final zzbw.zza.C0189zza zzhiw;

            {
                this.zzhiw = r1;
                this.zzeax = r2;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzdpy.zza(this.zzhiw, this.zzeax, task);
            }
        });
    }

    public static final /* synthetic */ Boolean zza(zzbw.zza.C0189zza zza, int i, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zztx zzf = ((zztt) task.getResult()).zzf(((zzbw.zza) ((zzegp) zza.zzbfx())).toByteArray());
        zzf.zzby(i);
        zzf.zzdv();
        return Boolean.TRUE;
    }
}
