package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class zzjz {
    private static final zzmk zzaot = new zzkc();
    private static final Pattern zzaou = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahl = -1;
    public int zzahm = -1;

    public final boolean zzb(zzmc zzmc) {
        for (int i = 0; i < zzmc.length(); i++) {
            zzmc.zza zzba = zzmc.zzba(i);
            if (zzba instanceof zzmi) {
                zzmi zzmi = (zzmi) zzba;
                if (zzb(zzmi.description, zzmi.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgq() {
        return (this.zzahl == -1 || this.zzahm == -1) ? false : true;
    }

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzaou.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzahl = parseInt;
                    this.zzahm = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
