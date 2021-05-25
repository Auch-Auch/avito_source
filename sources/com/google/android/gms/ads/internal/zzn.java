package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class zzn extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzj zzbpi;

    private zzn(zzj zzj) {
        this.zzbpi = zzj;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzj zzj = this.zzbpi;
            zzj.zzbpg = (zzeg) zzj.zzbpc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzbbd.zzd("", e);
        }
        return this.zzbpi.zzkj();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        if (this.zzbpi.zzbpe != null && str2 != null) {
            this.zzbpi.zzbpe.loadUrl(str2);
        }
    }

    public /* synthetic */ zzn(zzj zzj, zzm zzm) {
        this(zzj);
    }
}
