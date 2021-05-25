package com.google.android.gms.internal.gtm;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
public final class zzmi extends zzhb {
    private final zzei zzary;

    public zzmi(zzei zzei) {
        this.zzary = zzei;
    }

    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        zzoa<?> zzoa = zzoaArr[0];
        Preconditions.checkArgument(!(zzoa instanceof zzog));
        zzog zzog = zzoaArr.length > 1 ? zzoaArr[1] : zzog.zzaum;
        zzog zzog2 = zzog.zzaum;
        Preconditions.checkArgument(zzog == zzog2 || (zzog instanceof zzoh));
        zzog zzog3 = zzoaArr.length > 2 ? zzoaArr[2] : zzog2;
        if (zzog3 != zzog2 && (zzog3 instanceof zzog)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Uri.Builder buildUpon = Uri.parse(zzha.zzd(zzoa)).buildUpon();
        if (zzog != zzog2) {
            for (zzoa<?> zzoa2 : ((zzoh) zzog).value()) {
                Preconditions.checkArgument(zzoa2 instanceof zzok);
                for (Map.Entry<String, zzoa<?>> entry : ((zzok) zzoa2).value().entrySet()) {
                    buildUpon.appendQueryParameter(entry.getKey().toString(), zzha.zzd(zzoo.zza(zzfl, entry.getValue())));
                }
            }
        }
        String uri = buildUpon.build().toString();
        zzog zzog4 = zzog.zzaum;
        if (zzog3 == zzog4) {
            this.zzary.zzay(uri);
            String valueOf = String.valueOf(uri);
            zzev.zzab(valueOf.length() != 0 ? "SendPixel: url = ".concat(valueOf) : new String("SendPixel: url = "));
        } else {
            String zzd = zzha.zzd(zzog3);
            this.zzary.zzf(uri, zzd);
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + String.valueOf(uri).length() + 30);
            sb.append("SendPixel: url = ");
            sb.append(uri);
            sb.append(", uniqueId = ");
            sb.append(zzd);
            zzev.zzab(sb.toString());
        }
        return zzog4;
    }
}
