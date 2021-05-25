package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;
public final class zzti implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ zztg zzbvg;
    private final /* synthetic */ zzta zzbvm;
    private final /* synthetic */ zzbbq zzbvn;

    public zzti(zztg zztg, zzta zzta, zzbbq zzbbq) {
        this.zzbvg = zztg;
        this.zzbvm = zzta;
        this.zzbvn = zzbbq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbvg.lock) {
            if (!(this.zzbvg.zzbvh)) {
                this.zzbvg.zzbvh = true;
                zzsx zzsx = this.zzbvg.zzbuw;
                if (zzsx != null) {
                    zzdvt<?> zzf = zzbbi.zzedu.zzf(new Runnable(this, zzsx, this.zzbvm, this.zzbvn) { // from class: com.google.android.gms.internal.ads.zzth
                        private final zzti zzbvi;
                        private final zzsx zzbvj;
                        private final zzta zzbvk;
                        private final zzbbq zzbvl;

                        {
                            this.zzbvi = r1;
                            this.zzbvj = r2;
                            this.zzbvk = r3;
                            this.zzbvl = r4;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzti zzti = this.zzbvi;
                            zzsx zzsx2 = this.zzbvj;
                            zzta zzta = this.zzbvk;
                            zzbbq zzbbq = this.zzbvl;
                            try {
                                zzsv zza = zzsx2.zzmx().zza(zzta);
                                if (!zza.zzmu()) {
                                    zzbbq.setException(new RuntimeException("No entry contents."));
                                    zzti.zzbvg.disconnect();
                                    return;
                                }
                                zztj zztj = new zztj(zzti, zza.zzmv(), 1);
                                int read = zztj.read();
                                if (read != -1) {
                                    zztj.unread(read);
                                    zzbbq.set(zztj);
                                    return;
                                }
                                throw new IOException("Unable to read from cache.");
                            } catch (RemoteException | IOException e) {
                                zzbbd.zzc("Unable to obtain a cache service instance.", e);
                                zzbbq.setException(e);
                                zzti.zzbvg.disconnect();
                            }
                        }
                    });
                    zzbbq zzbbq = this.zzbvn;
                    zzbbq.addListener(new Runnable(zzbbq, zzf) { // from class: com.google.android.gms.internal.ads.zztk
                        private final zzbbq zzbvp;
                        private final Future zzbvq;

                        {
                            this.zzbvp = r1;
                            this.zzbvq = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzbbq zzbbq2 = this.zzbvp;
                            Future future = this.zzbvq;
                            if (zzbbq2.isCancelled()) {
                                future.cancel(true);
                            }
                        }
                    }, zzbbi.zzedz);
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
