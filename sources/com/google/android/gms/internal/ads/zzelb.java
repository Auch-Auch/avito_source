package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;
public final class zzelb extends zzelg {
    private Logger logger;

    public zzelb(String str) {
        this.logger = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final void zzik(String str) {
        this.logger.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
