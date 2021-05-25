package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
public final class zzadd extends zzadn {
    private static final int zzdce;
    private static final int zzdcf;
    private static final int zzdcg;
    private static final int zzdch;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzdci;
    private final List<zzadi> zzdcj = new ArrayList();
    private final List<zzadw> zzdck = new ArrayList();
    private final int zzdcl;
    private final int zzdcm;
    private final boolean zzdcn;

    static {
        int rgb = Color.rgb(12, 174, 206);
        zzdce = rgb;
        int rgb2 = Color.rgb(204, 204, 204);
        zzdcf = rgb2;
        zzdcg = rgb2;
        zzdch = rgb;
    }

    public zzadd(String str, List<zzadi> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzdci = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadi zzadi = list.get(i3);
                this.zzdcj.add(zzadi);
                this.zzdck.add(zzadi);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzdcg;
        this.textColor = num2 != null ? num2.intValue() : zzdch;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzdcl = i;
        this.zzdcm = i2;
        this.zzdcn = z;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final String getText() {
        return this.zzdci;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final List<zzadw> zzry() {
        return this.zzdck;
    }

    public final List<zzadi> zzrz() {
        return this.zzdcj;
    }

    public final int zzsa() {
        return this.zzdcl;
    }

    public final int zzsb() {
        return this.zzdcm;
    }
}
