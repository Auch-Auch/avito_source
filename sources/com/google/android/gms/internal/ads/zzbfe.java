package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzbfe {
    private final ArrayList<zzop> zzelg = new ArrayList<>();
    private long zzelh;

    public final void zza(zzop zzop) {
        this.zzelg.add(zzop);
    }

    public final long zzaau() {
        Iterator<zzop> it = this.zzelg.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.zzelh = Math.max(this.zzelh, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzelh;
    }
}
