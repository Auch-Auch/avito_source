package com.google.android.gms.internal.ads;

import java.util.Comparator;
public final class zzefh implements Comparator<zzeff> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeff zzeff, zzeff zzeff2) {
        zzeff zzeff3 = zzeff;
        zzeff zzeff4 = zzeff2;
        zzefk zzefk = (zzefk) zzeff3.iterator();
        zzefk zzefk2 = (zzefk) zzeff4.iterator();
        while (zzefk.hasNext() && zzefk2.hasNext()) {
            int compare = Integer.compare(zzeff.zzb(zzefk.nextByte()), zzeff.zzb(zzefk2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeff3.size(), zzeff4.size());
    }
}
