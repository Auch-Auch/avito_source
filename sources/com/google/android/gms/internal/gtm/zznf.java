package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public final class zznf {
    private String zzafk = "https://www.google-analytics.com";

    private static String zzbs(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            String valueOf = String.valueOf(str);
            zzev.zzav(valueOf.length() != 0 ? "Cannot encode the string: ".concat(valueOf) : new String("Cannot encode the string: "));
            return "";
        }
    }

    public final String zzb(zzmk zzmk) {
        String str;
        String str2 = this.zzafk;
        if (zzmk.zzlg()) {
            str = zzmk.zzlh();
        } else {
            String trim = !zzmk.zzli().trim().equals("") ? zzmk.zzli().trim() : DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME;
            StringBuilder sb = new StringBuilder();
            if (zzmk.zzle() != null) {
                sb.append(zzmk.zzle());
            } else {
                sb.append("id");
            }
            sb.append("=");
            sb.append(zzbs(zzmk.getContainerId()));
            sb.append("&pv=");
            sb.append(zzbs(trim));
            sb.append("&rv=5.0");
            if (zzmk.zzlg()) {
                sb.append("&gtm_debug=x");
            }
            str = sb.toString();
        }
        return a.s2(a.q0(str, a.q0(str2, 13)), str2, "/gtm/android?", str);
    }
}
