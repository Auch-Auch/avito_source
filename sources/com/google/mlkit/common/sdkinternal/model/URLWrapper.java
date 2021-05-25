package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
@KeepForSdk
public class URLWrapper {
    public final URL a;

    @KeepForSdk
    public URLWrapper(String str) throws MalformedURLException {
        this.a = new URL(str);
    }

    @KeepForSdk
    public URLConnection openConnection() throws IOException {
        return this.a.openConnection();
    }
}
