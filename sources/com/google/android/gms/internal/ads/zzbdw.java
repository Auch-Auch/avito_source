package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class zzbdw implements zzom {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzeji;
    private final zzom zzejj;
    @Nullable
    private final zzpa<zzom> zzejk;
    private final zzbdz zzejl;
    private final Context zzvr;

    public zzbdw(Context context, zzom zzom, zzpa<zzom> zzpa, zzbdz zzbdz) {
        this.zzvr = context;
        this.zzejj = zzom;
        this.zzejk = zzpa;
        this.zzejl = zzbdz;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            this.uri = null;
            InputStream inputStream = this.zzeji;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
                this.zzeji = null;
            } else {
                this.zzejj.close();
            }
            zzpa<zzom> zzpa = this.zzejk;
            if (zzpa != null) {
                zzpa.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.isOpen) {
            InputStream inputStream = this.zzeji;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzejj.read(bArr, i, i2);
            }
            zzpa<zzom> zzpa = this.zzejk;
            if (zzpa != null) {
                zzpa.zzc(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzon) throws IOException {
        Long l;
        long j;
        StringBuilder sb;
        zzon zzon2 = zzon;
        String str = "ms";
        String str2 = "Cache connection took ";
        if (!this.isOpen) {
            boolean z = true;
            this.isOpen = true;
            this.uri = zzon2.uri;
            zzpa<zzom> zzpa = this.zzejk;
            if (zzpa != null) {
                zzpa.zza(this, zzon2);
            }
            zzta zzd = zzta.zzd(zzon2.uri);
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcsr)).booleanValue()) {
                zzsv zzsv = null;
                if (zzd != null) {
                    zzd.zzbvf = zzon2.position;
                    zzsv = zzp.zzkv().zza(zzd);
                }
                if (zzsv != null && zzsv.zzmu()) {
                    this.zzeji = zzsv.zzmv();
                    return -1;
                }
            } else if (zzd != null) {
                zzd.zzbvf = zzon2.position;
                if (zzd.zzbve) {
                    l = (Long) zzwe.zzpu().zzd(zzaat.zzcst);
                } else {
                    l = (Long) zzwe.zzpu().zzd(zzaat.zzcss);
                }
                long longValue = l.longValue();
                long elapsedRealtime = zzp.zzkw().elapsedRealtime();
                zzp.zzlj();
                Future<InputStream> zza = zztl.zza(this.zzvr, zzd);
                z = false;
                int i = 44;
                try {
                    this.zzeji = zza.get(longValue, TimeUnit.MILLISECONDS);
                    return -1;
                } catch (ExecutionException | TimeoutException unused) {
                    zza.cancel(true);
                } catch (InterruptedException unused2) {
                    zza.cancel(true);
                    Thread.currentThread().interrupt();
                } finally {
                    j = zzp.zzkw().elapsedRealtime() - elapsedRealtime;
                    this.zzejl.zzb(z, j);
                    sb = new StringBuilder(i);
                    sb.append(str2);
                    sb.append(j);
                    sb.append(str);
                    zzaxy.zzei(sb.toString());
                }
            }
            if (zzd != null) {
                zzon2 = new zzon(Uri.parse(zzd.url), zzon2.zzbhy, zzon2.zzbhz, zzon2.position, zzon2.zzcp, zzon2.zzcn, zzon2.flags);
            }
            return this.zzejj.zza(zzon2);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }
}
