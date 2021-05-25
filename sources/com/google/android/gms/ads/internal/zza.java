package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzayh;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zza {
    private boolean zzbob;
    private zzavu zzboc;
    private zzasa zzbod = null;
    private final Context zzvr;

    public zza(Context context, zzavu zzavu, zzasa zzasa) {
        this.zzvr = context;
        this.zzboc = zzavu;
        if (0 == 0) {
            this.zzbod = new zzasa();
        }
    }

    private final boolean zzjw() {
        zzavu zzavu = this.zzboc;
        return (zzavu != null && zzavu.zzvn().zzdwm) || this.zzbod.zzdsw;
    }

    public final void recordClick() {
        this.zzbob = true;
    }

    public final void zzbo(@Nullable String str) {
        List<String> list;
        if (zzjw()) {
            if (str == null) {
                str = "";
            }
            zzavu zzavu = this.zzboc;
            if (zzavu != null) {
                zzavu.zza(str, null, 3);
                return;
            }
            zzasa zzasa = this.zzbod;
            if (zzasa.zzdsw && (list = zzasa.zzdsx) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzp.zzkp();
                        zzayh.zzb(this.zzvr, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzjx() {
        return !zzjw() || this.zzbob;
    }
}
