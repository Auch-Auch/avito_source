package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
public final class zzlg implements zzjv {
    private static final zzka zzapf = new zzlf();
    private static final int zzaxh = zzpq.zzbl("seig");
    private static final byte[] zzaxi = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaid;
    private final zzpk zzapm;
    private int zzarb;
    private int zzarc;
    private zzjx zzarf;
    private final zzln zzaxj;
    private final SparseArray<zzlh> zzaxk;
    private final zzpk zzaxl;
    private final zzpk zzaxm;
    private final zzpk zzaxn;
    private final zzpo zzaxo;
    private final zzpk zzaxp;
    private final byte[] zzaxq;
    private final Stack<zzku> zzaxr;
    private final LinkedList<zzli> zzaxs;
    private int zzaxt;
    private int zzaxu;
    private long zzaxv;
    private int zzaxw;
    private zzpk zzaxx;
    private long zzaxy;
    private int zzaxz;
    private long zzaya;
    private zzlh zzayb;
    private int zzayc;
    private boolean zzayd;
    private zzkg zzaye;
    private zzkg[] zzayf;
    private boolean zzayg;

    public zzlg() {
        this(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzjn zzb(java.util.List<com.google.android.gms.internal.ads.zzkt> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x0098
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzkt r5 = (com.google.android.gms.internal.ads.zzkt) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzkr.zzaui
            if (r6 != r7) goto L_0x0094
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzpk r5 = r5.zzawe
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpk r6 = new com.google.android.gms.internal.ads.zzpk
            r6.<init>(r5)
            int r8 = r6.limit()
            r9 = 32
            if (r8 >= r9) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x007f
        L_0x0030:
            r6.zzbo(r1)
            int r8 = r6.readInt()
            int r9 = r6.zziy()
            int r9 = r9 + 4
            if (r8 == r9) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r8 = r6.readInt()
            if (r8 == r7) goto L_0x0047
            goto L_0x002e
        L_0x0047:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.zzkr.zzaq(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x0053
            goto L_0x002e
        L_0x0053:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x006b
            int r7 = r6.zzjd()
            int r7 = r7 << 4
            r6.zzbp(r7)
        L_0x006b:
            int r7 = r6.zzjd()
            int r8 = r6.zziy()
            if (r7 == r8) goto L_0x0076
            goto L_0x002e
        L_0x0076:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x007f:
            if (r6 != 0) goto L_0x0083
            r6 = r2
            goto L_0x0087
        L_0x0083:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x0087:
            if (r6 != 0) goto L_0x008a
            goto L_0x0094
        L_0x008a:
            com.google.android.gms.internal.ads.zzjn$zza r7 = new com.google.android.gms.internal.ads.zzjn$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        L_0x0094:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x0098:
            if (r4 != 0) goto L_0x009b
            return r2
        L_0x009b:
            com.google.android.gms.internal.ads.zzjn r14 = new com.google.android.gms.internal.ads.zzjn
            r14.<init>(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zzb(java.util.List):com.google.android.gms.internal.ads.zzjn");
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzeb(long r49) throws com.google.android.gms.internal.ads.zzhv {
        /*
        // Method dump skipped, instructions count: 1718
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zzeb(long):void");
    }

    private final void zzgz() {
        this.zzaxt = 0;
        this.zzaxw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjy) throws IOException, InterruptedException {
        return zzlo.zzd(zzjy);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        int size = this.zzaxk.size();
        for (int i = 0; i < size; i++) {
            this.zzaxk.valueAt(i).reset();
        }
        this.zzaxs.clear();
        this.zzaxz = 0;
        this.zzaxr.clear();
        zzgz();
    }

    private zzlg(int i) {
        this(0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjx) {
        this.zzarf = zzjx;
    }

    private zzlg(int i, zzpo zzpo) {
        this(0, null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:258:0x025b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05a0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0004 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjy r26, com.google.android.gms.internal.ads.zzkb r27) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 1458
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }

    private zzlg(int i, zzpo zzpo, zzln zzln) {
        this.flags = i;
        this.zzaxo = null;
        this.zzaxj = null;
        this.zzaxp = new zzpk(16);
        this.zzapm = new zzpk(zzpf.zzbjn);
        this.zzaxl = new zzpk(5);
        this.zzaxm = new zzpk();
        this.zzaxn = new zzpk(1);
        this.zzaxq = new byte[16];
        this.zzaxr = new Stack<>();
        this.zzaxs = new LinkedList<>();
        this.zzaxk = new SparseArray<>();
        this.zzaid = C.TIME_UNSET;
        this.zzaya = C.TIME_UNSET;
        zzgz();
    }

    private static void zza(zzpk zzpk, int i, zzlp zzlp) throws zzhv {
        zzpk.zzbo(i + 8);
        int zzar = zzkr.zzar(zzpk.readInt());
        if ((zzar & 1) == 0) {
            boolean z = (zzar & 2) != 0;
            int zzjd = zzpk.zzjd();
            if (zzjd == zzlp.zzawy) {
                Arrays.fill(zzlp.zzbar, 0, zzjd, z);
                zzlp.zzaw(zzpk.zziy());
                zzpk.zze(zzlp.zzbau.data, 0, zzlp.zzbat);
                zzlp.zzbau.zzbo(0);
                zzlp.zzbav = false;
                return;
            }
            throw new zzhv(a.p2(41, "Length mismatch: ", zzjd, ", ", zzlp.zzawy));
        }
        throw new zzhv("Overriding TrackEncryptionBox parameters is unsupported.");
    }
}
