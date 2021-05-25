package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public final class zzfv implements zzfx {
    @Override // com.google.android.gms.internal.gtm.zzfx
    public final HttpURLConnection zzc(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
