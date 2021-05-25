package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.ArrayDeque;
import java.util.Arrays;
public final class zzeiu {
    private final ArrayDeque<zzeff> zziji;

    private zzeiu() {
        this.zziji = new ArrayDeque<>();
    }

    private final void zzal(zzeff zzeff) {
        while (!zzeff.zzbdo()) {
            if (zzeff instanceof zzeis) {
                zzeis zzeis = (zzeis) zzeff;
                zzal(zzeis.zzijc);
                zzeff = zzeis.zzijd;
            } else {
                String valueOf = String.valueOf(zzeff.getClass());
                throw new IllegalArgumentException(a.r2(valueOf.length() + 49, "Has a new type of ByteString been created? Found ", valueOf));
            }
        }
        int zzhn = zzhn(zzeff.size());
        int zzhm = zzeis.zzhm(zzhn + 1);
        if (this.zziji.isEmpty() || this.zziji.peek().size() >= zzhm) {
            this.zziji.push(zzeff);
            return;
        }
        int zzhm2 = zzeis.zzhm(zzhn);
        zzeff pop = this.zziji.pop();
        while (!this.zziji.isEmpty() && this.zziji.peek().size() < zzhm2) {
            pop = new zzeis(this.zziji.pop(), pop, null);
        }
        zzeis zzeis2 = new zzeis(pop, zzeff, null);
        while (!this.zziji.isEmpty() && this.zziji.peek().size() < zzeis.zzhm(zzhn(zzeis2.size()) + 1)) {
            zzeis2 = new zzeis(this.zziji.pop(), zzeis2, null);
        }
        this.zziji.push(zzeis2);
    }

    /* access modifiers changed from: public */
    private final zzeff zzc(zzeff zzeff, zzeff zzeff2) {
        zzal(zzeff);
        zzal(zzeff2);
        zzeff pop = this.zziji.pop();
        while (!this.zziji.isEmpty()) {
            pop = new zzeis(this.zziji.pop(), pop, null);
        }
        return pop;
    }

    private static int zzhn(int i) {
        int binarySearch = Arrays.binarySearch(zzeis.zzija, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzeiu(zzeir zzeir) {
        this();
    }
}
