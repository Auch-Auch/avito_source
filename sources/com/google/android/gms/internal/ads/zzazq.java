package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
public final class zzazq {
    private final List<String> zzebo = new ArrayList();
    private final List<Double> zzebp = new ArrayList();
    private final List<Double> zzebq = new ArrayList();

    public final zzazq zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzebo.size()) {
            double doubleValue = this.zzebq.get(i).doubleValue();
            double doubleValue2 = this.zzebp.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzebo.add(i, str);
        this.zzebq.add(i, Double.valueOf(d));
        this.zzebp.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzazp zzye() {
        return new zzazp(this);
    }
}
