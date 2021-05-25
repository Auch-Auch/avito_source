package com.google.android.gms.internal.ads;

import java.io.IOException;
public class zzos extends IOException {
    private final int type;
    private final zzon zzbik;

    public zzos(String str, zzon zzon, int i) {
        super(str);
        this.zzbik = zzon;
        this.type = 1;
    }

    public zzos(IOException iOException, zzon zzon, int i) {
        super(iOException);
        this.zzbik = zzon;
        this.type = i;
    }

    public zzos(String str, IOException iOException, zzon zzon, int i) {
        super(str, iOException);
        this.zzbik = zzon;
        this.type = 1;
    }
}
