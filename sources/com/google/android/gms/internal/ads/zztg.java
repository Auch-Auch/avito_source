package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;
public final class zztg {
    private final Object lock = new Object();
    @Nullable
    @GuardedBy("lock")
    private zzsx zzbuw;
    @GuardedBy("lock")
    private boolean zzbvh;
    private final Context zzvr;

    public zztg(Context context) {
        this.zzvr = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void disconnect() {
        synchronized (this.lock) {
            zzsx zzsx = this.zzbuw;
            if (zzsx != null) {
                zzsx.disconnect();
                this.zzbuw = null;
                Binder.flushPendingCommands();
            }
        }
    }

    public final Future<InputStream> zzb(zzta zzta) {
        zztf zztf = new zztf(this);
        zzti zzti = new zzti(this, zzta, zztf);
        zztm zztm = new zztm(this, zztf);
        synchronized (this.lock) {
            zzsx zzsx = new zzsx(this.zzvr, zzp.zzld().zzyf(), zzti, zztm);
            this.zzbuw = zzsx;
            zzsx.checkAvailabilityAndConnect();
        }
        return zztf;
    }
}
