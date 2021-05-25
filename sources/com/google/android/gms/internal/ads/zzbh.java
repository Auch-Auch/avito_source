package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Map;
public class zzbh extends zzaa<String> {
    private final Object mLock = new Object();
    @Nullable
    @GuardedBy("mLock")
    private zzal<String> zzcy;

    public zzbh(int i, String str, zzal<String> zzal, @Nullable zzai zzai) {
        super(i, str, zzai);
        this.zzcy = zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final zzaj<String> zza(zzy zzy) {
        String str;
        String str2;
        try {
            byte[] bArr = zzy.data;
            Map<String, String> map = zzy.zzam;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = map.get("Content-Type")) != null) {
                String[] split = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzy.data);
        }
        return zzaj.zza(str, zzbc.zzb(zzy));
    }

    /* renamed from: zzj */
    public void zza(String str) {
        zzal<String> zzal;
        synchronized (this.mLock) {
            zzal = this.zzcy;
        }
        if (zzal != null) {
            zzal.zzb(str);
        }
    }
}
