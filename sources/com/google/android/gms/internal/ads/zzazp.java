package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
public final class zzazp {
    private final String[] zzebj;
    private final double[] zzebk;
    private final double[] zzebl;
    private final int[] zzebm;
    private int zzebn;

    private zzazp(zzazq zzazq) {
        int size = zzazq.zzebp.size();
        this.zzebj = (String[]) zzazq.zzebo.toArray(new String[size]);
        this.zzebk = zzg(zzazq.zzebp);
        this.zzebl = zzg(zzazq.zzebq);
        this.zzebm = new int[size];
        this.zzebn = 0;
    }

    private static double[] zzg(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzebn++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzebl;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzebk[i]) {
                    int[] iArr = this.zzebm;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= dArr[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzazr> zzyd() {
        ArrayList arrayList = new ArrayList(this.zzebj.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzebj;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzebl[i];
            double d2 = this.zzebk[i];
            int[] iArr = this.zzebm;
            arrayList.add(new zzazr(str, d, d2, ((double) iArr[i]) / ((double) this.zzebn), iArr[i]));
            i++;
        }
    }
}
