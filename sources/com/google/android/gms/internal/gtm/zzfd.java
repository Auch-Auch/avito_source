package com.google.android.gms.internal.gtm;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
@VisibleForTesting
public class zzfd {
    private static zzfd zzaoq;
    private volatile String zzaec = null;
    private volatile String zzais = null;
    private volatile int zzaor = zza.zzaos;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zza {
        public static final int zzaos = 1;
        public static final int zzaot = 2;
        private static final /* synthetic */ int[] zzaou = {1, 2};
    }

    @VisibleForTesting
    public static zzfd zzkr() {
        zzfd zzfd;
        synchronized (zzfd.class) {
            if (zzaoq == null) {
                zzaoq = new zzfd();
            }
            zzfd = zzaoq;
        }
        return zzfd;
    }

    public final String getContainerId() {
        return this.zzaec;
    }

    public final boolean isPreview() {
        return this.zzaor == zza.zzaot;
    }

    public final synchronized boolean zza(String str, Uri uri) {
        int i;
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\S+")) {
                zzev.zzac(decode.length() != 0 ? "Bad preview url: ".concat(decode) : new String("Bad preview url: "));
                return false;
            }
            String queryParameter = uri.getQueryParameter("id");
            String queryParameter2 = uri.getQueryParameter("gtm_auth");
            String queryParameter3 = uri.getQueryParameter("gtm_preview");
            if (!str.equals(queryParameter)) {
                zzev.zzac("Preview fails (container doesn't match the container specified by the asset)");
                return false;
            } else if (queryParameter == null || queryParameter.length() <= 0) {
                zzev.zzac(decode.length() != 0 ? "Bad preview url: ".concat(decode) : new String("Bad preview url: "));
                return false;
            } else {
                if (queryParameter3 == null || queryParameter3.length() != 0) {
                    if (queryParameter3 == null || queryParameter3.length() <= 0 || queryParameter2 == null || queryParameter2.length() <= 0) {
                        zzev.zzac(decode.length() != 0 ? "Bad preview url: ".concat(decode) : new String("Bad preview url: "));
                        return false;
                    }
                    this.zzaor = zza.zzaot;
                    this.zzais = uri.getQuery();
                    this.zzaec = queryParameter;
                } else if (!queryParameter.equals(this.zzaec) || this.zzaor == (i = zza.zzaos)) {
                    zzev.zzac("Error in exiting preview mode. The container is not in preview.");
                    return false;
                } else {
                    String valueOf = String.valueOf(this.zzaec);
                    zzev.zzab(valueOf.length() != 0 ? "Exit preview mode for container: ".concat(valueOf) : new String("Exit preview mode for container: "));
                    this.zzaor = i;
                    this.zzaec = null;
                    this.zzais = null;
                }
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            String valueOf2 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf2.length() + 32);
            sb.append("Error decoding the preview url: ");
            sb.append(valueOf2);
            zzev.zzac(sb.toString());
            return false;
        }
    }

    public final boolean zzbw(String str) {
        return isPreview() && this.zzaec.equals(str);
    }

    public final String zzks() {
        return this.zzais;
    }
}
