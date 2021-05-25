package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
public final class zzrp {
    private final int zzbtv;
    private final int zzbtw;
    private final int zzbtx;
    private final zzrq zzbty = new zzrt();

    public zzrp(int i) {
        this.zzbtw = i;
        this.zzbtv = 6;
        this.zzbtx = 0;
    }

    @VisibleForTesting
    private final String zzbt(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzrr zzrr = new zzrr();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbtw, new zzrs(this));
        for (String str2 : split) {
            String[] zze = zzru.zze(str2, false);
            if (zze.length != 0) {
                zzrv.zza(zze, this.zzbtw, this.zzbtv, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzrr.write(this.zzbty.zzbu(((zzry) it.next()).zzbuf));
            } catch (IOException e) {
                zzbbd.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzrr.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzbt(sb.toString());
    }
}
